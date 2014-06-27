attribute vec3 position;

uniform mat4 projector;
uniform mat4 modelview;

varying vec3 obj;

void main(void) {
	vec4 pos = modelview * vec4(position, 1.0) + vec4(0.0, 0.0, -10.0, 0.0);
	gl_Position = projector * pos;
	obj = pos.xyz;
}
