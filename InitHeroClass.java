import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * InitHeroClass will initialize the Hero when it is chosen on the very first panel. Depending on which image they choose,
 * that character object is chosen from the enum and initialized with different 'base' stats. We also set the faceImage and
 * fullImage of the Hero. 
 */
public enum InitHeroClass {
    ARCHER(12,11,11,6,new ImageIcon(InitHeroClass.class.getResource("/imgss/cutearcher.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cutearcherhead.png")))
    ,MAGE(10,8,9,13,new ImageIcon(InitHeroClass.class.getResource("/imgss/cutemage.png")), new ImageIcon(InitHeroClass.class.getResource("/imgss/cutemadehead.png")))
    ,ROGUE(10,13,14,5,new ImageIcon(InitHeroClass.class.getResource("/imgss/cuterogue.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteroguehead.png")))
    ,WARRIOR(14,5,8,13,new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteswordguy.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteswordhead.png")));

    public final int ATTACK;
    public final int DEFENSE;
    public final int HEALTH;
    public final int CRIT;
    public final Icon fullImage;
    public final Icon faceImage;

    /**
     * @param attack attack of the hero (from the enum).
     * @param defense defense of the hero (from the enum).
     * @param health health of the hero (from the enum).
     * @param crit crit of the hero (from the enum).
     * @param fullImage fullImage (body) of the hero (from the enum).
     * @param faceImage faceImage of the hero (from the enum).
     * no return, just basically a setter method.
     */
    InitHeroClass(int attack, int defense, int health, int crit, Icon fullImage, Icon faceImage) {
        this.ATTACK = attack;
        this.DEFENSE = defense;
        this.HEALTH = health;
        this.CRIT = crit;
        this.fullImage = fullImage;
        this.faceImage = faceImage;
    }

    /**
     * toString() in initHeroClass is used in the GUI to get the names
     */
    @Override
    public String toString() {
        return super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
    }
}
