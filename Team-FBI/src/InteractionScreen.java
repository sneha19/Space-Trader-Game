import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

/** This is the interactions class
 * All random interactions and interactions on planets with pirates or merchants take place here
 * You can trade and fight with merchants
 * You can fight with pirates
 * 
 * @author Sneha,Samarth
 * @version 1.0
 *
 */

//make a createBattle method in BattleOptions that makes a panel for battle
//BattleOptions.createBattle(player);
public class InteractionScreen extends JPanel
{
	private Player player;
	private JButton trade;
	private JButton battle;
	private JButton ignore;
	private JButton flee;
	public BattleOptions BattleOptions;
	public UIMain ui;
	public MapPanel mp;
	public Universe uni;

	public InteractionScreen(Player player)
	{
		
		this.player = player;
		ui = new UIMain();
		uni = new Universe(player);
		//mp = new MapPanel(uni,player);
		
		trade = new JButton("Trade");
		trade.addActionListener(new TradeListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		battle = new JButton("Battle");
		battle.addActionListener(new BattleListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		ignore = new JButton("Ignore");
		ignore.addActionListener(new IgnoreListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		flee = new JButton("Flee");
		flee.addActionListener(new FleeListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		
		JProgressBar playerHealth = new JProgressBar();
		
		JProgressBar encounterHealth = new JProgressBar();
		
		JLabel playerName = new JLabel("Player");
		
		JLabel encounterName = new JLabel("Encounter");
		
		JLabel healthBar = new JLabel("Health");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(playerName)
					.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
					.addComponent(encounterName)
					.addGap(73))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(playerHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addComponent(encounterHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(healthBar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(ignore, Alignment.LEADING)
								.addComponent(flee, Alignment.LEADING)
								.addComponent(battle, Alignment.LEADING)
								.addComponent(trade, Alignment.LEADING))))
					.addContainerGap(208, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(playerName)
						.addComponent(encounterName))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(healthBar))
							.addGap(46)
							.addComponent(trade)
							.addGap(18)
							.addComponent(battle)
							.addGap(11)
							.addComponent(ignore))
						.addComponent(encounterHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(flee)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		BattleOptions = new BattleOptions(player);
		
		
	}
	
	public int hitDamage(Player player,int aHit) {
		int a = player.getShip().getHull();
		player.getShip.setHull(a-aHit);
		
	}

	public boolean isDead(Player player) {
		if(player.getShip.getHull() <= 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void useMissile(Player player, Player opponent) {
		Equipment e = player.getShip().getEquipment();
		if(e.getMissiles() >0){
			opponent.getShip().setHull(-20);
		}
		else{
			;
		}
		
	}

	public void surrender(Player player) {
		player.setCash((player.getCash()/2)*(-1));
		Goods g = player.getShip().getGoods();
		g.setWater((g.getWater()/2)*(-1));
		g.setFurs((g.getFurs()/2)*(-1));
		g.setFood((g.getFood()/2)*(-1));
		g.setOre((g.getOre()/2)*(-1));
		g.setGames((g.getGames())*(-1));
		g.setFirearms((g.getFirearms()/2)*(-1));
		g.setMedicines((g.getMedicines()/2)*(-1));
		g.setMachines((g.getMachines()/2)*(-1));
		g.setNarcotics((g.getNarcotics()/2)*(-1));
		g.setRobots((g.getRobots()/2)*(-1));
		
	}

	public int addGoods(Player player) {
		Goods g = player.getShip().getGoods();
		Goods now = Player.getShip().getCargo();
		now.setWater(g.getWater());
		now.setFurs(g.getFurs());
		now.setFood(g.getFood());
		now.setOre(g.getOre());
		now.setGames(g.getGames());
		now.setFirearms(g.getFirearms());
		now.setMedicines(g.getMedicines());
		now.setMachines(g.getMachines());
		now.setNarcotics(g.getNarcotics());
		now.setRobots(g.getRobots());
	}

	public boolean checkWin(Player player,Player opponent) {
		if(opponent.getShip().getHull <= 0){
			return true;
		}
		else{
			return false;
		}
		}
	
	private class TradeListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if((player.getName()).equals("merchant"){
				ui.createTrade(player);	
			}
			else{
				trade.setEnabled(false);
			}
		}
	}
	
	private class BattleListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			BattleOptions.createBattle(player);
		}
	}
	
	private class IgnoreListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if((player.getName()).equals("merchant"){ 
				mp = new MapPanel(uni,player);
			}
			else{
				ignore.setEnabled(false);
			}
				
		}
	}
	
	private class FleeListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if((player.getName()).equals("pirate"){ 
				int a = player.getShip().getHull();
				player.getShip().setHull((int)(a/4)*(-1)); // reduces hull a little 
				// penalty for fleeing
				//return to map
				mp = new MapPanel(uni,player);
			}
			else{
				flee.setEnabled(false);
			}
				
		}
	}
	
	
			
}