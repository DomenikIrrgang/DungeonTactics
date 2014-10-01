package com.DCStudios.VBall.Character;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.Animation2D;
import com.DCStudios.VBall.Interface.Combat.Model.UnitModel;
import com.DCStudios.VBall.Interface.Combat.Model.UnitModelState;
import com.DCStudios.VBall.Resources.TextureResource;
import com.badlogic.gdx.math.Vector2;

import RoundBasedCombat.CharacterUnit;
import RoundBasedCombat.StatSet;

public class Bilad extends CharacterUnit {

	public Bilad() {
		super("Bilad", 110, 100, new StatSet());
		stats.setIntellect(10);
		setModel(new UnitModel(new Vector2(100,100), new Measure(100,100)));
		getModel().setAnimationForState(UnitModelState.STANDING, new Animation2D(TextureResource.get(TextureResource.COMBAT_ANIMATION_MONSTER), 4, 1, new Vector2(0,0), new Measure(100,100)));
		getModel().setAnimationForState(UnitModelState.CASTING, new Animation2D(TextureResource.get(TextureResource.COMBAT_ANIMATION_EXPLOSION), 5, 5, new Vector2(0,0), new Measure(100,100)));
	}

}
