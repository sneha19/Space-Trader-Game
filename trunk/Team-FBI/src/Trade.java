import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Trade extends JPanel{
	private int _price;
	public Zone _unnamed_Zone_;
	public PlanetScreen _unnamed_PlanetScreen_;
	public Merchant _unnamed_Merchant_;
	public Goods _unnamed_Goods_;
	public Player currPlayer;
	public  Planet currPlanet;
	public  Ship currShip;
	private int level;
	JButton fursBuy;
	JButton fursSell;
	JButton waterBuy;
	JButton waterSell;
	JButton foodBuy;
	JButton foodSell;
	JButton oreBuy;
	JButton oreSell;
	JButton gamesBuy;
	JButton gamesSell;
	JButton firearmsBuy;
	JButton firearmsSell;
	JButton medicineBuy;
	JButton medicineSell;
	JButton machinesBuy;
	JButton machinesSell;
	JButton narcoticesBuy;
	JButton narcoticesSell;
	JButton robotsBuy;
	JButton robotsSell;
//	
//	int waterBasePrice = 30;
//	int fursBasePrice = 250;
//	int foodBasePrice = 100;
//	int oreBasePrice = 350;
//	int gamesBasePrice = 250;
//	int firearmsBasePrice = 1250;
//	int medicineBasePrice = 650;
//	int machinesBasePrice = 900;
//	int narcoticsBasePrice = 3500;
//	int robotsBasePrice = 5000;
	
	int[] basePrice = new int[]{30,250,100,350,250,1250,650,900,3500,5000};
	int[] priceIncreasePerTechLevel = new int[]{3,10,5,20,-10,-75,-20,-30,-125,-150};
	int[] minLevelToProduceResource = new int[]{0,0,1,2,3,3,4,4,5,6};
	int[] variance = new int[]{4,10,5,10,5,100,10,5,150,100};
	
	public int calculatorPrice(int location)
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
	public Trade(Player p, Planet planet)
	{
		currPlayer = p;
		currShip = currPlayer.getShip();
		currPlanet  = planet;
		
		level = currPlanet.getTechLevel();
		
		JLabel lblTrade = new JLabel("TRADE");
		
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
		
		
		JLabel lblFurs = new JLabel("Furs");
		
		JLabel label_2 = new JLabel("Buy Price:");
		
		JLabel label_3 = new JLabel("Sell Price:");
		
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
				int furAmount = currPlayer.getShip().getCurrentGoods().getFurs();
		JLabel fursAmount = new JLabel(furAmount+"");
		int furBuy = calculatorPrice(2);
		String myfur = Integer.toString(furBuy);
		JLabel FursBuyPrice = new JLabel(myfur);
		
		JLabel fursSellPrice = new JLabel(".");
		
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
					.addComponent(FursBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fursSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(fursBuy)
					.addGap(12)
					.addComponent(fursSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fursAmount)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_FursPanel.setVerticalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FursPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFurs)
						.addComponent(fursBuy)
						.addComponent(fursAmount)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(fursSell)
						.addComponent(FursBuyPrice)
						.addComponent(fursSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FursPanel.setLayout(gl_FursPanel);
		
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel label_6 = new JLabel("Buy Price:");
		
		JLabel label_7 = new JLabel("Sell Price:");
		
				
		JLabel foodAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getFood()));
		
		JLabel foodBuyPrice = new JLabel(".");
		
		JLabel foodSellPrice = new JLabel(".");
		GroupLayout gl_FoodPanel = new GroupLayout(FoodPanel);
		gl_FoodPanel.setHorizontalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFood)
					.addGap(18)
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(label_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(foodBuy)
					.addGap(12)
					.addComponent(foodSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(foodAmount)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_FoodPanel.setVerticalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FoodPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFood)
						.addComponent(label_6)
						.addComponent(foodAmount)
						.addComponent(label_7)
						.addComponent(foodBuy)
						.addComponent(foodSell)
						.addComponent(foodBuyPrice)
						.addComponent(foodSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FoodPanel.setLayout(gl_FoodPanel);
		
		
		JLabel lblOre = new JLabel("Ore");
		
		JLabel label_10 = new JLabel("Buy Price:");
		
		JLabel label_11 = new JLabel("Sell Price:");
		
	  		
		JLabel oreAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getOre()));
		
		JLabel oreBuyPrice = new JLabel(".");
		
		JLabel oreSellPrice = new JLabel(".");
		GroupLayout gl_OrePanel = new GroupLayout(OrePanel);
		gl_OrePanel.setHorizontalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOre)
					.addGap(27)
					.addComponent(label_10)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oreBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_11)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oreSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(oreBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oreSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(oreAmount)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_OrePanel.setVerticalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_OrePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOre)
						.addComponent(oreBuy)
						.addComponent(oreAmount)
						.addComponent(label_10)
						.addComponent(label_11)
						.addComponent(oreSell)
						.addComponent(oreBuyPrice)
						.addComponent(oreSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		OrePanel.setLayout(gl_OrePanel);
		
		JPanel GamesPanel = new JPanel();
		
		JLabel lblGames = new JLabel("Games");
		
		JLabel label_14 = new JLabel("Buy Price:");
		
		JLabel label_15 = new JLabel("Sell Price:");
		
				
		JLabel label_16 = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getGames()));
		
		JLabel gamesBuyPrice = new JLabel(".");
		
		JLabel gamesSellPrice = new JLabel(".");
		GroupLayout gl_GamesPanel = new GroupLayout(GamesPanel);
		gl_GamesPanel.setHorizontalGroup(
			gl_GamesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GamesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGames)
					.addGap(18)
					.addComponent(label_14)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gamesBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_15)
					.addGap(2)
					.addComponent(gamesSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(gamesBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(gamesSell)
					.addGap(31)
					.addComponent(label_16)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_GamesPanel.setVerticalGroup(
			gl_GamesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GamesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GamesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGames)
						.addComponent(label_14)
						.addComponent(label_15)
						.addComponent(label_16)
						.addComponent(gamesBuy)
						.addComponent(gamesSell)
						.addComponent(gamesBuyPrice)
						.addComponent(gamesSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		GamesPanel.setLayout(gl_GamesPanel);
		
		
		JLabel lblFirearms = new JLabel("Firearms");
		
		JLabel label_18 = new JLabel("Buy Price:");
		
		JLabel label_19 = new JLabel("Sell Price:");
		
		//firearmsBuy = new JButton("Buy");
		
		//firearmsSell = new JButton("Sell");
		
		JLabel firearmsAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getFirearms()));
		
		JLabel firearmsBuyPrice = new JLabel(".");
		
		JLabel firearmsSellPrice = new JLabel(".");
		GroupLayout gl_FirearmsPanel = new GroupLayout(FirearmsPanel);
		gl_FirearmsPanel.setHorizontalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFirearms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_18)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firearmsBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_19)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(firearmsSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(firearmsBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(firearmsSell)
					.addGap(31)
					.addComponent(firearmsAmount)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_FirearmsPanel.setVerticalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirearms)
						.addComponent(firearmsAmount)
						.addComponent(firearmsBuy)
						.addComponent(firearmsSell)
						.addComponent(label_19)
						.addComponent(label_18)
						.addComponent(firearmsBuyPrice)
						.addComponent(firearmsSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FirearmsPanel.setLayout(gl_FirearmsPanel);
		
		
		JLabel lblMedicine = new JLabel("Medicine");
		
		JLabel label_22 = new JLabel("Buy Price:");
		
		JLabel label_23 = new JLabel("Sell Price:");
		
				
		JLabel MedicineAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getMedicines()));
		
		JLabel medicineBuyPrice = new JLabel(".");
		
		JLabel medicineSellPrice = new JLabel(".");
		GroupLayout gl_MedicinePanel = new GroupLayout(MedicinePanel);
		gl_MedicinePanel.setHorizontalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMedicine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_22)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicineBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(label_23)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(medicineSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(medicineBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(medicineSell)
					.addGap(18)
					.addComponent(MedicineAmount)
					.addContainerGap(9, Short.MAX_VALUE))
		);
		gl_MedicinePanel.setVerticalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MedicinePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedicine)
						.addComponent(medicineBuy)
						.addComponent(medicineSell)
						.addComponent(label_23)
						.addComponent(label_22)
						.addComponent(MedicineAmount)
						.addComponent(medicineBuyPrice)
						.addComponent(medicineSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MedicinePanel.setLayout(gl_MedicinePanel);
		
		
		JLabel lblMachines = new JLabel("Machines");
		
		JLabel label_26 = new JLabel("Buy Price:");
		
		JLabel label_27 = new JLabel("Sell Price:");
		
		//machinesBuy = new JButton("Buy");
		
		//machinesSell = new JButton("Sell");
		
		JLabel MachinesAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getMachines()));
		
		JLabel machinesBuyPrice = new JLabel(".");
		
		JLabel machinesSellPrice = new JLabel(".");
		GroupLayout gl_MachinesPanel = new GroupLayout(MachinesPanel);
		gl_MachinesPanel.setHorizontalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMachines)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_26)
					.addGap(2)
					.addComponent(machinesBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_27)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(machinesSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(machinesBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(machinesSell)
					.addGap(18)
					.addComponent(MachinesAmount, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_MachinesPanel.setVerticalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MachinesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachines)
						.addComponent(MachinesAmount)
						.addComponent(label_26)
						.addComponent(label_27)
						.addComponent(machinesBuy)
						.addComponent(machinesSell)
						.addComponent(machinesBuyPrice)
						.addComponent(machinesSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MachinesPanel.setLayout(gl_MachinesPanel);
		
		
		JLabel lblNarcotices = new JLabel("Narcotices");
		
		JLabel label_30 = new JLabel("Buy Price:");
		
		JLabel label_31 = new JLabel("Sell Price:");
		
				
		JLabel narcoticesAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getNarcotics()));
		
		JLabel narcoticesBuyPrice = new JLabel(".");
		
		JLabel narcoticesSellPrice = new JLabel(".");
		GroupLayout gl_NarcoticesPanel = new GroupLayout(NarcoticesPanel);
		gl_NarcoticesPanel.setHorizontalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNarcotices)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_30)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(label_31)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(narcoticesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesSell)
					.addGap(18)
					.addComponent(narcoticesAmount)
					.addContainerGap(7, Short.MAX_VALUE))
		);
		gl_NarcoticesPanel.setVerticalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NarcoticesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNarcotices)
						.addComponent(label_30)
						.addComponent(narcoticesBuy)
						.addComponent(label_31)
						.addComponent(narcoticesSell)
						.addComponent(narcoticesAmount)
						.addComponent(narcoticesBuyPrice)
						.addComponent(narcoticesSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		NarcoticesPanel.setLayout(gl_NarcoticesPanel);
		
		JButton btnFinished = new JButton("Finished");
		
		
		JLabel lblRobots = new JLabel("Robots");
		
		JLabel label_5 = new JLabel("Buy Price:");
		
		JLabel label_9 = new JLabel("Sell Price:");
		
		//robotsBuy = new JButton("Buy");
		
		//robotsSell = new JButton("Sell");
		
		JLabel robotsAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getRobots()));
		
		JLabel robotsBuyPrice = new JLabel(".");
		
		JLabel robotsSellPrice = new JLabel(".");
		GroupLayout gl_RobotsPanel = new GroupLayout(RobotsPanel);
		gl_RobotsPanel.setHorizontalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRobots)
					.addGap(18)
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(robotsBuyPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(robotsSellPrice, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(robotsBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(robotsSell)
					.addGap(12)
					.addComponent(robotsAmount)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_RobotsPanel.setVerticalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRobots)
						.addComponent(label_9)
						.addComponent(robotsAmount)
						.addComponent(label_5)
						.addComponent(robotsBuy)
						.addComponent(robotsSell)
						.addComponent(robotsBuyPrice)
						.addComponent(robotsSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		RobotsPanel.setLayout(gl_RobotsPanel);
		
		JLabel currentAmountOfGoods = new JLabel("T");
		
		JLabel label_1 = new JLabel("|");
		
		JLabel totalAmountOfGoods = new JLabel("T");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(WaterPanel, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
								.addComponent(FursPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addComponent(FoodPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addComponent(OrePanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addComponent(GamesPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addComponent(FirearmsPanel, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(MedicinePanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(MachinesPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTrade)
									.addPreferredGap(ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(currentAmountOfGoods, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(totalAmountOfGoods, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(23))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(btnFinished))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(NarcoticesPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(RobotsPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTrade)
								.addComponent(lblNewLabel))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(currentAmountOfGoods)
								.addComponent(totalAmountOfGoods))
							.addPreferredGap(ComponentPlacement.RELATED)))
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
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnFinished)
					.addContainerGap())
		);
		
		JLabel lblWater = new JLabel("Water");
		
		JLabel lblBuyPrice = new JLabel("Buy Price:");
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		
		waterBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		JLabel waterAmount = new JLabel(Integer.toString(currPlayer.getShip().getCurrentGoods().getWater()));
		
		JLabel waterBuyPrice = new JLabel(".");
		
		JLabel waterSellPrice = new JLabel(".");
		GroupLayout gl_WaterPanel = new GroupLayout(WaterPanel);
		gl_WaterPanel.setHorizontalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWater)
					.addGap(18)
					.addComponent(lblBuyPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterBuyPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSellPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterSellPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterBuy)
					.addGap(12)
					.addComponent(waterSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(waterAmount)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_WaterPanel.setVerticalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_WaterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWater)
						.addComponent(lblBuyPrice)
						.addComponent(lblSellPrice)
						.addComponent(waterAmount)
						.addComponent(waterBuy)
						.addComponent(waterSell)
						.addComponent(waterBuyPrice)
						.addComponent(waterSellPrice))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		WaterPanel.setLayout(gl_WaterPanel);
		setLayout(groupLayout);
		//chucnk
		
		
	
	}
	
	
	
	
	public void setWater()
	{
		waterBuy = new JButton("Buy");
		waterSell = new JButton("Sell");
		waterBuy.setEnabled(true);
		waterSell.setEnabled(true);

	}
	public void setFurs()
	{
		 fursBuy = new JButton("Buy");
		 fursSell = new JButton("Sell");
		fursBuy.setEnabled(true);
		fursSell.setEnabled(true);

	}
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
	
	public void buy(int aItems, int aIndex) {
		throw new UnsupportedOperationException();
	}

	public void sell(int aItems, int aIndex) {
		throw new UnsupportedOperationException();
	}

	public boolean quantityCheck(int aIndex) {
		throw new UnsupportedOperationException();
	}
}








