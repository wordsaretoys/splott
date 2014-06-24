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
		"')'", "'('", "VARIABLE", "FUNCTION", "'+'", "'-'", "'*'", "'/'", "'**'", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16l\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\5\fB\n\f\3\f\3\f\3\f\3\f\5"+
		"\fH\n\f\3\f\5\fK\n\f\3\f\3\f\3\f\3\f\5\fQ\n\f\3\f\5\fT\n\f\3\r\3\r\3\r"+
		"\7\rY\n\r\f\r\16\r\\\13\r\5\r^\n\r\3\16\3\16\5\16b\n\16\3\16\3\16\3\17"+
		"\6\17g\n\17\r\17\16\17h\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\2\33\2\35\16\3\2\b\4\2vvz|\3\2\63;\3\2\62;\4"+
		"\2GGgg\4\2--//\5\2\13\f\17\17\"\"v\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2"+
		"\7#\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17\67\3\2\2\2\219"+
		"\3\2\2\2\23;\3\2\2\2\25>\3\2\2\2\27S\3\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35"+
		"f\3\2\2\2\37 \7+\2\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\t\2\2\2$\b\3\2"+
		"\2\2%&\7u\2\2&\'\7k\2\2\'\62\7p\2\2()\7e\2\2)*\7q\2\2*\62\7u\2\2+,\7g"+
		"\2\2,-\7z\2\2-\62\7r\2\2./\7n\2\2/\60\7q\2\2\60\62\7i\2\2\61%\3\2\2\2"+
		"\61(\3\2\2\2\61+\3\2\2\2\61.\3\2\2\2\62\n\3\2\2\2\63\64\7-\2\2\64\f\3"+
		"\2\2\2\65\66\7/\2\2\66\16\3\2\2\2\678\7,\2\28\20\3\2\2\29:\7\61\2\2:\22"+
		"\3\2\2\2;<\7,\2\2<=\7,\2\2=\24\3\2\2\2>?\7?\2\2?\26\3\2\2\2@B\7/\2\2A"+
		"@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\31\r\2DE\7\60\2\2EG\5\31\r\2FH\5\33"+
		"\16\2GF\3\2\2\2GH\3\2\2\2HT\3\2\2\2IK\7/\2\2JI\3\2\2\2JK\3\2\2\2KL\3\2"+
		"\2\2LM\5\31\r\2MN\5\33\16\2NT\3\2\2\2OQ\7/\2\2PO\3\2\2\2PQ\3\2\2\2QR\3"+
		"\2\2\2RT\5\31\r\2SA\3\2\2\2SJ\3\2\2\2SP\3\2\2\2T\30\3\2\2\2U^\7\62\2\2"+
		"VZ\t\3\2\2WY\t\4\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2"+
		"\2\\Z\3\2\2\2]U\3\2\2\2]V\3\2\2\2^\32\3\2\2\2_a\t\5\2\2`b\t\6\2\2a`\3"+
		"\2\2\2ab\3\2\2\2bc\3\2\2\2cd\5\31\r\2d\34\3\2\2\2eg\t\7\2\2fe\3\2\2\2"+
		"gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\b\17\2\2k\36\3\2\2\2\r\2\61"+
		"AGJPSZ]ah\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}