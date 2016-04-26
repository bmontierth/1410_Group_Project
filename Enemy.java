import java.util.Random;

/*****************************************
 * Assignment: 1410 Group Project Class : ${CLASS_NAME} Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/
// -Create multiple enemies
// Different stats
// -Stats scale off of hero level
//

public class Enemy extends Character
	{

		/**
		 * @param attack
		 * @param defense
		 * @param health
		 * @param crit
		 * @param name
		 */
		private Enemy(int attack, int defense, int health, int crit, String name)
			{
				super(attack, defense, health, crit, name);
			}

		public static Character randomEnemy(int heroLevel)
			{
				String[] enemyArray =
					{ "Golem", "Zombie", "Demon", "Flying Demon", "Skeleton", "Dragon", "Vampire" };

				int randAttack = 1;
				int randDefense = 1;
				int randHealth = 1;
				int randCrit = 1;

				int[] stats =
					{ randAttack, randDefense, randHealth, randCrit };
				Random rand = new Random();
				double heroScale = (heroLevel * .75);

				for (int stat = 0; stat < stats.length; stat++)
					{
						stats[stat] = (int) (rand.nextInt(enemyArray.length) + 8 + heroScale);
						System.out.println("the stat in the loop: " + stats[stat]);
					}

				System.out.println("stat at zero outside the loop: " + stats[0]);

				return new Enemy(stats[0], stats[1], stats[2], stats[3], enemyArray[rand.nextInt(enemyArray.length)]);
			}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
			{
				return super.getName();
			}
		
		public static Character finalBoss(int heroLevel)
		{
			String[] enemyArray =
						{ "Golem", "Zombie", "Demon", "Flying Demon", "Skeleton", "Dragon", "Vampire" };

					int randAttack = 1;
					int randDefense = 1;
					int randHealth = 1;
					int randCrit = 1;

					int[] stats =
						{ randAttack, randDefense, randHealth, randCrit };
					Random rand = new Random();
					double heroScale = (heroLevel * .9);

					for (int stat = 0; stat < stats.length; stat++)
						{
							stats[stat] = (int) (rand.nextInt(enemyArray.length) + 8 + heroScale);
							System.out.println("the stat in the loop: " + stats[stat]);
						}

					System.out.println("stat at zero outside the loop: " + stats[0]);

					return new Enemy(stats[0], stats[1], stats[2], stats[3], enemyArray[rand.nextInt(enemyArray.length)] + " Boss");
		}

	}