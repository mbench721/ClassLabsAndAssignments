package TrafficMain;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetupPanel extends JPanel {

	private JTextField ctypehere = new JTextField("",5);
	private JTextField ttypehere = new JTextField("",5);
	private JLabel carSelect = new JLabel("Rate of Car create?: ");
	private JLabel timeSelect = new JLabel("How long to run?: ");
	public static String carTime = null;
	public static String runTime = null;
	private JCheckBox red = new JCheckBox("Red Cars");
	private JCheckBox blue = new JCheckBox("Blue Cars");
	private JCheckBox yellow = new JCheckBox("Yellow Cars");
	private JCheckBox purple = new JCheckBox("Purple Cars");
	public boolean redTrue = false, blueTrue = false, purpleTrue = false,yellowTrue = false;
	public CheckBoxListener maaa = new CheckBoxListener();

	public SetupPanel(){

		ButtonListener meh = new ButtonListener();

		this.setLayout(new FlowLayout());
		this.add(carSelect);
		this.add(ctypehere);
		this.add(timeSelect);
		this.add(ttypehere);
		this.add(red);
		this.add(blue);
		this.add(yellow);
		this.add(purple);
		ctypehere.addActionListener(meh);
		ttypehere.addActionListener(meh);
		this.setBackground(Color.CYAN);
		this.setPreferredSize(new Dimension (200,40));

	}
	//61 acts per second
	private class CheckBoxListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e){

		}
	}
	private class ButtonListener implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {

			FileWriter outputStream = null;
			try {
				if(red.isSelected()){
					redTrue = true;

				}
				if(blue.isSelected()){
					blueTrue = true;
				}
				if(yellow.isSelected()){
					yellowTrue = true;
				}
				if(purple.isSelected()){
					purpleTrue = true;
				}
				outputStream = new FileWriter("Setup.txt");
				outputStream.write(ctypehere.getText()  + "\015");
				outputStream.write(ttypehere.getText() + "\015");



			} catch (IOException i) {

				i.printStackTrace();
			}

			finally{
				if(outputStream != null){
					try {
						outputStream.close();
					} catch (IOException i) {

						i.printStackTrace();
					}
				}
			}

			ctypehere.setText("");
			ttypehere.setText("");
		}
	}

}


