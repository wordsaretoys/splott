// Generated from Surface.g4 by ANTLR 4.2.2

package com.wordsaretoys.splott.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SurfaceParser}.
 */
public interface SurfaceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SurfaceParser#muldivExpr}.
	 * @param ctx the parse tree
	 */
	void enterMuldivExpr(@NotNull SurfaceParser.MuldivExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#muldivExpr}.
	 * @param ctx the parse tree
	 */
	void exitMuldivExpr(@NotNull SurfaceParser.MuldivExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#surface}.
	 * @param ctx the parse tree
	 */
	void enterSurface(@NotNull SurfaceParser.SurfaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#surface}.
	 * @param ctx the parse tree
	 */
	void exitSurface(@NotNull SurfaceParser.SurfaceContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(@NotNull SurfaceParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(@NotNull SurfaceParser.NumExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#equalsExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExpr(@NotNull SurfaceParser.EqualsExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#equalsExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExpr(@NotNull SurfaceParser.EqualsExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#varExpr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(@NotNull SurfaceParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#varExpr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(@NotNull SurfaceParser.VarExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#parensExpr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(@NotNull SurfaceParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#parensExpr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(@NotNull SurfaceParser.ParensExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(@NotNull SurfaceParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#funcExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(@NotNull SurfaceParser.FuncExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#uminusExpr}.
	 * @param ctx the parse tree
	 */
	void enterUminusExpr(@NotNull SurfaceParser.UminusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#uminusExpr}.
	 * @param ctx the parse tree
	 */
	void exitUminusExpr(@NotNull SurfaceParser.UminusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#addsubExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddsubExpr(@NotNull SurfaceParser.AddsubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#addsubExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddsubExpr(@NotNull SurfaceParser.AddsubExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link SurfaceParser#expExpr}.
	 * @param ctx the parse tree
	 */
	void enterExpExpr(@NotNull SurfaceParser.ExpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SurfaceParser#expExpr}.
	 * @param ctx the parse tree
	 */
	void exitExpExpr(@NotNull SurfaceParser.ExpExprContext ctx);
}