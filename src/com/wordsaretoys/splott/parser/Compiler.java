package com.wordsaretoys.splott.parser;

import java.util.ArrayList;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * compiles surface equation to f(x, y, z, t) function
 * note that function is assumed to be syntax-checked!
 */
public class Compiler {

	enum StepType {
		LoadConstant,
		OpAdd, OpSubtract, OpMultiply, OpDivide, OpExponent, OpUminus,
		FuncSine, FuncCosine, FuncLogarithm, FuncExponential
	}
	
	final int VarX = 0;
	final int VarY = 1;
	final int VarZ = 2;
	final int VarT = 3;
	
	class Step {
		public StepType type;
		public int local0, local1, local2;
		// set only for a load constant step
		public double constant;
		
		public Step() {}
		public Step(StepType t) { 
			type = t;
			switch(type) {

			case LoadConstant:
				local0 = local++;
				stack.push(local0);
				break;
				
			case OpAdd:
			case OpSubtract:
			case OpMultiply:
			case OpDivide:
			case OpExponent:
				local1 = stack.pop();
				local0 = stack.pop();
				// generate local result index
				local2 = local++;
				// push result on stack
				stack.push(local2);
				break;
				
			case FuncSine:
			case FuncCosine:
			case FuncLogarithm:
			case FuncExponential:
			case OpUminus:
				
				local0 = stack.pop();
				// generate local result index
				local1 = local++;
				// push result onto stack
				stack.push(local1);
				break;
				
			default: break;
				
			}
			
		}
	}
	
	class Listener extends SurfaceBaseListener {

		@Override public void exitMuldivExpr(@NotNull SurfaceParser.MuldivExprContext ctx) {
			Step step = null;
			if (ctx.MUL() != null) {
				step = new Step(StepType.OpMultiply);
			} else if (ctx.DIV() != null) {
				step = new Step(StepType.OpDivide);
			}		
			steps.add(step);
		}

		@Override public void exitUminusExpr(@NotNull SurfaceParser.UminusExprContext ctx) { 
			Step step = new Step(StepType.OpUminus);
			steps.add(step);
		}

		@Override public void exitNumExpr(@NotNull SurfaceParser.NumExprContext ctx) { 
			// generate a step that allocates a local variable
			// and loads a constant value into that variable
			Step step = new Step(StepType.LoadConstant);
			step.constant = Double.parseDouble(ctx.getText());
			steps.add(step);
		}

		@Override public void exitVarExpr(@NotNull SurfaceParser.VarExprContext ctx) { 
			// place index of variable onto the stack
			// variables already generated, no step creation!!
			String token = ctx.VARIABLE().getText();
			switch (token) {
			case "x":
				stack.push(VarX);
				break;
			case "y":
				stack.push(VarY);
				break;
			case "z":
				stack.push(VarZ);
				break;
			case "t":
				stack.push(VarT);
				break;
			}
		}

		@Override public void exitFuncExpr(@NotNull SurfaceParser.FuncExprContext ctx) { 
			// generate a step that pops a local from the stack
			// and places the result back onto the stack
			// process according to function def
			Step step = null;
			String token = ctx.FUNCTION().getText();
			switch (token) {
			case "sin":
				step = new Step(StepType.FuncSine);
				break;
			case "cos":
				step = new Step(StepType.FuncCosine);
				break;
			case "exp":
				step = new Step(StepType.FuncExponential);
				break;
			case "log":
				step = new Step(StepType.FuncLogarithm);
				break;
			}
			steps.add(step);
		}

		@Override public void exitAddsubExpr(@NotNull SurfaceParser.AddsubExprContext ctx) { 
			Step step = null;
			if (ctx.ADD() != null) {
				step = new Step(StepType.OpAdd);
			} else if (ctx.SUB() != null) {
				step = new Step(StepType.OpSubtract);
			}		
			steps.add(step);
		}

		@Override public void exitExpExpr(@NotNull SurfaceParser.ExpExprContext ctx) { 
			// generate a step that pops two locals from the stack
			// and places the result back onto the stack
			Step step = new Step(StepType.OpExponent);
			steps.add(step);
		}
		
		@Override public void exitEqualsExpr(@NotNull SurfaceParser.EqualsExprContext ctx) { 
			// generate a subtraction step
			Step step = new Step(StepType.OpSubtract);
			steps.add(step);
		}
		
	}

	ArrayList<Step> steps;
	Stack<Integer> stack;
	int local;
	int output;
	
	public Compiler() {
        steps = new ArrayList<Step>();
        stack = new Stack<Integer>();
	}
	
	public Vm compile(String eq) {
        // generate the parse tree
		ParseTree tree = null;
        ANTLRInputStream input = new ANTLRInputStream(eq);
        SurfaceLexer lexer = new SurfaceLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurfaceParser parser = new SurfaceParser(tokens);
        tree = parser.surface();
        // reset our structures
        steps.clear();
        stack.clear();
        local = VarT + 1;
        // walking the parse tree generates the steps
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Listener(), tree);
        // the return index is the last thing on the stack
        output = stack.pop();
		//debug();
		return new Vm(steps.toArray(new Step[0]), local, output);
	}
	
	void debug() {
        for (int i = 0; i < steps.size(); i++) {
        	Step s = steps.get(i);
        	switch(s.type) {
        	case LoadConstant: System.out.println("LC " + s.local0 + ", " + s.constant); break;

        	case FuncSine: System.out.println("SIN " + s.local0 + ", " + s.local1); break;
        	case FuncCosine: System.out.println("COS " + s.local0 + ", " + s.local1); break;
        	case FuncLogarithm: System.out.println("LOG " + s.local0 + ", " + s.local1); break;
        	case FuncExponential: System.out.println("EXP " + s.local0 + ", " + s.local1); break;
        	
        	case OpAdd: System.out.println("ADD " + s.local0 + ", " + s.local1 + ", " + s.local2); break;
        	case OpSubtract: System.out.println("SUB " + s.local0 + ", " + s.local1 + ", " + s.local2); break;
        	case OpMultiply: System.out.println("MUL " + s.local0 + ", " + s.local1 + ", " + s.local2); break;
        	case OpDivide: System.out.println("DIV " + s.local0 + ", " + s.local1 + ", " + s.local2); break;
        	case OpExponent: System.out.println("POW " + s.local0 + ", " + s.local1 + ", " + s.local2); break;
        	case OpUminus: System.out.println("UMS " + s.local0 + ", " + s.local1); break;
        	
        	default: break;
        	
        	}
        }
        System.out.println("RET " + output);
	}
	
}
