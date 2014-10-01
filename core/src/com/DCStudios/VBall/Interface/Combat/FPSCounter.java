package com.DCStudios.VBall.Interface.Combat;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class FPSCounter extends InterfaceObject {

	public FPSCounter(Vector2 position, Measure measure) {
		super(position, measure);
	}

	@Override
	public void render(SpriteBatch batch) {
		font.draw(batch, String.valueOf(Gdx.graphics.getFramesPerSecond()), getPosition().x, getPosition().y);
	}

	@Override
	public void update() {
	}

}
