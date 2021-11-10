class Aula6 {
	// Prints a matrix
	static void printMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++)
				System.out.printf("%d ", m[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	// Prints a vector
	static void printVector(int[] v) {
		for(int i = 0; i < v.length; i++)
			System.out.printf("%d ", v[i]);
		System.out.println();
	}
	
	// EXAMPLE 1: Define a function to create a matrix with random numbers between 0 and 9
	static int[][] randomMatrix(int lines, int columns) {
		int m[][] = new int[lines][columns];
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++) 
				m[i][j] = (int)(10*Math.random());
		return m;
	}
	
	static void testRandomMatrix() {
		printMatrix(randomMatrix(2,5));
	}
	
	// EXAMPLE 2: Define a function to create a square matrix with random numbers between 0 and 9
	static int[][] randomSquareMatrix(int lines) {
		return(randomMatrix(lines, lines));
	}
	
	static void testRandomSquareMatrix() {
		printMatrix(randomSquareMatrix(4));
	}
	
	// EXAMPLE 3: Define a function to get the sum of all the elements of a matrix
	static int sum(int[][] m) {
		int sum = 0;
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++) 
				sum += m[i][j];
		return sum;
	}
	
	static void testSum() {
		int m[][] = randomMatrix(2,2);
		printMatrix(m);
		System.out.println(sum(m));
	}
	
	// EXAMPLE 4: Define a function to count the number of elements of a matrix
	static int evalSum(int[][] m) {
		int sum = 0;
		
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++) 
				sum++;
		return sum;
	}
	
	static void testEvalSum() {
		int m[][] = randomMatrix(2,7);
		printMatrix(m);
		System.out.println(evalSum(m));
	}
	
	// A Put all the elements of a matrix in a vector
	static int[] unroll(int[][] m) {
		int v[] = new int[evalSum(m)];
		
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++)
				v[i*m[i].length+j] = m[i][j];
		return v;
	}
	
	static void testUnroll() {
		int m[][] = randomMatrix(3,7);
		printMatrix(m);
		printVector(unroll(m));
	}

	// B Create a matrix from a given vector, nb lines and nb columns
	static int[][] matrixForm(int[] v, int lines, int columns) {
		int m[][] = new int[lines][columns];
		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++) 
				m[i][j] = v[i * m[i].length + j];
		return m;
	}
	
	static void testMatrixForm() {
		int[] v = {1,2,3,4,5,6,7,8,9};
		printMatrix(matrixForm(v, 3, 3));
	}
		
	// C Check if the matrix is valid, i.e., all the rows of the matrix have the same length
	static boolean validMatrix(int[][] m) {		
		for(int i = 1; i < m.length; i++)
			if (m[0].length != m[i].length)
				return false;
		return true;
	}
	
	static void testValidMatrix() {
		int[][] m = {{1,2,3}, {1,2,3}, {1,2,4,8}};
		System.out.println(validMatrix(m));
	}
	
	// D Check if the matrix is square, i.e., if the nb of lines is the same as cols 
	// and all have the same length
	static boolean validSquareMatrix(int[][] m) {		
		return (validMatrix(m) && m.length==m[0].length);
	}
	
	static void testValidSquareMatrix() {
		int[][] m = {{1,2,3}, {1,2,3}};
		System.out.println(validSquareMatrix(m));
	}	
	
	// E Check if 2 matrices are equal
	static boolean isEqualMatrices(int[][] m, int[][] n) {		
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				if (m[i][j] != n[i][j])
					return false;
		return true;
	}
	
	static void testEqualMatrices() {
		int[][] m = {{1,2,3}, {1,2,3}};
		int[][] n = {{1,2,3}, {2,2,3}};
		System.out.println(isEqualMatrices(m, n));
	}	
	
	// F Create the identity matrix with size n
	static int[][] identity(int n) {
		int m[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) 
			m[i][i] = 1;
		
		return m;
	}
	
	static void testIdentity() {
		printMatrix(identity(3));
	}
	
	// G Multiply a matrix by a scalar
	static void multiplyByScalar(int[][] m, int s) {
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++) 
				m[i][j] *= s;
	}
	
	static void testMultiplyByScalar() {
		int m[][] = randomMatrix(3,7);
		printMatrix(m);
		multiplyByScalar(m, 10);
		printMatrix(m);
	}	
	
	// H Add 2 matrices
	static void accumulate(int[][] m, int[][] n) {
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++)
				m[i][j] += n[i][j];
	}
	
	static void testAccumulate() {
		int m[][] = randomMatrix(3,2);
		int n[][] = randomMatrix(3,2);
		printMatrix(m);
		printMatrix(n);
		accumulate(m,n);
		printMatrix(m);
	}	
		
	// I Check if a matrix is the identity
	static boolean isIdentity(int[][] m) {
		return validSquareMatrix(m) && isEqualMatrices(m, identity(m.length));
	}
	
	static void testIsIdentity() {
		// int m[][] = randomMatrix(2,6);
		// int m[][] = {{1,0,0},{0,1,0}};
		int m[][] = {{1,0,0},{0,1,0},{0,0,1}};
		
		printMatrix(m);
		System.out.println(isIdentity(m));
	}
	
	// J Obtain the column of a matrix as a vector, for a given index
	static int[] matrixColumn(int[][] m, int c) {
		int v[] = new int[m[0].length];

		for(int i = 0; i < v.length; i++)
			v[i] = m[i][c];
		return v;
	}
	
	static void testMatrixCoulmn() {
		// Assuming the nb of columns is the same for all the rows
		int m[][] = randomMatrix(6,6);
		printMatrix(m);
		printVector(matrixColumn(m, 4));
	}	
		
	// K Obtain the transposed of a matrix
	static int[][] matrixTransposed(int[][] m) {
		int n[][] = new int[m.length][m[0].length];
		
		for(int i = 0; i < n.length; i++)
			for(int j = 0; j < n[i].length; j++)
				n[i][j] = m[j][i];
		return n;
	}
	
	static void testMatrixTransposed() {
		int m[][] = randomMatrix(6,6);
		printMatrix(m);
		printMatrix(matrixTransposed(m));
	}
	
	// L Check if a matrix is symmetric
	static boolean isSymmetric(int[][] m) {
		return isEqualMatrices(m, matrixTransposed(m));
	}
	
	static boolean isSymmetric2(int[][] m) {
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m[i].length; j++) 
				if (m[i][j] != m[j][i])
					return false;
		return true;
	}
	
	static void testIsSymmetric() {
		// int m[][] = randomMatrix(6,6);
		// int m[][] = {{1,0,0},{0,1,0}};
		int m[][] = {{1,2,0},{2,0,5},{0,5,3}};
		
		printMatrix(m);
		System.out.println(isSymmetric(m));
	}
	
	// EXTRA A: Define a function to multiply 2 matrices,
	// assuming they have valid dimensions for such operation
	static int[][] multiplyMatrices(int[][] m, int[][] n) {
		int p[][] = new int[m.length][n[0].length];
		
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < n[0].length; j++)
				for (int k = 0; k < n.length; k++)
					p[i][j] += m[i][k]*n[k][j];
		return p;
	}
	
	static void testMultiplyMatrices() {
		// Multiply the lines of m by the cols of n
		// lengths = [lines of m][cols of n]
		int m[][] = {{1,2},{4,5}};
		int n[][] = {{1,2,3},{4,5,6}};
		// int m[][] = {{1,2,3},{4,5,6}};
		// int n[][] = {{7,8},{9,10},{11,12}};
		printMatrix(m);
		printMatrix(n);
		printMatrix(multiplyMatrices(m, n));
	}	
}