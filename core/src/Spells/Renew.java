/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Spells;

import RoundBasedCombat.AbilityType;
import RoundBasedCombat.AttackResult;
import RoundBasedCombat.Buff;
import RoundBasedCombat.BuffAbility;
import RoundBasedCombat.BuffType;
import RoundBasedCombat.Combat;
import RoundBasedCombat.HealthBuff;
import RoundBasedCombat.SpellType;
import RoundBasedCombat.TargetType;
import RoundBasedCombat.Unit;


/**
 *
 * @author Domenik
 */
public class Renew extends BuffAbility {

    public Renew() {
        super("Renew", "Heals every round for 3 rounds.", AbilityType.BUFF, TargetType.SINGLE, SpellType.LIGHT, -1000, 50, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 0.3;
    }

    @Override
    public Buff getBuff(Unit source) {
        return new HealthBuff("Renew","Periodically does lighthealing.", 3, BuffType.BUFF, 3, source, this);
    }
    
}
