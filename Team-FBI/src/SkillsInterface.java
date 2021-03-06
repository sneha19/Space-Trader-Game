// $codepro.audit.disable fileComment, variableShouldBeFinal, lineLength, methodChainLength, numericLiterals
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;


import java.awt.Graphics;
import java.awt.Image;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * GUI for skills
 * @author Haytham Abutair
 * @version 1
 */
public class SkillsInterface extends JPanel {
	/**
	 * curr player
	 */
	private Player currPlayer;

	/**
	 * curr skills
	 */
	private Skills currSkills;

	/**
	 * curr points
	 */
	private int currentPoints;

	/**
	 * engineering
	 */
	private JLabel lblEngineering = new JLabel("Engineering: ");

	/**
	 * skills
	 */
	private JLabel lblSkillsMenu =new JLabel("SKILLS MENU");

	/**
	 * fighter
	 */
	private JLabel lblFighter = new JLabel("Fighter:");

	/**
	 * pilot
	 */
	private JLabel lblPilot = new JLabel("Pilot:");

	/**
	 * trader
	 */
	private JLabel lblTrader = new JLabel("Trader: ");

	/**
	 * points remaning
	 */
	private JLabel lblPointsRemaning = new JLabel("Points remaning: ");

	/**
	 * skills points
	 */
	private JLabel lblSkillsPointsRemaning;

	/**
	 * engineering points
	 */
	private JLabel lblEngineeringPoints; 

	/**
	 * fighter butotn
	 */
	private JLabel lblFighterPoints; 

	/**
	 * pilot button
	 */
	private JLabel lblPilotPoints; 

	/**
	 * trader button
	 */
	private JLabel lblTraderPoints;

	/**
	 * next button
	 */
	private JButton btnNext = new JButton("Next");

	/**
	 * engineering button
	 */
	private JButton btnEngineering = new JButton("Increase");

	/**
	 * figher button
	 */
	private JButton btnFighter = new JButton("Increase");

	/**
	 * pilot button
	 */
	private JButton btnPilot = new JButton("Increase");

	/**
	 * trade button
	 */
	private JButton btnTrader = new JButton("Increase");

	/**
	 * Create the panel.
	 * @param skills
	 */
	public SkillsInterface(Skills skills) { // $codepro.audit.disable
		btnNext.setVisible(false);
		currSkills=skills;
		currPlayer=skills.getPlayer();
		currentPoints = currSkills.getCurrPoints();

		lblSkillsPointsRemaning = new JLabel
				(Integer.toString(currSkills.getCurrPoints()));
		lblSkillsPointsRemaning.setForeground(new Color(255, 255, 255));
		
	    lblEngineeringPoints = new JLabel(Integer.toString
	    		(currSkills.getEngineerPoints()));
	    lblEngineeringPoints.setForeground(new Color(255, 255, 255));
		
		lblFighterPoints = new JLabel(Integer.toString
				(currSkills.getFighterPoints()));
		lblFighterPoints.setForeground(new Color(255, 255, 255));
		
		lblPilotPoints = new JLabel(Integer.toString
				(currSkills.getPilotPoints()));
		lblPilotPoints.setForeground(new Color(255, 255, 255));
		
		lblTraderPoints = new JLabel(Integer.toString
				(currSkills.getTraderPoints()));
		lblTraderPoints.setForeground(new Color(255, 255, 255));

		btnFighter.addActionListener(new ActionListener() {
			/**
			 * actionPerformed for the fighter button
			 * @param e action
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1){
					currSkills.setFighterPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					if(currSkills.getCurrPoints() == 0){
						btnNext.setVisible(true);
					}
					
				}
				lblSkillsPointsRemaning.setText(Integer.toString(currSkills.getCurrPoints()));
				lblFighterPoints.setText(Integer.toString(currSkills.getFighterPoints()));
			}
		});
		btnEngineering.addActionListener(new ActionListener() {
			/**
			 * actionPerformed for the Engineer button
			 * @param e action
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1){
					currSkills.setEngineerPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					
					if(currSkills.getCurrPoints() == 0){
						btnNext.setVisible(true);
					}
					
				}
				lblSkillsPointsRemaning.setText(Integer.toString(currSkills.getCurrPoints()));
				lblEngineeringPoints.setText(Integer.toString(currSkills.getEngineerPoints()));
			}
		});
		
		btnPilot.addActionListener(new ActionListener() {
			/**
			 * actionPerformed for the Pilot button
			 *  @param e action
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1){
					currSkills.setPilotPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);

					btnNext.setVisible(false);
					if(currSkills.getCurrPoints() == 0){
						btnNext.setVisible(true);
					}
					
				}
				lblSkillsPointsRemaning.setText(Integer.toString(currSkills.getCurrPoints()));
				lblPilotPoints.setText(Integer.toString(currSkills.getPilotPoints()));
			}
		});
		btnTrader.addActionListener(new ActionListener() {
			/**
			 * actionPerformed for the Trader button
			 * @param e action
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1){
					currSkills.setTraderPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					
					if(currSkills.getCurrPoints() == 0){
						btnNext.setVisible(true);
					}
					
				}
				lblSkillsPointsRemaning.setText
				(Integer.toString(currSkills.getCurrPoints()));
				lblTraderPoints.setText(Integer.toString
						(currSkills.getTraderPoints()));
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEngineering)
						.addComponent(lblTrader)
						.addComponent(lblPilot)
						.addComponent(lblFighter))
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNext)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSkillsMenu)
								.addComponent(lblEngineeringPoints)
								.addComponent(lblTraderPoints)
								.addComponent(lblPilotPoints)
								.addComponent(lblFighterPoints)
								.addComponent(lblPointsRemaning))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnFighter, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnEngineering)
										.addComponent(btnPilot, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTrader, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addGap(28))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(46)
									.addComponent(lblSkillsPointsRemaning, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
									.addGap(44))))))
		);
		lblSkillsMenu.setForeground(Color.WHITE);
		lblPointsRemaning.setForeground(new Color(255, 255, 255));
		lblEngineering.setForeground(new Color(255, 255, 255));
		lblFighter.setForeground(new Color(255, 255, 255));
		lblPilot.setForeground(new Color(255, 255, 255));
		lblTrader.setForeground(new Color(255, 255, 255));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSkillsMenu)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPointsRemaning)
						.addComponent(lblSkillsPointsRemaning))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEngineering)
						.addComponent(lblEngineeringPoints)
						.addComponent(btnEngineering))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFighterPoints)
						.addComponent(lblFighter)
						.addComponent(btnFighter))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPilot)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPilotPoints)
							.addComponent(btnPilot)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTrader)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTraderPoints)
							.addComponent(btnTrader)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext)
					.addGap(35))
		);
		setLayout(groupLayout);
	}

	/**
	 * actionPerformed for the next button
	 * @param al action
	 */
	public void setbtnNextListener(ActionListener al){
		btnNext.addActionListener(al);
	}

	/**
	 * disables the next button
	 */
	public void disablebtnNext(){
		btnNext.setVisible(false);
	}

	/**
	 * draw background
	 * @param g a Graphics instance
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}
