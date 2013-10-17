package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JPanel;

public class Circle extends JPanel {

	private int diameter;
	private AtomicInteger x;
	private AtomicInteger y;
	private Color color;
	private AtomicInteger xVelocity;
	private AtomicInteger yVelocity;
	Random rand;
	
	public Circle() {
		
		Random rand = new Random();
		diameter = rand.nextInt(4)*2;
		x.set(rand.nextInt(500));
		y.set(rand.nextInt(500));
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity.set(rand.nextInt(20));
		yVelocity.set(rand.nextInt(20));
				
	}
	
public Circle(int xLimit, int yLimit) {
		
		Random rand = new Random();
		int scaledDiameter = (int)Math.floor(xLimit * yLimit * 0.001);
		x = new AtomicInteger();
		y = new AtomicInteger();
		xVelocity = new AtomicInteger();
		yVelocity = new AtomicInteger();
		diameter = rand.nextInt(scaledDiameter);
		x.set(rand.nextInt(xLimit));
		y.set(rand.nextInt(yLimit));
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity.set(rand.nextInt(20)-10);
		yVelocity.set(rand.nextInt(20)-10);
				
	}
	
	//-----Methods
	public void draw (Graphics page) {
		page.setColor(color);
		page.fillOval(x.get(), y.get(), diameter, diameter);
	}
	
	private boolean positionOutOfBounds(AtomicInteger pos, AtomicInteger velocity,  int start, int end) {
		
		if (pos.get() - diameter/2 < start) {
			pos.set(start - pos.get()) ;
			velocity.set(velocity.get() * -1);
			System.out.println("The velocity inside bounds is: " + velocity);
			return true;
		}
		else if (pos.get() + diameter/2 > end) {
			pos.set(pos.get() * 2 - end);
			velocity.set(velocity.get() * -1);
			System.out.println("The velocity inside bounds is: " + velocity);
			return true;
		}
		
		return false;
	}
	
	public void updatePosition(int xStart, int xEnd, int yStart, int yEnd) {
		
		x.set(x.get() + xVelocity.get());
		y.set(y.get() + yVelocity.get());
		
		positionOutOfBounds(x, xVelocity, xStart, xEnd);
		System.out.println("The xVelocity outside bounds is: " + xVelocity);
		positionOutOfBounds(y, yVelocity, yStart, yEnd);
		System.out.println("The yVelocity outside bounds is: " + yVelocity);
		
	}

	//-----Getters/Setters
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getX() {
		return x.get();
	}

	public void setX(int x) {
		this.x.set(x);
	}

	public int getY() {
		return y.get();
	}

	public void setY(int y) {
		this.y.set(y);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getXVelocity() {
		return xVelocity.get();
	}

	public void setXVelocity(int xVelocity) {
		this.xVelocity.set(xVelocity);
	}

	public int getYVelocity() {
		return yVelocity.get();
	}

	public void setYVelocity(int yVelocity) {
		this.yVelocity.set(yVelocity);
	}

	public Ellipse2D.Double getCircle() {
		Ellipse2D.Double circle = new Ellipse2D.Double(x.get(), y.get(), diameter, diameter);
		return circle;
	}
	
	public String toString() {
		return "xVelocity: " + getXVelocity() + " yVelocity: "  + getYVelocity() + " Position: (" + getX() + "," + getY() + ")";
	}
}
