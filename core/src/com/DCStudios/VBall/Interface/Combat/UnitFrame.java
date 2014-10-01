package com.DCStudios.VBall.Interface.Combat;

import RoundBasedCombat.Unit;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.InterfaceObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class UnitFrame extends InterfaceObject {

	private Unit unit;
	private BuffBar buffs;
	private double maxHealth;
	private double currentHealth;
	
	public UnitFrame(Unit unit, Vector2 position) {
		super(position, new Measure(0, 0));
		this.unit = unit;
		maxHealth = unit.getHealth();
		currentHealth = unit.getCurrentHealth();
		buffs = new BuffBar(unit, new Vector2(position.x, position.y - 26),
				new Measure(0, 0));
	}

	@Override
	public void render(SpriteBatch batch) {
		maxHealth = unit.getHealth();
		currentHealth = unit.getCurrentHealth();

		batch.end();
		render.begin(ShapeType.Filled);
		render.setColor(Color.GRAY);
		render.rect(getPosition().x + 20 - 1, getPosition().y - 10 - 1,
				100 + 2, 17);
		render.end();

		render.begin(ShapeType.Line);
		render.setColor(Color.BLACK);
		render.rect(getPosition().x + 20 - 1, getPosition().y - 10 - 1,
				100 + 2, 17);
		render.end();

		render.begin(ShapeType.Filled);
		render.setColor(Color.BLUE);
		render.rect(
				getPosition().x + 20,
				getPosition().y - 10,
				100 * (float) unit.getCurrentManaPoints()
						/ (float) unit.getManaPoints(), 15);
		render.setColor(Color.GRAY);
		render.rect(getPosition().x - 1, getPosition().y - 1, 100 + 2, 22);
		render.end();

		render.begin(ShapeType.Line);
		render.setColor(Color.BLACK);
		render.rect(getPosition().x - 1, getPosition().y - 1, 100 + 2, 22);
		render.end();

		render.begin(ShapeType.Filled);
		render.setColor(color);
		render.rect(getPosition().x, getPosition().y,
				Math.round(unit.getHealthPercentge()), 20);
		render.end();

		batch.begin();

		font.setColor(Color.WHITE);
		font.draw(batch, unit.getName(), getPosition().x + 2, getPosition().y
				+ 20 + font.getLineHeight() / 2);
		font.draw(batch, String.valueOf(Math.round(unit.getHealthPercentge()))
				+ "%", getPosition().x + 100 / 4, getPosition().y + 20 / 3
				+ font.getLineHeight() / 2);

		buffs.render(batch);

	}

	@Override
	public void update() {
	}

}
