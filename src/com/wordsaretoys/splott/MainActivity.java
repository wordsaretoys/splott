package com.wordsaretoys.splott;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.wordsaretoys.splott.parser.Compiler;
import com.wordsaretoys.splott.parser.Compiler.Vm;
import com.wordsaretoys.splott.parser.SyntaxChecker;

public class MainActivity extends Activity {

	// maps key buttons to generated key codes
	static int[][] keymap = {
		
		{ R.id.key_0, KeyEvent.KEYCODE_0 },
		{ R.id.key_1, KeyEvent.KEYCODE_1 },
		{ R.id.key_2, KeyEvent.KEYCODE_2 },
		{ R.id.key_3, KeyEvent.KEYCODE_3 },
		{ R.id.key_4, KeyEvent.KEYCODE_4 },
		{ R.id.key_5, KeyEvent.KEYCODE_5 },
		{ R.id.key_6, KeyEvent.KEYCODE_6 },
		{ R.id.key_7, KeyEvent.KEYCODE_7 },
		{ R.id.key_8, KeyEvent.KEYCODE_8 },
		{ R.id.key_9, KeyEvent.KEYCODE_9 },
		
		{ R.id.key_add, KeyEvent.KEYCODE_PLUS },
		{ R.id.key_sub, KeyEvent.KEYCODE_MINUS },
		{ R.id.key_mul, KeyEvent.KEYCODE_STAR },
		{ R.id.key_div, KeyEvent.KEYCODE_SLASH },
		{ R.id.key_dpt, KeyEvent.KEYCODE_PERIOD },
		{ R.id.key_lpr, KeyEvent.KEYCODE_NUMPAD_LEFT_PAREN },
		{ R.id.key_rpr, KeyEvent.KEYCODE_NUMPAD_RIGHT_PAREN },
		{ R.id.key_equ, KeyEvent.KEYCODE_EQUALS },

		{ R.id.key_x, KeyEvent.KEYCODE_X },
		{ R.id.key_y, KeyEvent.KEYCODE_Y },
		{ R.id.key_z, KeyEvent.KEYCODE_Z },
		{ R.id.key_t, KeyEvent.KEYCODE_T },
		
		{ R.id.key_sin, KeyEvent.KEYCODE_S, KeyEvent.KEYCODE_I, KeyEvent.KEYCODE_N },
		{ R.id.key_cos, KeyEvent.KEYCODE_C, KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_S },
		{ R.id.key_log, KeyEvent.KEYCODE_L, KeyEvent.KEYCODE_O, KeyEvent.KEYCODE_G },
		{ R.id.key_exp, KeyEvent.KEYCODE_E, KeyEvent.KEYCODE_X, KeyEvent.KEYCODE_P },
		
		{ R.id.key_del, KeyEvent.KEYCODE_DEL }
		
	};

	EditText source;
	SyntaxChecker syntax;
	Compiler compiler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// TODO: rotation will lose vm state??
		syntax = new SyntaxChecker();
		compiler = new Compiler();
		
		source = (EditText) findViewById(R.id.source);
		
		// when source changes
		source.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String eq = s.toString();
				int errors = syntax.parse(eq);
				source.setTextColor(errors > 0 ? Color.RED : Color.BLACK);
				if (errors == 0) {
					Vm vm = compiler.compile(eq);
					Shared.surface.create(vm);
				}
			}
			@Override
			public void afterTextChanged(Editable s) {}
		});
	
		// set up button dispatch to source editor
		for (int i = 0; i < keymap.length; i++) {
			final int[] keys = keymap[i];
			// first field is the resource id of the key view
			TextView tv = (TextView) findViewById(keys[0]);
			tv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// remaining fields are keycodes to send
					for (int k = 1; k < keys.length; k++) {
						source.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keys[k]));
					}
				}
			});
		}
		
		// prevents soft keyboard from popping up on click
		// (while preserving ability to position/select cursor)
		final InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		source.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				im.hideSoftInputFromWindow(source.getWindowToken(), 0);
			}
		});
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
