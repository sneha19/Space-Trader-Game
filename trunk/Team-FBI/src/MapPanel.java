import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * This is the panel for displaying the map and the main game-playing screen
 * But for purpose of M5, this only holds and display the information of created player
 * @author Guang Lu
 *
 */
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
	
	private JLabel lblShipName;
	private JLabel lblShipCargo;
	private JLabel lblShipCost;
	private JLabel lblShipFuel;
	private JLabel lblShipHull;
	/**
	 * Constructor, the map takes in a player
	 * @param player the player
	 */
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
		
		lblShipName = new JLabel("Ship Name: "+player.getShip().getName());
		
		lblShipCargo = new JLabel("Ship Cargo Capacity: "+player.getShip().getCargoCapacity());
		
		lblShipCost = new JLabel("Ship Cost: "+player.getShip().getCost());
		
		lblShipFuel = new JLabel("Ship Fuel Cap: "+player.getShip().getFuelCapacity());
		
		lblShipHull = new JLabel("Ship Hull: "+player.getShip().getHull());
		/*
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
		*/

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExp1)
								.addComponent(lblExp2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTraderPoints))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEngineerPoints))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblName))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFighterPoints))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDifficulty)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPilotPoints)
										.addComponent(lblAvailableSkillPoints))
									.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblShipHull)
										.addComponent(lblShipName)
										.addComponent(lblShipCargo)
										.addComponent(lblShipCost)
										.addComponent(lblShipFuel))))))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblExp1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExp2)
					.addGap(22)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFighterPoints)
						.addComponent(lblShipName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEngineerPoints)
						.addComponent(lblShipCargo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTraderPoints)
						.addComponent(lblShipCost))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(lblPilotPoints)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAvailableSkillPoints)
								.addComponent(lblShipHull))
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblShipFuel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(lblDifficulty)
					.addGap(23))
		);
		setLayout(groupLayout);
		
		
		
	}
}
