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
import RoundBasedCombat.SpellType;
import RoundBasedCombat.StatusBuff;
import RoundBasedCombat.TargetType;
import RoundBasedCombat.Unit;
import RoundBasedCombat.UnitStatus;


/**
 *
 * @author Domenik
 */
public class Lullaby extends BuffAbility {

    public Lullaby() {
        super("Lullaby", "Plays a Lullaby. Targets falls asleep for 2 rounds.", AbilityType.DEBUFF, TargetType.SINGLE, SpellType.NEUTRAL, 15, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        return new StatusBuff("Lullaby","Falling asleep.", 2, BuffType.DEBUFF, UnitStatus.ASLEEP, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
