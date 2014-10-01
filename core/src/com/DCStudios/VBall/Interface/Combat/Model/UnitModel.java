package com.DCStudios.VBall.Interface.Combat.Model;

import java.util.HashMap;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.Animation2D;
import com.DCStudios.VBall.Interface.InterfaceObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UnitModel extends InterfaceObject {
	
	private UnitModelState state = UnitModelState.STANDING;
	private HashMap<UnitModelState, Animation2D> animations = new HashMap<UnitModelState, Animation2D>();

	public UnitModel(Vector2 position, Measure measure) {
		super(position, measure);
	}
	
	public void setAnimationForState(UnitModelState state, Animation2D animation) {
		animation.setPosition(getPosition());
		animation.setMeasure(getMeasure());
		animations.put(state, animation);
	}

	@Override
	public void render(SpriteBatch batch) {
		animations.get(state).render(batch);
	}
	
	public void setState(UnitModelState state) {
		if (animations.get(state) != null) {
			animations.get(state).reset();
		}
		this.state = state;
	}
	
	public UnitModelState getState() {
		return state;
	}

	@Override
	public void update() {
	}

}
