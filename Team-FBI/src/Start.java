import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;




public class Start extends JPanel {
	private JTextField textField;
	private String playerName;
	private int difficulty;
	private JButton btnStart;
	
	public Start() {
		
		JLabel lblYoungSailorStart = new JLabel("Young sailor, start your journey here!");
		JLabel lblEnterName = new JLabel("Enter Name");
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblDifficulty = new JLabel("Difficulty");
		JButton btnBeginner = new JButton("Beginner-1  ");
		btnBeginner.addActionListener(new DiffListener());
		JButton btnEasy = new JButton("Easy-2        ");
		btnEasy.addActionListener(new DiffListener());
		JButton btnNormal = new JButton("Normal-3    ");
		btnNormal.addActionListener(new DiffListener());
		JButton btnHard = new JButton("Hard-4       ");
		btnHard.addActionListener(new DiffListener());
		JButton btnImpossib = new JButton("Impossible-5");
		btnImpossib.addActionListener(new DiffListener());
		btnStart = new JButton("START");
		
		//Chunk of groupLayout codes
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addComponent(lblYoungSailorStart))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(60)
									.addComponent(lblEnterName))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(28)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addComponent(btnStart)))
							.addGap(112)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnEasy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBeginner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNormal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnHard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnImpossib))))
					.addGap(53))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(lblDifficulty)
					.addGap(96))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblYoungSailorStart)
					.addGap(18)
					.addComponent(lblDifficulty)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnterName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBeginner)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEasy)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNormal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHard)
						.addComponent(btnStart))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnImpossib)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//groupLayout codes end
	}
	
	public int getDifficulty(){
	   return difficulty;
	}
	   
	  
	   
	public String getPlayerName(){
		return playerName;
	}
	   
	public void setbtnStartActionListener(ActionListener al){
		btnStart.addActionListener(al);
	}
	   
	public String getName(){
		return textField.getText();
	}
	   
	private class DiffListener implements ActionListener{
		   private String diffString;
		   public void actionPerformed(ActionEvent e){
			   diffString=e.getActionCommand();
			   
			   if(diffString=="Beginner"){
				   difficulty =1;
			   }else if(diffString=="Easy"){
				   difficulty=2;
			   }else if(diffString=="Normal"){
				   difficulty=3;
			   }else if(diffString=="Hard"){
				   difficulty=4;
			   }else{
				   difficulty=5;
			   }
		   }
	   }
}
