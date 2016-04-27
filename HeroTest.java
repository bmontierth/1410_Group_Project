import static org.junit.Assert.*;

import org.junit.Test;

public class HeroTest {
	Hero hero = new Hero(InitHeroClass.WARRIOR,"Bardok");
	
	@Test
	public void testHero() {
		assertTrue(hero instanceof Character);
		assertTrue(hero instanceof Hero);
		
	}

	@Test
	public void testToString() {
		String testName = "Bardok the Warrior";
		
		assertEquals(testName, hero.toString());
	}

}
