/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Enemies;

import java.util.ArrayList;
import java.util.List;

import sun.nio.cs.ext.MacArabic;

import com.DCStudios.VBall.DataStructures.Measure;
import com.DCStudios.VBall.Interface.Animation2D;
import com.DCStudios.VBall.Interface.Combat.Model.UnitModel;
import com.DCStudios.VBall.Interface.Combat.Model.UnitModelState;
import com.DCStudios.VBall.Resources.TextureResource;
import com.badlogic.gdx.math.Vector2;

import RoundBasedCombat.Ability;
import RoundBasedCombat.CharacterUnit;
import RoundBasedCombat.Combat;
import RoundBasedCombat.CombatTurnEntry;
import RoundBasedCombat.Enemy;
import Spells.Acceleration;
import Spells.Enrage;
import Spells.Fireball;
import Spells.FireballNova;
import Spells.FlashHeal;
import Spells.Lullaby;
import Spells.Renew;
import Spells.Shrink;


/**
 *
 * @author Domenik
 */
public class Kathak extends Enemy {
    
    private int turnCount = 0;
    private boolean enrage = false;
    
    private Ability fireBall = new Fireball();
    private Ability fireNova = new FireballNova();
    private Ability lullaby = new Lullaby();
    private Ability shrink = new Shrink();
    private Ability renew = new Renew();
    private Ability acc = new Acceleration();

    public Kathak() {
        super("Kathak", 2000, 5000);
        stats.setIntellect(20);
        stats.setWaterResistance(0.1);
        stats.setFireResistance(0.2);
        stats.setDarkResistance(0.1);
        stats.setLightResistance(0.4);
        stats.setMiss(5);
        UnitModel model = new UnitModel(new Vector2(0,0), new Measure(100, 100));
        model.setAnimationForState(UnitModelState.STANDING, new Animation2D(TextureResource.get(TextureResource.COMBAT_ANIMATION_MONSTER), 4, 1, new Vector2(0,0), new Measure(0, 0)));
        setModel(model);
    }

    @Override
    public List<CombatTurnEntry> getAbilitys(Combat combat, List<CharacterUnit> targets) {
        List<CombatTurnEntry> tmp = new ArrayList<CombatTurnEntry>();
        
        if (getHealthPercentge() > 75) {
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), fireBall));
            turnCount++;
        }
        
        if (getHealthPercentge() <= 75 && getHealthPercentge() > 25) {
            if (turnCount == 1) {
                tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), lullaby));
            }    
            
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), fireBall));
            
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), shrink));
            turnCount++;
        }
        
        if (getHealthPercentge() <= 50) {
            if (!enrage) {
                enrage = true;
                combat.buff(this, this, new Enrage());
            }
        }
        
        if (getHealthPercentge() < 25) {
            
            
            tmp.add(new CombatTurnEntry(this, this, new FlashHeal()));
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), fireNova));
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), shrink));
            
            if (turnCount == 2) {
                tmp.add(new CombatTurnEntry(this, this, acc));
                turnCount = 0;
            }
            turnCount++;
        }
        
        
        if (turnCount == 3 ) {
            tmp.add(new CombatTurnEntry(this, getRandomUnit(targets), fireNova));
            turnCount = 0;
        }
             
        return tmp;
    }
    
}
