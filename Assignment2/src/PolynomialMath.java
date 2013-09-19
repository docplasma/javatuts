import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public ArrayList<Polynomial> multiplyExpressions(ArrayList<Polynomial> expression1, ArrayList<Polynomial> expression2) {
		
		int sizeOfExpressions = expression1.size() + expression2.size();// Size of the result array, needs to be dynamically sized
		int k = 0;//Index of the result
		ArrayList<Polynomial> temp = new ArrayList<Polynomial>(sizeOfExpressions);
		for (int j=0;j<expression1.size();j++) {
			for (int i=0; i<expression2.size(); i++) {
				temp.add(k, new Polynomial(0,0));
				temp.get(k).setCoefficient(expression1.get(j).getCoefficient() * expression2.get(i).getCoefficient());
				temp.get(k).setExponent(expression1.get(j).getExponent() + expression2.get(i).getExponent());
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
			while(iterator.hasNext()) {
				if (iterator.next().getCoefficient() == 0) {
					iterator.remove();
				}
			}
			k++;
		}
		
		return result;
	}
	
	public void display(ArrayList<Polynomial> result) {
		for (int i=0; i<result.size(); i++) {
			out.print(result.get(i).toString());
			if (i != result.size()-1) {
				out.print(" + ");
			}
		}		
	}
	
	
	
	
}
