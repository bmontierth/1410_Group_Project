import static org.junit.Assert.*;
import org.junit.Test;


public class CharacterTest {

	Hero hero = new Hero(InitHeroClass.ARCHER,"Test");
	Enemy enemy = Enemy.randomEnemy(1);
	
	@Test
	public void testCharacter() {
		assertTrue(hero instanceof Character);
		String string = "Test";
		
		assertTrue(enemy instanceof Character);
		
		assertTrue(hero instanceof Hero);
		
		assertEquals("Expected:",string, hero.getName());
		
		
	}

	@Test
	public void testAttack() {
		
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
