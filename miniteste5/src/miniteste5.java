class miniteste5 {
	
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

    // 2
	static void test2() {
	    int[][] m1 = new int[3][];
	    // int[][] m2 = new int[][3];
	    int[][] m3 = new int[3][2];
	    // int[][] m4 = new int[][];
	}
	
	// 3
	static int[] f(int[][] m) {
        int[] v = new int[Math.min(m.length, m[0].length)];
        for(int i = 0; i != v.length; i++) {
            v[i] = m[i][i];
        }
        return v;
    }
	
	static void test3() {
		int[][] m = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		printVector(f(m));
	}
	
	// 4
	static int[] f2(int[][] m) {
        int[] v = new int[Math.min(m.length, m[0].length)];
        for(int i = 0; i != v.length; i++) {
            v[i] = m[i][i];
        }
        return v;
    }
	static void test4() {
		int[][] m = { {4, 5, 6}, {1, 2, 3} };
		printVector(f(m));
	}
	
	// 5
	/*
	static int[][] identity1(int n) {
        int[][] m = new int[][];
        for(int i = 0; i != n; i++) {
            m[i] = new int[n];
            m[i][i] = 1;
        }
        return m;
    }
	*/
	static int[][] identity2(int n) {
        int[][] m = new int[n][];
        for(int i = 0; i != n; i++) {
            m[i][i] = 1;
        }
        return m;
    }
	
	static int[][] identity3(int n) {
        int[][] m = new int[n][n];
        for(int i = 0; i != n; i++) {
            m[i][i] = 1;
        }
        return m;
    }
	
	static int[][] identity4(int n) {
        int[][] m = new int[n][];
        for(int i = 0; i != n; i++) {
            m[i] = new int[n];
            m[i][i] = 1;
        }
        return m;
    }
	
	static void test5() {
		printMatrix(identity4(3));
	}
	
	// test D
	static void testD() {
	int[][] m = {{1,2,3}, null, {1,2,3}};
	//printMatrix(m);
	}
	
}