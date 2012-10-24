import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trade extends JPanel{
	private int _price;
	public Zone _unnamed_Zone_;
	public PlanetScreen _unnamed_PlanetScreen_;
	public Merchant _unnamed_Merchant_;
	public Goods _unnamed_Goods_;
	public Player currPlayer;
	public Planet currPlanet;
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
	public Trade(Player p, Planet planet)
	{
		currPlayer = p;
		
		currPlanet = planet;
		
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
		
		 fursBuy = new JButton("Buy");
		
		 fursSell = new JButton("Sell");
		
		JLabel label_4 = new JLabel(".");
		
		//Chunck
		GroupLayout gl_FursPanel = new GroupLayout(FursPanel);
		gl_FursPanel.setHorizontalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFurs)
					.addGap(26)
					.addComponent(label_2)
					.addGap(38)
					.addComponent(label_3)
					.addGap(31)
					.addComponent(fursBuy)
					.addGap(12)
					.addComponent(fursSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_FursPanel.setVerticalGroup(
			gl_FursPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FursPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FursPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFurs)
						.addComponent(fursBuy)
						.addComponent(label_4)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(fursSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FursPanel.setLayout(gl_FursPanel);
		
		
		JLabel lblFood = new JLabel("Food");
		
		JLabel label_6 = new JLabel("Buy Price:");
		
		JLabel label_7 = new JLabel("Sell Price:");
		
		 foodBuy = new JButton("Buy");
		
		 foodSell = new JButton("Sell");
		
		JLabel label_8 = new JLabel(".");
		GroupLayout gl_FoodPanel = new GroupLayout(FoodPanel);
		gl_FoodPanel.setHorizontalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFood)
					.addGap(18)
					.addComponent(label_6)
					.addGap(42)
					.addComponent(label_7)
					.addGap(29)
					.addComponent(foodBuy)
					.addGap(12)
					.addComponent(foodSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_8)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_FoodPanel.setVerticalGroup(
			gl_FoodPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FoodPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FoodPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFood)
						.addComponent(label_6)
						.addComponent(label_8)
						.addComponent(label_7)
						.addComponent(foodBuy)
						.addComponent(foodSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FoodPanel.setLayout(gl_FoodPanel);
		
		
		JLabel lblOre = new JLabel("Ore");
		
		JLabel label_10 = new JLabel("Buy Price:");
		
		JLabel label_11 = new JLabel("Sell Price:");
		
	    oreBuy = new JButton("Buy");
		
		oreSell = new JButton("Sell");
		
		JLabel label_12 = new JLabel(".");
		GroupLayout gl_OrePanel = new GroupLayout(OrePanel);
		gl_OrePanel.setHorizontalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOre)
					.addGap(27)
					.addComponent(label_10)
					.addGap(40)
					.addComponent(label_11)
					.addGap(28)
					.addComponent(oreBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(oreSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_12)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_OrePanel.setVerticalGroup(
			gl_OrePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OrePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_OrePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOre)
						.addComponent(oreBuy)
						.addComponent(label_12)
						.addComponent(label_10)
						.addComponent(label_11)
						.addComponent(oreSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		OrePanel.setLayout(gl_OrePanel);
		
		JPanel GamesPanel = new JPanel();
		
		JLabel lblGames = new JLabel("Games");
		
		JLabel label_14 = new JLabel("Buy Price:");
		
		JLabel label_15 = new JLabel("Sell Price:");
		
		gamesBuy = new JButton("Buy");
		
		gamesSell = new JButton("Sell");
		
		JLabel label_16 = new JLabel(".");
		GroupLayout gl_GamesPanel = new GroupLayout(GamesPanel);
		gl_GamesPanel.setHorizontalGroup(
			gl_GamesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GamesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGames)
					.addGap(18)
					.addComponent(label_14)
					.addGap(40)
					.addComponent(label_15)
					.addGap(18)
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
						.addComponent(gamesSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		GamesPanel.setLayout(gl_GamesPanel);
		
		
		JLabel lblFirearms = new JLabel("Firearms");
		
		JLabel label_18 = new JLabel("Buy Price:");
		
		JLabel label_19 = new JLabel("Sell Price:");
		
		firearmsBuy = new JButton("Buy");
		
		firearmsSell = new JButton("Sell");
		
		JLabel label_20 = new JLabel(".");
		GroupLayout gl_FirearmsPanel = new GroupLayout(FirearmsPanel);
		gl_FirearmsPanel.setHorizontalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFirearms)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_18)
					.addGap(40)
					.addComponent(label_19)
					.addGap(18)
					.addComponent(firearmsBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(firearmsSell)
					.addGap(31)
					.addComponent(label_20)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_FirearmsPanel.setVerticalGroup(
			gl_FirearmsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FirearmsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FirearmsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirearms)
						.addComponent(label_20)
						.addComponent(firearmsBuy)
						.addComponent(firearmsSell)
						.addComponent(label_19)
						.addComponent(label_18))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		FirearmsPanel.setLayout(gl_FirearmsPanel);
		
		
		JLabel lblMedicine = new JLabel("Medicine");
		
		JLabel label_22 = new JLabel("Buy Price:");
		
		JLabel label_23 = new JLabel("Sell Price:");
		
		medicineBuy = new JButton("Buy");
		
		medicineSell = new JButton("Sell");
		
		JLabel label_24 = new JLabel(".");
		GroupLayout gl_MedicinePanel = new GroupLayout(MedicinePanel);
		gl_MedicinePanel.setHorizontalGroup(
			gl_MedicinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MedicinePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMedicine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_22)
					.addGap(30)
					.addComponent(label_23)
					.addGap(34)
					.addComponent(medicineBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(medicineSell)
					.addGap(18)
					.addComponent(label_24)
					.addContainerGap(98, Short.MAX_VALUE))
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
						.addComponent(label_24))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MedicinePanel.setLayout(gl_MedicinePanel);
		
		
		JLabel lblMachines = new JLabel("Machines");
		
		JLabel label_26 = new JLabel("Buy Price:");
		
		JLabel label_27 = new JLabel("Sell Price:");
		
		machinesBuy = new JButton("Buy");
		
		machinesSell = new JButton("Sell");
		
		JLabel label_28 = new JLabel(".");
		GroupLayout gl_MachinesPanel = new GroupLayout(MachinesPanel);
		gl_MachinesPanel.setHorizontalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMachines)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_26)
					.addGap(18)
					.addComponent(label_27)
					.addGap(44)
					.addComponent(machinesBuy)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(machinesSell)
					.addGap(27)
					.addComponent(label_28)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_MachinesPanel.setVerticalGroup(
			gl_MachinesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MachinesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_MachinesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMachines)
						.addComponent(label_28)
						.addComponent(label_26)
						.addComponent(label_27)
						.addComponent(machinesBuy)
						.addComponent(machinesSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		MachinesPanel.setLayout(gl_MachinesPanel);
		
		
		JLabel lblNarcotices = new JLabel("Narcotices");
		
		JLabel label_30 = new JLabel("Buy Price:");
		
		JLabel label_31 = new JLabel("Sell Price:");
		
		narcoticesBuy = new JButton("Buy");
		
		narcoticesSell = new JButton("Sell");
		
		JLabel label_32 = new JLabel(".");
		GroupLayout gl_NarcoticesPanel = new GroupLayout(NarcoticesPanel);
		gl_NarcoticesPanel.setHorizontalGroup(
			gl_NarcoticesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NarcoticesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNarcotices)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_30)
					.addGap(27)
					.addComponent(label_31)
					.addGap(34)
					.addComponent(narcoticesBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(narcoticesSell)
					.addGap(18)
					.addComponent(label_32)
					.addContainerGap(16, Short.MAX_VALUE))
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
						.addComponent(label_32))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		NarcoticesPanel.setLayout(gl_NarcoticesPanel);
		
		JButton btnFinished = new JButton("Finished");
		
		
		JLabel lblRobots = new JLabel("Robots");
		
		JLabel label_5 = new JLabel("Buy Price:");
		
		JLabel label_9 = new JLabel("Sell Price:");
		
		robotsBuy = new JButton("Buy");
		
		robotsSell = new JButton("Sell");
		
		JLabel label_13 = new JLabel(".");
		GroupLayout gl_RobotsPanel = new GroupLayout(RobotsPanel);
		gl_RobotsPanel.setHorizontalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRobots)
					.addGap(18)
					.addComponent(label_5)
					.addGap(40)
					.addComponent(label_9)
					.addGap(31)
					.addComponent(robotsBuy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(robotsSell)
					.addGap(12)
					.addComponent(label_13)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_RobotsPanel.setVerticalGroup(
			gl_RobotsPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 42, Short.MAX_VALUE)
				.addGroup(gl_RobotsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_RobotsPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRobots)
						.addComponent(label_9)
						.addComponent(label_13)
						.addComponent(label_5)
						.addComponent(robotsBuy)
						.addComponent(robotsSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		RobotsPanel.setLayout(gl_RobotsPanel);
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
									.addPreferredGap(ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addGap(9))))
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
							.addComponent(lblTrade)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnFinished)
					.addContainerGap())
		);
		
		JLabel lblWater = new JLabel("Water");
		
		JLabel lblBuyPrice = new JLabel("Buy Price:");
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		
		waterBuy = new JButton("Buy");
		waterBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		waterSell = new JButton("Sell");
		
		JLabel label = new JLabel(".");
		GroupLayout gl_WaterPanel = new GroupLayout(WaterPanel);
		gl_WaterPanel.setHorizontalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWater)
					.addGap(18)
					.addComponent(lblBuyPrice)
					.addGap(40)
					.addComponent(lblSellPrice)
					.addGap(31)
					.addComponent(waterBuy)
					.addGap(12)
					.addComponent(waterSell)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_WaterPanel.setVerticalGroup(
			gl_WaterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_WaterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_WaterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWater)
						.addComponent(lblBuyPrice)
						.addComponent(lblSellPrice)
						.addComponent(label)
						.addComponent(waterBuy)
						.addComponent(waterSell))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		WaterPanel.setLayout(gl_WaterPanel);
		setLayout(groupLayout);
		//chucnk
		
		
		
		
		
		
	}
	public void setWater()
	{
		
	}
	public void setFurs()
	{
		
	}
	public void setFood()
	{
		
	}
	public void setOre()
	{
		
	}
	public void setGames()
	{
		
	}
	public void setFirearms()
	{
		
	}
	public void setMedicines()
	{
		
	}
	public void setMachines()
	{
		
	}
	public void setNarcotices()
	{
		
	}
	public void setRobot()
	{
		
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