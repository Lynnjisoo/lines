import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Block {
	private Rectangle2D rectangle;
	private Color color;
	private Motion motion;
	
	public Block(Rectangle2D r, Color c, Motion m) {
		this.rectangle = r;
		this.color = c;
		this.setMotion(m);
	}
	
	public Rectangle2D getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle2D rectangle) {
		this.rectangle = rectangle;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public Motion getMotion() {
		return motion;
	}

	public void setMotion(Motion motion) {
		this.motion = motion;
	}

}
