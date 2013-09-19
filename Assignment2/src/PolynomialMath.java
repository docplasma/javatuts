import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class PolynomialMath {

	//-----Constructor
	PolynomialMath() {
		
	}
	
	//-----Random Number generator
	public int getRandomNum() {
		Random rand = new Random();
		int num = 0;
		
		//Used to generate a random number if 0 was the supplied random number
		while (num == 0) {
			//rand.nextInt() supplies a random number from 1-18 then shifts to the left giving -9 through 9
			num = rand.nextInt(18)-9;
		}
		return num;
	}
	//-----Multiply Function multiplies two ArrayList Polynomials
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

		//This half simplifies the temp expression
		//result is used to store the simplified expression
		ArrayList<Polynomial> result = new ArrayList<Polynomial>(k);
		k=0;
		//Loops until all of the polynomials in temp is erased
		while (!temp.isEmpty()) {
			//This adds the first polynomial in temp to result and then deletes the first polynomial in temp
			result.add(k, new Polynomial(temp.get(0).getCoefficient(),temp.get(0).getExponent()));
			temp.remove(0);
			//This loop checks for like exponents to add to the the current result Polynomial
			for (int i=0;i<temp.size();i++) {
				if (temp.get(i).getExponent() == result.get(k).getExponent()) {
					result.get(k).setCoefficient(result.get(k).getCoefficient() + temp.get(i).getCoefficient());
					temp.get(i).setCoefficient(0).setExponent(0);
				}
			}
			//Any polynomial with a zero coefficient is removed from temp
			//An iterator is used to safely traverse temp so any of its elements can be deleted
			Iterator<Polynomial> iterator = temp.iterator();
			while(iterator.hasNext()) {
				if (iterator.next().getCoefficient() == 0) {
					iterator.remove();
				}
			}
			//k is incremented to the next index for a polynomial to be added to result
			k++;

			
		}
		
		return result;
	}
	//-----display() prints out every Polynomial in the ArrayList
	public void display(ArrayList<Polynomial> result) {
		for (int i=0; i<result.size(); i++) {
			out.print(result.get(i).toString());
			//If this is not the last element in the ArrayList or the next number is a decimal, then print a " + "
			if (i != result.size()-1 && result.get(i+1).getCoefficient() >= 0) {
				out.print(" + ");
			}
			else {
				out.print(" ");
			}
		}		
	}
	
	//Provides extra details about the PolynomialMath object
	public String toString() {
		String string = "This object is used to display and perform mathmatical operations on Polynomial ArrayLists";
		return string;
	}
	
	
	
}
