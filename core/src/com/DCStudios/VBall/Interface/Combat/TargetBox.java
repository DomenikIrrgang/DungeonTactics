package com.DCStudios.VBall.Interface.Combat;

import java.util.List;

import RoundBasedCombat.Ability;
import RoundBasedCombat.Unit;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TargetBox extends Tooltip implements ChooseBox {
	
	private List<Unit> targets;
	private int targetCount = 0;
	private int chosenTarget = 1;
	private boolean active = false;

	public TargetBox(Vector2 position, Measure measure) {
		super(position, measure);
		setActive(false);
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
		if (!active) {
			color = new Color(0.15f, 0.15f, 0.15f, 1f);
		} else {
			color = colorGrey;
		}
	}
	
	public void setTargets(List<Unit> targets) {
		this.targets = targets;
		chosenTarget = 1;
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public void goUp() {
		if (chosenTarget == targets.size()) {
			chosenTarget = 1;
		} else {
			chosenTarget++;
		}
	}

	@Override
	public void goDown() {
		if (chosenTarget == 1) {
			chosenTarget = targets.size();
		} else {
			chosenTarget--;
		}
	}

	@Override
	public void renderFont(SpriteBatch batch) {
		if (targets != null) {
			targetCount = 0;
			for (Unit target : targets) {
				draw(batch, target.getName(), getPosition().x + 10, getPosition().y + getMeasure().height - 15 - targetCount * 30);
				targetCount++;
			}
		}
	}
	
	private void draw(SpriteBatch batch, String text, float x, float y) {
		if (targetCount + 1 == chosenTarget) {
			font.setColor(Color.YELLOW);
			font.draw(batch, text, x, y);
			font.setColor(Color.WHITE);
		} else {
			font.draw(batch, text, x, y);
		}
		
	}
	
	public Unit getTarget() {
		return targets.get(chosenTarget - 1);
	}

}
