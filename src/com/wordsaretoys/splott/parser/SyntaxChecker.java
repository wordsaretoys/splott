package com.wordsaretoys.splott.parser;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

/**
 * attempts to parse equation
 * and returns error state
 */
public class SyntaxChecker {

	int errors;

	public int parse(String eq) {
        // generate the parse tree
        ANTLRInputStream input = new ANTLRInputStream(eq);
        SurfaceLexer lexer = new SurfaceLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SurfaceParser parser = new SurfaceParser(tokens);
        parser.addErrorListener(new ANTLRErrorListener() {
			@Override
			public void reportAmbiguity(@NotNull Parser arg0, @NotNull DFA arg1, int arg2, int arg3, boolean arg4,@Nullable BitSet arg5, @NotNull ATNConfigSet arg6) {
				errors++;
			}
			@Override
			public void reportAttemptingFullContext(@NotNull Parser arg0, @NotNull DFA arg1, int arg2, int arg3, @Nullable BitSet arg4, @NotNull ATNConfigSet arg5) {
				errors++;
			}
			@Override
			public void reportContextSensitivity(@NotNull Parser arg0, @NotNull DFA arg1, int arg2, int arg3, int arg4, @NotNull ATNConfigSet arg5) {
				errors++;
			}
			@Override
			public void syntaxError(@NotNull Recognizer<?, ?> arg0, @Nullable Object arg1, int arg2, int arg3, @NotNull String arg4, @Nullable RecognitionException arg5) {
				errors++;
			}
        });
        errors = 0;
        parser.surface();
        return errors;
	}

}
