package com.wordsaretoys.splott.plotter;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class GlView extends GLSurfaceView {

	// gesture detector & listener
	GestureDetector gestureDetector;
	GestureListener gestureListener;
	
	// renderer
	Render render;
	
	/**
	 * xml-compatible ctor
	 */
	public GlView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		setEGLContextClientVersion(2);
		setRenderer(render = new Render(this));
		
		gestureListener = new GestureListener();
		gestureDetector = new GestureDetector(context, gestureListener);
		gestureDetector.setIsLongpressEnabled(false);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		// handle raw events for movement
		switch (e.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
			render.setMove(true);
			break;
		case MotionEvent.ACTION_UP:
			render.setMove(false);
			break;
		}
		return gestureDetector.onTouchEvent(e) || super.onTouchEvent(e);
	}
	
	/**
	 * gesture detector listener
	 */
	class GestureListener extends SimpleOnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {
			// must return true for other events to happen
			return true;
		}
		@Override
		public boolean onScroll(MotionEvent e0, MotionEvent e1, float dx, float dy) {
			render.setLook(dx, dy);
			return true;
		}
	}
	
}
