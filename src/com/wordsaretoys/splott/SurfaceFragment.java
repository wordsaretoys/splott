package com.wordsaretoys.splott;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SurfaceFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
		View view = inflater.inflate(R.layout.surface_fragment, container, false);
		return view;
	}
	
}
