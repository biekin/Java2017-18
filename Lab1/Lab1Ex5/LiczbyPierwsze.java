public class LiczbyPierwsze {
	private int i, j, maxNumber;
	private int numbers[]=new int[10000];

	public LiczbyPierwsze(int _max) {
		maxNumber=_max;	
		//sito eratostenesa
		for (i=1; i<=maxNumber; i++)
			numbers[i]=i;
		for (i=2; i<Math.floor(Math.sqrt(maxNumber)); i++) {
			if (numbers[i] != 0) {
				j=2*i;
				while (j<maxNumber) {
					numbers[j]=0;
					j=j+i;
				}			
			}
		}
	}

	
	public void Print() {
		for (i=2; i<maxNumber; i++) {
			if (numbers[i] != 0) {
				System.out.println(numbers[i]+", ");
			}
		}
	
	}

}
