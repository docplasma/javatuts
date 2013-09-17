
public class PolynomialCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial[] expression1 = new Polynomial[2];
		Polynomial[] expression2 = new Polynomial[2];
		Polynomial[] result = new Polynomial[4];

		expression1[0] = new Polynomial(1,1);
		expression1[1] = new Polynomial(1,0);
		
		expression2[0] = new Polynomial(1,1);
		expression2[1] = new Polynomial(1,0);
		
		
		
		int sizeOfExpressions = expression1.length + expression2.length;// Size of the result array, needs to be dynamically sized
		int k = 10;//Index of the result
		Polynomial temp[] = new Polynomial[k];
		for (int j=0;j<sizeOfExpressions;j++) {
			for (int i=0; i<sizeOfExpressions; i++) {
				temp[k] = new Polynomial();
				temp[k].setCoefficient(expression1[j].getCoefficient() * expression2[i].getCoefficient());
				temp[k].setExponent(expression1[j].getExponent() + expression2[i].getExponent());
				k++; //Increments temp to hold the next polynomial
			}
		}
		
		
	}

}
