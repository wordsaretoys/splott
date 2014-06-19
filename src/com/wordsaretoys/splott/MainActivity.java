package com.wordsaretoys.splott;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String eq = "sin(-2.5-y+z)/(-3-z)=x*2=7";
		new Compiler().compile(eq);
		
	}

}
