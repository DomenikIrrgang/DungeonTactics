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
public class DivineShield extends BuffAbility {

    public DivineShield() {
        super("Divine Shield", "Immune to damage for 1 round.", AbilityType.BUFF, TargetType.AOE, SpellType.LIGHT, 0, 0, 5);
    }

    @Override
    public Buff getBuff(Unit source) {
        return new StatusBuff("Divine Shield", "Immune to damage.", 1, BuffType.BUFF, UnitStatus.UNATTACKABLE, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
           
    }

    @Override
    public double calculateValue(Unit source) {
     return 0;
    }
    
}
