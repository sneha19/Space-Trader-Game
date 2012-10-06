import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class MapPanel extends JPanel {
	private JLabel lblExp1;
	private JLabel lblExp2;
	private JLabel lblName;
	private JLabel lblFighterPoints;
	private JLabel lblEngineerPoints;
	private JLabel lblTraderPoints;
	private JLabel lblPilotPoints;
	private JLabel lblAvailableSkillPoints;
	private JLabel lblDifficulty;
	public MapPanel(Player player) {
		
		lblExp1 = new JLabel("It will show we have successfully created a player object");
		
		lblExp2= new JLabel("Up to M5, this class is for testing");
		
		lblName = new JLabel("PlayerName: "+player.getName());
		
		lblFighterPoints = new JLabel("Fighter Point "+player.getFighter());
		
		lblEngineerPoints = new JLabel("Engineer Point "+player.getEngineer());
		
		lblTraderPoints = new JLabel("Trader Point "+player.getTrader());
		
		lblPilotPoints = new JLabel("Pilot Point "+player.getPilot());
		
		lblAvailableSkillPoints = new JLabel("Available Points: "+player.getAvailableSkillPoints());
		
		lblDifficulty = new JLabel("Difficulty selected: "+player.getDifficulty());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblFighterPoints)
								.addComponent(lblEngineerPoints)
								.addComponent(lblTraderPoints)
								.addComponent(lblPilotPoints)
								.addComponent(lblAvailableSkillPoints)
								.addComponent(lblDifficulty)
								.addComponent(lblExp1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addComponent(lblExp2)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblExp2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExp1)
					.addGap(30)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFighterPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEngineerPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTraderPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPilotPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAvailableSkillPoints)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDifficulty)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
