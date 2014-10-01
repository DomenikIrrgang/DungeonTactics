/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RoundBasedCombat;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Domenik
 */
public abstract class Enemy extends Unit {

    public Enemy(String name, double baseHealth, int baseManaPoints) {
        super(name, baseHealth, baseManaPoints, new StatSet());
    }
    
    protected Unit getRandomUnit(List<CharacterUnit> targets) {
        Random random = new Random();
        Unit target = targets.get(random.nextInt(targets.size()));
   /*     while (target.hasStatus(UnitStatus.DEAD)) {
        	target = targets.get(random.nextInt(targets.size()));
        }*/
        return target;
    }
    
    public abstract List<CombatTurnEntry> getAbilitys(Combat combat, List<CharacterUnit> targets);
    
}
