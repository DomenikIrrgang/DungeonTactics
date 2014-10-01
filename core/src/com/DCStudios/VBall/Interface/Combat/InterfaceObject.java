package com.DCStudios.VBall.Interface.Combat;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Rendering.Renderable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class InterfaceObject implements Renderable {
	
	private Vector2 position;
	private Measure measure;
	protected boolean visible = true;
	protected ShapeRenderer render = new ShapeRenderer();
	protected BitmapFont font;
	protected BitmapFont smallFont;
	
	protected Color color = new Color(0.2f, 0.2f, 0.2f, 0f);
	

	public InterfaceObject(Vector2 position, Measure measure) {
		this.position = position;
		this.measure = measure;
		
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(
				Gdx.files.internal("data/font.ttf"));

		FreeTypeFontParameter para = new FreeTypeFontParameter();
		para.size = 15;
		font = gen.generateFont(para);
		font.setColor(Color.WHITE);
		
		para.size = 10;
		smallFont = gen.generateFont(para);
		smallFont.setColor(Color.WHITE);
		
		gen.dispose();
	}
	
	protected boolean isMouseOver() {
		if (Gdx.input.getX() >= (int) this.getPosition().x &&
				Gdx.input.getX() <= (int) this.getPosition().x + this.getMeasure().width &&
				Gdx.input.getY() * -1 + Gdx.graphics.getHeight() >= (int) this.getPosition().y &&
				Gdx.input.getY() * -1 + Gdx.graphics.getHeight() <= (int) this.getPosition().y + this.getMeasure().height) {
			return true;
		}
		return false;
	}

	@Override
	public Vector2 getPosition() {
		return position;
	}

	@Override
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	@Override
	public Measure getMeasure() {
		return measure;
	}

	@Override
	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public void dispose() {
		render.dispose();
	}

}
