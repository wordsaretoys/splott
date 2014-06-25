package com.wordsaretoys.splott;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

	
	EquationFragment equationFragment;
	LimitsFragment limitsFragment;
	SurfaceFragment surfaceFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int selectedTab = 0;
		
		if (savedInstanceState != null) {
			selectedTab = savedInstanceState.getInt("selectedTab");
		}
//		getActionBar().setTitle("???");
		
		equationFragment = (EquationFragment) 
				getFragmentManager().findFragmentById(R.id.equationFragment);
		limitsFragment = (LimitsFragment) 
				getFragmentManager().findFragmentById(R.id.limitsFragment);
		surfaceFragment = (SurfaceFragment)
				getFragmentManager().findFragmentById(R.id.surfaceFragment);
		
		// create the action bar tabs
		Tab equationTab = getActionBar().newTab()
			.setText(R.string.tab_equation)
			.setTabListener(new TabListener() {
				@Override
				public void onTabSelected(Tab tab, FragmentTransaction ft) {
					ft.show(equationFragment);
				}
				public void onTabUnselected(Tab tab, FragmentTransaction ft) {
					ft.hide(equationFragment);
				}
				public void onTabReselected(Tab tab, FragmentTransaction ft) {}
			}
		);
		getActionBar().addTab(equationTab);

		Tab limitsTab = getActionBar().newTab()
			.setText(R.string.tab_limits)
			.setTabListener(new TabListener() {
				@Override
				public void onTabSelected(Tab tab, FragmentTransaction ft) {
					ft.show(limitsFragment);
				}
				public void onTabUnselected(Tab tab, FragmentTransaction ft) {
					ft.hide(limitsFragment);
				}
				public void onTabReselected(Tab tab, FragmentTransaction ft) {}
			}
		);
		getActionBar().addTab(limitsTab);

		Tab surfaceTab = getActionBar().newTab()
			.setText(R.string.tab_surface)
			.setTabListener(new TabListener() {
				@Override
				public void onTabSelected(Tab tab, FragmentTransaction ft) {
					ft.show(surfaceFragment);
				}
				public void onTabUnselected(Tab tab, FragmentTransaction ft) {
					ft.hide(surfaceFragment);
				}
				public void onTabReselected(Tab tab, FragmentTransaction ft) {}
			}
		);
		getActionBar().addTab(surfaceTab);

		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getActionBar().setSelectedNavigationItem(selectedTab);
		
		getFragmentManager().beginTransaction()
			.show(equationFragment)
			.hide(limitsFragment)
			.hide(surfaceFragment)
			.commit();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("selectedTab", 
			getActionBar().getSelectedTab().getPosition());
	}

	
/*
 
	Compiler compiler;
	Method getMethod;
	
	compiler = new Compiler(this);

	String eq = eqEdit.getText().toString();
	getMethod = compiler.compile(eq);
	
	double x = Double.parseDouble(xEdit.getText().toString());
	double y = Double.parseDouble(yEdit.getText().toString());
	double z = Double.parseDouble(zEdit.getText().toString());
	double t = Double.parseDouble(tEdit.getText().toString());
	Object o = getMethod.invoke(null, x, y, z, t);
	answerText.setText(o.toString());

 */
}
