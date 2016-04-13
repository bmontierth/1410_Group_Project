import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JProgressBar;
import java.awt.Color;

public class Battle {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battle window = new Battle();
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
	public Battle() {
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
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblHeroFace = new JLabel("Hero Face");
		GridBagConstraints gbc_lblHeroFace = new GridBagConstraints();
		gbc_lblHeroFace.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeroFace.gridx = 0;
		gbc_lblHeroFace.gridy = 0;
		panel.add(lblHeroFace, gbc_lblHeroFace);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.RED);
		progressBar.setValue(50);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 0;
		panel.add(progressBar, gbc_progressBar);
		
		JLabel lblEnemyFace = new JLabel("Enemy Face");
		GridBagConstraints gbc_lblEnemyFace = new GridBagConstraints();
		gbc_lblEnemyFace.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnemyFace.gridx = 10;
		gbc_lblEnemyFace.gridy = 0;
		panel.add(lblEnemyFace, gbc_lblEnemyFace);
		
		JProgressBar progressBar_1 = new JProgressBar();
		GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
		gbc_progressBar_1.gridx = 11;
		gbc_progressBar_1.gridy = 0;
		panel.add(progressBar_1, gbc_progressBar_1);
	}

}
