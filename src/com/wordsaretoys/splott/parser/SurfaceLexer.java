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
		"EQU", "NUMBER", "INT", "FRA", "EXP", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16s\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\5\fD\n\f\3\f\3\f"+
		"\3\f\3\f\5\fJ\n\f\3\f\5\fM\n\f\3\f\3\f\3\f\3\f\5\fS\n\f\3\f\5\fV\n\f\3"+
		"\r\3\r\3\r\7\r[\n\r\f\r\16\r^\13\r\5\r`\n\r\3\16\6\16c\n\16\r\16\16\16"+
		"d\3\17\3\17\5\17i\n\17\3\17\3\17\3\20\6\20n\n\20\r\20\16\20o\3\20\3\20"+
		"\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35"+
		"\2\37\16\3\2\b\4\2vvz|\3\2\63;\3\2\62;\4\2GGgg\4\2--//\5\2\13\f\17\17"+
		"\"\"}\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\63\3\2\2\2\13\65"+
		"\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25@\3\2\2\2"+
		"\27U\3\2\2\2\31_\3\2\2\2\33b\3\2\2\2\35f\3\2\2\2\37m\3\2\2\2!\"\7+\2\2"+
		"\"\4\3\2\2\2#$\7*\2\2$\6\3\2\2\2%&\t\2\2\2&\b\3\2\2\2\'(\7u\2\2()\7k\2"+
		"\2)\64\7p\2\2*+\7e\2\2+,\7q\2\2,\64\7u\2\2-.\7g\2\2./\7z\2\2/\64\7r\2"+
		"\2\60\61\7n\2\2\61\62\7q\2\2\62\64\7i\2\2\63\'\3\2\2\2\63*\3\2\2\2\63"+
		"-\3\2\2\2\63\60\3\2\2\2\64\n\3\2\2\2\65\66\7-\2\2\66\f\3\2\2\2\678\7/"+
		"\2\28\16\3\2\2\29:\7,\2\2:\20\3\2\2\2;<\7\61\2\2<\22\3\2\2\2=>\7,\2\2"+
		">?\7,\2\2?\24\3\2\2\2@A\7?\2\2A\26\3\2\2\2BD\7/\2\2CB\3\2\2\2CD\3\2\2"+
		"\2DE\3\2\2\2EF\5\31\r\2FG\7\60\2\2GI\5\33\16\2HJ\5\35\17\2IH\3\2\2\2I"+
		"J\3\2\2\2JV\3\2\2\2KM\7/\2\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\5\31\r\2"+
		"OP\5\35\17\2PV\3\2\2\2QS\7/\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\5\31\r"+
		"\2UC\3\2\2\2UL\3\2\2\2UR\3\2\2\2V\30\3\2\2\2W`\7\62\2\2X\\\t\3\2\2Y[\t"+
		"\4\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2\2\2^\\\3\2\2\2"+
		"_W\3\2\2\2_X\3\2\2\2`\32\3\2\2\2ac\t\4\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2e\34\3\2\2\2fh\t\5\2\2gi\t\6\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2"+
		"\2\2jk\5\31\r\2k\36\3\2\2\2ln\t\7\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op"+
		"\3\2\2\2pq\3\2\2\2qr\b\20\2\2r \3\2\2\2\16\2\63CILRU\\_dho\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}