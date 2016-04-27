import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Class Hero extends Character. Hero is going to be who the user controls, the user also chooses the hero class
 * and name. It has getters and setters for all stats and the name. It also contains the hero level, which is
 * used to scale enemies difficulty.
 * @author Taylor
 *
 */
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
	 * get the level of the hero
	 * @return the level of the hero Object.
	*/
	public int getLevel() {
		return level;
	}

	/**
	 * setter for the level of the hero
	 * @param level the level to set for the Hero object.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * getter for the class of the hero. There is no setter for this value, it is a FINAL field
	 * @return the hero's class 
	 */
	public String getHeroClass() {
		return heroClass;
	}

	/**
	 * toString gets the hero's name that was set by the user and then concatenates on the Class of that hero.
	 * @return a string of "(HeroName) the (HeroClass)" to use in the GUI
	 */
	@Override
	public String toString() {
		return super.getName() + " the " + getHeroClass();
	}

	/**
	 * fullImage is an Icon of the entire Hero.
	 * @return the fullImage of the hero
	 */
	public Icon getFullImage() {
		return fullImage;
	}

	/**
	 * faceImage is the cropped image of the hero's face.
	 *
	 * @return the faceImage of the Hero
	 */
	public Icon getFaceImage() {
		return faceImage;
	}

	/**
	 * levelUp is called when the hero levels up after defeating an enemy. It is a noarg, no return method, and calls 
	 * the method setLevel.
	 * levelUp has a JOptionPane which contains four values that the user can choose to levelUp. The user gets base
	 * stat increases on all fronts, but the user is able to choose in the JOptionPane one stat to levelUp again. Based on
	 * which stat is chosen by the user, that choice is increased again.
	 */
	public void levelUp()
	{
		this.setLevel(this.getLevel() + 1);
		String[] buttons =
			{ "Attack", "Defense", "Health", "Crit" };

		int returnValue = JOptionPane.showOptionDialog(null, "Select a stat to level up", "Level Up!",
				JOptionPane.PLAIN_MESSAGE, 0,
				this.getFaceImage(), buttons,
				buttons[0]);

		this.setAttack(this.getAttack() + 3);
		this.setDefense(this.getDefense() + 2);
		this.setHealth(this.getHealth() + 10);
		this.setCrit(this.getCrit() + 1);

		switch (returnValue)
			{
				case 0:
					this.setAttack(this.getAttack() + 3);
					break;
				case 1:
					this.setDefense(this.getDefense() + 2);
					break;
				case 2:
					this.setHealth(this.getHealth() + 10);
					break;
				case 3:
					this.setCrit(this.getCrit() + 1);
					break;
			}
	}
	
}