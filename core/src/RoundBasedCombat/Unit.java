/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RoundBasedCombat;

import java.util.ArrayList;
import java.util.List;

import com.DCStudios.VBall.Interface.Combat.Model.UnitModel;


/**
 *
 * @author Domenik
 */
public class Unit {

    private double baseHealth;
    private double health;
    private double currentHealth;
    private int manaPoints;
    private int baseManaPoints;
    private int currentManaPoints;
    private UnitModel model;

    private String name = "";

    protected StatSet stats;

    private List<Buff> buffs = new ArrayList<Buff>();
    private List<UnitStatus> stati = new ArrayList<UnitStatus>();

    public Unit(String name, double baseHealth, int baseManaPoints, StatSet stats) {
        this.name = name;
        this.baseHealth = baseHealth;
        this.baseManaPoints = baseManaPoints;
        this.stats = stats;
        currentHealth = baseHealth;
        currentManaPoints = baseManaPoints;
        updateHealth();
        updateMana();
    }
    
    public UnitModel getModel() {
		return model;
	}
    
    public void setModel(UnitModel model) {
		this.model = model;
	}
    
    public double getHealthPercentge() {
        return currentHealth * 100 / health;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        updateHealth();
        return health;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentManaPoints() {
        return currentManaPoints;
    }

    public void setCurrentManaPoints(int currentManaPoints) {
        this.currentManaPoints = currentManaPoints;
    }

    public List<Buff> getBuffs() {
        return buffs;
    }

    public void setBuffs(List<Buff> buffs) {
        this.buffs = buffs;
    }

    public List<UnitStatus> getStati() {
        return stati;
    }

    public void setStati(List<UnitStatus> stati) {
        this.stati = stati;
    }

    public int getManaPoints() {
        updateMana();
        return manaPoints;
    }


    public boolean damage(double value) {
        currentHealth = currentHealth - value;
        updateHealth();
        return hasStatus(UnitStatus.DEAD);
    }

    public boolean heal(double value) {
        return damage(-value);
    }

    public boolean reduceMana(int value) {
        if (currentManaPoints - value >= 0) {
            currentManaPoints = currentManaPoints - value;
            return true;
        }
        return false;
    }
    
    public BuffResult removeBuff(Buff buff) {
        buffs.remove(buff);
        return new BuffResult(AttackLanded.FADED, buff);
    }

    public boolean hasStatus(UnitStatus stat) {
        for (UnitStatus status : stati) {
            if (status.equals(stat)) {
                return true;
            }
        }
        return false;
    }

    public void applyBuff(Buff buff) {
        buffs.add(buff);
        if (buff instanceof StatusBuff) {
            stati.add(((StatusBuff) buff).getStatus());
        }
    }

    private void updateHealth() {

        health = baseHealth + getStats().getStamina() * 5;

        if (currentHealth > health) {
            currentHealth = health;
        }

        if (currentHealth <= 0 && !stati.contains(UnitStatus.DEAD)) {
            currentHealth = 0;
            stati.add(UnitStatus.DEAD);
        }

        if (currentHealth > 0 && stati.contains(UnitStatus.DEAD)) {
            stati.remove(UnitStatus.DEAD);
        }
    }

    private void updateMana() {
        Double intellect = getStats().getIntellect();
        manaPoints = baseManaPoints + intellect.intValue() * 0;

        if (currentManaPoints > manaPoints) {
            currentManaPoints = manaPoints;
        }
    }

    public StatSet getStats() {
        StatSet tmp = new StatSet();
        tmp = tmp.add(stats);

        for (Buff buff : buffs) {
            if (buff instanceof StatBuff) {
                tmp = tmp.add(((StatBuff) buff).getStatSet());
            }
        }

        return tmp;

    }

}
