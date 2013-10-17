package Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class CircleFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Circle circle1;
	private Circle circle2;
	private Circle circle3;
	private Circle circle4;
	private Circle circle5;
	
	public CircleFrame() {
	}
	
	public CircleFrame(String title, Circle circle1, Circle circle2, Circle circle3, Circle circle4, Circle circle5) {
		super(title);
		this.circle1 = circle1;
		this.circle2 = circle2;
		this.circle3 = circle3;
		this.circle4 = circle4;
		this.circle5 = circle5;

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(circle1.getColor());
		g2d.fill(circle1.getCircle());
				
		g2d.setColor(circle2.getColor());
		g2d.fill(circle2.getCircle());
		
		g2d.setColor(circle3.getColor());
		g2d.fill(circle3.getCircle());
		
		g2d.setColor(circle4.getColor());
		g2d.fill(circle4.getCircle());
		
		g2d.setColor(circle5.getColor());
		g2d.fill(circle5.getCircle());
	}	
}
