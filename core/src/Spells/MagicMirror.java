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
public class MagicMirror extends BuffAbility {

    public MagicMirror() {
        super("Magic Mirror", "Reflects all incoming spell on the group for 2 rounds.", AbilityType.BUFF, TargetType.AOE, SpellType.LIGHT, 0, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        return new StatusBuff("Magic Mirror","Reflects incoming abilities.", 2, BuffType.BUFF, UnitStatus.REFLECT, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
     
    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
