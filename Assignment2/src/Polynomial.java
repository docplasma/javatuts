public class Polynomial {

	
	
	//-----Data Members
	private char character;
	private int exponent;
	private int coefficient;
	private StringBuilder sb;
	
	
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
	public char getCharacter() {
		return character;
	}
	public int getCoefficient() {
		return coefficient;
	}
	public int getExponent() {
		return exponent;
	}
	public Polynomial setCharacter(char x) {
		character = x;
		return this;
	}
	public Polynomial setCoefficient(int y) {
		coefficient = y;
		return this;
	}
	public Polynomial setExponent(int z) {
		exponent = z;
		return this;
	}
	
	//-----toString
	public String toString() {
		sb = new StringBuilder();
		
		if (this.getExponent() !=0) {
			sb.append(getCoefficient());
			sb.append(getCharacter());
			sb.append("^");
			sb.append(getExponent());
		}
		else {
			sb.append((int)getCoefficient());
		}
		return sb.toString();
	}
		
	
}
