package com.wordsaretoys.splott.plotter;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.wordsaretoys.rise.geometry.Camera;
import com.wordsaretoys.rise.geometry.Vector;
import com.wordsaretoys.rise.utility.Interval;

/**
 * rendering object for gl surface
 * provides timer, gl & worker thread, and camera/motion state 
 */
public class Render implements GLSurfaceView.Renderer {

	// surface model object
	// made static for cheap access from activity
	public static Surface surface;
	
	// player eye-line camera
	public Camera camera;
	
	// looking state
	Vector looking = new Vector();

	// timer interval
	Interval interval = new Interval();
	
	// movement handling vectors
	Vector direction = new Vector();
	Vector velocity = new Vector();

	// gl view parent
	GlView parent;

	/**
	 * ctor
	 */
	public Render(GlView p) {
		camera = new Camera(30, 0.01f, 100);
		parent = p;
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		GLES20.glClearDepthf(1.0f);
		GLES20.glDepthFunc(GLES20.GL_LEQUAL);
		GLES20.glEnable(GLES20.GL_DEPTH_TEST);
		GLES20.glClearColor(1f, 0.8f, 0.8f, 1);
		GLES20.glDisable(GLES20.GL_BLEND);
		GLES20.glDisable(GLES20.GL_CULL_FACE);
		
		surface = new Surface(parent);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		camera.size(width, height);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		updateCamera();
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		surface.draw(camera);
	}
	
	public void setLook(float dx, float dy) {
		looking.set(-0.5f * dy, -0.5f * dx, 0);
	}
	
	public void updateCamera() {
		float dt = interval.next();
		// rotate camera
		camera.turn(0.25f * looking.x * dt, 0.25f * looking.y * dt, 0);
		looking.mul(0.9f);
	}
}
