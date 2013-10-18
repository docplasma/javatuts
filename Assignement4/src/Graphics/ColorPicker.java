package Graphics;

import java.awt.Color;

public class ColorPicker {

	//-----Constructors
	ColorPicker () {
		
	}
	
	//-----Methods
	
	//Returns a random color based off a random number
	public static Color getColor(int num) {
		Color color = new Color(0);
		num = num % 9;
		if (num == 0) {
			color = Color.black;
		}
		else if (num == 1) {
			color = Color.blue;
		}
		else if (num == 2) {
			color = Color.gray;
		}
		else if (num == 3) {
			color = Color.green;
		}
		else if (num == 4) {
			color = Color.magenta;
		}
		else if (num == 5) {
			color = Color.orange;
		}
		else if (num == 6) {
			color = Color.red;
		}
		else if (num == 7) {
			color = Color.yellow;
		}
		else if (num == 8) {
			color = Color.cyan;
		}
		else {
			color = Color.pink;
		}

		return color;
	}
	
	public String toString() {
		return "This Class provides a static member to select a color from a small pallet of the Color class.";
	}
}

