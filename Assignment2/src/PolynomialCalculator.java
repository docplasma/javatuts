import static java.lang.System.out;

import java.util.ArrayList;

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
		int k = 0;//Index of the result
		ArrayList<Polynomial> temp = new ArrayList<Polynomial>(sizeOfExpressions);
		for (int j=0;j<expression1.length;j++) {
			for (int i=0; i<expression2.length; i++) {
				temp.add(k, new Polynomial(0,0));
				temp.get(k).setCoefficient(expression1[j].getCoefficient() * expression2[i].getCoefficient());
				temp.get(k).setExponent(expression1[j].getExponent() + expression2[i].getExponent());
				k++; //Increments temp to hold the next polynomial
			}
		}
		ArrayList<Polynomial> buffer = new ArrayList<Polynomial>(k);
		k=0;
		for (int j=0; j<sizeOfExpressions; j++) {
			buffer.add(k, new Polynomial(0,0));
			for(int i=0; i<sizeOfExpressions; i++) {
				if (temp.get(j).getExponent() == temp.get(i).getExponent()) {
					//if (i==0) {
						//buffer[k].setCoefficient(temp[i].getCoefficient());
					//}
					buffer.get(k).setExponent(temp.get(j).getExponent());
					buffer.get(k).setCoefficient(buffer.get(k).getCoefficient()+temp.get(k).getCoefficient());
					temp.remove(i);
					i--;//The list's index is decremented so the for counter's increment must be offset
				}
			}
			k++;
		}
		
		//result = buffer;
		for (int i=0; i<k/*result.length*/;i++) {
			out.print(buffer.get(i).getCoefficient());
			out.print(buffer.get(i).getCharacter());
			out.print("^");
			out.print(buffer.get(i).getExponent());
			if (i != k/*result.length*/-1) {
				out.print(" + ");
			}
		}
		out.println("\n");
		for (int i=0; i<k/*result.length*/;i++) {
			out.print(buffer.get(i).toString());
			if (i != k/*result.length*/-1) {
				out.print(" + ");
			}
		}
	}

}
