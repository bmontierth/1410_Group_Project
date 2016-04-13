import java.util.Random;

/*****************************************
 * Author : Brian Montierth & Tyson Vance
 * Date : 12/05/2015
 * Assignment: A6 - Group Project
 ******************************************/
public class Character {

    private final String NAME;
    private int health;
    private int attack;
    private int defense;


    public Character(String name) {

        this.NAME = name;

        this.health = 100;
        this.attack = 20;
        this.defense = 0;
    }

    public void increaseStat(char stat){

        switch(stat){
            case 'h': this.health += 10 ;
                break;
            case 'a': this.attack += 3;
                break;
            case 'd': this.defense ++;
                break;
            default: this.attack += 3;
                break;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAttack() {
        return attack;
    }

    public int heroAttack()
    {
        Random rand = new Random();

        int crit = rand.nextInt(100) + 1;

        if (crit > 75)
        {
            return (this.getAttack() * 2);
        }
        else
        {
            return this.getAttack();
        }
    }
}
