import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI for skills
 * @author Haytham Abutair
 *
 */
public class SkillsInterface extends JPanel {
	Player currPlayer;
	Skills currSkills;
	int currentPoints;
	JLabel name111;
	
	JLabel lblEngineering = new JLabel("Engineering: ");
	
	JLabel lblSkillsMenu =new JLabel("SKILLS MENU");
	
	JLabel lblFighter = new JLabel("Fighter:");
	
	JLabel lblPilot = new JLabel("Pilot:");
	
	JLabel lblTrader = new JLabel("Trader: ");
	
	JLabel lblPointsRemaning = new JLabel("Points remaning: ");
	
	JLabel lblSkillsPointsRemaning;
	
    JLabel lblEngineeringPoints; 
	
	JLabel lblFighterPoints; 
	
	JLabel lblPilotPoints; 
	
	JLabel lblTraderPoints;
	
	JButton btnNext = new JButton("Next");
	
	JButton btnEngineering = new JButton("Increase");
	JButton btnFighter = new JButton("Increase");
	
	JButton btnPilot = new JButton("Increase");
	
	JButton btnTrader = new JButton("Increase");
	/**
	 * Create the panel.
	 */
	public SkillsInterface(Skills skills) {
		btnNext.setVisible(false);
		currSkills=skills;
		currPlayer=skills.getPlayer();
		currentPoints = currSkills.getCurrPoints();
		
		
		lblSkillsPointsRemaning = new JLabel(Integer.toString(currSkills.getCurrPoints()));
		
	    lblEngineeringPoints = new JLabel(Integer.toString(currSkills.getEngineerPoints()));
		
		lblFighterPoints = new JLabel(Integer.toString(currSkills.getFighterPoints()));
		
		lblPilotPoints = new JLabel(Integer.toString(currSkills.getPilotPoints()));
		
		lblTraderPoints = new JLabel(Integer.toString(currSkills.getTraderPoints()));
		
		
		

		btnFighter.addActionListener(new ActionListener() {
			/**
			 * actionPerformed for the fighter button
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1)
				{
					currSkills.setFighterPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					if(currSkills.getCurrPoints() == 0)
					{
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
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1)
				{
					currSkills.setEngineerPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					
					if(currSkills.getCurrPoints() == 0)
					{
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
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1)
				{
					currSkills.setPilotPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);

					btnNext.setVisible(false);
					if(currSkills.getCurrPoints() == 0)
					{
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
			 */
			public void actionPerformed(ActionEvent e) {
				if(currSkills.getCurrPoints() >= 1)
				{
					currSkills.setTraderPoints(1);
					currSkills.setCurrPoints(-1);
					currPlayer.setAvailableSkillPoints(-1);
					
					if(currSkills.getCurrPoints() == 0)
					{
						btnNext.setVisible(true);
					}
					
				}
				lblSkillsPointsRemaning.setText(Integer.toString(currSkills.getCurrPoints()));
				lblTraderPoints.setText(Integer.toString(currSkills.getTraderPoints()));
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
}
