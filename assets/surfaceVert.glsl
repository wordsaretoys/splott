attribute vec3 position;

uniform mat4 projector;
uniform mat4 modelview;

varying vec3 tex;

void main(void) {
	vec4 pos = modelview * vec4(position, 1.0);
	gl_Position = projector * pos;
	tex = pos.xyz;
}
