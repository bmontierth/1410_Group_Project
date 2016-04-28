
 // @author Tana Larrabee
 // Apr 26, 2016
 // TeamRpg


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * @author Tana Larrabee
 * Main.java contains the main method to start the game. It contains the GUI components.
 * It contains the adventure panes, content panes, etc. It also contains the starting pane
 * that the user uses to select their hero class and hero name.
 */
public class Main {

	private JFrame frame;
	private JPanel mainRoom;
	private JPanel upperRoom;
	private JPanel lowerRoom;
	private JPanel eastRoom;
	private JTextField txtHeroName;
	private InitHeroClass CLASS;
	private Character hero;
	private Character enemy;
	Battle battleWindow;

	/**
	 * Launch the application. Create Jframe.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setSize(1000, 800);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public  Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. Call the startingPane method.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adventurePane();
		startingPane();
	}

	/**
	 * adventurePane is called from the startingPane. Once the user chooses their hero information,
	 * adventurePane is called to start the game.
	 * adventurePane contains all the different panes for the map. It contains each of the rooms and all
	 * the directional navigation buttons. On each different pane/room, it calls the method fight().
	 */
	private void adventurePane() {
		frame.getContentPane().removeAll();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setBounds(100, 100, 834, 655);
		
		final JPanel mainRoom = new JPanel();
		frame.getContentPane().add(mainRoom, "name_995792453006807");
		mainRoom.setLayout(null);
		mainRoom.setVisible(true);
		
		final JPanel upperRoom = new JPanel();
		frame.getContentPane().add(upperRoom, "name_995794396943689");
		upperRoom.setLayout(null);
		upperRoom.setVisible(false);
		
		final JPanel lowerRoom = new JPanel();
		frame.getContentPane().add(lowerRoom, "name_995796042294153");
		lowerRoom.setLayout(null);
		lowerRoom.setVisible(false);
		
		final JPanel eastRoom = new JPanel();
		frame.getContentPane().add(eastRoom, "name_1002792640658415");
		eastRoom.setLayout(null);
		eastRoom.setVisible(false);
		
		JButton mainUpBtn = new JButton("");
		mainUpBtn.setBorderPainted(false);
		mainUpBtn.setOpaque(false);
		mainUpBtn.setBorder(null);
		mainUpBtn.setIcon(new ImageIcon(Main.class.getResource("/imgss/betterdoor.png")));
		mainUpBtn.setContentAreaFilled(false);
		mainUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperRoom.setVisible(true);
				mainRoom.setVisible(false);
				frame.setBounds(100, 100, 466, 655);
				fight();
			}
		});
		mainUpBtn.setBounds(369, 13, 78, 103);
		mainRoom.add(mainUpBtn);
		
		JButton mainDownBtn = new JButton("");
		mainDownBtn.setBorderPainted(false);
		mainDownBtn.setIcon(new ImageIcon(Main.class.getResource("/imgss/stairsdown.png")));
		mainDownBtn.setBorder(null);
		mainDownBtn.setContentAreaFilled(false);
		mainDownBtn.setOpaque(false);
		mainDownBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowerRoom.setVisible(true);
				mainRoom.setVisible(false);
				frame.setBounds(100, 100, 466, 655);
				fight();
			}
		});
		mainDownBtn.setBounds(12, 527, 138, 68);
		mainRoom.add(mainDownBtn);
		
		JButton mainButtonEast = new JButton("");
		mainButtonEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eastRoom.setVisible(true);
				mainRoom.setVisible(false);
				frame.setBounds(100, 100, 466, 655);
				fight();
			}
		});
		mainButtonEast.setContentAreaFilled(false);
		mainButtonEast.setBorderPainted(false);
		mainButtonEast.setBorder(null);
		mainButtonEast.setIcon(new ImageIcon(Main.class.getResource("/imgss/stairsup.png")));
		mainButtonEast.setBounds(710, 281, 95, 77);
		mainRoom.add(mainButtonEast);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/imgss/main.png")));
		label.setBounds(0, 0, 816, 608);
		mainRoom.add(label);
		
		
		
		JButton upperGoBack = new JButton("");
		upperGoBack.setBorderPainted(false);
		upperGoBack.setBorder(null);
		upperGoBack.setContentAreaFilled(false);
		upperGoBack.setIcon(new ImageIcon(Main.class.getResource("/imgss/stairsdown.png")));
		upperGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
				fight();
			}
		});
		upperGoBack.setBounds(12, 530, 130, 65);
		upperRoom.add(upperGoBack);
		
		JLabel upperLbl = new JLabel("");
		upperLbl.setIcon(new ImageIcon(Main.class.getResource("/imgss/room1.png")));
		upperLbl.setBounds(0, 0, 448, 608);
		upperRoom.add(upperLbl);
		
		
		
		JButton lowerGoBack = new JButton("");
		lowerGoBack.setBorder(null);
		lowerGoBack.setBorderPainted(false);
		lowerGoBack.setIcon(new ImageIcon(Main.class.getResource("/imgss/upstairs.png")));
		lowerGoBack.setContentAreaFilled(false);
		lowerGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowerRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
				fight();
			}
		});
		lowerGoBack.setBounds(181, 13, 86, 98);
		lowerRoom.add(lowerGoBack);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 448, 608);
		lowerRoom.add(label_1);
		label_1.setIcon(new ImageIcon(Main.class.getResource("/imgss/room1.png")));
		
		
		
		JButton eastGoBack = new JButton("");
		eastGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eastRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
				fight();
			}
		});
		eastGoBack.setContentAreaFilled(false);
		eastGoBack.setIcon(new ImageIcon(Main.class.getResource("/imgss/stairsdown.png")));
		eastGoBack.setBounds(12, 530, 130, 65);
		eastRoom.add(eastGoBack);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(null);
		label_2.setInheritsPopupMenu(false);
		label_2.setBounds(0, 0, 448, 608);
		label_2.setIcon(new ImageIcon(Main.class.getResource("/imgss/room1.png")));
		eastRoom.add(label_2);
	}
	
	/**
	 * startingPane method gives options for the user to select their Hero class and set their hero name.
	 * It also has a "Ready" button for when the user has selected their class and set the name. 
	 * Then Action Listeners for each of the Hero buttons.
	 * Calls heroEvent when Class and Name are set.
	 * Calls adventurePane to start the game.
	 */
	private void startingPane() {
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblHeroName = new JLabel("Hero Name: ");
		panel_3.add(lblHeroName);
		lblHeroName.setFont(new Font("Papyrus", Font.BOLD, 15));
		
		txtHeroName = new JTextField();
		panel_3.add(txtHeroName);
		txtHeroName.setFont(new Font("Papyrus", Font.BOLD, 15));
		txtHeroName.setColumns(10);
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {0};
		gbl_panel_4.rowHeights = new int[] {0};
		gbl_panel_4.columnWeights = new double[]{0.0};
		gbl_panel_4.rowWeights = new double[]{0.0};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblChosenHero = new JLabel("");
		lblChosenHero.setFont(new Font("Papyrus", Font.BOLD, 25));
		GridBagConstraints gbc_lblChosenHero = new GridBagConstraints();
		gbc_lblChosenHero.insets = new Insets(0, 0, 5, 0);
		gbc_lblChosenHero.weighty = 1.0;
		gbc_lblChosenHero.weightx = 1.0;
		gbc_lblChosenHero.fill = GridBagConstraints.BOTH;
		gbc_lblChosenHero.gridx = 0;
		gbc_lblChosenHero.gridy = 0;
		panel_4.add(lblChosenHero, gbc_lblChosenHero);
		lblChosenHero.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblWelcome = new JLabel("Welcome to Tanaylan!");
		lblWelcome.setFont(new Font("Papyrus", Font.BOLD, 29));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblWelcome, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {200};
		gbl_panel_2.rowHeights = new int[] {0, 150, 150, 150, 150};
		gbl_panel_2.columnWeights = new double[]{0.0};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnArcher = new JButton("Archer");
		btnArcher.setFont(new Font("Papyrus", Font.PLAIN, 13));
		btnArcher.setPreferredSize(new Dimension(250, 150));
		btnArcher.setIcon(InitHeroClass.ARCHER.fullImage);
		GridBagConstraints gbc_btnArcher = new GridBagConstraints();
		gbc_btnArcher.insets = new Insets(0, 0, 5, 0);
		gbc_btnArcher.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnArcher.gridx = 0;
		gbc_btnArcher.gridy = 1;
		panel_2.add(btnArcher, gbc_btnArcher);
		
		JButton btnMage = new JButton("Mage");
		btnMage.setFont(new Font("Papyrus", Font.PLAIN, 13));
		btnMage.setPreferredSize(new Dimension(250, 150));
		btnMage.setIcon(InitHeroClass.MAGE.fullImage);
		GridBagConstraints gbc_btnMage = new GridBagConstraints();
		gbc_btnMage.insets = new Insets(0, 0, 5, 0);
		gbc_btnMage.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMage.gridx = 0;
		gbc_btnMage.gridy = 2;
		panel_2.add(btnMage, gbc_btnMage);
		
		JButton btnRogue = new JButton("Rogue");
		btnRogue.setFont(new Font("Papyrus", Font.PLAIN, 13));
		btnRogue.setPreferredSize(new Dimension(250, 150));
		btnRogue.setIcon(InitHeroClass.ROGUE.fullImage);
		GridBagConstraints gbc_btnRogue = new GridBagConstraints();
		gbc_btnRogue.insets = new Insets(0, 0, 5, 0);
		gbc_btnRogue.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnRogue.gridx = 0;
		gbc_btnRogue.gridy = 3;
		panel_2.add(btnRogue, gbc_btnRogue);
		
		JButton btnWarrior = new JButton("Warrior");
		btnWarrior.setFont(new Font("Papyrus", Font.PLAIN, 13));
		btnWarrior.setPreferredSize(new Dimension(250, 150));
		btnWarrior.setIcon(InitHeroClass.WARRIOR.fullImage);
		GridBagConstraints gbc_btnWarrior = new GridBagConstraints();
		gbc_btnWarrior.insets = new Insets(0, 0, 5, 0);
		gbc_btnWarrior.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnWarrior.gridx = 0;
		gbc_btnWarrior.gridy = 4;
		panel_2.add(btnWarrior, gbc_btnWarrior);
		
		JLabel lblNewLabel = new JLabel("Select A Class:");
		lblNewLabel.setFont(new Font("Papyrus", Font.BOLD, 15));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnContinue = new JButton("Ready!");
		
		btnContinue.setFont(new Font("Papyrus", Font.BOLD, 25));
		panel.add(btnContinue, BorderLayout.SOUTH);
		
		
		btnArcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLASS = InitHeroClass.ARCHER;
				heroEvent(e,lblChosenHero);
			}
		});
		btnMage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLASS = InitHeroClass.MAGE;
				heroEvent(e,lblChosenHero);
			}
		});
		btnRogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLASS = InitHeroClass.ROGUE;
				heroEvent(e,lblChosenHero);
			}
		});
		btnWarrior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CLASS = InitHeroClass.WARRIOR;
				heroEvent(e,lblChosenHero);
			}
		});
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHeroName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Your hero needs a name!");
					return;
				}
				
				if (lblChosenHero.getIcon() == null) {
					JOptionPane.showMessageDialog(frame, "Please select a class on the left");
					return;
				}
				
				hero = new Hero(CLASS,txtHeroName.getText());
				adventurePane();
				
			}
		});
	}
	
	/**
	 * Hero event sets the Hero that the user has chosen.
	 * @param e ActionEvent from startingPane
	 * @param lblChosenHero the user's chosen hero from startingPane.
	 */
	private void heroEvent(ActionEvent e, JLabel lblChosenHero) {
		lblChosenHero.setIcon(((JButton) e.getSource()).getIcon());
	}
	
	/**
	 * fight is called from adventurePane when the hero enters a new room. Each room has
	 * an enemy. 
	 * Fight starts a new Battle with a random enemy. Once they defeat that enemy, they are
	 * able to progress to the next room.
	 * Calls Battle.java
	 */
	private void fight() {
		try {
			battleWindow = new Battle(hero, Enemy.randomEnemy(((Hero) hero).getLevel()));
			battleWindow.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
