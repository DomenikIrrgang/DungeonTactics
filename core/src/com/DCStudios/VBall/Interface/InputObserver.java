package com.DCStudios.VBall.Interface;

import com.badlogic.gdx.math.Vector2;


public interface InputObserver {
	void keyInput(KeyEvent event, int keyCode);
	void mouseInput(MouseEvent event, Vector2 position);
}
