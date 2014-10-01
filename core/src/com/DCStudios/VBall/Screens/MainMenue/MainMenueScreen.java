package com.DCStudios.VBall.Screens.MainMenue;

import java.util.ArrayList;
import java.util.List;

import Enemies.Kathak;
import RoundBasedCombat.CharacterUnit;
import RoundBasedCombat.Combat;
import RoundBasedCombat.Enemy;
import RoundBasedCombat.StatSet;
import RoundBasedCombat.Unit;
import Spells.CircleoftheHeavens;
import Spells.DominationOfLife;
import Spells.Fireball;
import Spells.FlashHeal;
import Spells.MagicMirror;
import Spells.SpellSteal;

import com.DCStudios.VBall.VBall;
import com.DCStudios.VBall.Character.Bilad;
import com.DCStudios.VBall.Character.Luner;
import com.DCStudios.VBall.Maps.GraphicsCombat;
import com.DCStudios.VBall.Rendering.Map;
import com.DCStudios.VBall.Rendering.Render;
import com.badlogic.gdx.Screen;

public class MainMenueScreen implements Screen {
	
	private VBall game;
	
	private Map map;
	private Render render;
	
	public MainMenueScreen(VBall game) {
		this.game = game;
		map = new GraphicsCombat(getCombat());
		render = new Render(map);
	}
	
	private Combat getCombat() {
		StatSet stats = new StatSet();
		stats.setIntellect(30);
		stats.setFireResistance(0.2);
		
		List<CharacterUnit> group = new ArrayList<CharacterUnit>();
		List<Enemy> enemies = new ArrayList<Enemy>();
		
		CharacterUnit unit1 = new Luner();
		CharacterUnit unit2 = new Bilad();
		
		unit1.addAbility(new CircleoftheHeavens());
		unit1.addAbility(new MagicMirror());
		unit1.addAbility(new SpellSteal());
		unit1.addAbility(new DominationOfLife());
		unit2.addAbility(new Fireball());
		unit2.addAbility(new SpellSteal());
		
		Enemy enemy = new Kathak();

		
		group.add(unit1);
		group.add(unit2);	
		enemies.add(enemy);

		
		return new Combat(group, enemies);
	}

	@Override
	public void render(float delta) {
		map.update();
		render.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
