package com.wordsaretoys.splott.plotter;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;

import com.wordsaretoys.rise.geometry.Camera;
import com.wordsaretoys.rise.glwrapper.Mesh;
import com.wordsaretoys.rise.glwrapper.Shader;
import com.wordsaretoys.rise.meshutil.IndexBuffer;
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
			
		vertex = new VertexBuffer();
		index = new IndexBuffer();
	}

	/**
	 * generate the mesh
	 */
	public void create(GLSurfaceView parent) {
		vertex.reset();
		index.reset();

		parent.queueEvent(new Runnable() {
			@Override
			public void run() {
				mesh.build(vertex, index);
				Log.d("debris", "built " + vertex.length / mesh.stride + " vertices");
			}
		});
		
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

}
