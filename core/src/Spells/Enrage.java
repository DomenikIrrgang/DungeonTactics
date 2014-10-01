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
public class Enrage extends BuffAbility {

    public Enrage() {
        super("Enrage", "Increases damage done by 30%.", AbilityType.BUFF, TargetType.SINGLE, SpellType.NEUTRAL, -1000, 0, 0);
    }

    @Override
    public Buff getBuff(Unit source) {
        StatSet tmp = new StatSet();
        tmp.setDamageDoneModificator(0.3);
        return new StatBuff("Enrage!","Increases damage done by 30%.", 50000, BuffType.BUFF, tmp, source);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
  
    }

    @Override
    public double calculateValue(Unit source) {
        return 0;
    }
    
}
