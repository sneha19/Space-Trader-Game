
import java.awt.event.ActionListener;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class SettingPanel extends JPanel implements Serializable {
/*	
 * 	
 * 
 * 
 */
	
	
	/**
	 * Create the panel.
	 */
	JButton btnSave;
	JButton btnLoad;
	
	public SettingPanel() {
		setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		btnSave = new JButton("Save");
		
		add(btnSave, "cell 2 3");
		
		btnLoad = new JButton("Load");
		
		add(btnLoad, "cell 2 4");
		
		
		
	}
	
	
	
	public void setSaveListener(ActionListener a){
		btnSave.addActionListener(a);
	}
	
	public void setLoadListener(ActionListener a){
		btnLoad.addActionListener(a);
	}

	
	
	

}