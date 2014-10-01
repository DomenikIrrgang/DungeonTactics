package com.DCStudios.VBall.Interface.Combat;

import RoundBasedCombat.Buff;
import RoundBasedCombat.BuffType;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BuffToolTip extends Tooltip {
	
	private Buff buff;

	public BuffToolTip(Vector2 position, Measure measure) {
		super(position, measure);	
	}
	
	public void setBuff(Buff buff) {
		this.buff = buff;
	}

	@Override
	public void renderFont(SpriteBatch batch) {
		font.draw(batch, buff.getName(), getPosition().x + 5, getPosition().y + getMeasure().height - 10);
		if (buff.getType().equals(BuffType.BUFF)) {
			font.draw(batch, buff.getType().toString(), getPosition().x + getMeasure().width - 40, getPosition().y + getMeasure().height - 10);
		} else {
			font.draw(batch, buff.getType().toString(), getPosition().x + getMeasure().width - 55, getPosition().y + getMeasure().height - 10);
		}
		
		smallFont.draw(batch, buff.getTooltip(), getPosition().x + 5, getPosition().y + getMeasure().height - 30);
	}

}
