package groupProject;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/*****************************************
 * Assignment: 1410 Group Project Class : ${CLASS_NAME} Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/

public class Enemy extends Character
	{

		/**
		 * @param attack
		 * @param defense
		 * @param health
		 * @param crit
		 * @param name
		 */
		private Enemy(int attack, int defense, int health, int crit, String name, Icon fullImage, Icon faceImage)
			{
				super(attack, defense, health, crit, name);
			}

		public static Character randomEnemy(int heroLevel)
			{
				String[] enemyArray =
					{ "Golem", "Zombie", "Demon", "Skeleton", "Dragon", "Vampire" };

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
					}
				
				int random = rand.nextInt(enemyArray.length);
				Icon body = null;
				Icon face = null;
				
				switch (random) {
					case 0: body = new ImageIcon(Enemy.class.getResource("/imgss/golemboss.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/golembosshead.png"));
					break;
					case 1: body = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZ.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZhead.png"));
					break;
					case 2: body = new ImageIcon(Enemy.class.getResource("/imgss/demon.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/demonhead.png"));
					break;
					case 3: body = new ImageIcon(Enemy.class.getResource("/imgss/skelly.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/skellyhead.png"));
					break;
					case 4: body = new ImageIcon(Enemy.class.getResource("/imgss/dragon.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/dragonhead.png"));
					break;
					case 5: body = new ImageIcon(Enemy.class.getResource("/imgss/vampire.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/vampirehead.png"));
					break;
				}

				return new Enemy(stats[0], stats[1], stats[2], stats[3], enemyArray[random], body, face);
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
					{ "Golem", "Zombie", "Demon", "Skeleton", "Dragon", "Vampire" };

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
					}

				int random = rand.nextInt(enemyArray.length);
				Icon body = null;
				Icon face = null;
				
				switch (random) {
					case 0: body = new ImageIcon(Enemy.class.getResource("/imgss/golemboss.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/golembosshead.png"));
					break;
					case 1: body = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZ.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZhead.png"));
					break;
					case 2: body = new ImageIcon(Enemy.class.getResource("/imgss/demon.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/demonhead.png"));
					break;
					case 3: body = new ImageIcon(Enemy.class.getResource("/imgss/skelly.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/skellyhead.png"));
					break;
					case 4: body = new ImageIcon(Enemy.class.getResource("/imgss/dragon.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/dragonhead.png"));
					break;
					case 5: body = new ImageIcon(Enemy.class.getResource("/imgss/vampire.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/vampirehead.png"));
					break;
				}

				return new Enemy(stats[0], stats[1], stats[2], stats[3], enemyArray[random] + " Boss", body, face);
			}

	}