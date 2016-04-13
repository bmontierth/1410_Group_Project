import java.util.Random;

/*****************************************
 * Author : Brian Montierth & Tyson Vance
 * Date : 12/05/2015
 * Assignment: A6 - Group Project
 ******************************************/
public class Enemy {

    Random rand = new Random();

    private String name;
    private int health;
    private int attack;
    private int defense;
    private static int battleNumber = 1;
    String[] enemyNames = new String[] {"Vampire", "Werewolf", "Witch", "Troll", "Zombie"};

    public Enemy() {

        this.attack = (rand.nextInt(5) + 5) + battleNumber;
        this.defense = (rand.nextInt(2) + 1) + battleNumber;
        this.health = (rand.nextInt(50) + 25) + (battleNumber * 5);

        if (battleNumber < 10)
            name = enemyNames[rand.nextInt(5)];
        else
            name = "The Ender Dragon";
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public static int getBattleNumber() {
        return battleNumber;
    }

    public static void increaseBattleNumber() {
        battleNumber++;
    }

    public int enemyAttack() {
        Random rand = new Random();

        int crit = rand.nextInt(100) + 1;

        if (crit > 75) {
            return (this.getAttack() * 2);
        } else {
            return this.getAttack();
        }
    }
}

