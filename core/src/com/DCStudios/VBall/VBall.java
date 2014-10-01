package com.DCStudios.VBall;

import com.DCStudios.VBall.Interface.Input;
import com.DCStudios.VBall.Resources.TextureResource;
import com.DCStudios.VBall.Screens.MainMenue.MainMenueScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.sun.corba.se.impl.io.InputStreamHook;


public class VBall extends Game {
	
	public static final String name = "Dungeon Tactics";
	public static final String version = "0.0.0.10 Pre-Alpha";
	public static final Input input = new Input();
	static final public boolean debug = false;
	
	@Override
	public void create() {	
		TextureResource.load();
		Gdx.input.setInputProcessor(input);
		setScreen(new MainMenueScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
