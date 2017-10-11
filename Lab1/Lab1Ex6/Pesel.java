class Pesel {
	private static String pesel;
	private static int[] multipliers = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
	private static int control = 0;
	
	public Pesel(String _pesel) {
		pesel=_pesel;
	}

	public static boolean check() {
		for (int i=0; i<10; i++) {
			control+=multipliers[i]*Character.getNumericValue(pesel.charAt(i));
		}
		control=control%10;
		if (control==Character.getNumericValue(pesel.charAt(10)))
			return true;
		else return false;
	}
}
