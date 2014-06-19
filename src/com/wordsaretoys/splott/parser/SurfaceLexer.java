// Generated from Surface.g4 by ANTLR 4.2.2

package com.wordsaretoys.splott.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SurfaceLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, VARIABLE=3, FUNCTION=4, ADD=5, SUB=6, MUL=7, DIV=8, POW=9, 
		EQU=10, NUMBER=11, WS=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"')'", "'('", "VARIABLE", "FUNCTION", "'+'", "'-'", "'*'", "'/'", "'^'", 
		"'='", "NUMBER", "WS"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "VARIABLE", "FUNCTION", "ADD", "SUB", "MUL", "DIV", "POW", 
		"EQU", "NUMBER", "INT", "EXP", "WS"
	};


	public SurfaceLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Surface.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16k\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\5\fA\n\f\3\f\3\f\3\f\3\f\5\fG\n"+
		"\f\3\f\5\fJ\n\f\3\f\3\f\3\f\3\f\5\fP\n\f\3\f\5\fS\n\f\3\r\3\r\3\r\7\r"+
		"X\n\r\f\r\16\r[\13\r\5\r]\n\r\3\16\3\16\5\16a\n\16\3\16\3\16\3\17\6\17"+
		"f\n\17\r\17\16\17g\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\2\33\2\35\16\3\2\b\4\2vvz|\3\2\63;\3\2\62;\4\2GGg"+
		"g\4\2--//\5\2\13\f\17\17\"\"u\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3"+
		"\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219\3\2\2"+
		"\2\23;\3\2\2\2\25=\3\2\2\2\27R\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35e\3"+
		"\2\2\2\37 \7+\2\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\t\2\2\2$\b\3\2\2"+
		"\2%&\7u\2\2&\'\7k\2\2\'\62\7p\2\2()\7e\2\2)*\7q\2\2*\62\7u\2\2+,\7g\2"+
		"\2,-\7z\2\2-\62\7r\2\2./\7n\2\2/\60\7q\2\2\60\62\7i\2\2\61%\3\2\2\2\61"+
		"(\3\2\2\2\61+\3\2\2\2\61.\3\2\2\2\62\n\3\2\2\2\63\64\7-\2\2\64\f\3\2\2"+
		"\2\65\66\7/\2\2\66\16\3\2\2\2\678\7,\2\28\20\3\2\2\29:\7\61\2\2:\22\3"+
		"\2\2\2;<\7`\2\2<\24\3\2\2\2=>\7?\2\2>\26\3\2\2\2?A\7/\2\2@?\3\2\2\2@A"+
		"\3\2\2\2AB\3\2\2\2BC\5\31\r\2CD\7\60\2\2DF\5\31\r\2EG\5\33\16\2FE\3\2"+
		"\2\2FG\3\2\2\2GS\3\2\2\2HJ\7/\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\5\31"+
		"\r\2LM\5\33\16\2MS\3\2\2\2NP\7/\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QS\5"+
		"\31\r\2R@\3\2\2\2RI\3\2\2\2RO\3\2\2\2S\30\3\2\2\2T]\7\62\2\2UY\t\3\2\2"+
		"VX\t\4\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2"+
		"\\T\3\2\2\2\\U\3\2\2\2]\32\3\2\2\2^`\t\5\2\2_a\t\6\2\2`_\3\2\2\2`a\3\2"+
		"\2\2ab\3\2\2\2bc\5\31\r\2c\34\3\2\2\2df\t\7\2\2ed\3\2\2\2fg\3\2\2\2ge"+
		"\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\b\17\2\2j\36\3\2\2\2\r\2\61@FIORY\\`g\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}