package com.wordsaretoys.splott.plotter;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.wordsaretoys.rise.geometry.Camera;
import com.wordsaretoys.rise.geometry.Vector;
import com.wordsaretoys.rise.glwrapper.Mesh;
import com.wordsaretoys.rise.glwrapper.Shader;
import com.wordsaretoys.rise.meshutil.IndexBuffer;
import com.wordsaretoys.rise.meshutil.SurfaceMapper;
import com.wordsaretoys.rise.meshutil.VertexBuffer;
import com.wordsaretoys.rise.utility.Asset;

public class Surface {

	VertexBuffer vertex;
	IndexBuffer index;
	Mesh mesh;
	Shader shader;

	/**
	 * ctor; creates GL objects
	 * must be called in GL context
	 */
	public Surface(Context context) {
		
		shader = new Shader();
		shader.build(
        	Asset.getTextAsset(context, "surfaceVert.glsl"),
        	Asset.getTextAsset(context, "surfaceFrag.glsl")
        );

		int[] attr = {
			shader.getAttributeId("position"), 3
		};
		mesh = new Mesh(attr);
//		mesh.drawPrimitive = GLES20.GL_POINTS;
			
		vertex = new VertexBuffer();
		index = new IndexBuffer();
	}

	/**
	 * generate the mesh
	 */
	public void create(final GLSurfaceView parent) {
		vertex.reset();
		index.reset();
		
		new Thread() {
			@Override public void run() {
				
				new Mapper().generate(-5, -5, -5, 5, 5, 5, 0.25f, 0);
				parent.queueEvent(new Runnable() {
					@Override public void run() {
//						mesh.build(vertex, index);
						mesh.build(vertex);
						Log.d("debris", "built " + vertex.length / mesh.stride + " vertices");
					}
				});
				
			}
		}.start();

		
	}

	/**
	 * draw the mesh
	 */
	public void draw(Camera camera) {
		shader.activate();
		shader.setMatrix("modelview", camera.modelview);
		shader.setMatrix("projector", camera.projector);
		mesh.draw();
	}

	/**
	 * marching cubes class
	 */
	class Mapper extends SurfaceMapper {

		@Override
		public float field(float x, float y, float z) {
			return (float)(Math.sin(x * Math.sin(y * Math.sin(z))));
		}

		@Override
		public void build(Vector v0, Vector v1, Vector v2, Vector n) {
			vertex.set(v0.x, v0.y, v0.z);
			vertex.set(v1.x, v1.y, v1.z);
			vertex.set(v2.x, v2.y, v2.z);
		}
		
	}
	
}
