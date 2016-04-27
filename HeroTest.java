import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class HeroTest tests the Hero.java class. Hero.java extends Character and has getters and
 * setters for all the hero stats (like attack, defense, crit, health, etc.
 * 
 * HeroTest initializes a new Hero to run tests on. We check that the hero is an instanceof Character
 * as well as Hero. We then make sure the toString method works correctly.
 * @author Taylor
 */
public class HeroTest {
	Hero hero = new Hero(InitHeroClass.WARRIOR,"Bardok");
	
	/**
	 * testHero() tests to make sure that our instantiated hero is an instanceof Character and Hero using the assertTrue Method.
	 * no param, no return method.
	 */
	@Test
	public void testHero() {
		assertTrue(hero instanceof Character);
		assertTrue(hero instanceof Hero);
		
	}

	/**
	 * testToString() makes sure that when we pass the hero object to its toString method, it returns the hero
	 * name concatenated with it's class.
	 * no param, no return.
	 */
	@Test
	public void testToString() {
		String testName = "Bardok the Warrior";
		
		assertEquals(testName, hero.toString());
	}

}
