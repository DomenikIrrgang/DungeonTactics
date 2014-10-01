/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Spells;

import RoundBasedCombat.Ability;
import RoundBasedCombat.AbilityType;
import RoundBasedCombat.AttackResult;
import RoundBasedCombat.Combat;
import RoundBasedCombat.SpellType;
import RoundBasedCombat.TargetType;
import RoundBasedCombat.Unit;

/**
 *
 * @author Domenik
 */
public class CircleoftheHeavens extends Ability {

    public CircleoftheHeavens() {
        super("Circle of the Heavens","Heal the group and applies Renew on them.", AbilityType.HEAL, TargetType.AOE, SpellType.LIGHT, 0, 20, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        combat.cast(source, target, new Renew());
    }

    @Override
    public double calculateValue(Unit source) {
        return 1 + source.getStats().getIntellect() * 0.6;
    }
    
}
