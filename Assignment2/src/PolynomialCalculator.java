import java.util.ArrayList;

public class PolynomialCalculator {

	public static void main(String[] args) {
		
		//Initializes constant for the maximum amount of polynomials per expression
		final int MAX_ASSIGNMENT_SIZE = 9;
		
		//Initializes two ArrayLists to hold two polynomial expressions to multiply
		ArrayList<Polynomial> expression1 = new ArrayList<Polynomial>(MAX_ASSIGNMENT_SIZE);
		ArrayList<Polynomial> expression2 = new ArrayList<Polynomial>(MAX_ASSIGNMENT_SIZE);
		
		//Creates a new math object to perform the display and multiplication of the ArrayList expressions
		PolynomialMath polymath = new PolynomialMath();
		
		//Adds a new Polynomial to the first expression using a random number from -9 to 9 *Note, 0 is discarded since a coefficient of zero is simply zero
		expression1.add(0, new Polynomial(polymath.getRandomNum(),1));
		expression1.add(1, new Polynomial(polymath.getRandomNum(),0));
		
		//Same as above but for the second expression
		expression2.add(0, new Polynomial(polymath.getRandomNum(),1));
		expression2.add(1, new Polynomial(polymath.getRandomNum(),0));
		
		//Calls the display function using the returned ArrayList from the nested multiplyExpressions()
		polymath.display(polymath.multiplyExpressions(expression1, expression2));
		
	}
}
