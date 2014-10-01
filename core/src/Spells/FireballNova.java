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
public class FireballNova extends Ability {

    public FireballNova() {
        super("Fireball nova", "Cast a Fireball on the group.", AbilityType.DAMAGE, TargetType.AOE, SpellType.FIRE, 0, 5, 0);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
            combat.cast(source, target, new FireballDOT());
    }
    
    public double calculateDamageDone(Unit source) {
        double tmp;
        
        tmp = 5 + source.getStats().getIntellect() * 0.57;
        
        return tmp;
    }

    @Override
    public double calculateValue(Unit source) {
        return 1 + source.getStats().getIntellect() * 0.57;
    }
    
}