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
public class FlashHeal extends Ability {

    public FlashHeal() {
        super("Flashheal", "Heals the target and applys Renew.", AbilityType.HEAL, TargetType.SINGLE, SpellType.LIGHT, 0, 50, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        combat.cast(source, target, new Renew());
    }

    @Override
    public double calculateValue(Unit source) {
        return source.getStats().getIntellect() * 1.7 + 1;
    }
    
}
