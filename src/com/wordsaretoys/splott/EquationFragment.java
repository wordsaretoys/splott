package com.wordsaretoys.splott;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class EquationFragment extends Fragment {

	// maps key buttons to generated key codes
	int[][] keymap = {
		
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
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
		View view = inflater.inflate(R.layout.equation_fragment, container, false);
		
		source = (EditText) view.findViewById(R.id.source);
		
		for (int i = 0; i < keymap.length; i++) {
			final int[] keys = keymap[i];
			// first field is the resource id of the key view
			TextView tv = (TextView) view.findViewById(keys[0]);
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
		source.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				InputMethodManager im = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				im.hideSoftInputFromWindow(source.getWindowToken(), 0);
			}
		});
		
		return view;
	}

	/**
	 * new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_xxx)
	 * view.dispatchKeyEvent(event)
	 */
}
