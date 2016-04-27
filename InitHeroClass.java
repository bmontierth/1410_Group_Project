import javax.swing.Icon;
import javax.swing.ImageIcon;

/*****************************************
 * Assignment: 1410 Group Project
 * Class : ${CLASS_NAME}
 * Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/
public enum InitHeroClass {
    ARCHER(12,11,11,6,new ImageIcon(InitHeroClass.class.getResource("/imgss/cutearcher.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cutearcherhead.png")))
    ,MAGE(10,8,9,13,new ImageIcon(InitHeroClass.class.getResource("/imgss/cutemage.png")), new ImageIcon(InitHeroClass.class.getResource("/imgss/cutemadehead.png")))
    ,ROGUE(8,13,14,5,new ImageIcon(InitHeroClass.class.getResource("/imgss/cuterogue.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteroguehead.png")))
    ,WARRIOR(14,5,8,13,new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteswordguy.png")),new ImageIcon(InitHeroClass.class.getResource("/imgss/cuteswordhead.png")));

    public final int ATTACK;
    public final int DEFENSE;
    public final int HEALTH;
    public final int CRIT;
    public final Icon fullImage;
    public final Icon faceImage;


    InitHeroClass(int attack, int defense, int health, int crit, Icon fullImage, Icon faceImage) {
        this.ATTACK = attack;
        this.DEFENSE = defense;
        this.HEALTH = health;
        this.CRIT = crit;
        this.fullImage = fullImage;
        this.faceImage = faceImage;
        
    }

    @Override
    public String toString() {
        return super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
    }
}
