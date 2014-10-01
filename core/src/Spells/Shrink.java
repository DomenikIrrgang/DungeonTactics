/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package	Spells;

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
public class Shrink extends BuffAbility {

    public Shrink() {
        super("Shrink", "Reduces damage done by 20%.", AbilityType.DEBUFF, TargetType.SINGLE, SpellType.DARK, 0, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        StatSet stats = new StatSet();
        stats.setDamageDoneModificator(-0.2);
        return new StatBuff("Shrinked!","Damage done is decreased by 20%.", 2, BuffType.DEBUFF, stats, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {

    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
