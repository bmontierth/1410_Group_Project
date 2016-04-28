import static org.junit.Assert.*;

import org.junit.Test;

// @author Tana Larrabee
// Apr 27, 2016
// TeamRpg

/**
 * @author Tana Larrabee
 */
public class LevelUpTest {

	@Test
	public void test() {
		Hero hero = new Hero(InitHeroClass.WARRIOR, "Test");
		
		int attack = hero.getAttack();
		int health = hero.getHealth();
		int defense = hero.getDefense();
		int crit = hero.getCrit();
		int level = hero.getLevel();
		
		hero.levelUp();
		
		assertEquals(attack + 3, hero.getAttack(), 3.0);
		assertEquals(health + 10, hero.getHealth(), 10.0);
		assertEquals(defense + 2, hero.getDefense(), 2.0);
		assertEquals(crit + 1, hero.getCrit(), 1.0);
		assertEquals(level +1, hero.getLevel());
	}

}