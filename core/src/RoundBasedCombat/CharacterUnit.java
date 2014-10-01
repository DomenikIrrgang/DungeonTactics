package RoundBasedCombat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterUnit extends Unit {
	
	private List<Ability> abilities = new ArrayList<Ability>();
	private int maxAbilityCount = 4;
	private Random random = new Random();

	public CharacterUnit(String name, double baseHealth, int baseManaPoints,
			StatSet stats) {
		super(name, baseHealth, baseManaPoints, stats);	
	}
	
	public boolean addAbility(Ability ability) {
		if (abilities.size() < maxAbilityCount) {
			return abilities.add(ability);
		}
		return false;
	}
	
	public boolean removeAbility(Ability ability) {
		return abilities.remove(ability);
	}
	
	public Ability getRandomAbility() {
		return abilities.get(random.nextInt(abilities.size()));
	}
	
	public List<Ability> getAbilities() {
		return abilities;
	}

}
