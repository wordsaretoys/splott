package com.wordsaretoys.splott.plotter;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.wordsaretoys.rise.geometry.Camera;
import com.wordsaretoys.rise.geometry.Vector;
import com.wordsaretoys.rise.utility.Interval;
import com.wordsaretoys.splott.Shared;

/**
 * rendering object for gl surface
 * provides timer, gl & worker thread, and camera/motion state 
 */
public class Render implements GLSurfaceView.Renderer {

	// model objects
	Surface surface;
	
	// player eye-line camera
	public Camera camera;
	
	// looking and moving state
	Vector looking = new Vector();
	boolean moving;

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
		
		Shared.surface = surface = new Surface(parent);
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
	
	public void setMove(boolean on) {
		moving = on;
	}

	public void updateCamera() {
		float dt = interval.next();
		// rotate camera (with roll stabilization)
		camera.turn(0.25f * looking.x * dt, 0.25f * looking.y * dt, 10 * camera.right.y * dt);
		looking.mul(0.9f);
		// move camera if thrusting
		direction.copy(camera.front).mul(moving ? 1 : 0);
		// determine new velocity and position
		direction.mul(dt);
		velocity.add(direction).mul(0.99f);
		camera.move(velocity.x * dt, velocity.y * dt, velocity.z * dt);
	}
}
