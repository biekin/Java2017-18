import javaIn.*;

public class LiczbyPierwszeProgram {
	public static void main (String[] args) {
		int max = Integer.parseInt(JIn.getString());
		LiczbyPierwsze primeNumbers = new LiczbyPierwsze(max);
		primeNumbers.Print();
	}
}
