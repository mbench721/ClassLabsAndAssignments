package TrafficMain;

import java.awt.Dimension;

import javax.swing.JFrame;

public class BeginStats {
	SetupPanel panel;
	
	public BeginStats(){
		
		JFrame begin = new JFrame("Setup");
		begin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.panel = new SetupPanel();
		begin.getContentPane().add(panel);
		Dimension d = new Dimension(250,200);
		begin.setPreferredSize(d);
		begin.pack();
		begin.setLocation(1100, 10);
		begin.setVisible(true);
	}

}
