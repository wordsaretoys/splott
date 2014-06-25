precision mediump float;

varying vec3 obj;

void main(void) {
	float lit = (10.0 - length(obj)) / 10.0;
	gl_FragColor = vec4(0.8, 1.0, 0.8, 1.0) * lit;
}
