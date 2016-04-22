/*****************************************
 * Assignment: 1410 Group Project
 * Class : ${CLASS_NAME}
 * Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/
public class Enemy extends Character {
    /**
     * @param attack
     * @param defense
     * @param health
     * @param crit
     * @param name
     */
    private Enemy(int attack, int defense, int health, int crit, String name) {
        super(attack, defense, health, crit, name);
    }

    public static Character randomEnemy(int heroLevel){

    	return null;
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
