import java.util.Random;

/**
 * Superclass that creates a Character object.
 * 
 * @author Brian, Taylor, and Tana
 *
 */
public abstract class Character {

	/**
	 *  Attack Stat
	 */
	private int attack;
	/**
	 * Defense Stat
	 */
	private int defense;
	/*
	 * Health Stat
	 */
	private int health;
	/*
	 * Critical Strike Stat
	 */
	private int crit;
	private final String name;

	/**
	 * Creates the Character with starting stats and name.
	 * 
	 * @param attack
	 * @param defense
	 * @param health
	 * @param crit
	 * @param name
	 */
	public Character(int attack, int defense, int health, int crit, String name) {
		this.attack = attack * 3;
		this.defense = defense * 2;
		this.health = health * 10;
		this.crit = crit;
		this.name = name;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @returns crit
	 */
	public int getCrit() {
		return crit;
	}

	/**
	 * @param crit the crit to set
	 */
	public void setCrit(int crit) {
		this.crit = crit;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Calculates the attack value and allows a Character to attack another character 
	 * and returns the damage based on the other Character's defense and health.
	 * 
	 * If damage is > than health, the entire health value is returned.
	 * 
	 * @param character
	 * @param tempHealth
	 * @return damage
	 */
	public int attack(Character character, int tempHealth){

		int critMultiplier = 1;
		int thisAttackValue;
		int critChance;
		Random random = new Random();

		critChance = random.nextInt(100) + this.getCrit();

		if (critChance > 75)
			critMultiplier = 2;

		thisAttackValue = (this.getAttack()  - character.getDefense()) * critMultiplier;


		return (tempHealth < thisAttackValue) ? tempHealth : thisAttackValue;

	}
	
	/**
	 * Returns the Characters stats.
	 * 
	 * @return stats
	 */
	public String getStats() {
		
		return String.format("%s's stats:%nattack: %d%ndefense: %d%nhealth: %d%ncrit: %d%n", getName(), getAttack(), getDefense(), getHealth(), getCrit());
	}


}
