import static org.junit.Assert.*;
import org.junit.Test;


public class CharacterTest {

	Hero hero = new Hero(InitHeroClass.ARCHER,"Test");
	Enemy enemy = Enemy.randomEnemy(1);
	
	/**
	 * Tests the Character (and subclass) constructors.
	 * 
	 * hero instanceof Character
	 * enemy instanceof Character
	 * hero instanceof Hero
	 * 
	 */
	@Test
	public void testCharacter() {
		assertTrue(hero instanceof Character);
		String string = "Test";
		
		assertTrue(enemy instanceof Character);
		
		assertTrue(hero instanceof Hero);
		
		assertEquals(string, hero.getName());
		
		
	}

	/**
	 * Tests the attack method of class Character. 
	 * 
	 * hero damage == (hero attack - enemy defense) * hero crit multiplier
	 */
	@Test
	public void testAttack() {
		
		Hero hero = new Hero(InitHeroClass.ARCHER,"Test");
		Enemy enemy = Enemy.randomEnemy(10);
		
		int attackValue = hero.getAttack()-enemy.getDefense();
		int testDamage = ((enemy.getHealth() < attackValue) ? enemy.getHealth() : attackValue);
		
		// 0% chance of crit
		hero.setCrit(-100);
		assertEquals(testDamage, hero.attack(enemy, enemy.getHealth()));
		
		
		// 100% chance of crit
		hero.setCrit(100);
		assertEquals(testDamage * 2 , hero.attack(enemy, enemy.getHealth()));
		
		
		
	}

}
