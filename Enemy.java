
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/*
 * Assignment: 1410 Group Project 
 * Class : ${CLASS_NAME} Author : Brian Montierth
 * Created : 4/7/2016
 ******************************************/

/**
 * Class Enemy extends Character. 
 * It contains a constructor for an Enemy object. 
 * a randomEnemy method that generates a random enemy including random stats. 
 * a finalBoss method that generates a random final boss enemy that is stronger than the usual enemy
 * 
 * 
 * @author Taylor
 */
public class Enemy extends Character
	{
		
	private final Icon fullImage;
	private final Icon faceImage;

		/**
		 * Enemy constructs an enemy. It takes in its' parameters from randomEnemy
		 * @param attack
		 * @param defense
		 * @param health
		 * @param crit
		 * @param name
		 */
		private Enemy(int attack, int defense, int health, int crit, String name, Icon fullImage, Icon faceImage)
			{
				super(attack, defense, health, crit, name);
				this.fullImage = fullImage;
				this.faceImage = faceImage;
			}

		/**
		 * randomEnemy is a method that creates a random enemy and its parameters to be passed onto the Enemy constructor.
		 * randomEnemy will also call a finalBoss every 5 levels. 
		 * @param heroLevel heroLevel is needed because it scales the Enemy stats
		 * @return Enemy that is randomly chosen from an enemyArray.
		 */
		public static Enemy randomEnemy(int heroLevel)
			{
				if(heroLevel % 5 == 0)
					return finalBoss(heroLevel);
			
			String[] enemyArray =
					{ "Golem", "Zombie", "Demon", "Skeleton", "Dragon", "Vampire"};

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
						stats[stat] = (int) ((rand.nextInt(enemyArray.length) + 5) * heroScale);
					}
				
				int random = rand.nextInt(enemyArray.length);
				Icon body = null;
				Icon face = null;
				
				switch (random) {
					case 0: body = new ImageIcon(Enemy.class.getResource("/imgss/golemboss.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/golembosshead.png"));
					break;
					case 1: body = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZ.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/zombiehead.png"));
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
		 * @see java.lang.Object#toString()
		 */
		/**
		 * toString calls super.getName() method. @see Character.java
		 * @return super.getName() 
		 */
		@Override
		public String toString()
			{
				return super.getName();
			}

		/**
		 * finalBoss is very similar to randomEnemy() except that assigns higher stats than usual to make
		 * a stronger Enemy.
		 * @param heroLevel is the level of the Hero object. Enemy difficulty is scaled off of that param.
		 * @return an Enemy object with higher than normal stats.
		 */
		public static Enemy finalBoss(int heroLevel)
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
						stats[stat] = (int) ((rand.nextInt(enemyArray.length) + 8) * heroScale);
					}

				int random = rand.nextInt(enemyArray.length);
				Icon body = null;
				Icon face = null;
				
				switch (random) {
					case 0: body = new ImageIcon(Enemy.class.getResource("/imgss/golemboss.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/golembosshead.png"));
					break;
					case 1: body = new ImageIcon(Enemy.class.getResource("/imgss/meeseeksZ.png"));
					face = new ImageIcon(Enemy.class.getResource("/imgss/zombiehead.png"));
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

		/**
		 * @return the fullImage of the Enemy object
		 */
		public Icon getFullImage() {
			return fullImage;
		}

		/**
		 * @return the faceImage of the Enemy object
		 */
		public Icon getFaceImage() {
			return faceImage;
		}

		
	}