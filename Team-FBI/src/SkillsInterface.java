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


public class SkillsInterface extends JPanel {
	Player myCurrentPlayer;
	Skills currSkills = new Skills(myCurrentPlayer);
	int currentPoints = currSkills.getCurrPoints();
	JLabel lblEngineering = new JLabel("Engineering: ");
	
	JLabel lblSkillsMenu = new JLabel("SKILLS MENU");
	
	JLabel lblFighter = new JLabel("Fighter:");
	
	JLabel lblPilot = new JLabel("Pilot:");
	
	JLabel lblTrader = new JLabel("Trader: ");
	
	JLabel lblPointsRemaning = new JLabel("Points remaning: ");
	
	JLabel lblSkillsPointsRemaning = new JLabel(Integer.toString(currSkills.getCurrPoints()));
	
    JLabel lblEngineeringPoints = new JLabel(Integer.toString(currSkills.getEngineerPoints()));
	
	JLabel lblFighterPoints = new JLabel(Integer.toString(currSkills.getFighterPoints()));
	
	JLabel lblPilotPoints = new JLabel(Integer.toString(currSkills.getPilotPoints()));
	
	JLabel lblTraderPoints = new JLabel(Integer.toString(currSkills.getTraderPoints()));
	
	JButton btnNext = new JButton("Next!");
	
	JButton btnEngineering = new JButton("Increase");
	JButton btnFighter = new JButton("Increase");
	
	JButton btnPilot = new JButton("Increase");
	
	JButton btnTrader = new JButton("Increase");
	/**
	 * Create the panel.
	 */
	public SkillsInterface(Player player) {
		
		
		btnEngineering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currSkills.getCurrPoints() > 0)
				{
					currSkills.setEngineerPoints(1);
					currSkills.setCurrPoints(-1);
					

				}
				lblSkillsPointsRemaning.setText(Integer.toString(currSkills.getCurrPoints()));
				lblEngineeringPoints.setText(Integer.toString(currSkills.getEngineerPoints()));
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
		myCurrentPlayer = player;
	}
}
