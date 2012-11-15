// $codepro.audit.disable fileComment, numericLiterals
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
/**
 * This is a GUI that shows the inventory and related information of the player
 * @author Guang Lu
 *
 */
public class Inventory extends JPanel{
	
	/**
	 * player
	 */
	private Player player = null;

	/**
	 * name
	 */
	private JLabel lblPlayerName = null;

	/**
	 * ship
	 */
	private JLabel lblPlayership = null;

	/**
	 * hull
	 */
	private JLabel lblPlayerhull = null;

	/**
	 * player
	 */
	private JLabel lblPlayerCash = null;

	/**
	 * player
	 */
	private JLabel lblPlayerdiff = null;

	/**
	 * water
	 */
	private JLabel lblWaterNum = null;

	/**
	 * food
	 */
	private JLabel lblFoodNum = null;

	/**
	 * ore
	 */
	private JLabel lblOreNum = null;

	/**
	 * game
	 */
	private JLabel lblGameNum = null;

	/**
	 * firearm
	 */
	private JLabel lblFirearmNum = null;

	/**
	 * med
	 */
	private JLabel lblMedNum = null;

	/**
	 * mac
	 */
	private JLabel lblMacNum = null;

	/**
	 * nar
	 */
	private JLabel lblNarNum = null;

	/**
	 * rob
	 */
	private JLabel lblRobNum = null;

	/**
	 * fur
	 */
	private JLabel lblFurNum = null;
	
	/**
	 *Constructor
	 *@param player
	 */
	public Inventory(Player player) { // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.constructorsOnlyInvokeFinalMethods
		
		this.player=player;
		this.setPreferredSize(new Dimension(800, 800));
		setLayout(new MigLayout("", "[][][][][][][][][][][][][][][]", 
				"[][][][][][][][][][][][][][][][][][][]"));
		
		final JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblInventory.setForeground(Color.WHITE);
		add(lblInventory, "cell 11 1");
		
		final JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		add(lblName, "cell 4 3");
		
		lblPlayerName = new JLabel(player.getName());
		lblPlayerName.setForeground(Color.WHITE);
		lblPlayerName.setBackground(Color.BLACK);
		add(lblPlayerName, "cell 6 3");
		
		final JLabel lblShip = new JLabel("Ship:");
		lblShip.setForeground(Color.WHITE);
		add(lblShip, "cell 12 3");
		
		lblPlayership = new JLabel(player.getShip().getName());
		lblPlayership.setForeground(Color.WHITE);
		add(lblPlayership, "cell 14 3");
		
		final JLabel lblHull = new JLabel("Hull:");
		lblHull.setForeground(Color.WHITE);
		add(lblHull, "cell 12 4");
		
		lblPlayerhull = new JLabel(player.getShip().getHull() + "/" +
		player.getShip().getMaxHull());
		lblPlayerhull.setForeground(Color.WHITE);
		add(lblPlayerhull, "cell 14 4");
		
		final JLabel lblCash = new JLabel("Cash:");
		lblCash.setForeground(Color.WHITE);
		lblCash.setBackground(Color.BLACK);
		add(lblCash, "cell 4 5");
		
		lblPlayerCash = new JLabel(player.getCash() + "");
		lblPlayerCash.setForeground(Color.WHITE);
		lblPlayerCash.setBackground(Color.BLACK);
		add(lblPlayerCash, "cell 6 5");
		
		final JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setForeground(Color.WHITE);
		add(lblDifficulty, "cell 12 5");
		
		lblPlayerdiff = new JLabel(player.getDifficulty() + "");
		lblPlayerdiff.setForeground(Color.WHITE);
		add(lblPlayerdiff, "cell 14 5");
		
		final JLabel lblWater = new JLabel("Water");
		lblWater.setForeground(Color.WHITE);
		add(lblWater, "cell 4 9");
		
		lblWaterNum = new JLabel(player.getShip().getCurrentGoods().getWater() + "");
		lblWaterNum.setForeground(Color.WHITE);
		add(lblWaterNum, "cell 6 9");
		
		final JLabel lblFurs = new JLabel("Fur");
		lblFurs.setForeground(Color.WHITE);
		add(lblFurs, "cell 4 10");
		
		lblFurNum = new JLabel(player.getShip().getCurrentGoods().getFurs() + "");
		lblFurNum.setForeground(Color.WHITE);
		add(lblFurNum, "cell 6 10");
		
		final JLabel lblFood = new JLabel("Food");
		lblFood.setForeground(Color.WHITE);
		add(lblFood, "cell 4 11");
		
		lblFoodNum = new JLabel(player.getShip().getCurrentGoods().getFood() + "");
		lblFoodNum.setForeground(Color.WHITE);
		add(lblFoodNum, "cell 6 11");
		
		final JLabel lblOre = new JLabel("Ore");
		lblOre.setForeground(Color.WHITE);
		add(lblOre, "cell 4 12");
		
		lblOreNum = new JLabel(player.getShip().getCurrentGoods().getOre() + "");
		lblOreNum.setForeground(Color.WHITE);
		add(lblOreNum, "cell 6 12");
		
		final JLabel lblGames = new JLabel("Game");
		lblGames.setForeground(Color.WHITE);
		add(lblGames, "cell 4 13");
		
		lblGameNum = new JLabel(player.getShip().getCurrentGoods().getGames() + "");
		lblGameNum.setForeground(Color.WHITE);
		add(lblGameNum, "cell 6 13");
		
		final JLabel lblFirearms = new JLabel("Firearm");
		lblFirearms.setForeground(Color.WHITE);
		add(lblFirearms, "cell 4 14");
		
		lblFirearmNum = new JLabel(player.getShip().getCurrentGoods().getFirearms() + "");
		lblFirearmNum.setForeground(Color.WHITE);
		add(lblFirearmNum, "cell 6 14");
		
		final JLabel lblMedicine = new JLabel("Medicine");
		lblMedicine.setForeground(Color.WHITE);
		add(lblMedicine, "cell 4 15");
		
		lblMedNum = new JLabel(player.getShip().getCurrentGoods().getMedicines() + "");
		lblMedNum.setForeground(Color.WHITE);
		add(lblMedNum, "cell 6 15");
		
		final JLabel lblMachine = new JLabel("Machine");
		lblMachine.setForeground(Color.WHITE);
		add(lblMachine, "cell 4 16");
		
		lblMacNum = new JLabel(player.getShip().getCurrentGoods().getMachines() + "");
		lblMacNum.setForeground(Color.WHITE);
		add(lblMacNum, "cell 6 16");
		
		final JLabel lblNarcotic = new JLabel("Narcotic");
		lblNarcotic.setForeground(Color.WHITE);
		add(lblNarcotic, "cell 4 17");
		
		lblNarNum = new JLabel(player.getShip().getCurrentGoods().getNarcotics() + "");
		lblNarNum.setForeground(Color.WHITE);
		add(lblNarNum, "cell 6 17");
		
		final JLabel lblRobot = new JLabel("Robot");
		lblRobot.setForeground(Color.WHITE);
		add(lblRobot, "cell 4 18");
		
		lblRobNum = new JLabel(player.getShip().getCurrentGoods().getRobots() + "");
		lblRobNum.setForeground(Color.WHITE);
		add(lblRobNum, "cell 6 18");
	}
	
	/**
	 * draw the background
	 * @param g a Graphics instance
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		final Image bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * update the labels
	 */
	public void update(){
		lblPlayership.setText(player.getShip().getName());
		lblPlayerhull.setText(player.getShip().getHull()
		+ "/" + player.getShip().getMaxHull());
		lblPlayerCash.setText(player.getCash() + "");
		lblWaterNum.setText(player.getShip().getCurrentGoods().getWater() + "");
		lblFoodNum.setText(player.getShip().getCurrentGoods().getFood() + "");
		lblOreNum.setText(player.getShip().getCurrentGoods().getOre() + "");
		lblGameNum.setText(player.getShip().getCurrentGoods().getGames() + "");
		lblFirearmNum.setText(player.getShip().getCurrentGoods().getFirearms() + "");
		lblMedNum.setText(player.getShip().getCurrentGoods().getMedicines() + "");
		lblMacNum.setText(player.getShip().getCurrentGoods().getMachines() + "");
		lblNarNum.setText(player.getShip().getCurrentGoods().getNarcotics() + "");
		lblRobNum.setText(player.getShip().getCurrentGoods().getRobots() + "");
		lblFurNum.setText(player.getShip().getCurrentGoods().getFurs() + "");
	}

}
