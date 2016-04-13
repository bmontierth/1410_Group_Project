/*****************************************
 * Assignment: 1410 Group Project
 * Class : ${CLASS_NAME}
 * Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/
public enum InitHeroClass {
    WARRIOR(12,11,11,6),ROGUE(10,8,9,13),KNIGHT(8,13,14,5),BERSERKER(14,5,8,13);

    public final int ATTACK;
    public final int DEFENSE;
    public final int HEALTH;
    public final int CRIT;


    InitHeroClass(int attack, int defense, int health, int crit) {
        this.ATTACK = attack;
        this.DEFENSE = defense;
        this.HEALTH = health;
        this.CRIT = crit;
    }

    @Override
    public String toString() {
        return super.toString().substring(0,1) + super.toString().substring(1).toLowerCase();
    }
}
