package com.wordsaretoys.splott;

import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button compileButton, runButton;
	EditText eqEdit, xEdit, yEdit, zEdit, tEdit;
	TextView answerText;
	
	Compiler compiler;
	Method getMethod;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		compiler = new Compiler(this);
		
		compileButton = (Button) findViewById(R.id.compile);
		runButton = (Button) findViewById(R.id.run);

		eqEdit = (EditText) findViewById(R.id.equation);
		xEdit = (EditText) findViewById(R.id.inputX);
		yEdit = (EditText) findViewById(R.id.inputY);
		zEdit = (EditText) findViewById(R.id.inputZ);
		tEdit = (EditText) findViewById(R.id.inputT);
		
		answerText = (TextView) findViewById(R.id.answer);
		
		compileButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String eq = eqEdit.getText().toString();
				getMethod = compiler.compile(eq);
			}
		});

		runButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					double x = Double.parseDouble(xEdit.getText().toString());
					double y = Double.parseDouble(yEdit.getText().toString());
					double z = Double.parseDouble(zEdit.getText().toString());
					double t = Double.parseDouble(tEdit.getText().toString());
					Object o = getMethod.invoke(null, x, y, z, t);
					answerText.setText(o.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
