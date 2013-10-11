package Graphics;

import java.awt.Color;
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
	public void draw (color) {
		page.set
	}

}
