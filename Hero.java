import javax.swing.Icon;

public class Hero extends Character {
	private int level;
	private final String heroClass;
	private final Icon fullImage;
	private final Icon faceImage;
	/**
	 * Constructor to create a Hero.
	 * @param CLASS One of the classes from Enum InitHeroClass.
	 * @param name The name of the Hero.
	 */
	public Hero(InitHeroClass CLASS, String name) {
		super(CLASS.ATTACK, CLASS.DEFENSE, CLASS.HEALTH, CLASS.CRIT, name);
		this.level = 1;
		this.heroClass = CLASS.toString();
		this.fullImage = CLASS.fullImage;
		this.faceImage = CLASS.faceImage;
	}

	/**
	 * @return the level
	*/
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the hero's class
	 */
	public String getHeroClass() {
		return heroClass;
	}

	@Override
	public String toString() {
		return super.getName() + " the " + getHeroClass();
	}

	/**
	 * @return the fullImage
	 */
	public Icon getFullImage() {
		return fullImage;
	}

	/**
	 * @return the faceImage
	 */
	public Icon getFaceImage() {
		return faceImage;
	}

	
}


