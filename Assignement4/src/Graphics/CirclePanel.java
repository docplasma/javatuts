package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {

	//-----Data Members
	private static final long serialVersionUID = 1L;
	private ArrayList<Circle> circles;
	
	//-----Constructors
	public CirclePanel(ArrayList<Circle> circles, int width, int height) {
		this.setPreferredSize(new Dimension(width, height));
		this.circles = circles;
	}
	
	//JPanel's paint() is overridden to color and fill circles based off of each circle in the array
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i=0; i < circles.size(); i++) {
			g2d.setColor(circles.get(i).getColor());
			g2d.fillOval(circles.get(i).getX(), circles.get(i).getY(), circles.get(i).getDiameter(), circles.get(i).getDiameter());
		}
	}	
}
