import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	}
	
	public Timers() {
		super();
		setBackground(Color.BLACK);
	}
	
	public static void main(String[] ARGS) {
		Timers program = new Timers();
		program.setupGraphics();
		rect = new Rectangle2D.Double(0, 0, 500, 500);
		
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
		
		int max = 800;
		int min = 300;
		if(expanding) {
			rect.setFrame(0, 0, rect.getWidth() + 5, rect.getHeight() + 5);
			if(rect.getWidth() >= max) {expanding = false; }
		} else {
			rect.setFrame(0, 0, rect.getWidth() - 5, rect.getHeight() - 5);
			if(rect.getWidth() <= min) { expanding = true; }
		}
	} 
	
}
