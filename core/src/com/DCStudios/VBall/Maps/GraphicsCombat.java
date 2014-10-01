package com.DCStudios.VBall.Maps;

import java.util.ArrayList;
import java.util.Collection;

import RoundBasedCombat.Ability;
import RoundBasedCombat.CharacterUnit;
import RoundBasedCombat.Combat;
import RoundBasedCombat.Enemy;
import RoundBasedCombat.Unit;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.Container;
import com.DCStudios.VBall.Interface.Label;
import com.DCStudios.VBall.Interface.ListBox;
import com.DCStudios.VBall.Interface.MouseListener;
import com.DCStudios.VBall.Interface.Combat.CombatState;
import com.DCStudios.VBall.Interface.Combat.FPSCounter;
import com.DCStudios.VBall.Interface.Combat.UnitFrame;
import com.DCStudios.VBall.Interface.Combat.Model.UnitModelState;
import com.DCStudios.VBall.Rendering.Map;
import com.DCStudios.VBall.Rendering.Renderable;
import com.DCStudios.VBall.Resources.TextureResource;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class GraphicsCombat implements Map {

	private CombatState state = CombatState.SPELL_SELECTION;
	private Combat combat;
	private Texture background = TextureResource
			.get(TextureResource.COMBAT_BACKGROUND);
	
	private Container contentPane = new Container(new Vector2(0,0), new Measure(0, 0));

	private ListBox abilityBox = new ListBox(new Vector2(5,5), new Measure(135,250));

	private Collection<Renderable> interfaceObjects = new ArrayList<Renderable>();

	private CharacterUnit currentPlayer;
	private Ability selectedSpell;
	
	public GraphicsCombat(Combat combat) {
		this.combat = combat;
		setUpHealthBars();
		setUpBoxes();
		setUpModels();
		interfaceObjects.add(new FPSCounter(new Vector2(
				Gdx.graphics.getWidth() - 23, Gdx.graphics.getHeight() - 7),
				null));
		
		interfaceObjects.add(contentPane);	
		contentPane.addObject(abilityBox);
	}
	
	private void setUpModels() {
		int i = 0;
		for (CharacterUnit unit : combat.getPlayers()) {
			contentPane.addObject(unit.getModel());
			unit.getModel().getPosition().x = 220 - (i * 60);
			unit.getModel().getPosition().y = 300 - (i * 60);
			unit.getModel().addMouseListener(new TargetSelection(unit));
			i++;
		}
		i = 0;
		for (Enemy unit : combat.getEnemies()) {
			contentPane.addObject(unit.getModel());
			unit.getModel().getPosition().x = 750 + (i * 50);
			unit.getModel().getPosition().y = 300 - (i * 50);
			unit.getModel().addMouseListener(new TargetSelection(unit));
			i++;
		}
	}

	private void setUpBoxes() {
		currentPlayer = combat.getPlayers().get(0);
		updateAbilityBox(currentPlayer);
	}
	
	private void updatenAbilityBox(CharacterUnit unit) {
		Ability ability;
		abilityBox.resetAllText();
		int size = unit.getAbilities().size();
		for (int i = 0; i < size; i++) {
			ability = unit.getAbilities().get(i);
			((Label) abilityBox.getObjects().get(i)).setText(ability.getName());
			abilityBox.getObjects().get(i).removeAllMouseListener();
			abilityBox.getObjects().get(i).addMouseListener(new AbilityMouseListener(ability));
		}
		((Label) abilityBox.getObjects().get(4)).setText("Skip");
		abilityBox.getObjects().get(4).removeAllMouseListener();
		abilityBox.getObjects().get(4).addMouseListener(new AbilityMouseListener(null));
	}
	
	private void updateAbilityBox(CharacterUnit unit) {
		Label tmp;
		for (Ability ability : unit.getAbilities()) {
			tmp = new Label(ability.getName(), new Vector2(0,0));
			tmp.addMouseListener(new AbilityMouseListener(ability));
			abilityBox.addLabel(tmp);
		}
		tmp = new Label("Skip", new Vector2(0,0));
		tmp.addMouseListener(new AbilityMouseListener(null));
		abilityBox.addLabel(tmp);
	}

	private void setUpHealthBars() {
		int i = 0;
		for (Unit player : combat.getPlayers()) {
			contentPane.addObject(new UnitFrame(player, new Vector2(15, Gdx.graphics.getHeight() - 38 - (i * 55))));
			i++;
		}
		i = 0;
		for (Unit player : combat.getEnemies()) {
			contentPane.addObject(new UnitFrame(player, new Vector2(Gdx.graphics.getWidth() - 140, Gdx.graphics.getHeight() - 38 - (i * 55))));
			i++;
		}
	}
	
	private void nextCharacter() {
		int i = 0;
		while (!combat.getPlayers().get(i).equals(currentPlayer)) {
			i++;
		}
		if (i + 1 < combat.getPlayers().size()) {
			currentPlayer = combat.getPlayers().get(i + 1);
		} else {
			combat.doRound();
			currentPlayer = combat.getPlayers().get(0);
		}
		updatenAbilityBox(currentPlayer);
	}

	@Override
	public Collection<Renderable> getRenderables() {
		return interfaceObjects;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void update() {
		contentPane.update();
	}

	@Override
	public Texture getBackground() {
		return background;
	}

	@Override
	public void step() {
	}

	@Override
	public World getPhysic() {
		return null;
	}
	
	private class AbilityMouseListener implements MouseListener {
		
		private Ability ability;
		
		private AbilityMouseListener(Ability ability) {
			this.ability = ability;
		}

		@Override
		public void onMouseMove(Vector2 position) {
		}

		@Override
		public void onMousePress(Vector2 position) {
		}

		@Override
		public void onMouseRelease(Vector2 position) {
			if (ability != null) {
				selectedSpell = ability;
				state = CombatState.TARGET_SELECTION;
			} else {
				nextCharacter();
			}
		}
		
	}
	
	private class TargetSelection implements MouseListener {
		
		private Unit target;
		
		public TargetSelection(Unit unit) {
			target = unit;
		}

		@Override
		public void onMouseMove(Vector2 position) {
		}

		@Override
		public void onMousePress(Vector2 position) {
		}

		@Override
		public void onMouseRelease(Vector2 position) {
			if (state == CombatState.TARGET_SELECTION) {
				combat.queueAbility(currentPlayer, target, selectedSpell);
				currentPlayer.getModel().setState(UnitModelState.CASTING);
				nextCharacter();
				state = CombatState.SPELL_SELECTION;
			}
		}
		
	}

}
