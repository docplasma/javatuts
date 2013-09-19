import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;

public class PolynomialCalculator {

	public static void main(String[] args) {
		
		Polynomial[] expression1 = new Polynomial[2];
		Polynomial[] expression2 = new Polynomial[2];
		
		PolynomialMath polymath = new PolynomialMath();
		
		expression1[0] = new Polynomial(polymath.getRandomNum(),1);
		expression1[1] = new Polynomial(polymath.getRandomNum(),0);
		
		expression2[0] = new Polynomial(polymath.getRandomNum(),1);
		expression2[1] = new Polynomial(polymath.getRandomNum(),0);
		
		
		
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

		ArrayList<Polynomial> result = new ArrayList<Polynomial>(k);
		k=0;
		while (!temp.isEmpty()) {
			result.add(k, new Polynomial(temp.get(0).getCoefficient(),temp.get(0).getExponent()));
			temp.remove(0);
			Iterator<Polynomial> iterator = result.iterator();
			for (int i=0;i<temp.size();i++) {
				if (temp.get(i).getExponent() == result.get(k).getExponent()) {
					result.get(k).setCoefficient(result.get(k).getCoefficient() + temp.get(i).getCoefficient());
					temp.get(i).setCoefficient(0).setExponent(0);
				}
			}
			/*if (!temp.isEmpty()) {
				while (temp.get(0).getCoefficient() == 0 && temp.get(0).getExponent() == 0) {
					temp.remove(0);
				}
			}*/
			while(iterator.hasNext()) {
				if (iterator.next().getCoefficient() == 0) {
					iterator.remove();
				}
			}
			k++;
		}
		/*
		while (result.get(delCounter) != result.get(k-1)) {
			if (result.get(delCounter).getCoefficient() == 0) {
				result.remove(delCounter);
			}
			else {
				delCounter++;
			}
			
		}*/
		for (int i=0; i<result.size(); i++) {
			out.print(result.get(i).toString());
			if (i != result.size()-1) {
				out.print(" + ");
			}
		}
	}
}
