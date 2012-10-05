import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIMain {
	//private Random _rand;
	//public Player_ _unnamed_Player__;
	//public Merchant _unnamed_Merchant_;
	//public Pirate _unnamed_Pirate_;
	//public Police _unnamed_Police_;

	private Player player;
	private Start start;
	private Skills skills;
	private SkillsInterface skillGUI;
	
	
	//GUI stuff
	private JFrame frame;
	public UIMain(){
		start = new Start();
		frame = new JFrame("Star Trader");
		start = new Start();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(start);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args){
		UIMain uiMain = new UIMain();
	}
	
	
	
	
	
	
	/*
	public void interactions(int aParameter) {
		throw new UnsupportedOperationException();
	}

	public void move(Player aPlayer) {
		throw new UnsupportedOperationException();
	}

	public void switchPanel(int aParameter) {
		throw new UnsupportedOperationException();
	}

	public void drawMap() {
		throw new UnsupportedOperationException();
	}

	public boolean checkOverlap() {
		throw new UnsupportedOperationException();
	}

	public void displayPlanetStats() {
		throw new UnsupportedOperationException();
	}

	public void displayPlayerStats() {
		throw new UnsupportedOperationException();
	}

	*/
	
}