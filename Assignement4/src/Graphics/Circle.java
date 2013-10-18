package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JPanel;

public class Circle extends JPanel {

	//-----Data Members
	private int diameter;
	private AtomicInteger x;
	private AtomicInteger y;
	private Color color;
	private AtomicInteger xVelocity;
	private AtomicInteger yVelocity;
	Random rand;
	
	//-----Constructors
	public Circle() {
		
		Random rand = new Random();
		diameter = rand.nextInt(4)*2;
		x.set(rand.nextInt(500));
		y.set(rand.nextInt(500));
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity.set(rand.nextInt(20));
		yVelocity.set(rand.nextInt(20));
				
	}
	
	//This is the constructors that is used in this assignment
	public Circle(int xLimit, int yLimit) {
		
		Random rand = new Random();
		
		//Data is initialized
		x = new AtomicInteger();
		y = new AtomicInteger();
		xVelocity = new AtomicInteger();
		yVelocity = new AtomicInteger();
		
		//Diameter is set based on the size of the panel
		diameter = rand.nextInt((int)Math.floor(xLimit * yLimit * 0.0001))+10;
		
		//Position is set, but not outside the borders of the panel
		x.set(rand.nextInt(xLimit-diameter));
		y.set(rand.nextInt(yLimit-diameter));
		
		//Color is randomly retrieved based of the input of a random number
		color = ColorPicker.getColor(rand.nextInt(100));
		
		//Velocity is set from a range of -10px to 10px per iteration
		xVelocity.set(rand.nextInt(20)-10);
		yVelocity.set(rand.nextInt(20)-10);
				
	}
	
	//-----Methods
	
	//This method checks if the ball is out of bounds of the panel
	//--If it is out of bounds, then it inverts the velocity and reflects the position off the edge of the panel
	private boolean positionOutOfBounds(AtomicInteger pos, AtomicInteger velocity,  int start, int end) {
		
		if (pos.get() < start) {
			pos.set(start - pos.get()) ;
			velocity.set(velocity.get() * -1);
			return true;
		}
		else if (pos.get() + diameter > end) {
			pos.set(pos.get() + end - (pos.get() + diameter));
			velocity.set(velocity.get() * -1);
			return true;
		}
		
		return false;
	}
	
	//This method is called to change the position of the ball based on its velocity
	//--It then calls positionOutOfBounds to check if it is outside the panel
	public void updatePosition(int xStart, int xEnd, int yStart, int yEnd) {
		
		x.set(x.get() + xVelocity.get());
		y.set(y.get() + yVelocity.get());
		
		if (positionOutOfBounds(x, xVelocity, xStart, xEnd)) {
			this.color = ColorPicker.getColor(new Random().nextInt(100));
		}
		if (positionOutOfBounds(y, yVelocity, yStart, yEnd)) {
			this.color = ColorPicker.getColor(new Random().nextInt(100));
		}
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
	
	public String toString() {
		return "xVelocity: " + getXVelocity() + " yVelocity: "  + getYVelocity() + " Position: (" + getX() + "," + getY() + ") " + " Diameter: " +  getDiameter() ;
	}
}
