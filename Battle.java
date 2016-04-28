import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

/**
 * This class runs the battle scene between the hero and enemy.
 * 
 * @author Brian, Taylor, and Tana
 *
 */
public class Battle {

	/**
	 * Main window frame.
	 */
	public JFrame frame;
	/**
	 * Represents the hero. Passed from Main.
	 */
	private Character hero;
	/**
	 * Represents the enemy (randomly generated).
	 */
	private Character enemy;
	/**
	 * Temporary hero health. Initialized by the hero's health stat.
	 */
	private int heroTempHealth;
	/**
	 * Temporary enemy health. Initialized by the enemy's health stat.
	 */
	private int enemyTempHealth;
	/**
	 * String variable for the main window message.
	 */
	private String message;
	/**
	 * represents the damage the enemy inflicts.
	 */
	private int enemyDamage;
	/**
	 * represents the damage the hero inflicts.
	 */
	private int heroDamage;


	/**
	 * Create the application.
	 */
	public Battle(Character hero, Character enemy) {
		this.hero = hero;
		this.heroTempHealth = hero.getHealth();
		this.enemy = enemy;
		this.enemyTempHealth = enemy.getHealth();
		System.out.println(hero.getStats());
		System.out.println();
		System.out.println(enemy.getStats());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 721, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[] {0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblHeroFace = new JLabel("");
		lblHeroFace.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblHeroFace.setIcon(((Hero)hero).getFaceImage());
		GridBagConstraints gbc_lblHeroFace = new GridBagConstraints();
		gbc_lblHeroFace.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeroFace.gridx = 0;
		gbc_lblHeroFace.gridy = 0;
		panel.add(lblHeroFace, gbc_lblHeroFace);
		
		JProgressBar heroHealthBar = new JProgressBar();
		heroHealthBar.setStringPainted(true);
		heroHealthBar.setForeground(Color.RED);
		GridBagConstraints gbc_heroHealthBar = new GridBagConstraints();
		gbc_heroHealthBar.anchor = GridBagConstraints.NORTH;
		gbc_heroHealthBar.insets = new Insets(0, 0, 5, 5);
		gbc_heroHealthBar.gridx = 1;
		gbc_heroHealthBar.gridy = 0;
		heroHealthBar.setMaximum(heroTempHealth);
		heroHealthBar.setValue(heroTempHealth);
		heroHealthBar.setString(Integer.toString(heroTempHealth));
		panel.add(heroHealthBar, gbc_heroHealthBar);
		
		JLabel lblSpacer = new JLabel("");
		GridBagConstraints gbc_lblSpacer = new GridBagConstraints();
		gbc_lblSpacer.weighty = 1.0;
		gbc_lblSpacer.weightx = 1.0;
		gbc_lblSpacer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSpacer.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer.gridx = 2;
		gbc_lblSpacer.gridy = 0;
		panel.add(lblSpacer, gbc_lblSpacer);
		
		JLabel lblHeroName = new JLabel(hero.toString());
		GridBagConstraints gbc_lblHeroName = new GridBagConstraints();
		gbc_lblHeroName.anchor = GridBagConstraints.WEST;
		gbc_lblHeroName.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeroName.gridx = 1;
		gbc_lblHeroName.gridy = 0;
		panel.add(lblHeroName, gbc_lblHeroName);
		
		JLabel lblEnemyName = new JLabel(enemy.toString());
		GridBagConstraints gbc_lblEnemyName = new GridBagConstraints();
		gbc_lblEnemyName.anchor = GridBagConstraints.EAST;
		gbc_lblEnemyName.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnemyName.gridx = 3;
		gbc_lblEnemyName.gridy = 0;
		panel.add(lblEnemyName, gbc_lblEnemyName);
		
		JLabel lblEnemyFace = new JLabel("");
		lblEnemyFace.setIcon(((Enemy) enemy).getFaceImage());
		lblEnemyFace.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_lblEnemyFace = new GridBagConstraints();
		gbc_lblEnemyFace.gridx = 4;
		gbc_lblEnemyFace.gridy = 0;
		panel.add(lblEnemyFace, gbc_lblEnemyFace);
		
		JProgressBar enemyHealthBar = new JProgressBar();
		enemyHealthBar.setStringPainted(true);
		enemyHealthBar.setForeground(Color.RED);
		GridBagConstraints gbc_enemyHealthBar = new GridBagConstraints();
		gbc_enemyHealthBar.anchor = GridBagConstraints.NORTH;
		gbc_enemyHealthBar.insets = new Insets(0, 0, 5, 5);
		gbc_enemyHealthBar.gridx = 3;
		gbc_enemyHealthBar.gridy = 0;
		enemyHealthBar.setMaximum(enemyTempHealth);
		enemyHealthBar.setValue(enemyTempHealth);
		enemyHealthBar.setString(Integer.toString(enemyTempHealth));
		panel.add(enemyHealthBar, gbc_enemyHealthBar);
		
		JPanel panelBattleActions = new JPanel();
		frame.getContentPane().add(panelBattleActions, BorderLayout.SOUTH);
			
		
		JButton btnFight = new JButton("Fight");
		panelBattleActions.add(btnFight);
		
		JButton btnRunAway = new JButton("Run Away");
		btnRunAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		panelBattleActions.add(btnRunAway);
		
		JLabel battleMessage = new JLabel();
		battleMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(battleMessage, BorderLayout.CENTER);
		
		JLabel lblHeroImage = new JLabel("");
		lblHeroImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeroImage.setPreferredSize(new Dimension(128, 0));
		lblHeroImage.setIcon(((Hero)hero).getFullImage());
		frame.getContentPane().add(lblHeroImage, BorderLayout.WEST);
		
		JLabel lblEnemyImage = new JLabel("");
		lblEnemyImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyImage.setPreferredSize(new Dimension(128, 0));
		lblEnemyImage.setIcon(((Enemy) enemy).getFullImage());
		frame.getContentPane().add(lblEnemyImage, BorderLayout.EAST);
		
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnFight.setEnabled(false);
				lblHeroImage.setVisible(false);
				battleMessage.setHorizontalAlignment(SwingConstants.RIGHT);
				battleMessage.setIcon(lblHeroImage.getIcon());
				battleMessage.setIconTextGap(-300);
				
				
				message = "";
				
				enemyDamage = hero.attack(enemy, enemyTempHealth);
				enemyTempHealth -= enemyDamage;
				enemyHealthBar.setString(Integer.toString(enemyTempHealth));
				enemyHealthBar.setValue(enemyTempHealth);
				
				message = hero.getName() + " hit " + enemy.getName() + " for " + enemyDamage + " damage!";
				battleMessage.setText(message);
				
				
				
				if (enemyTempHealth == 0) {
					battleMessage.setHorizontalAlignment(SwingConstants.CENTER);
	        		battleMessage.setIcon(null);
	        		lblEnemyImage.setVisible(true);
	        		lblHeroImage.setVisible(true);
	        		battleComplete(true,battleMessage,enemy);
	        		((Hero) hero).levelUp();
	        		frame.dispose();
					return;
				}
				
				ActionListener listener = new ActionListener(){
			        public void actionPerformed(ActionEvent event){
			        	
			        	if (battleMessage.getIcon().equals(lblEnemyImage.getIcon())) {
			        		battleMessage.setHorizontalAlignment(SwingConstants.CENTER);
			        		battleMessage.setIcon(null);
			        		lblEnemyImage.setVisible(true);
			        		
			        		if (heroTempHealth <= 0)
							{
								btnFight.setEnabled(false);
								battleComplete(false,battleMessage,enemy);
				        		
							}
			        		else
			        			btnFight.setEnabled(true);
			        		return;
			        	}
			        	
			        	if (battleMessage.getIcon().equals(lblHeroImage.getIcon())) {
			        		battleMessage.setIconTextGap(4);
							lblHeroImage.setVisible(true);
							lblEnemyImage.setVisible(false);
							battleMessage.setHorizontalAlignment(SwingConstants.LEFT);
							battleMessage.setIcon(lblEnemyImage.getIcon());
							((Timer) event.getSource()).restart();
			        	}

			        	heroDamage = enemy.attack(hero, heroTempHealth);
						heroTempHealth -= heroDamage;
						heroHealthBar.setString(Integer.toString(heroTempHealth));
						heroHealthBar.setValue(heroTempHealth);
						
						message = "<html>" + message + "<br>" + enemy.getName() + " hit " + hero.getName() + " for " + heroDamage + " damage!</html>";
						battleMessage.setText(message);
						
			        }
			    };
			    Timer timer = new Timer(1000, listener);
			    timer.setRepeats(false);
			    timer.start();
			    
			    
			    
				
				
			}
		});
	}

	/**
	 * Displays results of the battle.
	 * 
	 * @param win
	 * @param message
	 * @param enemy
	 */
	protected void battleComplete(boolean win,JLabel message,Character enemy) {
		if (win)
		{
			message.setText("Congrats! \nYou defeated the " + enemy.getName() + "!");
		}
		else
			message.setText("Oh No! \nYou were defeated by the " + enemy.getName() + "!");
	}
	
}
