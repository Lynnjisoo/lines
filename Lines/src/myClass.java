import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myClass extends JPanel {
	
	public myClass() {
		super();
		//New colors - pass RGBA 0 ~ 255
		//Color myColor = new Color(255, 255, 255, 100);
		setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		g2.setColor(Color.WHITE);
		
		for(int x = 0; x < 1280; x += 10) {
			g2.drawLine(x,  0,  640,  773);
		}
	}
	
	
	
	public void setupDisplay() {
		JFrame application = new JFrame();
		application.add(this);
		application.setSize(1280, 773);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		
		Dimension size = application.getSize();
		System.out.println(size.getWidth() + ", " + size.getHeight());
	}
	
	
	public static void main(String[] ARGS) {
		myClass program = new myClass();
		program.setupDisplay();
		
		program.repaint();
	}
	

}
