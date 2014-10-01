package com.DCStudios.VBall.Interface.Combat;

import java.util.ArrayList;
import java.util.List;

import RoundBasedCombat.Buff;
import RoundBasedCombat.BuffType;
import RoundBasedCombat.HealthBuff;
import RoundBasedCombat.Unit;
import Spells.FlashHeal;

import com.DCStudios.VBall.DataStructures.Measure;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BuffBar extends InterfaceObject {
	
	private List<GraphicalBuff> buffs;
	private Unit unit;
	private int buffCount;

	public BuffBar(Unit unit, Vector2 position, Measure measure) {
		super(position, measure);	
		this.unit = unit;
		buffs = new ArrayList<GraphicalBuff>();	
	}

	@Override
	public void render(SpriteBatch batch) {
		
		while (unit.getBuffs().size() > buffs.size()) {
			buffs.add(new GraphicalBuff(new HealthBuff("","", 0, BuffType.BUFF, 0, unit, new FlashHeal()), new Vector2(0,0), new Measure(10, 10)));
		}

		buffCount = 0;
		for (Buff buff : unit.getBuffs()) {
			if(buff.getType().equals(BuffType.BUFF)) {
				buffs.get(buffCount).setPosition(new Vector2(getPosition().x + buffCount * 15, getPosition().y));
				buffs.get(buffCount).setBuff(buff);
				buffCount++;
			}			
		}
		for (Buff buff : unit.getBuffs()) {
			if(buff.getType().equals(BuffType.DEBUFF)) {
				buffs.get(buffCount).setPosition(new Vector2(getPosition().x + buffCount * 15, getPosition().y));
				buffs.get(buffCount).setBuff(buff);
				buffCount++;
			}			
		}
		
		for (int i = 0; i < buffCount; i++) {
			buffs.get(i).render(batch);
		}
		
	}

	@Override
	public void update() {
	}

}
