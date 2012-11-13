import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.util.Random;

import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * A class that shows summary of a chosen planet
 * @author Guang Lu
 *
 */
public class Stats extends JPanel {
	private Planet planet;
	private Player player;
	private JLabel lblPlanetname;
	private JLabel lblTechleveld;
	private JLabel lblDistanced;
	private JLabel lblZoned;
	
	/**
	 * Constructor
	 * @param planet
	 * @param player
	 */
	public Stats(Planet planet, Player player){
		this.planet=planet;
		this.player=player;
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(330, 440));
		
		
		JLabel lblInformationHub = new JLabel("Information Hub");
		lblInformationHub.setForeground(Color.WHITE);
		
		JLabel lblPlanet = new JLabel("Planet :");
		lblPlanet.setForeground(Color.WHITE);
		
		lblPlanetname = new JLabel(planet.getPlanetName());
		lblPlanetname.setForeground(Color.WHITE);
		
		JLabel lblTechLevel = new JLabel("Tech Level :");
		lblTechLevel.setForeground(Color.WHITE);
		
		lblTechleveld = new JLabel(planet.getTechLevel()+"");
		lblTechleveld.setForeground(Color.WHITE);
		
		JLabel lblDistance = new JLabel("Distance :");
		lblDistance.setForeground(Color.WHITE);
		
		
		
		int s =Math.abs(planet.getLocation().x-player.getPosition().x)+Math.abs(planet.getLocation().y-player.getPosition().y);
		
		lblDistanced = new JLabel(""+s);
		lblDistanced.setForeground(Color.WHITE);
		
		JLabel lblZone = new JLabel("Zone :");
		lblZone.setForeground(Color.WHITE);
		
		lblZoned = new JLabel(planet.getZone().getZone()+"");
		lblZoned.setForeground(Color.WHITE);
		
		JLabel lblAverageBuyPrice = new JLabel("Avg Buy Price");
		lblAverageBuyPrice.setForeground(Color.WHITE);
		
		JLabel lblAverageSellPrice = new JLabel("Avg Sell Price");
		lblAverageSellPrice.setForeground(Color.WHITE);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(Color.WHITE);
		
		JLabel lblWaterBuy = new JLabel(averageBuy(0)+"");
		lblWaterBuy.setForeground(Color.WHITE);
		
		JLabel lblWaterSell = new JLabel(averageSell(0)+"");
		lblWaterSell.setForeground(Color.WHITE);
		
		JLabel lblFurs = new JLabel("Furs");
		lblFurs.setForeground(Color.WHITE);
		
		JLabel lblFursBuy = new JLabel(averageBuy(1)+"");
		lblFursBuy.setForeground(Color.WHITE);
		
		JLabel lblFursSell = new JLabel(averageSell(1)+"");
		lblFursSell.setForeground(Color.WHITE);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(Color.WHITE);
		
		JLabel lblFoodBuy = new JLabel(averageBuy(2)+"");
		lblFoodBuy.setForeground(Color.WHITE);
		
		JLabel lblFoodSell = new JLabel(averageSell(2)+"");
		lblFoodSell.setForeground(Color.WHITE);
		
		JLabel lblOre = new JLabel("Ore");
		lblOre.setForeground(Color.WHITE);
		
		JLabel lblOreBuy = new JLabel(averageBuy(3)+"");
		lblOreBuy.setForeground(Color.WHITE);
		
		JLabel lblOreSell = new JLabel(averageSell(3)+"");
		lblOreSell.setForeground(Color.WHITE);
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setForeground(Color.WHITE);
		
		JLabel lblGamesBuy = new JLabel(averageBuy(4)+"");
		lblGamesBuy.setForeground(Color.WHITE);
		
		JLabel lblGamesSell = new JLabel(averageSell(4)+"");
		lblGamesSell.setForeground(Color.WHITE);
		
		JLabel lblFirearms = new JLabel("Firearms");
		lblFirearms.setForeground(Color.WHITE);
		
		JLabel lblFireBuy = new JLabel(averageBuy(5)+"");
		lblFireBuy.setForeground(Color.WHITE);
		
		JLabel lblFireSell = new JLabel(averageSell(5)+"");
		lblFireSell.setForeground(Color.WHITE);
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setForeground(Color.WHITE);
		
		JLabel lblMedBuy = new JLabel(averageBuy(6)+"");
		lblMedBuy.setForeground(Color.WHITE);
		
		JLabel lblMedSell = new JLabel(averageSell(6)+"");
		lblMedSell.setForeground(Color.WHITE);
		
		JLabel lblMachines = new JLabel("Machines");
		lblMachines.setForeground(Color.WHITE);
		
		JLabel lblMacBuy = new JLabel(averageBuy(7)+"");
		lblMacBuy.setForeground(Color.WHITE);
		
		JLabel lblMacSell = new JLabel(averageSell(7)+"");
		lblMacSell.setForeground(Color.WHITE);
		
		JLabel lblNarcotics = new JLabel("Narcotics");
		lblNarcotics.setForeground(Color.WHITE);
		
		JLabel lblNarBuy = new JLabel(averageBuy(8)+"");
		lblNarBuy.setForeground(Color.WHITE);
		
		JLabel lblNarSell = new JLabel(averageSell(8)+"");
		lblNarSell.setForeground(Color.WHITE);
		
		JLabel lblRobots = new JLabel("Robots");
		lblRobots.setForeground(Color.WHITE);
		
		JLabel lblRobBuy = new JLabel(averageBuy(9)+"");
		lblRobBuy.setForeground(Color.WHITE);
		
		JLabel lblRobSell = new JLabel(averageSell(9)+"");
		lblRobSell.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPlanet)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblPlanetname))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDistance)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAverageBuyPrice)
										.addComponent(lblDistanced))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblTechLevel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblTechleveld))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblZone)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblZoned)
												.addComponent(lblWaterSell)
												.addComponent(lblFursSell)
												.addComponent(lblFoodSell)
												.addComponent(lblOreSell)
												.addComponent(lblGamesSell)
												.addComponent(lblFireSell)
												.addComponent(lblMedSell)
												.addComponent(lblMacSell)
												.addComponent(lblNarSell)
												.addComponent(lblRobSell)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addComponent(lblAverageSellPrice)))
							.addGap(20))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(lblInformationHub))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWater)
								.addComponent(lblFurs)
								.addComponent(lblFood)
								.addComponent(lblOre)
								.addComponent(lblGames)
								.addComponent(lblFirearms)
								.addComponent(lblMedicine)
								.addComponent(lblMachines)
								.addComponent(lblNarcotics)
								.addComponent(lblRobots))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRobBuy)
								.addComponent(lblNarBuy)
								.addComponent(lblMacBuy)
								.addComponent(lblMedBuy)
								.addComponent(lblFireBuy)
								.addComponent(lblGamesBuy)
								.addComponent(lblOreBuy)
								.addComponent(lblFoodBuy)
								.addComponent(lblFursBuy)
								.addComponent(lblWaterBuy))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(lblInformationHub)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlanet)
						.addComponent(lblPlanetname)
						.addComponent(lblTechLevel)
						.addComponent(lblTechleveld))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDistance)
						.addComponent(lblDistanced)
						.addComponent(lblZone)
						.addComponent(lblZoned))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAverageBuyPrice)
						.addComponent(lblAverageSellPrice))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWater)
						.addComponent(lblWaterBuy)
						.addComponent(lblWaterSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFurs)
						.addComponent(lblFursBuy)
						.addComponent(lblFursSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFood)
						.addComponent(lblFoodBuy)
						.addComponent(lblFoodSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOre)
						.addComponent(lblOreBuy)
						.addComponent(lblOreSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGames)
						.addComponent(lblGamesBuy)
						.addComponent(lblGamesSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirearms)
						.addComponent(lblFireBuy)
						.addComponent(lblFireSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicine)
						.addComponent(lblMedBuy)
						.addComponent(lblMedSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachines)
						.addComponent(lblMacBuy)
						.addComponent(lblMacSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNarcotics)
						.addComponent(lblNarBuy)
						.addComponent(lblNarSell))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRobots)
						.addComponent(lblRobBuy)
						.addComponent(lblRobSell))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	int[] basePrice = new int[]{30,250,100,350,250,1250,650,900,3500,5000};
	int[] priceIncreasePerTechLevel = new int[]{3,10,5,20,-10,-75,-20,-30,-125,-150};
	int[] minLevelToProduceResource = new int[]{0,0,1,2,3,3,4,4,5,6};
	int[] variance = new int[]{4,10,5,10,5,100,10,5,150,100};
	
	/**
	 * Calculate the lowest buy price possible of an item
	 * @param index index number of an item
	 * @return the lowest buy price possible
	 */
	public int buyLowRange(int index){
		int temp = variance[index];
		int coinResults = -1;
		int total = basePrice[index] + 
				(priceIncreasePerTechLevel[index] * (planet.getTechLevel() - minLevelToProduceResource[index])) +
				basePrice[index]*(temp/100)*coinResults;
		return total;
	}
	/**
	 * Calculate the highest buy price possible of an item
	 * @param index index number of an item
	 * @return the highest buy price possible
	 */
	public int buyHighRange(int index){
		int temp = variance[index];
		int coinResults = 1;
		int total = basePrice[index] + 
				(priceIncreasePerTechLevel[index] * (planet.getTechLevel() - minLevelToProduceResource[index])) +
				basePrice[index]*(temp/100)*coinResults;
		return total;
	}
	/**
	 * Calculate the highest sell price possible of an item
	 * @param index index number of an item
	 * @return the highest sell price possible
	 */
	public int sellHighRange(int index){
		return buyHighRange(index);
	}
	/**
	 * Calculate the lowest sell price possible of an item
	 * @param index index number of an item
	 * @return the lowest sell price possible
	 */
	public int sellLowRange(int index){
		return (int)(buyLowRange(index)*0.75);
	
	}
	/**
	 * calculate the average buy price of an item in the planet
	 * @param index
	 * @return average buy price
	 */
	public int averageBuy(int index){
		return (buyHighRange(index)+buyLowRange(index))/2;
	}
	/**
	 * calculate the average sell price of an item in the planet
	 * @param index
	 * @return average sell price
	 */
	public int averageSell(int index){
		return (sellHighRange(index)+sellLowRange(index))/2;
	}
	/**
	 * draw background
	 * @param g a Graphics instance
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
