import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
/**
 * This is a GUI that shows the start screen
 * @author Guang Lu
 *
 */
public class Start extends JPanel {
	private JTextField textField;
	private String playerName;
	private int difficulty;
	private JButton btnStart;
	private boolean isDiffed;
	private JButton btnContinue;
	/**
	 * constructor
	 */
	public Start() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblYoungSailorStart = new JLabel("Young sailor, start your journey here!");
		lblYoungSailorStart.setForeground(new Color(255, 255, 255));
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setForeground(new Color(255, 255, 255));
		isDiffed = false;
		setLayout(new MigLayout("", "[134px][][112px][113px]", "[16px][16px][][][16px][][][][12px][][1px][][][6px][29px][29px][29px][29px]"));
		add(lblYoungSailorStart, "cell 0 0 4 1,alignx center,aligny top");
		JButton btnBeginner = new JButton("Beginner");
		btnBeginner.addActionListener(new DiffListener());
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setForeground(new Color(255, 255, 255));
		add(lblEnterName, "cell 0 1,alignx center,aligny top");
		textField = new JTextField();
		textField.setColumns(10);
		add(textField, "cell 0 2 2 1,alignx left,aligny top");
		add(btnBeginner, "flowy,cell 3 2,growx,aligny top");
		add(lblDifficulty, "cell 3 1,alignx left,aligny top");
		JButton btnEasy = new JButton("Easy");
		btnEasy.addActionListener(new DiffListener());
		add(btnEasy, "cell 3 2,growx,aligny top");
		JButton btnNormal = new JButton("Normal");
		btnNormal.addActionListener(new DiffListener());
		add(btnNormal, "cell 3 2,growx,aligny top");
		JButton btnHard = new JButton("Hard");
		btnHard.addActionListener(new DiffListener());
		add(btnHard, "cell 3 2,growx,aligny top");
		JButton btnImpossib = new JButton("Impossible");
		btnImpossib.addActionListener(new DiffListener());
		add(btnImpossib, "cell 3 2,alignx left,aligny top");
		btnStart = new JButton("START");
		add(btnStart, "cell 1 6,alignx center,aligny top");
		
		btnContinue = new JButton("CONTINUE");
		add(btnContinue, "cell 2 6");
		//groupLayout codes end
	}
	/**
	 * getter, get the difficulty
	 * @return difficulty
	 */
	public int getDifficulty(){
	   return difficulty;
	}
	   
	  
	/**
	 * getter, get the player name   
	 * @return playerName
	 */
	public String getPlayerName(){
		return playerName;
	}
	/**
	 * setter, set the action listener for two buttons  
	 * @param startListener
	 * @param continueListener
	 */
	public void setbtnActionListener(ActionListener startListener,ActionListener continueListener){
		btnStart.addActionListener(startListener);
		btnContinue.addActionListener(continueListener);
	}
	/**
	 * getter, get the name of the player
	 * @return name of the player   
	 */
	public String getName(){
		return textField.getText();
	}
	/**
	 * check if difficulty is selected
	 * @return whether the difficulty is selected
	 */
	public boolean isDiffed(){
		return isDiffed;
	}
	/**
	 * Private class, a button listener
	 * @author Guang Lu
	 *
	 */
	private class DiffListener implements ActionListener{
		   private String diffString;
		   /**
		    * implemented method
		    * @param e ActionEvent
		    */
		   public void actionPerformed(ActionEvent e){
			   diffString=e.getActionCommand();
			   System.out.println(diffString);
			   
			   if(diffString.equals("Beginner")){
				   difficulty =1;
				   isDiffed = true;
			   }else if(diffString.equals("Easy")){
				   difficulty=2;
				   isDiffed=true;
			   }else if(diffString.equals("Normal")){
				   difficulty=3;
				   isDiffed=true;
			   }else if(diffString.equals("Hard")){
				   difficulty=4;
				   isDiffed=true;
			   }else if(diffString.equals("Impossible")){
				   difficulty=5;
				   isDiffed=true;
			   }
		   }
	   }
	/**
	 * draw the background
	 * @param g a Graphics instance
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/bg.jpg").getImage();
		g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
	}
}
