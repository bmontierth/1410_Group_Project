
public abstract class Character {

	private int attack;
	private int defense;
	private int health;
	private int crit;
	private final String name;

	/**
	 *
	 * @param attack
	 * @param defense
	 * @param health
	 * @param crit
     * @param name
     */
	public Character(int attack, int defense, int health, int crit, String name) {
		this.attack = attack;
		this.defense = defense;
		this.health = health;
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
	
	

}
