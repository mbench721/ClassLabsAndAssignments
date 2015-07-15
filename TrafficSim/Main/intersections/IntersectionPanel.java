package intersections;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class IntersectionPanel extends JInternalFrame implements MouseListener {
	private Dimension dimension = new Dimension(150,125);
	private Dimension maxSize = new Dimension(500,500);
	public IntersectionPanel(){
		
		setBackground(Color.GREEN);
		setPreferredSize(dimension);
		
		pack();
		
		
		setVisible(true);
		
		
	}
	

		@Override
		public void mouseClicked(MouseEvent e) {
			this.setSize(maxSize);
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	

}
