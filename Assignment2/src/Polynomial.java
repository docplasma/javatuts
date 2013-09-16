public class Polynomial {

	
	//-----Data Members
	private char character;
	private int exponent;
	private int coefficient;
	
	
	//-----Class Constructor
	Polynomial() {
		character = 'x';
		coefficient = 1;
		exponent = 1;
	}
	Polynomial(char x, int y, int z) {
		character = x;
		coefficient = y;
		exponent = z;
	}
	Polynomial(int y, int z) {
		character = 'x';
		coefficient = y;
		exponent = z;
	}
	Polynomial(int y) {
		character = 'x';
		coefficient = y;
		exponent = 1;
	}
	
	//-----get/set
	char getCharacter() {
		return character;
	}
	int getCoefficient() {
		return coefficient;
	}
	int getExponent() {
		return exponent;
	}
	void setCharacter(char x) {
		character = x;
	}
	void setCoefficient(int y) {
		exponent = y;
	}
	void setExponent(int z) {
		exponent = z;
	}
	
		
	
}
