package groupProject;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class JUnit
	{
		Hero hero = new Hero(InitHeroClass.WARRIOR,"Bardok");
		Character enemy = Enemy.randomEnemy(5);
		Character boss = Enemy.finalBoss(5);
		String[] enemyArray =
					{ "Golem", "Zombie", "Demon", "Flying Demon", "Skeleton", "Dragon", "Vampire" };

		@Test
		public void testRandomEnemy()
			{
				int shouldntBe = 1;
				assertFalse(enemy.getAttack() == shouldntBe);
				assertFalse(enemy.getDefense() == shouldntBe);
				assertFalse(enemy.getCrit() == shouldntBe);
				assertFalse(enemy.getHealth() == shouldntBe);
				
			}

		@Test
		public void testToString()
			{
				assertTrue(Arrays.asList(enemyArray).contains(enemy.getName()));
			}

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
