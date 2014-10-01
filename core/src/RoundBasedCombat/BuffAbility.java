/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RoundBasedCombat;

/**
 *
 * @author Domenik
 */
public abstract class BuffAbility extends Ability {

    public BuffAbility(String name, String tooltip, AbilityType abilityType, TargetType targetType, SpellType spellType, double missChance, double critChance, int manaCosts) {
        super(name, tooltip, abilityType, targetType, spellType, missChance, critChance, manaCosts);
    }
    
    public abstract Buff getBuff(Unit source);
    
}
