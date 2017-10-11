class MatrixProgram {
	public static void main(String[] args) {
		int[][] t1= new int[][] {new int[] {1,2},
								 new int[] {3,4}};
		int[][] t2= new int[][] {new int[] {1,1},
								 new int[] {0,0}};
		try{
			Matrix m1 = new Matrix(2,2,t1);
			//m1.Print();
			Matrix m2 = new Matrix(2,2,t2);
			m1.Add(m2).Print();
			m1.Sub(m2).Print();
			m1.Mul(m2).Print();

		}catch(IllegalArgumentException e){}
	}
}
