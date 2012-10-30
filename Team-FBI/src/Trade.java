import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
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
		
		JPanel WaterPanel = new JPanel();
		JPanel OrePanel = new JPanel();
		JPanel FursPanel = new JPanel();
		JPanel FoodPanel = new JPanel();
		JPanel FirearmsPanel = new JPanel();
		JPanel MedicinePanel = new JPanel();
		JPanel MachinesPanel = new JPanel();
		JPanel NarcoticesPanel = new JPanel();
		JPanel RobotsPanel = new JPanel();

		JLabel lblNewLabel = new JLabel("Amount");
		
		
		lblFurs = new JLabel("Furs");
		
		JLabel label_2 = new JLabel("Buy Price:");
		
		JLabel label_3 = new JLabel("Sell Price:");
		
					
		
						
		fursAmount = new JLabel(currShip.getCurrentGoods().getFurs()+"");
		
		int fursBuyPrice=calculatorBuy(1);
		int fursSellPrice=calculatorSell(fursBuyPrice);
		JLabel lblFbp = new JLabel(fursBuyPrice+"");
		
		JLabel lblFsp = new JLabel(fursSellPrice+"");
		
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
					.addComponent(fursBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fursSell)
					.addGap(18)
					.addComponent(fursAmount)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_FursPanel.setVerticalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FursPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFurs)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(fursSell)
						.addComponent(lblFbp)
						.addComponent(lblFsp)
						.addComponent(fursBuy)
						.addComponent(fursAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FursPanel.setLayout(gl_FursPanel);
		
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel label_6 = new JLabel("Buy Price:");
		
		JLabel label_7 = new JLabel("Sell Price:");
		
				
		foodAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getFood()));
		int foodBuyPrice=calculatorBuy(2);
		int foodSellPrice=calculatorSell(foodBuyPrice);
		JLabel lblFoobp = new JLabel(foodBuyPrice+"");
		
		JLabel lblFoosp = new JLabel(foodSellPrice+"");
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
					.addGap(21)
					.addComponent(foodBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodSell)
					.addGap(18)
					.addComponent(foodAmount)
					.addContainerGap(137, Short.MAX_VALUE))
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
						.addComponent(foodBuy)
						.addComponent(foodSell)
						.addComponent(foodAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FoodPanel.setLayout(gl_FoodPanel);
		
		
		JLabel lblOre = new JLabel("Ore");
		
		JLabel label_10 = new JLabel("Buy Price:");
		
		JLabel label_11 = new JLabel("Sell Price:");
		
	  		
		oreAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getOre()));
		
		int oreBuyPrice=calculatorBuy(3);
		int oreSellPrice=calculatorSell(oreBuyPrice);
		JLabel lblObp = new JLabel(oreBuyPrice+"");
		
		JLabel lblOsp = new JLabel(oreSellPrice+"");
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
					.addGap(20)
					.addComponent(oreBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oreSell)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oreAmount)
					.addContainerGap(138, Short.MAX_VALUE))
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
						.addComponent(oreSell)
						.addComponent(oreBuy)
						.addComponent(oreAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		OrePanel.setLayout(gl_OrePanel);
		
		JPanel GamesPanel = new JPanel();
		
		JLabel lblGames = new JLabel("Games");
		
		JLabel label_14 = new JLabel("Buy Price:");
		
		JLabel label_15 = new JLabel("Sell Price:");
		
				
		label_16 = new JLabel(Integer.toString(currShip.getCurrentGoods().getGames()));
		
		int gameBuyPrice=calculatorBuy(4);
		int gameSellPrice=calculatorSell(gameBuyPrice);
		JLabel lblGbp = new JLabel(gameBuyPrice+"");
		
		JLabel lblGsp = new JLabel(gameSellPrice+"");
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
					.addGap(12)
					.addComponent(gamesBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(gamesSell)
					.addGap(12)
					.addComponent(label_16)
					.addContainerGap(135, Short.MAX_VALUE))
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
						.addComponent(gamesBuy)
						.addComponent(gamesSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		GamesPanel.setLayout(gl_GamesPanel);
		
		
		JLabel lblFirearms = new JLabel("Firearms");
		
		JLabel label_18 = new JLabel("Buy Price:");
		
		JLabel label_19 = new JLabel("Sell Price:");
		
		
		firearmsAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getFirearms()));
		
		int firearmBuyPrice=calculatorBuy(5);
		int firearmSellPrice=calculatorSell(firearmBuyPrice);
		JLabel lblFibp = new JLabel(firearmBuyPrice+"");
		JLabel lblFisp = new JLabel(firearmSellPrice+"");
		
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
					.addGap(12)
					.addComponent(firearmsBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firearmsSell)
					.addGap(18)
					.addComponent(firearmsAmount)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		gl_FirearmsPanel.setVerticalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap(6, Short.MAX_VALUE)
					.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirearms)
						.addComponent(firearmsSell)
						.addComponent(label_19)
						.addComponent(label_18)
						.addComponent(lblFibp)
						.addComponent(lblFisp)
						.addComponent(firearmsAmount)
						.addComponent(firearmsBuy))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FirearmsPanel.setLayout(gl_FirearmsPanel);
		
		
		JLabel lblMedicine = new JLabel("Medicine");
		
		JLabel label_22 = new JLabel("Buy Price:");
		
		JLabel label_23 = new JLabel("Sell Price:");
		
				
		MedicineAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getMedicines()));
		
		int medBuyPrice=calculatorBuy(6);
		int medSellPrice=calculatorSell(medBuyPrice);
		JLabel lblMbp = new JLabel(medBuyPrice+"");
		JLabel lblMsp = new JLabel(medSellPrice+"");
		
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(medicineBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicineSell)
					.addGap(18)
					.addComponent(MedicineAmount)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_MedicinePanel.setVerticalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MedicinePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicine)
						.addComponent(medicineSell)
						.addComponent(label_23)
						.addComponent(label_22)
						.addComponent(MedicineAmount)
						.addComponent(lblMbp)
						.addComponent(lblMsp)
						.addComponent(medicineBuy))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MedicinePanel.setLayout(gl_MedicinePanel);
		
		
		JLabel lblMachines = new JLabel("Machines");
		
		JLabel label_26 = new JLabel("Buy Price:");
		
		JLabel label_27 = new JLabel("Sell Price:");
		
		
		
		MachinesAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getMachines()));
		
		
		int macBuyPrice=calculatorBuy(7);
		int macSellPrice=calculatorSell(macBuyPrice);
		JLabel lblMabp = new JLabel(macBuyPrice+"");
		JLabel lblMasp = new JLabel(macSellPrice+"");
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
					.addComponent(machinesBuy)
					.addGap(12)
					.addComponent(machinesSell)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(MachinesAmount, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_MachinesPanel.setVerticalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MachinesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachines)
						.addComponent(label_26)
						.addComponent(label_27)
						.addComponent(machinesSell)
						.addComponent(lblMabp)
						.addComponent(lblMasp)
						.addComponent(MachinesAmount)
						.addComponent(machinesBuy))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MachinesPanel.setLayout(gl_MachinesPanel);
		
		
		JLabel lblNarcotices = new JLabel("Narcotices");
		
		
		JLabel label_30 = new JLabel("Buy Price:");
		
		JLabel label_31 = new JLabel("Sell Price:");
		
				
		narcoticesAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getNarcotics()));
		int narBuyPrice=calculatorBuy(8);
		int narSellPrice=calculatorSell(narBuyPrice);
		JLabel lblNabp = new JLabel(narBuyPrice+"");
		
		JLabel lblNasp = new JLabel(narSellPrice+"");
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
					.addComponent(narcoticesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesSell)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(narcoticesAmount)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_NarcoticesPanel.setVerticalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NarcoticesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNarcotices)
						.addComponent(label_30)
						.addComponent(label_31)
						.addComponent(lblNabp)
						.addComponent(lblNasp)
						.addComponent(narcoticesBuy)
						.addComponent(narcoticesSell)
						.addComponent(narcoticesAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		NarcoticesPanel.setLayout(gl_NarcoticesPanel);
		
		btnFinished = new JButton("Finish");
		
		
		JLabel lblRobots = new JLabel("Robots");
		
		JLabel label_5 = new JLabel("Buy Price:");
		
		JLabel label_9 = new JLabel("Sell Price:");
		
		
		robotsAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getRobots()));
		
		int robBuyPrice=calculatorBuy(9);
		int robSellPrice=calculatorSell(robBuyPrice);
		JLabel lblRobp = new JLabel(robBuyPrice+"");
		
		JLabel lblRosp = new JLabel(robSellPrice+"");
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(robotsBuy)
					.addGap(12)
					.addComponent(robotsSell)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(robotsAmount)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_RobotsPanel.setVerticalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRobots)
						.addComponent(label_9)
						.addComponent(label_5)
						.addComponent(robotsSell)
						.addComponent(lblRobp)
						.addComponent(lblRosp)
						.addComponent(robotsBuy)
						.addComponent(robotsAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		RobotsPanel.setLayout(gl_RobotsPanel);
		
		currentAmountOfGoods = new JLabel(currShip.getCurrentGoods().getTotal()+"");
		
		JLabel label_1 = new JLabel("|");
		
		totalAmountOfGoods = new JLabel(currShip.getCargoCapacity()+"");
		
		JLabel lblPlanetName = new JLabel("Planet Name:");
		
		JLabel lblPlanetName_1 = new JLabel(planet.getPlanetName());
		
		JLabel lblTechLevel = new JLabel("Tech level:");
		
		JLabel lblNewLabel_2 = new JLabel(planet.getTechLevel() + "");
		
		JLabel lblZone = new JLabel("Zone:");
		
		JLabel lblNewLabel_1 = new JLabel(planet.getZone().getZone() +"");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(WaterPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTrade)
									.addPreferredGap(ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addGap(28)
									.addComponent(currentAmountOfGoods, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(totalAmountOfGoods, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(109))
								.addComponent(FursPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(FoodPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(OrePanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(GamesPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(FirearmsPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(MedicinePanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(MachinesPanel, GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(RobotsPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
								.addComponent(NarcoticesPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblPlanetName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPlanetName_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTechLevel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(172)
									.addComponent(btnFinished)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addGap(36)
							.addComponent(lblZone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(currentAmountOfGoods)
						.addComponent(label_1)
						.addComponent(totalAmountOfGoods)
						.addComponent(lblNewLabel)
						.addComponent(lblTrade))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(WaterPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FursPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FoodPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(OrePanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GamesPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FirearmsPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MedicinePanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(MachinesPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(NarcoticesPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(RobotsPanel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlanetName)
						.addComponent(lblPlanetName_1)
						.addComponent(lblTechLevel)
						.addComponent(lblNewLabel_2)
						.addComponent(lblZone)
						.addComponent(lblNewLabel_1))
					.addGap(20)
					.addComponent(btnFinished)
					.addContainerGap())
		);
		
		JLabel lblWater = new JLabel("Water");
		
		JLabel lblBuyPrice = new JLabel("Buy Price:");
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		
		
		
		
		waterAmount = new JLabel(Integer.toString(currShip.getCurrentGoods().getWater()));
		int waterBuyPrice=calculatorBuy(0);
		int waterSellPrice=calculatorSell(waterBuyPrice);
		JLabel lblWbp = new JLabel(waterBuyPrice+"");
		
		JLabel lblWsp = new JLabel(waterSellPrice+"");
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
					.addComponent(waterBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterSell)
					.addGap(18)
					.addComponent(waterAmount)
					.addContainerGap(136, Short.MAX_VALUE))
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
						.addComponent(waterBuy)
						.addComponent(waterSell)
						.addComponent(waterAmount))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		WaterPanel.setLayout(gl_WaterPanel);
		setLayout(groupLayout);
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
		return true;
	}
	
	
	/**
	 * Check is player has enough money after buy is pressed
	 * @param index number of the item
	 * @return whether player has enough money
	 */
	public boolean checkMoney(int index){
		if(currPlayer.getCash()>=allBuy[index]&&currShip.getCurrentGoods().getTotal()<currShip.getCargoCapacity()){
			return true;
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
}










