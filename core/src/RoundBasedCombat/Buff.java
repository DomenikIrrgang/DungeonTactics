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
public abstract class Buff {
    private final String name;
    private final String tooltip;
    private int duration;
    private final BuffType type;
    protected Unit source;

    public Buff(String name, String tooltip, int duration, BuffType type, Unit source) {
        this.duration = duration;
        this.name = name;
        this.tooltip = tooltip;
        this.type = type;
        this.source = source;
    }
    
    public String getTooltip() {
		return tooltip;
	}
    
    
    public Unit getSource() {
    	return source;
    }

    public String getName() {
        return name;
    }

    public BuffType getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }
    
    public void update(Combat combat, Unit unit) {
        duration--;
    }
}
