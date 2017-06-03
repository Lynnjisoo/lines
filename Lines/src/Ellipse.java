import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ellipse extends JPanel {
	public static final long serialVersionUID = 1L;
	public static Dimension size;
	
	public void setupDisplay() {
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(this);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(20.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		
		Ellipse2D full = new Ellipse2D.Double(0, 0, size.getWidth(), size.getHeight());
		Rectangle2D fullr = full.getBounds2D();
		/*g2.draw(fullr); 
		g2.fill(full);*/
		


		Point2D[] starPoints = new Point2D[5];
		
		for(int i = 0; i < starPoints.length; i++) {
			starPoints[i] = new Point2D.Double(full.getX() + full.getWidth() / 2
					+ Math.cos(Math.toRadians(i*72))
					, full.getY() + full.getWidth() / 2 * Math.sin(Math.toRadians(i*72)));
		

			//코 
			
			g2.setColor(Color.BLACK); 
			Ellipse2D candy9 = new Ellipse2D.Double(505, 445, 110, 110);
			g2.fill(candy9);
			
			g2.setColor(Color.YELLOW);
			Ellipse2D candy10 = new Ellipse2D.Double(523, 460, 75, 75);
			g2.fill(candy10);
			

			Rectangle2D r1 = new Rectangle2D.Double(500, 405, 300, 100);
			g2.setColor(Color.YELLOW);
			g2.fill(r1);
			
			g2.setColor(Color.BLACK); 
			Ellipse2D candy11 = new Ellipse2D.Double(505, 495, 19, 19);
			g2.fill(candy11);
			

			
			g2.setColor(Color.BLACK); 
			Ellipse2D candy12 = new Ellipse2D.Double(605, 445, 110, 110);
			g2.fill(candy12);
			
			g2.setColor(Color.YELLOW);
			Ellipse2D candy13 = new Ellipse2D.Double(623, 460, 75, 75);
			g2.fill(candy13);
			
			Rectangle2D r2 = new Rectangle2D.Double(600, 405, 300, 100);
			g2.setColor(Color.YELLOW);
			g2.fill(r2);
			
			g2.setColor(Color.BLACK); 
			Ellipse2D candy14 = new Ellipse2D.Double(697, 496, 18, 18);
			g2.fill(candy14);
			
			g2.setColor(Color.BLACK);
			Ellipse2D candy8 = new Ellipse2D.Double(575, 448, 70, 70);
			g2.fill(candy8);		
			
			
			//eyes
			g2.setColor(Color.BLACK);
			Ellipse2D candy = new Ellipse2D.Double(400, 300, 170, 170);
			g2.fill(candy);
			
			Ellipse2D candy1 = new Ellipse2D.Double(675, 300, 170, 170);
			g2.fill(candy1);	
			
			g2.setColor(Color.WHITE);
			Ellipse2D candy2 = new Ellipse2D.Double(425, 340, 50, 50);
			g2.fill(candy2);	
			Ellipse2D candy3 = new Ellipse2D.Double(494, 345, 45, 45);
			g2.fill(candy3);	
			Ellipse2D candy4 = new Ellipse2D.Double(463, 400, 35, 35);
			g2.fill(candy4);	
			
			g2.setColor(Color.WHITE);
			Ellipse2D candy5 = new Ellipse2D.Double(705, 340, 50, 50);
			g2.fill(candy5);	
			Ellipse2D candy6 = new Ellipse2D.Double(774, 345, 45, 45);
			g2.fill(candy6);	
			Ellipse2D candy7 = new Ellipse2D.Double(748, 400, 35, 35);
			g2.fill(candy7);	
			
			g2.setColor(Color.BLACK);
			g2.drawLine(420, 300, 450, 330);
			g2.drawLine(480, 280, 480, 300);
			g2.drawLine(510, 330, 540, 300);
			
			g2.drawLine(700, 300, 730, 330);
			g2.drawLine(760, 280, 760, 300);
			g2.drawLine(790, 330, 820, 300);
			
		}
		

	}
	
	
	public Ellipse() {
		super();
		setBackground(Color.YELLOW);
	}
	public static void main(String[] ARGS) {
		Ellipse program = new Ellipse();
		program.setupDisplay();
		
		program.repaint();
	}
	

}
