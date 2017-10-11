import javaIn.*;

class PeselProgram {
	public static void main(String[] args) {
		String tmppesel = JIn.getString();
		while (tmppesel.length() != 11) {
			System.out.println("zla dlugosc, wpisz ponownie");
			tmppesel = JIn.getString();
		}
		Pesel pesel = new Pesel(tmppesel);
		System.out.println(pesel.check());
	}
}
