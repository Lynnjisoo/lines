import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Art extends JPanel {
	
	public Art() {
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
		
		g2.drawLine(400, 250, 400, 650);
		g2.drawLine(800, 250, 800, 650);
		g2.drawLine(400, 250, 800, 250);
		g2.drawLine(400, 650, 800, 650);

		g2.drawLine(400, 250, 550, 100);
		g2.drawLine(800, 250, 950, 100);
		g2.drawLine(800, 650, 950, 500);

		g2.drawLine(550, 100, 950, 100);
		g2.drawLine(950, 100, 950, 500);

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
		Art program = new Art();
		program.setupDisplay();
		
		program.repaint();
	}
	

}

