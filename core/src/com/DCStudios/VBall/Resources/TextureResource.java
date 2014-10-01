package com.DCStudios.VBall.Resources;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class TextureResource {
private static AssetManager manager;
	
	public static final String path = "data/";	
	public static final String COMBAT_BACKGROUND = path + "FIGHT_BACKGROUND.png";
	public static final String COMBAT_ANIMATION_EXPLOSION = path + "explosion.png";
	public static final String COMBAT_ANIMATION_MONSTER = path + "testAnimation.png";
	
	public static Texture get(String id) {
		manager.finishLoading();
		return manager.get(id, Texture.class);
	}
	
	public static void load() {
		manager = new AssetManager();
		
		TextureParameter parameter = new TextureParameter();
		parameter.minFilter = TextureFilter.Linear;
		parameter.magFilter = TextureFilter.Linear;
		parameter.genMipMaps = true;

		manager.load(COMBAT_BACKGROUND, Texture.class, parameter);
		manager.load(COMBAT_ANIMATION_EXPLOSION, Texture.class, parameter);
		manager.load(COMBAT_ANIMATION_MONSTER, Texture.class, parameter);
		
	}
}
