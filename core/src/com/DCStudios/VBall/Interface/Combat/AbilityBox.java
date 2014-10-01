package com.DCStudios.VBall.Interface.Combat;

import RoundBasedCombat.Ability;
import RoundBasedCombat.CharacterUnit;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Vector2;

public class AbilityBox extends Tooltip implements ChooseBox {
	
	private CharacterUnit unit;
	private int abilityCount = 0;
	private int chossenAbility = 1;
	private boolean active = false;

	public AbilityBox(Vector2 position, Measure measure) {
		super(position, measure);
		setActive(false);
	}
	
	public void setUnit(CharacterUnit unit) {
		this.unit = unit;
		chossenAbility = 1;
	}

	@Override
	public void renderFont(SpriteBatch batch) {
		if (unit != null) {
			abilityCount = 0;
			for (Ability ability : unit.getAbilities()) {
				draw(batch, ability.getName(), getPosition().x + 10, getPosition().y + getMeasure().height - 15 - abilityCount * 30);
				draw(batch, String.valueOf(ability.getManaCosts()), getPosition().x + getMeasure().width - 20, getPosition().y + getMeasure().height - 15 - abilityCount * 30);
				abilityCount++;
			}
			draw(batch, "SKIP", getPosition().x + 10, getPosition().y + getMeasure().height - 15 - abilityCount * 30);
		}
	}
	
	private void draw(SpriteBatch batch, String text, float x, float y) {
		if (abilityCount + 1 == chossenAbility) {
			font.setColor(Color.YELLOW);
			font.draw(batch, text, x, y);
			font.setColor(Color.WHITE);
		} else {
			font.draw(batch, text, x, y);
		}
		
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

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void goUp() {
		if (chossenAbility == unit.getAbilities().size() + 1) {
			chossenAbility = 1;
		} else {
			chossenAbility++;
		}
	}

	@Override
	public void goDown() {
		if (chossenAbility == 1) {
			chossenAbility = unit.getAbilities().size() + 1;
		} else {
			chossenAbility--;
		}
	}
	
	public Ability getAbility() {
		if (chossenAbility <= unit.getAbilities().size()) {
			return unit.getAbilities().get(chossenAbility - 1);
		}
		return null;
	}

}
