package com.DCStudios.VBall.Interface;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class Input implements InputProcessor {
	
	private List<InputObserver> observer = new ArrayList<InputObserver>();
	
	public void addObserver(InputObserver observer) {
		this.observer.add(observer);
	}
	
	public void removeObserver(InputObserver observer) {
		this.removeObserver(observer);
	}

	@Override
	public boolean keyDown(int keycode) {
		for (InputObserver io : observer) {
			io.keyInput(KeyEvent.PRESS, keycode);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		for (InputObserver io : observer) {
			io.keyInput(KeyEvent.RELEASE, keycode);
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		for (InputObserver io : observer) {
			io.mouseInput(MouseEvent.PRESS, new Vector2(screenX, screenY));
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		InputObserver io;
		for (int i = 0; i < observer.size(); i++) {
			io = observer.get(i);
			io.mouseInput(MouseEvent.RELEASE, new Vector2(screenX, screenY));
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		for (InputObserver io : observer) {
			io.mouseInput(MouseEvent.MOVE, new Vector2(screenX, screenY));
		}
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
