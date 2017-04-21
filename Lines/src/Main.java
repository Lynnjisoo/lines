import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel {
	public static final long serialVersionUID = 1L;
	public static Dimension size; 
	public static final int DELAY = 1000 / 60;
	public static ArrayList <Block> blocks = new ArrayList<>();
	public static double meter_pixels;
	
	public void setupGraphics() {
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(this);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true); 
		application.setVisible(true); 
		size = application.getSize();
		meter_pixels = size.getHeight() / 1000;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(10.0f, 
				BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_ROUND));
		
		for(Block b : blocks) {
			g2.setColor(b.getColor());
			g2.fill(b.getRectangle());
		}
		
		for(int a = 0; a < blocks.size() - 2; a++) {
			for(int b = a + 1; b <= blocks.size() - 1; b++) {
			}
		}
	}
	
	public Color mixColors(Color a, Color b) {
		return new Color( 		(a.getRed()   + b.getRed())		/ 2, 
								(a.getGreen() + b.getGreen())	/ 2, 
								(a.getBlue()  + b.getBlue()) 	/ 2, 
								(a.getAlpha() + b.getAlpha()) 	/ 2 );
	}
	
	public Main() {
		super();
		setBackground(Color.BLACK);
	}
	
	public static void recalculate() {
		for(Block b : blocks) {
			Motion 		m = b.getMotion();
			Rectangle2D r = b.getRectangle();
			
			r.setFrame(r.getX() + m.getX(), r.getY() + m.getY(), r.getWidth(), r.getHeight());
			m.addGravity();
		
		}
	}
	
	public static void main(String[] ARGS) {
		Main program = new Main();
		program.setupGraphics();

		blocks.add(new Block( //Create a new block, blocks need rectangle, color, and motion 
				new Rectangle2D.Double(80, 100, 200, 200), 
				Color.PINK, 
				new Motion(5, -10)
				));
		
		blocks.add(new Block(
				new Rectangle2D.Double(700, 150, 200, 200), 
				Color.BLUE, 
				new Motion(10, -5)
				));
	
		
		ActionListener repainter = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				recalculate();
				program.repaint();
			}
		};
		
		Timer paintingTimer = new Timer(DELAY, repainter);
		paintingTimer.start();
	}
}

