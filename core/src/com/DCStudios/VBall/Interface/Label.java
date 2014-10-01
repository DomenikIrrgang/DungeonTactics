package com.DCStudios.VBall.Interface;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Label extends InterfaceObject {
	
	private String text;

	public Label(String text, Vector2 position) {
		super(position, null);
		this.text = text;
		updateMeasure();
	}
	
	public String getText() {
		return text;
	}
	
	private void updateMeasure() {
		this.setMeasure(new Measure((int) font.getBounds(text).height, (int) font.getBounds(text).width)); 
	}
	
	public void setText(String text) {
		this.text = text;
		updateMeasure();
	}

	@Override
	public void render(SpriteBatch batch) {
		if (isMouseOver()) {
			font.setColor(Color.YELLOW);
		} else {
			font.setColor(Color.WHITE);
		}
		font.draw(batch, text, getDrawingPosition().x, getDrawingPosition().y + 8);
	}

	@Override
	public void update() {
	}

}
