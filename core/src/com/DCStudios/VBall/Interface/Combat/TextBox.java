package com.DCStudios.VBall.Interface.Combat;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TextBox extends Tooltip {

	private String text = "";
	private TextBounds textSize;

	public TextBox(Vector2 position, Measure measure) {
		super(position, measure);
	}

	public void setText(String text) {
		this.text = text;
		textSize = font.getBounds(text);
	}

	@Override
	public void renderFont(SpriteBatch batch) {		
		font.draw(batch, text, getPosition().x + getMeasure().width / 2
				- textSize.width / 2, getPosition().y + getMeasure().height / 2
				+ textSize.height / 2);
	}

}
