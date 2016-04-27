import static org.junit.Assert.*;
import java.util.Arrays;


import org.junit.Test;

/**
 * @author Taylor
 *	class EnemyTest tests the Enemy.java file with JUnit4. A hero, enemy, and boss are initialized with values to conduct
 *	tests on. I also initialize eneyarray as well.
 */
public class EnemyTest
	{
		
	Hero hero = new Hero(InitHeroClass.WARRIOR,"Bardok");
	Character enemy = Enemy.randomEnemy(5);
	Character boss = Enemy.finalBoss(5);
	String[] enemyArray =
				{ "Golem", "Zombie", "Demon", "Flying Demon", "Skeleton", "Dragon", "Vampire"
						,"Golem Boss", "Zombie Boss", "Demon Boss", "Skeleton Boss", "Dragon Boss", "Vampire Boss" };
	
	/**
	 * testRandomEnemy tests the randomEnemy method in Enemy.java. It is checking to ensure that
	 * the values of the enemy's attack, defense, crit, and health are being assigned values correctly
	 * as they are all initalized with '1' in each criteria. 
	 */
	@Test
	public void testRandomEnemy()
		{
			int shouldntBe = 1;
			assertFalse(enemy.getAttack() == shouldntBe);
			assertFalse(enemy.getDefense() == shouldntBe);
			assertFalse(enemy.getCrit() == shouldntBe);
			assertFalse(enemy.getHealth() == shouldntBe);
			
		}

	/**
	 * The testToString() method tests toString() that is in Enemy.java. toString returns the enemy name that it takes
	 * out of the enemyArray. I check this with the contains method to be sure that a name was chosen from the array.
	 */
	@Test
	public void testToString()
		{
			assertTrue(Arrays.asList(enemyArray).contains(enemy.getName()));
		}

	/**
	 * testFinalBoss() is very similar to randomEnemy. In FinalBoss, the stat values are higher so it makes
	 * the boss tougher to defeat. We initialize the same crit, attack, defense, health with 1 and then
	 * multiply based off of hero level to a random value. I'm just making sure that random value is replacing
	 * the initialized value.
	 */
	@Test
	public void testFinalBoss()
		{
			int shouldntBe = 1;
			assertFalse(boss.getAttack() == shouldntBe);
			assertFalse(boss.getDefense() == shouldntBe);
			assertFalse(boss.getCrit() == shouldntBe);
			assertFalse(boss.getHealth() == shouldntBe);
		}
}
