package com.DCStudios.VBall.Interface.Combat;

import RoundBasedCombat.BuffType;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.InterfaceObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public abstract class Tooltip extends InterfaceObject{
	
	protected Color color = new Color(0.2f, 0.2f, 0.2f, 0f);
	protected Color colorGrey = new Color(0.2f, 0.2f, 0.2f, 0f);

	public Tooltip(Vector2 position, Measure measure) {
		super(position, measure);
	}

	@Override
	public void render(SpriteBatch batch) {
		
		batch.end();

		render.begin(ShapeType.Filled);
		render.setColor(color);
		render.rect(getPosition().x, getPosition().y, getMeasure().width, getMeasure().height);
		render.end();
		
		render.begin(ShapeType.Line);
		render.setColor(Color.BLACK);
		render.rect(getPosition().x, getPosition().y, getMeasure().width, getMeasure().height);
		render.end();
		
		batch.begin();
		
		renderFont(batch);
	}
	
	public abstract void renderFont(SpriteBatch batch);

	@Override
	public void update() {
	}

}
