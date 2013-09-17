import static java.lang.System.out;

public class PolynomialCalculator {

	public static void main(String[] args) {
		
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
		k=0;
		for (int j=0;j<sizeOfExpressions;j++) {
			for (int i=0; i<sizeOfExpressions; i++) {
				temp[0] = new Polynomial();
				temp[0].setCoefficient(1);//expression1[j].getCoefficient() * expression2[i].getCoefficient());
				temp[0].setExponent(1);//expression1[j].getExponent() + expression2[i].getExponent());
				k++; //Increments temp to hold the next polynomial
			}
		}
		
		k=0;
		Polynomial[] buffer = new Polynomial[k+1];
		for (int j=0; j<sizeOfExpressions; j++) {
			for(int i=0; i<sizeOfExpressions; i++) {
				if (temp[j].getExponent() == temp[i].getExponent()) {
					buffer[k].setCoefficient(buffer[k].getCoefficient()+temp[k].getCoefficient());
				}
			}
			k++;
		}
		
		
		for (int i=0; i<result.length;i++) {
			out.print(result[i].getCoefficient());
			out.print(result[i].getCharacter());
			out.print("^");
			out.print(result[i].getExponent());
			if (i != result.length-1) {
				out.print(" + ");
			}
		}
		
	}

}
