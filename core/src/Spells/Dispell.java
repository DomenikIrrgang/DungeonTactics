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
public class Dispell extends Ability {

    public Dispell() {
        super("Dispell", "Removes all Buffs and Debuffs.", AbilityType.HEAL, TargetType.SINGLE, SpellType.LIGHT, 0, 0, 5);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        combat.clearAllBuffs(target);
    }

    @Override
    public double calculateValue(Unit source) {
        return 5;
    }
    
}
