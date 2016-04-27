
 // @author Tana Larrabee
 // Apr 26, 2016
 // TeamRpg

package team;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * @author Tana Larrabee
 */
public class teamRpg {

	private JFrame frame;
	private JPanel mainRoom;
	private JPanel upperRoom;
	private JPanel lowerRoom;
	private JPanel eastRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teamRpg window = new teamRpg();
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
	public teamRpg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
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
		mainUpBtn.setIcon(new ImageIcon(teamRpg.class.getResource("/images/betterdoor.png")));
		mainUpBtn.setContentAreaFilled(false);
		mainUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperRoom.setVisible(true);
				mainRoom.setVisible(false);
				frame.setBounds(100, 100, 466, 655);
			}
		});
		mainUpBtn.setBounds(369, 13, 78, 103);
		mainRoom.add(mainUpBtn);
		
		JButton mainDownBtn = new JButton("");
		mainDownBtn.setBorderPainted(false);
		mainDownBtn.setIcon(new ImageIcon(teamRpg.class.getResource("/images/stairsdown.png")));
		mainDownBtn.setBorder(null);
		mainDownBtn.setContentAreaFilled(false);
		mainDownBtn.setOpaque(false);
		mainDownBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowerRoom.setVisible(true);
				mainRoom.setVisible(false);
				frame.setBounds(100, 100, 466, 655);
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
			}
		});
		mainButtonEast.setContentAreaFilled(false);
		mainButtonEast.setBorderPainted(false);
		mainButtonEast.setBorder(null);
		mainButtonEast.setIcon(new ImageIcon(teamRpg.class.getResource("/images/stairsup.png")));
		mainButtonEast.setBounds(710, 281, 95, 77);
		mainRoom.add(mainButtonEast);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(teamRpg.class.getResource("/images/main.png")));
		label.setBounds(0, 0, 816, 608);
		mainRoom.add(label);
		
		
		
		JButton upperGoBack = new JButton("");
		upperGoBack.setBorderPainted(false);
		upperGoBack.setBorder(null);
		upperGoBack.setContentAreaFilled(false);
		upperGoBack.setIcon(new ImageIcon(teamRpg.class.getResource("/images/stairsdown.png")));
		upperGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upperRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
			}
		});
		upperGoBack.setBounds(12, 530, 130, 65);
		upperRoom.add(upperGoBack);
		
		JLabel upperLbl = new JLabel("");
		upperLbl.setIcon(new ImageIcon(teamRpg.class.getResource("/images/room1.png")));
		upperLbl.setBounds(0, 0, 448, 608);
		upperRoom.add(upperLbl);
		
		
		
		JButton lowerGoBack = new JButton("");
		lowerGoBack.setBorder(null);
		lowerGoBack.setBorderPainted(false);
		lowerGoBack.setIcon(new ImageIcon(teamRpg.class.getResource("/images/upstairs.png")));
		lowerGoBack.setContentAreaFilled(false);
		lowerGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowerRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
			}
		});
		lowerGoBack.setBounds(181, 13, 86, 98);
		lowerRoom.add(lowerGoBack);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 448, 608);
		lowerRoom.add(label_1);
		label_1.setIcon(new ImageIcon(teamRpg.class.getResource("/images/room1.png")));
		
		
		
		JButton eastGoBack = new JButton("");
		eastGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eastRoom.setVisible(false);
				mainRoom.setVisible(true);
				frame.setBounds(100, 100, 834, 655);
			}
		});
		eastGoBack.setContentAreaFilled(false);
		eastGoBack.setIcon(new ImageIcon(teamRpg.class.getResource("/images/stairsdown.png")));
		eastGoBack.setBounds(12, 530, 130, 65);
		eastRoom.add(eastGoBack);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(null);
		label_2.setInheritsPopupMenu(false);
		label_2.setBounds(0, 0, 448, 608);
		label_2.setIcon(new ImageIcon(teamRpg.class.getResource("/images/room1.png")));
		eastRoom.add(label_2);
	}
}
