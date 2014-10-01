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
import RoundBasedCombat.StatBuff;
import RoundBasedCombat.StatSet;
import RoundBasedCombat.TargetType;
import RoundBasedCombat.Unit;


/**
 *
 * @author Domenik
 */
public class Acceleration extends BuffAbility {

    public Acceleration() {
        super("Accelration", "Increases the speed by 10 for 3 rounds.", AbilityType.BUFF, TargetType.SINGLE, SpellType.NEUTRAL, 0, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        StatSet stats = new StatSet();
        stats.setSpeed(10);
        return new StatBuff("Make haste!", "Increases speed by 10.", 3, BuffType.BUFF, stats, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
        
    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
