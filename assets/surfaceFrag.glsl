precision mediump float;

varying vec3 tex;

void main(void) {
	gl_FragColor = vec4(tex, 1.0);
}
