import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

import org.omg.CORBA.TRANSIENT;

/**
 * stardock gui side to allow users to interact with game
 * @author Haytham Abutair
 *
 */
public class StarDock extends JPanel  implements Serializable{
	public Zone _unnamed_Zone_;
	public PlanetScreen _unnamed_PlanetScreen_;
	public Equipment _unnamed_Equipment_;
	private int fuel = 25;
	private int hull = 75;
	private Player currPlayer;
	JButton btnContinue;
	JComboBox comboBox;
	JLabel currentHullLbl = new JLabel("");
	JLabel currShiplbl = new JLabel("");
	JLabel cashLabel = new JLabel("");
	JLabel currFuelLbl = new JLabel("");
	JSlider hullSlider;
	JSlider fuelSlider;
	JLabel maxFuelLbl = new JLabel("");
	JLabel maxHullLbl = new JLabel("");
	transient Image bg;

	int i = 0;
	/**
	 * Create the panel.
	 */
	public StarDock(Player p) {
		currPlayer = p;
		setBackground(new Color(51, 102, 102));
		setForeground(UIManager.getColor("Desktop.background"));
		setLayout(new MigLayout("", "[][][grow][][][][][][][][][][][][][][][][][grow]", "[][][][][][][][][][][][][][][][grow][]"));
		JLabel lblBuyShip = new JLabel("Buy Ship:");
		lblBuyShip.setForeground(new Color(255, 255, 255));
		add(lblBuyShip, "cell 1 1");

		comboBox = new JComboBox();
		//		fighter("Fighter",100,20,100,100),hauler("Hauler",120,100,80,700),bullDog("Bulldog",200,50,50,300),carrier("Carrier",60,150,80,350),yellowJacket("Yellow Jacket",140,30,150,300),destroyer("Destroyer",500,50,100,700),heat("Heat",100,100,100,400);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fighter - $1550", "Hauler - $2000", "Bulldog - $1000", "Carrier - $1100", "YellowJacket - $2000", "Destroyer - $1450", "Heat - $3000"}));

		add(comboBox, "cell 9 1,growx");

		JButton btnGo = new JButton("Buy Ship!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String output = (String)comboBox.getSelectedItem();
				int i = 0;
				String finalName = "";
				while( output.charAt(i) != ' ')
				{
					finalName += output.charAt(i);
					i++;
				}
				String fighter = "Fighter";
				String hauler = "Hauler";
				String bulldog = "Bulldog";
				String carrier = "Carrier";
				String yellowJacket = "YellowJacket";
				String destroyer = "Destroyer";
				String heat = "Heat";
				Ship tempShip;
				if(finalName.equals(heat) && currPlayer.getCash() >= 1050 && !currPlayer.getShip().getName().equals("Heat")){
					currPlayer.setCash(-1050);
					currPlayer.setShip(new Ship(ShipType.heat));
				}
				if(finalName.equals(destroyer) && currPlayer.getCash() >= 2450 && !currPlayer.getShip().getName().equals("Destroyer")){
					currPlayer.setCash(-1450);
					currPlayer.setShip(new Ship(ShipType.destroyer));
				}
				if(finalName.equals(yellowJacket) && currPlayer.getCash() >= 2000 && !currPlayer.getShip().getName().equals("Yellow Jacket")){
					currPlayer.setCash(-2000);
					currPlayer.setShip(new Ship(ShipType.yellowJacket));
				}
				if(finalName.equals(carrier) && currPlayer.getCash() >= 1100 && !currPlayer.getShip().getName().equals("Carrier")){
					currPlayer.setCash(-1100);
					currPlayer.setShip(new Ship(ShipType.carrier));
				}
				if(finalName.equals(fighter) && currPlayer.getCash() >= 1550 && !currPlayer.getShip().getName().equals("Fighter")){
					currPlayer.setCash(-1550);
					currPlayer.setShip(new Ship(ShipType.fighter));
				}
				if(finalName.equals(hauler) && currPlayer.getCash() >= 2000 && !currPlayer.getShip().getName().equals("Hauler")){
					currPlayer.setCash(-2000);
					currPlayer.setShip(new Ship(ShipType.hauler));
				}

				if(finalName.equals(bulldog) && currPlayer.getCash() >= 1000 && !currPlayer.getShip().getName().equals("Bulldog")){
					currPlayer.setCash(-1000);
					currPlayer.setShip(new Ship(ShipType.bullDog));
				}

				updateLabels();

			}

		});
		add(btnGo, "cell 11 1");

		JLabel lblRepairHull = new JLabel("Repair Hull: @ $75/e");
		lblRepairHull.setForeground(new Color(255, 255, 255));
		add(lblRepairHull, "cell 1 2");
		//hullSpinner.
		hullSlider = new JSlider();
		hullSlider.setMaximum((int) (currPlayer.getShip().getMaxHull() - currPlayer.getShip().getHull()));
		hullSlider.setOrientation(SwingConstants.VERTICAL);
		hullSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int calcPrice = currPlayer.getCash()/hull;
				//		if(hullSlider.getValue() < calcPrice)
				//		{
				//			hullSlider.setValue(hullSlider.getValue() + 1);
				//		}
			}
		});
		hullSlider.setForeground(new Color(255, 255, 255));
		hullSlider.setMajorTickSpacing(3);
		hullSlider.setValue(0);
		hullSlider.setMinimum(0);
		hullSlider.setMinorTickSpacing(1);
		hullSlider.setSnapToTicks(true);
		hullSlider.setPaintLabels(true);
		hullSlider.setPaintTicks(true);
		hullSlider.setToolTipText("");
		add(hullSlider, "flowx,cell 9 2");

		JButton btnRepair = new JButton("Repair!");
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hullSlider.getValue() * hull <= currPlayer.getCash() && (hullSlider.getValue()+currPlayer.getShip().getHull() <= currPlayer.getShip().getMaxHull()))
				{
					currPlayer.setCash(-hullSlider.getValue() * hull);
					currPlayer.getShip().setHull(currPlayer.getShip().getHull() + hullSlider.getValue());
					updateLabels();
				}
			}
		});
		add(btnRepair, "cell 11 2");

		JLabel lblBuyFuel = new JLabel("Buy Fuel: @ $25/e");
		lblBuyFuel.setForeground(new Color(255, 255, 255));
		add(lblBuyFuel, "cell 1 3");

		fuelSlider = new JSlider();
		fuelSlider.setMajorTickSpacing(1);
		fuelSlider.setSnapToTicks(true);
		fuelSlider.setPaintLabels(true);
		fuelSlider.setPaintTicks(true);
		fuelSlider.setForeground(new Color(255, 255, 255));
		fuelSlider.setMinimum(0);
		fuelSlider.setMinorTickSpacing(0);
		fuelSlider.setMaximum((int) (currPlayer.getShip().getFuelCapacity() - currPlayer.getShip().getCurrentFuel()));
		add(fuelSlider, "cell 9 3");

		JButton btnPumpFuel = new JButton("Pump Fuel!");
		btnPumpFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fuelSlider.getValue() * fuel <= currPlayer.getCash() && (fuelSlider.getValue()+currPlayer.getShip().getCurrentFuel() <= currPlayer.getShip().getFuelCapacity()))
				{
					currPlayer.setCash(-fuelSlider.getValue() * fuel);
					currPlayer.getShip().updateCurrentFuel(fuelSlider.getValue());
					updateLabels();
				}
			}
		});
		add(btnPumpFuel, "cell 11 3");

		JLabel lblCurrentAmount = new JLabel("Current cash:");
		lblCurrentAmount.setForeground(new Color(255, 255, 255));
		lblCurrentAmount.setBackground(new Color(255, 255, 255));
		add(lblCurrentAmount, "cell 1 5");

		cashLabel = new JLabel("\"\"");
		cashLabel.setForeground(new Color(255, 255, 255));
		add(cashLabel, "flowx,cell 9 5");

		JLabel lblCurrentHull = new JLabel("Current hull:");
		lblCurrentHull.setForeground(new Color(255, 255, 255));
		add(lblCurrentHull, "cell 1 6");

		currentHullLbl = new JLabel("\" \"");
		currentHullLbl.setForeground(new Color(255, 255, 255));
		add(currentHullLbl, "flowx,cell 9 6");

		JLabel lblCurrentShip = new JLabel("Current Ship:");
		lblCurrentShip.setForeground(new Color(255, 255, 255));
		add(lblCurrentShip, "cell 1 7");

		currShiplbl = new JLabel(" \" \"");
		currShiplbl.setForeground(new Color(255, 255, 255));
		add(currShiplbl, "flowx,cell 9 7,alignx left");

		JLabel lblCurrentFuel = new JLabel("Current Fuel:");
		lblCurrentFuel.setForeground(new Color(255, 255, 255));
		add(lblCurrentFuel, "cell 1 9");

		currFuelLbl = new JLabel(" \"  \"");
		currFuelLbl.setForeground(new Color(255, 255, 255));
		add(currFuelLbl, "flowx,cell 9 9");

		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(btnContinue, "cell 9 10");

		JList list = new JList();
		add(list, "cell 5 15");
		updateLabels();
		currFuelLbl.setText(decimalFormat(currPlayer.getShip().getCurrentFuel() - currPlayer.getShip().getFuelPerMove()) + "");


		JLabel label_1 = new JLabel("/");
		label_1.setForeground(Color.WHITE);
		add(label_1, "cell 9 6");

		JLabel label = new JLabel("/");
		label.setForeground(Color.WHITE);
		add(label, "cell 9 9");


		maxHullLbl.setForeground(new Color(255, 255, 255));
		add(maxHullLbl, "cell 9 6");

		maxFuelLbl.setForeground(new Color(255, 255, 255));
		add(maxFuelLbl, "cell 9 9");		

	}
	/**
	 * formater for doubles to only 2 decimal places
	 * @param longDouble amount passed in
	 * @return new value #.## sentax
	 */
	public double decimalFormat(double longDouble)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(longDouble));
	}
	/**
	 * updates the labels on screen
	 */
	public void updateLabels()
	{
		currentHullLbl.setText(currPlayer.getShip().getHull() + "");
		currShiplbl.setText(currPlayer.getShip().getName());
		cashLabel.setText(currPlayer.getCash() + "");
		currFuelLbl.setText(currPlayer.getShip().getCurrentFuel()+"");
		maxHullLbl.setText(currPlayer.getShip().getMaxHull() +"");
		maxFuelLbl.setText(currPlayer.getShip().getFuelCapacity() +"");
		fuelSlider.setMaximum((int) (currPlayer.getShip().getFuelCapacity() - currPlayer.getShip().getCurrentFuel()));
		hullSlider.setMaximum((int) (currPlayer.getShip().getMaxHull() - currPlayer.getShip().getHull()));

	}
	/**
	 * paint method for gui
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
	}
	public void afterLoad()
	{
		bg = new ImageIcon("img/bricks.jpg").getImage();
	}

	/**
	 * Set the btnlistener for the finished button
	 * @param a a button listener in the UIMain class
	 * @return whether the set is successful
	 */
	public boolean setBtnFinished(ActionListener a){
		btnContinue.addActionListener(a);
		return true;
	}
}

