package com.wordsaretoys.splott.plotter;

import com.wordsaretoys.rise.geometry.Camera;
import com.wordsaretoys.rise.geometry.Vector;
import com.wordsaretoys.rise.glwrapper.Mesh;
import com.wordsaretoys.rise.glwrapper.Shader;
import com.wordsaretoys.rise.meshutil.IndexBuffer;
import com.wordsaretoys.rise.meshutil.SurfaceMapper;
import com.wordsaretoys.rise.meshutil.VertexBuffer;
import com.wordsaretoys.rise.utility.Asset;
import com.wordsaretoys.splott.parser.Vm;

public class Surface {

	VertexBuffer vertex;
	IndexBuffer index;
	Mesh mesh;
	Shader shader;
	Vm vm;
	GlView parent;

	/**
	 * ctor; creates GL objects
	 * must be called in GL context
	 */
	public Surface(GlView parent) {
		
		this.parent = parent;
		
		shader = new Shader();
		shader.build(
        	Asset.getTextAsset(parent.getContext(), "surfaceVert.glsl"),
        	Asset.getTextAsset(parent.getContext(), "surfaceFrag.glsl")
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
	public void create(Vm vm) {
		this.vm = vm;
		
		vertex.reset();
		index.reset();
		
		new Thread() {
			@Override public void run() {
				
				new Mapper().generate(-5, -5, -5, 5, 5, 5, 0.25f, 0);
				parent.queueEvent(new Runnable() {
					@Override public void run() {
						mesh.build(vertex);
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
		shader.setMatrix("modelview", camera.rotations);
		shader.setMatrix("projector", camera.projector);
		mesh.draw();
	}

	/**
	 * marching cubes class
	 */
	class Mapper extends SurfaceMapper {

		@Override
		public float field(float x, float y, float z) {
			return (float) vm.get(x, y, z, 0);
		}

		@Override
		public void build(Vector v0, Vector v1, Vector v2, Vector n) {
			vertex.set(v0.x, v0.y, v0.z);
			vertex.set(v1.x, v1.y, v1.z);
			vertex.set(v2.x, v2.y, v2.z);
		}
		
	}
	
}
