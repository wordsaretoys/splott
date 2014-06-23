package com.wordsaretoys.splott;

import android.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;

public class EquationFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
		View view = inflater.inflate(R.layout.equation_fragment, container, false);
		
		final EditText source = (EditText) view.findViewById(R.id.source);
		source.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				source.setInputType(InputType.TYPE_NULL);
				source.onTouchEvent(event);
				source.setInputType(InputType.TYPE_CLASS_TEXT);
				return true;
			}
		});
		
		return view;
	}
	
}
