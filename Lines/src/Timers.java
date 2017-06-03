import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Timers extends JPanel {
	
	public static final long serialVersionUID = 1L;
	public static Dimension size; 
	public static final int DELAY = 1000 / 60;
	public static Rectangle2D rect;
	public static Color rectColor = new Color(0, 0, 0, 255);
	public static boolean colorRising = true; 
	public static boolean expanding = true;
	
	public void setupGraphics() {
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(this);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(10.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		g2.setColor(rectColor);
		g2.fill(rect);
		
		//WATERMELON 
		g2.setColor(Color.BLACK);
		Ellipse2D candy345 = new Ellipse2D.Double(478, 245, 325, 325);
		g2.fill(candy345);
		
		g2.setColor(Color.GREEN);
		Ellipse2D candy2 = new Ellipse2D.Double(470, 240, 320, 320);
		g2.fill(candy2);
		
		g2.setColor(Color.WHITE);
		Ellipse2D candy1 = new Ellipse2D.Double(480, 250, 300, 300);
		g2.fill(candy1);
		
		g2.setColor(Color.RED);
		Ellipse2D candy = new Ellipse2D.Double(490, 260, 280, 280);
		g2.fill(candy);	
		
		g2.setColor(Color.BLACK);
		Ellipse2D candy3 = new Ellipse2D.Double(550, 400, 15, 15);
		g2.fill(candy3);	
		
		g2.setColor(Color.BLACK);
		Ellipse2D candy4 = new Ellipse2D.Double(600, 450, 15, 15);
		g2.fill(candy4);	
		
		
		
		g2.setColor(Color.BLACK);
		Ellipse2D candy5 = new Ellipse2D.Double(650, 380, 15, 15);
		g2.fill(candy5);	

		g2.setColor(Color.BLACK);
		Ellipse2D candy6 = new Ellipse2D.Double(610, 310, 15, 15);
		g2.fill(candy6);	

		g2.setColor(Color.BLACK);
		Ellipse2D candy7 = new Ellipse2D.Double(700, 450, 15, 15);
		g2.fill(candy7);	
	}
	
	public Timers() {
		super();
		setBackground(Color.WHITE);
	}
	
	public static void main(String[] ARGS) {
		Timers program = new Timers();
		program.setupGraphics();
		rect = new Rectangle2D.Double(500, 500, 700, 500);
		
		ActionListener repainter = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				recalculate();
				program.repaint();
			}
		};
		
		Timer paintingTimer = new Timer(DELAY, repainter); 
		paintingTimer.start(); 
	}
	
	public static void recalculate() {
		if(colorRising) {
			rectColor = new Color(rectColor.getRed() + 3, 255 - rectColor.getRed(), 255);
			if(rectColor.getRed() == 255) { colorRising = false; }
		} else {
			rectColor = new Color(rectColor.getRed() - 1, 0, 0, 255);
			if(rectColor.getRed() <= 0) { colorRising = true; }
		}
		
		int max = 1600;
		int min = 1600;
		if(expanding) {
			rect.setFrame(0, 0, rect.getWidth() + 5, rect.getHeight() + 5);
			if(rect.getWidth() >= max) {expanding = false; }
		} else {
			rect.setFrame(0, 0, rect.getWidth() - 5, rect.getHeight() - 5);
			if(rect.getWidth() <= min) { expanding = true; }
		}
	} 
	
}
