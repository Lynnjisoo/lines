import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Name extends JPanel {
	
	public Name() {
		super();
		setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(15.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		g2.setColor(Color.WHITE);
		
		//L
		g2.drawLine(100,  100,  100,  500);	
		g2.drawLine(100,  500,  250,  500);
		//Y
		g2.drawLine(400,  250,  400,  500);	
		g2.drawLine(300, 100, 400, 250);
		g2.drawLine(500, 100, 400, 250);
		//N
		g2.drawLine(600,  100,  600,  500);	
		g2.drawLine(600, 100, 750, 500);
		g2.drawLine(750,  100,  750,  500);	
		//N
		g2.drawLine(850,  100,  850,  500);	
		g2.drawLine(850, 100, 1000, 500);
		g2.drawLine(1000,  100,  1000,  500);	

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
		Name program = new Name();
		program.setupDisplay();
		
		program.repaint();
	}
	

}
