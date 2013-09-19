import java.util.Random;


public class PolynomialMath {

	PolynomialMath() {
		
	}
	
	public int getRandomNum() {
		Random rand = new Random();
		int num =0;
		
		while (num == 0) {
			num = rand.nextInt(18)-9;
		}
		return num;
	}
	
}
