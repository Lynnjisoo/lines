import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rectangle extends JPanel {
	
	public Rectangle() {
		super();
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(10.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		
		g2.setColor(Color.PINK);
		Rectangle2D r = new Rectangle2D.Double(350, 150, 400, 400);
		g2.fill(r);
		g2.setColor(Color.BLACK);

		//EYES
		Rectangle2D r4 = new Rectangle2D.Double(500, 350, 30, 30);
		Color white = new Color (2, 2, 5);
		g2.fill(r4);

		Rectangle2D r5 = new Rectangle2D.Double(600, 350, 30, 30);
		g2.fill(r5);
		
		//MOUTH
		Rectangle2D r6 = new Rectangle2D.Double(548, 397, 78, 78);
		g2.fill(r6);
		
		//EYEBROWS
		Rectangle2D r7 = new Rectangle2D.Double(450, 300, 60, 15);
		g2.setColor(Color.BLACK);
		g2.fill(r7);
		Rectangle2D r8 = new Rectangle2D.Double(600, 300, 60, 15);
		g2.fill(r8);
		g2.drawLine(500, 450, 550, 400);
		g2.drawLine(500, 520, 550, 470);
		g2.drawLine(580, 510, 620, 470);

		/*//!
		Rectangle2D r9 = new Rectangle2D.Double(900, 100, 50, 300);
		g2.fill(r9);
		
		Rectangle2D r10 = new Rectangle2D.Double(900, 450, 50, 50);
		g2.fill(r10); */
		
		//legs
		g2.setColor(Color.PINK);
		g2.drawLine(200, 200, 320, 470);
		g2.setColor(Color.PINK);
		g2.drawLine(780, 470, 880, 200);
		g2.setColor(Color.PINK);
		g2.drawLine(320, 470, 320, 370);
		
		g2.setColor(Color.PINK);
		g2.drawLine(200, 200, 320, 370);
		g2.setColor(Color.PINK);
		g2.drawLine(780, 370, 880, 200);
		g2.drawLine(780, 370, 780, 470);
		


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
		Rectangle program = new Rectangle();
		program.setupDisplay();
		
		program.repaint();
	}
	

}
