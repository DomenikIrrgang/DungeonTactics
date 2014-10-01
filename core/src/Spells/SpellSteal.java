/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Spells;

import java.util.ArrayList;
import java.util.List;

import RoundBasedCombat.Ability;
import RoundBasedCombat.AbilityType;
import RoundBasedCombat.AttackResult;
import RoundBasedCombat.Buff;
import RoundBasedCombat.Combat;
import RoundBasedCombat.SpellType;
import RoundBasedCombat.TargetType;
import RoundBasedCombat.Unit;


/**
 *
 * @author Domenik
 */
public class SpellSteal extends Ability {

    public SpellSteal() {
        super("Spell steal", "Steels all Debuffs and Buffs.", AbilityType.DAMAGE, TargetType.SINGLE, SpellType.DARK, 0, 0, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        List<Buff> tmp = new ArrayList<Buff>();
        for (Buff buff : target.getBuffs()) {
            tmp.add(buff);
        }
        combat.clearAllBuffs(target);
        for (Buff buff: tmp) {
            combat.buff(source, source, buff);
        }          
    }

    @Override
    public double calculateValue(Unit source) {
        return 3;
    }
    
}
