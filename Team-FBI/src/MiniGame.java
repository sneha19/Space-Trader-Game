import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


public class MiniGame extends JPanel {
	private JTextField txtWager;
	private Player player;
	private int mul=1;
	private String myMove;
	private String AIMove;
	private JButton btnPlay;
	private int wager=0;
	private JFrame frame;
	
	
	
	public MiniGame(Player player) {
		this.player=player;
		
		
		
		
		setLayout(new MigLayout("", "[][][][][][][][][][][grow][][][][]", "[][][][][][][][][][][][]"));
		
		JLabel lblGalaxyCasino = new JLabel("Galaxy Casino");
		lblGalaxyCasino.setForeground(Color.WHITE);
		add(lblGalaxyCasino, "cell 3 1");
		
		JLabel lblEnter = new JLabel("Enter your wager:");
		lblEnter.setForeground(Color.WHITE);
		lblEnter.setBackground(Color.BLACK);
		add(lblEnter, "cell 1 3");
		
		txtWager = new JTextField();
		txtWager.setForeground(Color.WHITE);
		txtWager.setBackground(Color.BLACK);
		add(txtWager, "cell 3 3,growx");
		txtWager.setColumns(10);
		
		JLabel lblChooseMultiplifier = new JLabel("Choose multiplier:");
		lblChooseMultiplifier.setForeground(Color.WHITE);
		add(lblChooseMultiplifier, "cell 1 4");
		
		JButton btnx_3 = new JButton("1X");
		add(btnx_3, "flowx,cell 3 4");
		
		JButton btnx = new JButton("5X");
		add(btnx, "cell 3 4");
		
		JButton btnx_1 = new JButton("10X");
		add(btnx_1, "cell 3 4");
		
		JLabel lblYourGuess = new JLabel("Your move:");
		lblYourGuess.setForeground(Color.WHITE);
		add(lblYourGuess, "flowy,cell 1 5");
		
		JButton btnPaper = new JButton("Paper");
		add(btnPaper, "flowx,cell 3 5");
		
		JButton btnRock = new JButton("Rock");
		add(btnRock, "cell 3 5");
		
		JButton btnNewButton = new JButton("Scissors");
		add(btnNewButton, "cell 3 5");
		
		JButton btnx_2 = new JButton("15X");
		add(btnx_2, "cell 3 4");
		
		btnx_3.addActionListener(new MulListener());
		btnx.addActionListener(new MulListener());
		btnx_1.addActionListener(new MulListener());
		btnx_2.addActionListener(new MulListener());
		btnPaper.addActionListener(new MoveListener());
		btnRock.addActionListener(new MoveListener());
		btnNewButton.addActionListener(new MoveListener());
		
		
		btnPlay = new JButton("Play");
		add(btnPlay, "cell 3 11");
		btnPlay.setEnabled(false);
		btnPlay.addActionListener(new PlayListener());
		
		frame = new JFrame("casino");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		final Image bg = new ImageIcon("img/bricks.jpg").getImage();
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	
	private class MulListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("1X")){
				mul=1;
			}else if(e.getActionCommand().equals("5X")){
				mul=5;
			}else if(e.getActionCommand().equals("10X")){
				mul=10;
			}else if(e.getActionCommand().equals("15X")){
				mul=15;
			}	
			System.out.print(mul);
		}
	}
	
	private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Rock")){
				myMove="Rock";
			}else if(e.getActionCommand().equals("Paper")){
				myMove="Paper";
			}else if(e.getActionCommand().equals("Scissors")){
				myMove="Scissors";
			}	
			btnPlay.setEnabled(true);
			System.out.print(myMove);
		}
	}
	
	private class PlayListener implements ActionListener{
		int money;
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			int i = rand.nextInt(3);
			if(i==0){
				AIMove="Rock";
			}else if(i==1){
				AIMove="Paper";
			}else if(i==2){
				AIMove="Scissors";
			}
			System.out.print(AIMove);
			
			
			wager=Integer.parseInt(txtWager.getText());
			
			
			System.out.print(wager);
			
			money = wager*mul;
			
			if(myMove.equals("Rock")&&AIMove.equals("Scissors")){
				player.setCash(money);
				show();
			}else if(myMove.equals("paper")&&AIMove.equals("Rock")){
				player.setCash(money);
				show();
			}else if(myMove.equals("Scissors")&&AIMove.equals("Paper")){
				player.setCash(money);
				show();
			}else if(myMove.equals("Rock")&&AIMove.equals("Paper")){
				player.setCash(-money);
				show2();
			}else if(myMove.equals("Paper")&&AIMove.equals("Scissors")){
				player.setCash(-money);
				show2();
			}else if(myMove.equals("Scissors")&&AIMove.equals("Rock")){
				player.setCash(-money);
				show2();
			}else{
				show3();
			}
		}
		
		public void show(){
			JOptionPane.showMessageDialog(null, "You Win $"+money+"!");
				frame.dispose();
			
		}
		public void show2(){
			JOptionPane.showMessageDialog(null, "You lose $"+money+"!");
			frame.dispose();
		}
		public void show3(){
			JOptionPane.showMessageDialog(null, "Same move, try again!");
		}
		
	}
}
