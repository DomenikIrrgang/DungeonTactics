package com.DCStudios.VBall.Interface.Combat;

import RoundBasedCombat.Buff;
import RoundBasedCombat.BuffType;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class GraphicalBuff extends InterfaceObject {
	
	private Buff buff;

	public GraphicalBuff(Buff buff, Vector2 position, Measure measure) {
		super(position, measure);
		this.buff = buff;
	}

	@Override
	public void render(SpriteBatch batch) {
		
		batch.end();
		
		render.begin(ShapeType.Filled);
		if (buff.getType().equals(BuffType.BUFF)) {
			render.setColor(Color.GREEN);
		} else {
			render.setColor(Color.RED);
		}
		
		render.rect(getPosition().x, getPosition().y, 10, 10);
		render.end();
		
		font.setColor(Color.WHITE);
		batch.begin();
		
		smallFont.draw(batch, String.valueOf(buff.getDuration()) ,getPosition().x + 3, getPosition().y - 5);
		
		if (isMouseOver()) {
			Tooltipkit.buff.setBuff(buff);
			Tooltipkit.buff.render(batch);
		}
			
	}
	
	public void setBuff(Buff buff) {
		this.buff = buff;
	}

	@Override
	public void update() {
	}

}
