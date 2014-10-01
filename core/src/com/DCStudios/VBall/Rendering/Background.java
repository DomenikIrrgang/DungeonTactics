package com.DCStudios.VBall.Rendering;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Background extends GameObject {

	public Background(Texture texture, Vector2 position, Measure measure) {
		super(texture, position, measure);		
	}

}
