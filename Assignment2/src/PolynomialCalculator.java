import java.util.ArrayList;

public class PolynomialCalculator {

	public static void main(String[] args) {
		
		final int MAX_ASSIGNMENT_SIZE = 9;
		
		ArrayList<Polynomial> expression1 = new ArrayList<Polynomial>(MAX_ASSIGNMENT_SIZE);
		ArrayList<Polynomial> expression2 = new ArrayList<Polynomial>(MAX_ASSIGNMENT_SIZE);
		
		PolynomialMath polymath = new PolynomialMath();
		
		expression1.add(0, new Polynomial(polymath.getRandomNum(),1));
		expression1.add(1, new Polynomial(polymath.getRandomNum(),1));
		
		expression2.add(0, new Polynomial(polymath.getRandomNum(),1));
		expression2.add(1, new Polynomial(polymath.getRandomNum(),1));
		
		polymath.display(polymath.multiplyExpressions(expression1, expression2));
		
	}
}
