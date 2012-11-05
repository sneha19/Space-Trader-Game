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
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
/**
 * The JPanel for a trade screen, where player buy/sell goods
 * @author Guang Lu
 *
 */
public class Trade extends JPanel{
	private Zone zone;
	private PlanetScreen PlanetScreen;
	private Merchant merchant;
	
	private Player currPlayer;
	private  Planet currPlanet;
	private  Ship currShip;
	private int level;
	private JButton fursBuy;
	private JButton fursSell;
	private JButton waterBuy;
	private JButton waterSell;
	private JButton foodBuy;
	private JButton foodSell;
	private JButton oreBuy;
	private JButton oreSell;
	private JButton gamesBuy;
	private JButton gamesSell;
	private JButton firearmsBuy;
	private JButton firearmsSell;
	private JButton medicineBuy;
	private JButton medicineSell;
	private JButton machinesBuy;
	private JButton machinesSell;
	private JButton narcoticesBuy;
	private JButton narcoticesSell;
	private JButton robotsBuy;
	private JButton robotsSell;
	private JButton btnFinished;
	
	private JLabel lblFurs;
	private JLabel foodAmount;
	private JLabel oreAmount;
	private JLabel label_16;
	private JLabel firearmsAmount;
	private JLabel MachinesAmount;
	private JLabel narcoticesAmount;
	private JLabel robotsAmount;
	private JLabel waterAmount;
	private JLabel MedicineAmount;
	private JLabel fursAmount;
	private JLabel lblTrade;
	private JLabel currentAmountOfGoods;
	private JLabel totalAmountOfGoods;
	
	private JLabel lblWatreAvi;
	private JLabel lblFoodAvi;
	private JLabel lblFursAvi;
	private JLabel lblOreAvi;
	private JLabel lblGamesAvi;
	private JLabel lblFirearmsAvi;
	private JLabel lblNarcoticsAvi;
	private JLabel lblMedAvi;
	private JLabel lblMacAvi;
	private JLabel lblRobotsAvi;
	
	
	
	
	int[] basePrice = new int[]{30,250,100,350,250,1250,650,900,3500,5000};
	int[] priceIncreasePerTechLevel = new int[]{3,10,5,20,-10,-75,-20,-30,-125,-150};
	int[] minLevelToProduceResource = new int[]{0,0,1,2,3,3,4,4,5,6};
	int[] variance = new int[]{4,10,5,10,5,100,10,5,150,100};
	int[] allBuy = new int[10];
	int[] allSell= new int[10];
	
	/**
	 * Calculate the buy price for an item
	 * @param location item index number
	 * @return the buy price
	 */
	public int calculatorBuy(int location)
	{
		Random r = new Random();
		int temp = variance[location];
		int flipCoin = r.nextInt(2);
		int coinResults;
		if(flipCoin == 0)
			coinResults = 1;
		else coinResults = -1;
		int variance = r.nextInt(temp);
		int total = basePrice[location] + 
				(priceIncreasePerTechLevel[location] * (currPlanet.getTechLevel() - minLevelToProduceResource[location])) +
				basePrice[location]*(variance/100)*coinResults;
		return total;
	}
	/**
	 * Calculate the sell price for an item based on its buy price
	 * @param buyPrice 
	 * @return sellPrice
	 */
	public int calculatorSell(int buyPrice)
	{	
		
		Random r = new Random();
		
		int sellPrice = (int) ((buyPrice*(1-r.nextInt(26)*0.01)))/1;
		return sellPrice;
		
	}
	/**
	 * Constructor for Trade
	 * @param p current player
	 * @param planet on which the trade is going on
	 */
	public Trade(Player p, Planet planet)
	{
		currPlayer = p;
		currShip = currPlayer.getShip();
		currPlanet  = planet;
		
		level = currPlanet.getTechLevel();
		
		setWater();
		setFurs();
		setFood();
		setOre();
		setGames();
		setFirearms();
		setMedicines();
		setMachines();
		setNarcotices();
		setRobot();

		  fursBuy.addActionListener(new FursBuyListener());
	      fursSell.addActionListener(new FursSellListener());
		  waterBuy.addActionListener(new WaterBuyListener());
		  waterSell.addActionListener(new WaterSellListener());
		  foodBuy.addActionListener(new FoodBuyListener());
		  foodSell.addActionListener(new FoodSellListener());
		  oreBuy.addActionListener(new OreBuyListener());
		  oreSell.addActionListener(new OreSellListener());
		  gamesBuy.addActionListener(new GamesBuyListener());
		  gamesSell.addActionListener(new GamesSellListener());
		  firearmsBuy.addActionListener(new FirearmsBuyListener());
		  firearmsSell.addActionListener(new FirearmsSellListener());
		  medicineBuy.addActionListener(new MedicineBuyListener());
		  medicineSell.addActionListener(new MedicineSellListener());
		  machinesBuy.addActionListener(new MachinesBuyListener());
		  machinesSell.addActionListener(new MachinesSellListener());
		  narcoticesBuy.addActionListener(new NarcoticsBuyListener());
		  narcoticesSell.addActionListener(new NarcoticsSellListener());
		  robotsBuy.addActionListener(new RobotsBuyListener());
		  robotsSell.addActionListener(new RobotsSellListener());	
		
		
		
		
		
		
		
		
		
		lblTrade = new JLabel("$ "+currPlayer.getCash());
		lblTrade.setForeground(new Color(255, 255, 255));
		
		JPanel WaterPanel = new JPanel();
		WaterPanel.setBackground(new Color(0, 0, 0));
		JPanel OrePanel = new JPanel();
		OrePanel.setBackground(new Color(0, 0, 0));
		JPanel FursPanel = new JPanel();
		FursPanel.setBackground(new Color(0, 0, 0));
		JPanel FoodPanel = new JPanel();
		FoodPanel.setBackground(new Color(0, 0, 0));
		JPanel FirearmsPanel = new JPanel();
		FirearmsPanel.setBackground(new Color(0, 0, 0));
		JPanel MedicinePanel = new JPanel();
		MedicinePanel.setBackground(new Color(0, 0, 0));
		JPanel MachinesPanel = new JPanel();
		MachinesPanel.setBackground(new Color(0, 0, 0));
		JPanel NarcoticesPanel = new JPanel();
		NarcoticesPanel.setBackground(new Color(0, 0, 0));
		JPanel RobotsPanel = new JPanel();
		RobotsPanel.setBackground(new Color(0, 0, 0));
		
		
		lblFurs = new JLabel("Furs");
		lblFurs.setForeground(new Color(255, 255, 255));
		
		JLabel label_2 = new JLabel("Buy Price:");
		label_2.setForeground(new Color(255, 255, 255));
		
		JLabel label_3 = new JLabel("Sell Price:");
		label_3.setForeground(new Color(255, 255, 255));
		
					
		
						
		fursAmount = new JLabel(currShip.getCurrentGoods().getFurs()+"");
		fursAmount.setForeground(new Color(255, 255, 255));
		
		int fursBuyPrice=calculatorBuy(1);
		int fursSellPrice=calculatorSell(fursBuyPrice);
		JLabel lblFbp = new JLabel(fursBuyPrice+"");
		lblFbp.setForeground(new Color(255, 255, 255));
		
		JLabel lblFsp = new JLabel(fursSellPrice+"");
		lblFsp.setForeground(new Color(255, 255, 255));
		
		JLabel label = new JLabel("Avi.");
		label.setForeground(Color.WHITE);
		
		lblFursAvi = new JLabel(planet.getGoods().getFurs()+"");
		lblFursAvi.setForeground(Color.WHITE);
		
		//Chunck
		GroupLayout gl_FursPanel = new GroupLayout(FursPanel);
		gl_FursPanel.setHorizontalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFurs)
					.addGap(26)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFbp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFsp)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblFursAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(fursBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fursSell)
					.addGap(28)
					.addComponent(fursAmount)
					.addGap(31))
		);
		gl_FursPanel.setVerticalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FursPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFurs)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(lblFbp)
						.addComponent(lblFsp)
						.addComponent(fursAmount)
						.addComponent(fursSell)
						.addComponent(fursBuy)
						.addComponent(label)
						.addComponent(lblFursAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		FursPanel.setLayout(gl_FursPanel);
		
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(new Color(255, 255, 255));
		
		JLabel label_6 = new JLabel("Buy Price:");
		label_6.setForeground(new Color(255, 255, 255));
		
		JLabel label_7 = new JLabel("Sell Price:");
		label_7.setForeground(new Color(255, 255, 255));
		
				
		foodAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getFood()));
		foodAmount.setForeground(new Color(255, 255, 255));
		foodAmount.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		int foodBuyPrice=calculatorBuy(2);
		int foodSellPrice=calculatorSell(foodBuyPrice);
		JLabel lblFoobp = new JLabel(foodBuyPrice+"");
		lblFoobp.setForeground(new Color(255, 255, 255));
		
		JLabel lblFoosp = new JLabel(foodSellPrice+"");
		lblFoosp.setForeground(new Color(255, 255, 255));
		
		JLabel label_4 = new JLabel("Avi.");
		label_4.setForeground(Color.WHITE);
		
		lblFoodAvi = new JLabel(planet.getGoods().getFood()+"");
		lblFoodAvi.setForeground(Color.WHITE);
		GroupLayout gl_FoodPanel = new GroupLayout(FoodPanel);
		gl_FoodPanel.setHorizontalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFood)
					.addGap(18)
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFoobp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFoosp)
					.addGap(18)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFoodAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(foodBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodSell)
					.addGap(29)
					.addComponent(foodAmount)
					.addGap(30))
		);
		gl_FoodPanel.setVerticalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FoodPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFood)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(lblFoobp)
						.addComponent(lblFoosp)
						.addComponent(foodAmount)
						.addComponent(foodSell)
						.addComponent(foodBuy)
						.addComponent(label_4)
						.addComponent(lblFoodAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		FoodPanel.setLayout(gl_FoodPanel);
		
		
		JLabel lblOre = new JLabel("Ore");
		lblOre.setForeground(new Color(255, 255, 255));
		
		JLabel label_10 = new JLabel("Buy Price:");
		label_10.setForeground(new Color(255, 255, 255));
		
		JLabel label_11 = new JLabel("Sell Price:");
		label_11.setForeground(new Color(255, 255, 255));
		
	  		
		oreAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getOre()));
		oreAmount.setForeground(new Color(255, 255, 255));
		
		int oreBuyPrice=calculatorBuy(3);
		int oreSellPrice=calculatorSell(oreBuyPrice);
		JLabel lblObp = new JLabel(oreBuyPrice+"");
		lblObp.setForeground(new Color(255, 255, 255));
		
		JLabel lblOsp = new JLabel(oreSellPrice+"");
		lblOsp.setForeground(new Color(255, 255, 255));
		
		JLabel label_8 = new JLabel("Avi.");
		label_8.setForeground(Color.WHITE);
		
		lblOreAvi = new JLabel(planet.getGoods().getOre()+"");
		lblOreAvi.setForeground(Color.WHITE);
		GroupLayout gl_OrePanel = new GroupLayout(OrePanel);
		gl_OrePanel.setHorizontalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOre)
					.addGap(27)
					.addComponent(label_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblObp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_11)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOsp)
					.addGap(18)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOreAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(oreBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oreSell)
					.addGap(29)
					.addComponent(oreAmount)
					.addGap(29))
		);
		gl_OrePanel.setVerticalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_OrePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOre)
						.addComponent(label_10)
						.addComponent(label_11)
						.addComponent(lblObp)
						.addComponent(lblOsp)
						.addComponent(oreAmount)
						.addComponent(oreSell)
						.addComponent(oreBuy)
						.addComponent(label_8)
						.addComponent(lblOreAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		OrePanel.setLayout(gl_OrePanel);
		
		JPanel GamesPanel = new JPanel();
		GamesPanel.setBackground(new Color(0, 0, 0));
		
		JLabel lblGames = new JLabel("Games");
		lblGames.setForeground(new Color(255, 255, 255));
		
		JLabel label_14 = new JLabel("Buy Price:");
		label_14.setForeground(new Color(255, 255, 255));
		
		JLabel label_15 = new JLabel("Sell Price:");
		label_15.setForeground(new Color(255, 255, 255));
		
				
		label_16 = new JLabel(Integer.toString(currShip.getCurrentGoods().getGames()));
		label_16.setForeground(new Color(255, 255, 255));
		
		int gameBuyPrice=calculatorBuy(4);
		int gameSellPrice=calculatorSell(gameBuyPrice);
		JLabel lblGbp = new JLabel(gameBuyPrice+"");
		lblGbp.setForeground(new Color(255, 255, 255));
		
		JLabel lblGsp = new JLabel(gameSellPrice+"");
		lblGsp.setForeground(new Color(255, 255, 255));
		
		JLabel label_12 = new JLabel("Avi.");
		label_12.setForeground(Color.WHITE);
		
		lblGamesAvi = new JLabel(planet.getGoods().getGames()+"");
		lblGamesAvi.setForeground(Color.WHITE);
		GroupLayout gl_GamesPanel = new GroupLayout(GamesPanel);
		gl_GamesPanel.setHorizontalGroup(
			gl_GamesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GamesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGames)
					.addGap(18)
					.addComponent(label_14)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGbp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_15)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGsp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGamesAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(gamesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gamesSell)
					.addGap(29)
					.addComponent(label_16)
					.addGap(29))
		);
		gl_GamesPanel.setVerticalGroup(
			gl_GamesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GamesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GamesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGames)
						.addComponent(label_14)
						.addComponent(label_15)
						.addComponent(lblGbp)
						.addComponent(lblGsp)
						.addComponent(label_16)
						.addComponent(gamesSell)
						.addComponent(gamesBuy)
						.addComponent(label_12)
						.addComponent(lblGamesAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GamesPanel.setLayout(gl_GamesPanel);
		
		
		JLabel lblFirearms = new JLabel("Firearms");
		lblFirearms.setForeground(new Color(255, 255, 255));
		
		JLabel label_18 = new JLabel("Buy Price:");
		label_18.setForeground(new Color(255, 255, 255));
		
		JLabel label_19 = new JLabel("Sell Price:");
		label_19.setForeground(new Color(255, 255, 255));
		
		
		firearmsAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getFirearms()));
		firearmsAmount.setForeground(new Color(255, 255, 255));
		
		int firearmBuyPrice=calculatorBuy(5);
		int firearmSellPrice=calculatorSell(firearmBuyPrice);
		JLabel lblFibp = new JLabel(firearmBuyPrice+"");
		lblFibp.setForeground(new Color(255, 255, 255));
		JLabel lblFisp = new JLabel(firearmSellPrice+"");
		lblFisp.setForeground(new Color(255, 255, 255));
		
		JLabel label_13 = new JLabel("Avi.");
		label_13.setForeground(Color.WHITE);
		
		lblFirearmsAvi = new JLabel(planet.getGoods().getFirearms()+"");
		lblFirearmsAvi.setForeground(Color.WHITE);
		
		GroupLayout gl_FirearmsPanel = new GroupLayout(FirearmsPanel);
		gl_FirearmsPanel.setHorizontalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFirearms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_18)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFibp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_19)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFisp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFirearmsAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addComponent(firearmsBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firearmsSell)
					.addGap(29)
					.addComponent(firearmsAmount)
					.addGap(28))
		);
		gl_FirearmsPanel.setVerticalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_FirearmsPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFirearms)
								.addComponent(label_19)
								.addComponent(label_18)
								.addComponent(lblFibp)
								.addComponent(lblFisp)
								.addComponent(label_13)
								.addComponent(lblFirearmsAvi)))
						.addGroup(gl_FirearmsPanel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(firearmsAmount)
								.addComponent(firearmsSell)
								.addComponent(firearmsBuy))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		FirearmsPanel.setLayout(gl_FirearmsPanel);
		
		
		JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setForeground(new Color(255, 255, 255));
		
		JLabel label_22 = new JLabel("Buy Price:");
		label_22.setForeground(new Color(255, 255, 255));
		
		JLabel label_23 = new JLabel("Sell Price:");
		label_23.setForeground(new Color(255, 255, 255));
		
				
		MedicineAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getMedicines()));
		MedicineAmount.setForeground(new Color(255, 255, 255));
		
		int medBuyPrice=calculatorBuy(6);
		int medSellPrice=calculatorSell(medBuyPrice);
		JLabel lblMbp = new JLabel(medBuyPrice+"");
		lblMbp.setForeground(new Color(255, 255, 255));
		JLabel lblMsp = new JLabel(medSellPrice+"");
		lblMsp.setForeground(new Color(255, 255, 255));
		
		JLabel label_17 = new JLabel("Avi.");
		label_17.setForeground(Color.WHITE);
		
		lblMedAvi = new JLabel(planet.getGoods().getMedicines()+"");
		lblMedAvi.setForeground(Color.WHITE);
		
		GroupLayout gl_MedicinePanel = new GroupLayout(MedicinePanel);
		gl_MedicinePanel.setHorizontalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMedicine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_22)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMbp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_23)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMsp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMedAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addComponent(medicineBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicineSell)
					.addGap(30)
					.addComponent(MedicineAmount)
					.addGap(27))
		);
		gl_MedicinePanel.setVerticalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MedicinePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicine)
						.addComponent(label_23)
						.addComponent(label_22)
						.addComponent(lblMbp)
						.addComponent(lblMsp)
						.addComponent(MedicineAmount)
						.addComponent(medicineSell)
						.addComponent(medicineBuy)
						.addComponent(label_17)
						.addComponent(lblMedAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		MedicinePanel.setLayout(gl_MedicinePanel);
		
		
		JLabel lblMachines = new JLabel("Machines");
		lblMachines.setForeground(new Color(255, 255, 255));
		
		JLabel label_26 = new JLabel("Buy Price:");
		label_26.setForeground(new Color(255, 255, 255));
		
		JLabel label_27 = new JLabel("Sell Price:");
		label_27.setForeground(new Color(255, 255, 255));
		
		
		
		MachinesAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getMachines()));
		MachinesAmount.setForeground(new Color(255, 255, 255));
		
		
		int macBuyPrice=calculatorBuy(7);
		int macSellPrice=calculatorSell(macBuyPrice);
		JLabel lblMabp = new JLabel(macBuyPrice+"");
		lblMabp.setForeground(new Color(255, 255, 255));
		JLabel lblMasp = new JLabel(macSellPrice+"");
		lblMasp.setForeground(new Color(255, 255, 255));
		
		JLabel label_20 = new JLabel("Avi.");
		label_20.setForeground(Color.WHITE);
		
		lblMacAvi = new JLabel(planet.getGoods().getMachines()+"");
		lblMacAvi.setForeground(Color.WHITE);
		GroupLayout gl_MachinesPanel = new GroupLayout(MachinesPanel);
		gl_MachinesPanel.setHorizontalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMachines)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_26)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMabp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_27)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMasp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMacAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(machinesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(machinesSell)
					.addGap(30)
					.addComponent(MachinesAmount, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		gl_MachinesPanel.setVerticalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MachinesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachines)
						.addComponent(label_26)
						.addComponent(label_27)
						.addComponent(lblMabp)
						.addComponent(lblMasp)
						.addComponent(MachinesAmount)
						.addComponent(machinesSell)
						.addComponent(machinesBuy)
						.addComponent(label_20)
						.addComponent(lblMacAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		MachinesPanel.setLayout(gl_MachinesPanel);
		
		
		JLabel lblNarcotices = new JLabel("Narcotices");
		lblNarcotices.setForeground(new Color(255, 255, 255));
		
		
		JLabel label_30 = new JLabel("Buy Price:");
		label_30.setForeground(new Color(255, 255, 255));
		
		JLabel label_31 = new JLabel("Sell Price:");
		label_31.setForeground(new Color(255, 255, 255));
		
				
		narcoticesAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getNarcotics()));
		narcoticesAmount.setForeground(new Color(255, 255, 255));
		int narBuyPrice=calculatorBuy(8);
		int narSellPrice=calculatorSell(narBuyPrice);
		JLabel lblNabp = new JLabel(narBuyPrice+"");
		lblNabp.setForeground(new Color(255, 255, 255));
		
		JLabel lblNasp = new JLabel(narSellPrice+"");
		lblNasp.setForeground(new Color(255, 255, 255));
		
		JLabel label_21 = new JLabel("Avi.");
		label_21.setForeground(Color.WHITE);
		
		lblNarcoticsAvi = new JLabel(planet.getGoods().getNarcotics()+"");
		lblNarcoticsAvi.setForeground(Color.WHITE);
		GroupLayout gl_NarcoticesPanel = new GroupLayout(NarcoticesPanel);
		gl_NarcoticesPanel.setHorizontalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNarcotices)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_30)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNabp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_31)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNasp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNarcoticsAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(narcoticesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesSell)
					.addGap(32)
					.addComponent(narcoticesAmount)
					.addGap(24))
		);
		gl_NarcoticesPanel.setVerticalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NarcoticesPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNarcotices)
							.addComponent(label_30)
							.addComponent(label_31)
							.addComponent(lblNabp)
							.addComponent(lblNasp)
							.addComponent(label_21)
							.addComponent(lblNarcoticsAvi))
						.addGroup(gl_NarcoticesPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(narcoticesAmount)
							.addComponent(narcoticesSell)
							.addComponent(narcoticesBuy)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		NarcoticesPanel.setLayout(gl_NarcoticesPanel);
		
		
		JLabel lblRobots = new JLabel("Robots");
		lblRobots.setForeground(new Color(255, 255, 255));
		
		JLabel label_5 = new JLabel("Buy Price:");
		label_5.setForeground(new Color(255, 255, 255));
		
		JLabel label_9 = new JLabel("Sell Price:");
		label_9.setForeground(new Color(255, 255, 255));
		
		
		robotsAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getRobots()));
		robotsAmount.setForeground(new Color(255, 255, 255));
		
		int robBuyPrice=calculatorBuy(9);
		int robSellPrice=calculatorSell(robBuyPrice);
		JLabel lblRobp = new JLabel(robBuyPrice+"");
		lblRobp.setForeground(new Color(255, 255, 255));
		
		JLabel lblRosp = new JLabel(robSellPrice+"");
		lblRosp.setForeground(new Color(255, 255, 255));
		
		JLabel label_24 = new JLabel("Avi.");
		label_24.setForeground(Color.WHITE);
		
		lblRobotsAvi = new JLabel(planet.getGoods().getRobots()+"");
		lblRobotsAvi.setForeground(Color.WHITE);
		GroupLayout gl_RobotsPanel = new GroupLayout(RobotsPanel);
		gl_RobotsPanel.setHorizontalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRobots)
					.addGap(18)
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRobp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRosp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRobotsAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(robotsBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(robotsSell)
					.addGap(30)
					.addComponent(robotsAmount)
					.addGap(25))
		);
		gl_RobotsPanel.setVerticalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRobots)
							.addComponent(label_9)
							.addComponent(label_5)
							.addComponent(lblRobp)
							.addComponent(lblRosp)
							.addComponent(label_24)
							.addComponent(lblRobotsAvi))
						.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(robotsAmount)
							.addComponent(robotsSell)
							.addComponent(robotsBuy)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		RobotsPanel.setLayout(gl_RobotsPanel);
		
		JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(new Color(255, 255, 255));
		
		JLabel lblBuyPrice = new JLabel("Buy Price:");
		lblBuyPrice.setForeground(new Color(255, 255, 255));
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		lblSellPrice.setForeground(new Color(255, 255, 255));
		
		
		
		
		waterAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getWater()));
		waterAmount.setForeground(new Color(255, 255, 255));
		int waterBuyPrice=calculatorBuy(0);
		int waterSellPrice=calculatorSell(waterBuyPrice);
		setLayout(new MigLayout("", "[82px][6px][73px][5px][82px][6px][8px][][][][][][36px][35px][6px][][8px][19px][50px][28px][][16px][6px][][5px][12px][125px]", "[16px][42px][42px][42px][42px][42px][42px][42px][42px][42px][42px][16px][][29px][]"));
		
				JLabel lblNewLabel = new JLabel("Current CargoBay:");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				add(lblNewLabel, "cell 8 0,alignx left,aligny top");
		
		currentAmountOfGoods = new JLabel(currShip.getCurrentGoods().getTotal()+"");
		currentAmountOfGoods.setForeground(new Color(255, 255, 255));
		add(currentAmountOfGoods, "cell 9 0,growx,aligny top");
		
		JLabel label_1 = new JLabel("|");
		label_1.setForeground(new Color(255, 255, 255));
		add(label_1, "cell 10 0,alignx left,aligny top");
		
		totalAmountOfGoods = new JLabel(currShip.getCargoCapacity()+"");
		totalAmountOfGoods.setForeground(new Color(255, 255, 255));
		add(totalAmountOfGoods, "cell 11 0,alignx left,aligny top");
		JLabel lblWbp = new JLabel(waterBuyPrice+"");
		lblWbp.setForeground(new Color(255, 255, 255));
		
		JLabel lblWsp = new JLabel(waterSellPrice+"");
		lblWsp.setForeground(new Color(255, 255, 255));
		
		JLabel lblAvi = new JLabel("Avi.");
		lblAvi.setForeground(Color.WHITE);
		
		lblWatreAvi = new JLabel(planet.getGoods().getWater()+"");
		lblWatreAvi.setForeground(Color.WHITE);
		GroupLayout gl_WaterPanel = new GroupLayout(WaterPanel);
		gl_WaterPanel.setHorizontalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWater)
					.addGap(18)
					.addComponent(lblBuyPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWbp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSellPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWsp, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAvi)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWatreAvi)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(waterBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterSell)
					.addGap(27)
					.addComponent(waterAmount)
					.addGap(32))
		);
		gl_WaterPanel.setVerticalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_WaterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWater)
						.addComponent(lblBuyPrice)
						.addComponent(lblSellPrice)
						.addComponent(lblWbp)
						.addComponent(lblWsp)
						.addComponent(waterAmount)
						.addComponent(waterSell)
						.addComponent(waterBuy)
						.addComponent(lblAvi)
						.addComponent(lblWatreAvi))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		WaterPanel.setLayout(gl_WaterPanel);
		add(WaterPanel, "cell 0 1 27 1,growx,aligny top");
		add(lblTrade, "cell 0 0,alignx left,aligny top");
		add(FursPanel, "cell 0 2 27 1,growx,aligny top");
		add(FoodPanel, "cell 0 3 27 1,growx,aligny top");
		add(OrePanel, "cell 0 4 27 1,growx,aligny top");
		add(GamesPanel, "cell 0 5 27 1,growx,aligny top");
		add(FirearmsPanel, "cell 0 6 27 1,growx,aligny top");
		add(MedicinePanel, "cell 0 7 27 1,growx,aligny top");
		add(MachinesPanel, "cell 0 8 27 1,growx,aligny top");
		add(RobotsPanel, "cell 0 10 27 1,growx,aligny top");
		add(NarcoticesPanel, "cell 0 9 27 1,growx,aligny top");
		
		JLabel lblPlanetName = new JLabel("Planet Name:");
		lblPlanetName.setForeground(new Color(255, 255, 255));
		add(lblPlanetName, "cell 0 12,alignx left,aligny top");
		
		JLabel lblPlanetName_1 = new JLabel(planet.getPlanetName());
		lblPlanetName_1.setForeground(new Color(255, 255, 255));
		add(lblPlanetName_1, "cell 2 12,alignx left,aligny top");
		
		JLabel lblTechLevel = new JLabel("Tech level:");
		lblTechLevel.setForeground(new Color(255, 255, 255));
		add(lblTechLevel, "cell 4 12,alignx right,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel(planet.getTechLevel() + "");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		add(lblNewLabel_2, "cell 7 12,alignx left,aligny top");
		
		JLabel lblZone = new JLabel("Zone:");
		lblZone.setForeground(new Color(255, 255, 255));
		add(lblZone, "cell 13 12,alignx left,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel(planet.getZone().getZone() +"");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		add(lblNewLabel_1, "cell 15 12,alignx left,aligny top");
		
		btnFinished = new JButton("Finish");
		add(btnFinished, "cell 4 14,alignx left,aligny top");
		//chucnk
		
		allBuy = new int[10];
		allSell= new int[10];
		allBuy[0]=waterBuyPrice;
		allBuy[1]=fursBuyPrice;
		allBuy[2]=foodBuyPrice;
		allBuy[3]=oreBuyPrice;
		allBuy[4]=gameBuyPrice;
		allBuy[5]=firearmBuyPrice;
		allBuy[6]=medBuyPrice;
		allBuy[7]=macBuyPrice;
		allBuy[8]=narBuyPrice;
		allBuy[9]=robBuyPrice;
		
		allSell[0]=waterSellPrice;
		allSell[1]=fursSellPrice;
		allSell[2]=foodSellPrice;
		allSell[3]=oreSellPrice;
		allSell[4]=gameSellPrice;
		allSell[5]=firearmSellPrice;
		allSell[6]=medSellPrice;
		allSell[7]=macSellPrice;
		allSell[8]=narSellPrice;
		allSell[9]=robSellPrice;
		
	}
	
	
	
	/**
	 * Set water buy/sell button visibility based on the tech level of the planet
	 */
	public void setWater()
	{
		waterBuy = new JButton("Buy");
		waterSell = new JButton("Sell");
		waterBuy.setEnabled(true);
		waterSell.setEnabled(true);

	}
	/**
	 * Set fur buy/sell button visibility based on the tech level of the planet
	 */
	public void setFurs()
	{
		 fursBuy = new JButton("Buy");
		 fursSell = new JButton("Sell");
		fursBuy.setEnabled(true);
		fursSell.setEnabled(true);

	}
	/**
	 * Set food buy/sell button visibility based on the tech level of the planet
	 */
	public void setFood()
	{
		 foodBuy = new JButton("Buy");
		 foodSell = new JButton("Sell");
		 foodBuy.setEnabled(false);
		 if(level>0){
	foodBuy.setEnabled(true);
	}
		 foodSell.setEnabled(true);	
	}
	/**
	 * Set ore buy/sell button visibility based on the tech level of the planet
	 */
	public void setOre()
	{
		oreBuy = new JButton("Buy");
		oreSell = new JButton("Sell");
		oreBuy.setEnabled(false);
		oreSell.setEnabled(false);
		if(level>1){
			oreBuy.setEnabled(true);
		}
		if(level>1){
			oreSell.setEnabled(true);
		}
	}
	




	/**
	 * Set game buy/sell button visibility based on the tech level of the planet
	 */
public void setGames()
	{
		gamesBuy = new JButton("Buy");
		gamesSell = new JButton("Sell");
		gamesBuy.setEnabled(false);
		gamesSell.setEnabled(false);
		if(level>2){
			gamesBuy.setEnabled(true);
}
if(level>0){
			gamesSell.setEnabled(true);
}
	}
/**
 * Set firearms buy/sell button visibility based on the tech level of the planet
 */
	public void setFirearms()
	{
		firearmsBuy = new JButton("Buy");
		firearmsSell = new JButton("Sell");
		firearmsBuy.setEnabled(false);
		firearmsSell.setEnabled(false);
		if(level>2){
			firearmsBuy.setEnabled(true);
}
if(level>0){
			firearmsSell.setEnabled(true);
}
	}
	/**
	 * Set medicine buy/sell button visibility based on the tech level of the planet
	 */
	public void setMedicines()
	{
		medicineBuy = new JButton("Buy");
		medicineSell = new JButton("Sell");
		medicineBuy.setEnabled(false);
		medicineSell.setEnabled(false);
		if(level>3){
			medicineBuy.setEnabled(true);
}
if(level>0){
			medicineSell.setEnabled(true);
}
	}
	/**
	 * Set machines buy/sell button visibility based on the tech level of the planet
	 */
	public void setMachines()
	{
		machinesBuy = new JButton("Buy");
		machinesSell = new JButton("Sell");
		machinesBuy.setEnabled(false);
		machinesSell.setEnabled(false);
		if(level>3){
			machinesBuy.setEnabled(true);
}
if(level>2){
			machinesSell.setEnabled(true);
}
	}
	/**
	 * Set narcotics buy/sell button visibility based on the tech level of the planet
	 */
	public void setNarcotices()
	{
		narcoticesBuy = new JButton("Buy");
		narcoticesSell = new JButton("Sell");
		narcoticesSell.setSelectedIcon(new ImageIcon("/Users/haysam_121/Pictures/iPhoto Library/Originals/2010/Aug 29, 2010/DSCN0187.JPG"));
		narcoticesBuy.setEnabled(false);
		
		if(level>4){
			narcoticesBuy.setEnabled(true);
}

			narcoticesSell.setEnabled(true);


	}
	/**
	 * Set robot buy/sell button visibility based on the tech level of the planet
	 */
	public void setRobot()
	{
		robotsBuy = new JButton("Buy");
		robotsSell = new JButton("Sell");
		robotsBuy.setEnabled(false);
		robotsSell.setEnabled(false);
		if(level>5){
			robotsBuy.setEnabled(true);
}
		if(level>3){
			robotsSell.setEnabled(true);
}
	}
	/**
	 * processing the buy request of the trade
	 * @param index of the item being bought
	 * @return true if buy is successful
	 */
	public boolean buy(int index) {
		currPlayer.setCash(-allBuy[index]);
		currShip.increase(index);
		
		switch(index){
		
		
		case 0:
			currPlanet.getGoods().setWater(-1);
			break;
		case 1:
			currPlanet.getGoods().setFurs(-1);
			break;
		case 2:
			currPlanet.getGoods().setFood(-1);
			break;
		case 3:
			currPlanet.getGoods().setOre(-1);
			break;
		case 4:
			currPlanet.getGoods().setGames(-1);
			break;
		case 5:
			currPlanet.getGoods().setFirearms(-1);
			break;
		case 6:
			currPlanet.getGoods().setMedicines(-1);
			break;
		case 7:
			currPlanet.getGoods().setMachines(-1);
			break;
		case 8:
			currPlanet.getGoods().setNarcotics(-1);
			break;
		case 9:
			currPlanet.getGoods().setRobots(-1);
			break;
		
		}
		return true;
	}
	/**
	 * processing the sell request of the trade
	 * @param index of the item being sold
	 * @return true if sell is successful
	 */
	public boolean sell(int index) {
		currPlayer.setCash(allSell[index]);
		currShip.decrease(index);
		
		
	switch(index){
			case 0:
				currPlanet.getGoods().setWater(1);
				break;
			case 1:
				currPlanet.getGoods().setFurs(1);
				break;
			case 2:
				currPlanet.getGoods().setFood(1);
				break;
			case 3:
				currPlanet.getGoods().setOre(1);
				break;
			case 4:
				currPlanet.getGoods().setGames(1);
				break;
			case 5:
				currPlanet.getGoods().setFirearms(1);
				break;
			case 6:
				currPlanet.getGoods().setMedicines(1);
				break;
			case 7:
				currPlanet.getGoods().setMachines(1);
				break;
			case 8:
				currPlanet.getGoods().setNarcotics(1);
				break;
			case 9:
				currPlanet.getGoods().setRobots(1);
				break;
			
			}
		return true;
	}
	
	
	/**
	 * Check is player has enough money after buy is pressed
	 * @param index number of the item
	 * @return whether player has enough money
	 */
	public boolean checkMoney(int index){
		if(currPlayer.getCash()>=allBuy[index]&&currShip.getCurrentGoods().getTotal()<currShip.getCargoCapacity()){
			if(index==0&&currPlanet.getGoods().getWater()>=1)
				return true;
			else if(index==1&&currPlanet.getGoods().getFurs()>0)
				return true;
			else if(index==2&&currPlanet.getGoods().getFood()>0)
				return true;
			else if(index==3&&currPlanet.getGoods().getOre()>0)
				return true;
			else if(index==4&&currPlanet.getGoods().getGames()>0)
				return true;
			else if(index==5&&currPlanet.getGoods().getFirearms()>0)
				return true;
			else if(index==6&&currPlanet.getGoods().getMedicines()>0)
				return true;
			else if(index==7&&currPlanet.getGoods().getMachines()>0)
				return true;
			else if(index==8&&currPlanet.getGoods().getNarcotics()>0)
				return true;
			else if(index==9&&currPlanet.getGoods().getRobots()>0)
				return true;	
			else
				return false;
			
		}else{
			return false;
		}
	}
	/**
	 * UPdate all the labels after buy/sell
	 * @return whether the update is successful
	 */
	public boolean update(){
		lblTrade.setText("$ "+currPlayer.getCash());
		currentAmountOfGoods.setText(currShip.getCurrentGoods().getTotal()+"");
		
		foodAmount.setText(currShip.getCurrentGoods().getFood()+"");
		oreAmount.setText(currShip.getCurrentGoods().getOre()+"");
		label_16.setText(currShip.getCurrentGoods().getGames()+"");
		firearmsAmount.setText(currShip.getCurrentGoods().getFirearms()+"");
		MachinesAmount.setText(currShip.getCurrentGoods().getMachines()+"");
		narcoticesAmount.setText(currShip.getCurrentGoods().getNarcotics()+"");
		robotsAmount.setText(currShip.getCurrentGoods().getRobots()+"");
		waterAmount.setText(currShip.getCurrentGoods().getWater()+"");
		MedicineAmount.setText(currShip.getCurrentGoods().getMedicines()+"");
		fursAmount.setText(currShip.getCurrentGoods().getFurs()+"");
		
		
		
		lblWatreAvi.setText(currPlanet.getGoods().getWater()+"");
		lblFoodAvi.setText(currPlanet.getGoods().getFood()+"");
		lblFursAvi.setText(currPlanet.getGoods().getFurs()+"");
		lblOreAvi.setText(currPlanet.getGoods().getOre()+"");
		lblGamesAvi.setText(currPlanet.getGoods().getGames()+"");
		lblFirearmsAvi.setText(currPlanet.getGoods().getFirearms()+"");
		lblNarcoticsAvi.setText(currPlanet.getGoods().getNarcotics()+"");
		lblMedAvi.setText(currPlanet.getGoods().getMedicines()+"");
		lblMacAvi.setText(currPlanet.getGoods().getMachines()+"");
		lblRobotsAvi.setText(currPlanet.getGoods().getRobots()+"");
		return true;
	}
	/**
	 * Check if the player has the item to sell
	 * @param index number of the item
	 * @return whether player has an item to sell
	 */
	public boolean notZeroGood(int index){
		int amount=0;
		switch (index){
		case 0:
			amount = currShip.getCurrentGoods().getWater();
			break;
		case 1:
			amount = currShip.getCurrentGoods().getFurs();
			break;
		case 2:
			amount = currShip.getCurrentGoods().getFood();
			break;
		case 3:
			amount = currShip.getCurrentGoods().getOre();
			break;
		case 4:
			amount = currShip.getCurrentGoods().getGames();
			break;
		case 5:
			amount = currShip.getCurrentGoods().getFirearms();
			break;
		case 6:
			amount = currShip.getCurrentGoods().getMedicines();
			break;
		case 7:
			amount = currShip.getCurrentGoods().getMachines();
			break;
		case 8:
			amount = currShip.getCurrentGoods().getNarcotics();
			break;
		case 9:
			amount = currShip.getCurrentGoods().getRobots();
			break;
		
			
		}
		if(amount<=0){
			return false;
		}else{
		return true;
		}
	}
	
	/**
	 * Private listener class for water buy button
	 * @author Guang Lu
	 *
	 */
	private class WaterBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(0)){
				buy(0);
			}
			update();
		}
	}
	/**
	 * Private listener class for furs buy button
	 * @author Guang Lu
	 *
	 */
	private class FursBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(1)){
				buy(1);
			}
			update();
		}
	}
	/**
	 * Private listener class for food buy button
	 * @author Guang Lu
	 *
	 */
	private class FoodBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(2)){
				buy(2);
			}
			update();
		}
	}
	/**
	 * Private listener class for ore buy button
	 * @author Guang Lu
	 *
	 */
	private class OreBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(3)){
				buy(3);
			}
			update();
		}
	}
	/**
	 * Private listener class for game buy button
	 * @author Guang Lu
	 *
	 */
	private class GamesBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(4)){
				buy(4);
			}
			update();
		}
	}
	/**
	 * Private listener class for firearms buy button
	 * @author Guang Lu
	 *
	 */
	private class FirearmsBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(5)){
				buy(5);
			}
			update();
		}
	}
	/**
	 * Private listener class for medicine buy button
	 * @author Guang Lu
	 *
	 */
	private class MedicineBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(6)){
				buy(6);
			}
			update();
		}
	}
	/**
	 * Private listener class for machines buy button
	 * @author Guang Lu
	 *
	 */
	private class MachinesBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(7)){
				buy(7);
			}
			update();
		}
	}
	/**
	 * Private listener class for narcotics buy button
	 * @author Guang Lu
	 *
	 */
	private class NarcoticsBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(8)){
				buy(8);
			}
			update();
		}
	}
	/**
	 * Private listener class for robot buy button
	 * @author Guang Lu
	 *
	 */
	private class RobotsBuyListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(checkMoney(9)){
				buy(9);
			}
			update();
		}
	}
	
	
	
	/**
	 * Private listener class for water sell button
	 * @author Guang Lu
	 *
	 */
	private class WaterSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(0)){
				sell(0);
			}
			update();
		}
	}
	/**
	 * Private listener class for fur sell button
	 * @author Guang Lu
	 *
	 */
	private class FursSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(1)){
				sell(1);
			}
			update();
		}
	}
	/**
	 * Private listener class for food sell button
	 * @author Guang Lu
	 *
	 */
	private class FoodSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(2)){
				sell(2);
			}
			update();
		}
	}
	/**
	 * Private listener class for ore sell button
	 * @author Guang Lu
	 *
	 */
	private class OreSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(3)){
				sell(3);
			}
			update();
		}
	}
	/**
	 * Private listener class for games sell button
	 * @author Guang Lu
	 *
	 */
	private class GamesSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(4)){
				sell(4);
			}
			update();
		}
	}
	/**
	 * Private listener class for firearms sell button
	 * @author Guang Lu
	 *
	 */
	private class FirearmsSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(5)){
				sell(5);
			}
			update();
		}
	}
	/**
	 * Private listener class for medicine sell button
	 * @author Guang Lu
	 *
	 */
	private class MedicineSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(6)){
				sell(6);
			}
			update();
		}
	}
	/**
	 * Private listener class for machines sell button
	 * @author Guang Lu
	 *
	 */
	private class MachinesSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(7)){
				sell(7);
			}
			update();
		}
	}
	/**
	 * Private listener class for narcotics sell button
	 * @author Guang Lu
	 *
	 */
	private class NarcoticsSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(8)){
				sell(8);
			}
			update();
		}
	}
	/**
	 * Private listener class for robot sell button
	 * @author Guang Lu
	 *
	 */
	private class RobotsSellListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(notZeroGood(9)){
				sell(9);
			}
			update();
		}
	}
	/**
	 * Set the btnlistener for the finished button
	 * @param a a button listener in the UIMain class
	 * @return whether the set is successful
	 */
	public boolean setBtnFinished(ActionListener a){
		btnFinished.addActionListener(a);
		return true;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
	}
}










