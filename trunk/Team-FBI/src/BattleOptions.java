
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

public class BattleOptions extends JPanel
{
	private JButton Hit;
	private JButton missile;
	private JButton surrender;
	private JButton flee;
	public BattleOptions BattleOptions;

	public BattleOptions()
	{
		
		Hit = new JButton("Hit");
		missile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		missile = new JButton("missile");
		missile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		surrender = new JButton("Surrender");
		surrender.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		flee = new JButton("Flee");
		missile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		JProgressBar playerHealth = new JProgressBar();
		
		JProgressBar encounterHealth = new JProgressBar();
		
		JLabel playerName = new JLabel("Player");
		
		JLabel encounterName = new JLabel("Pirate");
		
		JLabel healthBar = new JLabel("Health");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(playerName)
					.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
					.addComponent(encounterName)
					.addGap(73))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(playerHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
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
							.addComponent(Hit)))
					.addContainerGap(210, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(187)
					.addComponent(missile)
					.addContainerGap(200, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(178)
					.addComponent(surrender)
					.addContainerGap(191, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(195)
					.addComponent(flee)
					.addContainerGap(202, Short.MAX_VALUE))
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
							.addComponent(Hit)
							.addGap(18)
							.addComponent(missile))
						.addComponent(encounterHealth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(surrender)
					.addGap(18)
					.addComponent(flee)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
	public int hitDamage(int aHit) {
		
	}

	public boolean isDead() {
		
	}

	public void useMissile() {
		
	}

	public void surrender() {
		
	}

	public int addGoods() {
		
	}

	public boolean checkWin() {
		
	}
}