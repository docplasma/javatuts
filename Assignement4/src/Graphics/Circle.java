package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle {

	private int diameter;
	private int x;
	private int y;
	private Color color;
	private int xVelocity;
	private int yVelocity;
	Random rand;
	
	Circle() {
		
		Random rand = new Random();
		diameter = rand.nextInt(4)*2;
		x = rand.nextInt(500);
		y = rand.nextInt(500);
		color = ColorPicker.getColor(rand.nextInt(100));
		xVelocity = rand.nextInt(5);
		yVelocity = rand.nextInt(5);
	}
	
	//-----Methods
	public void draw (Graphics page) {
		page.setColor(color);
		page.fillOval(x, y, diameter, diameter);
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

	public int getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

}
