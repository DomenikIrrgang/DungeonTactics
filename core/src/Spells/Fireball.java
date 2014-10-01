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
public class Fireball extends Ability {

    public Fireball() {
        super("Fireball", "A fireball that burns the target for 3 rounds.", AbilityType.DAMAGE, TargetType.SINGLE, SpellType.FIRE, 0, 5, 5);
    }

    @Override
    public void execute(Combat combat, Unit source, Unit target, AttackResult result) {
            combat.cast(source, target, new FireballDOT());
    }
    

    @Override
    public double calculateValue(Unit source) {
        return 1 + source.getStats().getIntellect() * 0.57;
    }
    
}
