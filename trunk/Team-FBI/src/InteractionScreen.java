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

public class InteractionScreen extends JPanel
{
	private JButton trade;
	private JButton battle;
	private JButton ignore;
	private JButton flee;
	public BattleOptions BattleOptions;

	public InteractionScreen()
	{
		
		trade = new JButton("Trade");
		trade.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		battle = new JButton("Battle");
		battle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		ignore = new JButton("Ignore");
		ignore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		flee = new JButton("Flee");
		flee.addActionListener(new ActionListener() 
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
		
		
	}
	public int hitDamage(int aHit) 
	{
		
	}

	public boolean isDead() 
	{
		
	}

	public void useMissile() 
	{
		
	}

	public void surrender() 
	{
		
	}

	public int addGoods() 
	{
		
	}

	public boolean checkWin() 
	{
		
	}
}