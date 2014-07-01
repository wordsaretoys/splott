package com.wordsaretoys.splott.parser;

import com.wordsaretoys.splott.parser.Compiler.Step;

public class Vm {
	
	double[] locals;
	Step[] steps;
	int output;
	
	public Vm(Step[] s, int lc, int o) {
		steps = s;
		locals = new double[lc];
		output = o;
	}
	
	public double get(double x, double y, double z, double t) {
		locals[0] = x;
		locals[1] = y;
		locals[2] = z;
		locals[3] = t;
		for (int i = 0; i < steps.length; i++) {
			Step step = steps[i];
			switch (step.type) {

			case LoadConstant:
				locals[step.local0] = step.constant;
				break;
				
			case OpAdd:
				locals[step.local2] = locals[step.local0] + locals[step.local1];
				break;
				
			case OpSubtract:
				locals[step.local2] = locals[step.local0] - locals[step.local1];
				break;

			case OpMultiply:
				locals[step.local2] = locals[step.local0] * locals[step.local1];
				break;

			case OpDivide:
				locals[step.local2] = locals[step.local0] / locals[step.local1];
				break;

			case OpExponent:
				locals[step.local2] = Math.pow(locals[step.local0], locals[step.local1]);
				break;
				
			case OpUminus:
				locals[step.local1] = -locals[step.local0];
				break;
				
			case FuncSine:
				locals[step.local1] = Math.sin(locals[step.local0]);
				break;
			
			case FuncCosine:
				locals[step.local1] = Math.cos(locals[step.local0]);
				break;

			case FuncLogarithm:
				locals[step.local1] = Math.log(locals[step.local0]);
				break;
				
			case FuncExponential:
				locals[step.local1] = Math.exp(locals[step.local0]);
				break;
			}
		}
		return locals[output];
	}
	
}
