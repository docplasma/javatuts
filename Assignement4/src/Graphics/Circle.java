package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;

public class Circle extends JPanel {

	private int diameter;
	private Integer x;
	private Integer y;
	private Color color;
	private Integer xVelocity;
	private Integer yVelocity;
	Random rand;
	
	public Circle() {
		
		Random rand = new Random();
		diameter = rand.nextInt(4)*2;
		x = rand.nextInt(500);
		y = rand.nextInt(500);
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity = rand.nextInt(20);
		yVelocity = rand.nextInt(20);
				
	}
	
public Circle(int xLimit, int yLimit) {
		
		Random rand = new Random();
		int scaledDiameter = (int)Math.floor(xLimit * yLimit * 0.001);
		diameter = rand.nextInt(scaledDiameter);
		x = rand.nextInt(xLimit);
		y = rand.nextInt(yLimit);
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity = rand.nextInt(5);
		yVelocity = rand.nextInt(5);
				
	}
	
	//-----Methods
	public void draw (Graphics page) {
		page.setColor(color);
		page.fillOval(x, y, diameter, diameter);
	}
	
	private boolean positionOutOfBounds(Integer pos, Integer velocity,  int start, int end) {
		
		if (pos - diameter < start) {
			pos = start - pos;
			velocity = velocity * -1;
			return true;
		}
		else if (pos + diameter > end) {
			pos = pos * 2 - end;
			velocity = velocity * -1;
			return true;
		}
		
		return false;
	}
	
	public void updatePosition(int xStart, int xEnd, int yStart, int yEnd) {
		
		x = x + xVelocity;
		
		positionOutOfBounds(x, xVelocity, xStart, xEnd);
		positionOutOfBounds(y, yVelocity, yStart, yEnd);
		
	}

	//-----Getters/Setters
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getXVelocity() {
		return xVelocity;
	}

	public void setXVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getYVelocity() {
		return yVelocity;
	}

	public void setYVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public Ellipse2D.Double getCircle() {
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
		return circle;
	}
}
