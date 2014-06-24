grammar Surface;

@header {
package com.wordsaretoys.splott.parser;
}

surface : expr ;

expr
		:	NUMBER		# numExpr
		|	VARIABLE	# varExpr
		|	SUB expr	# uminusExpr
		|	expr ( MUL | DIV ) expr		# muldivExpr
		|	expr ( ADD | SUB ) expr		# addsubExpr
		|	expr POW expr	# expExpr
		|	FUNCTION '(' expr ')'		# funcExpr
		|	'(' expr ')'	# parensExpr
		|	expr EQU expr	#equalsExpr
		;

VARIABLE : [xyzt] ;

FUNCTION : 'sin' | 'cos' | 'exp' | 'log' ;

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
DIV : '/' ;
POW : '**' ;
EQU : '=' ;

//
// taken from ANTLR4 JSON grammar example
//

NUMBER
    :   '-'? INT '.' FRA EXP?   // 1.35, 1.35E-9, 0.3, -4.5
    |   '-'? INT EXP            // 1e10 -3e4
    |   '-'? INT                // -3, 45
    ;
fragment INT :	'0' | [1-9] [0-9]* ; // no leading zeros
fragment FRA :	[0-9]+ ;			// leading zeros ok
fragment EXP :	[Ee] [+\-]? INT ; // \- since - means "range" inside [...]

WS  :   [ \t\n\r]+ -> skip ;
