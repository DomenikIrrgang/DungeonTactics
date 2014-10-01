package com.DCStudios.VBall.Interface;

import com.badlogic.gdx.math.Vector2;

public interface MouseListener {
	void onMouseMove(Vector2 position);
	void onMousePress(Vector2 position);
	void onMouseRelease(Vector2 position);
}
