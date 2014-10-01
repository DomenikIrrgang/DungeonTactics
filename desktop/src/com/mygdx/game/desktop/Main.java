package com.mygdx.game.desktop;

import com.DCStudios.VBall.VBall;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title =VBall.name + " " + VBall.version;
		cfg.width = 1080;
		cfg.height = 720;
		
		new LwjglApplication(new VBall(), cfg);
	}
}
