import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * This is a GUI that give the option to user to choose a slot to save
 * @author Guang Lu
 *
 */
public class SaveLoadPanel extends JPanel {
	private String title;
	private String btnName;
	private String info1="";
	private String info2="";
	private String info3="";
	private JButton btnSave1;
	private JButton btnSave2;
	private JButton btnSave3;
	private JFrame frame;
	private int slSwitch;
	private JLabel lblSave1;
	private JLabel lblSave2;
	private JLabel lblSave3;
	/**
	 * constructor
	 * @param i
	 */
	public SaveLoadPanel(int i) {
		slSwitch =i;
		if(i==0){
			title = "Please choose a slot to save!";
			btnName = "Save";
		}else{
			title = "Please choose a slot to load!";
			btnName = "Load";
		}
		
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		noFile();
		
		setLayout(new MigLayout("", "[][][][][][][]", "[][][][][][][]"));
		
		JLabel lblTitle = new JLabel(title);
		add(lblTitle, "cell 2 0");
		lblTitle.setForeground(Color.WHITE);
		
		lblSave1 = new JLabel(info1);
		add(lblSave1, "cell 2 2");
		lblSave1.setForeground(Color.WHITE);
		
		btnSave1 = new JButton(btnName+1);
		add(btnSave1, "cell 6 2");
		
		lblSave2 = new JLabel(info2);
		add(lblSave2, "cell 2 4");
		lblSave2.setForeground(Color.WHITE);
		
		btnSave2 = new JButton(btnName+2);
		add(btnSave2, "cell 6 4");
		
		lblSave3 = new JLabel(info3);
		add(lblSave3, "cell 2 6");
		lblSave3.setForeground(Color.WHITE);
		
		btnSave3 = new JButton(btnName+3);
		add(btnSave3, "cell 6 6");
		
		btnSave1.addActionListener(new BtnListener());
		btnSave2.addActionListener(new BtnListener());
		btnSave3.addActionListener(new BtnListener());
		
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
	/**
	 * Read the saved info from source file
	 * @throws IOException
	 */
	public void readFile() throws IOException
	{
		File file = new File("src/save1.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()){
			info1=scan.nextLine();
		}
		
			
		file = new File("src/save2.txt");
		scan = new Scanner(file);
		while (scan.hasNextLine()){
			info2=scan.nextLine();
		}
		
			
		file = new File("src/save3.txt");
		scan = new Scanner(file);
		while (scan.hasNextLine()){
			info3=scan.nextLine();
		}
			
			
	}
	/**
	 * make no-data strings
	 */
	public void noFile(){
		if(info1.equals("")){
			info1="No Data";
		}
		if(info2.equals("")){
			info2="No Data";
		}
		if(info3.equals("")){
			info3="No Data";
		}
	}
	/**
	 * Setter, set button listener to the save/load button
	 * @param a
	 */
	public void setButtonListener(ActionListener a){
		btnSave1.addActionListener(a);
		btnSave2.addActionListener(a);
		btnSave3.addActionListener(a);
	}
	/**
	 * private class implements ActionListener, make sure the GUI will dispose when button is clicked
	 * @author Guang Lu
	 *
	 */
	private class BtnListener implements ActionListener{
		/**
		 * Implemented method
		 * @param e action event
		 */
		public void actionPerformed(ActionEvent e) {
			if(slSwitch==1){
				frame.dispose();
			}else{
				try {
					readFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				lblSave1.setText(info1);
				lblSave2.setText(info2);
				lblSave3.setText(info3);
			}
		}
		
	}
	/**
	 * Draw the backgroud
	 * @param g a Graphics instance
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/spacebackground.gif").getImage();
		g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
	}

}
