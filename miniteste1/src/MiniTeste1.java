class MiniTeste1 {
	
	static int numberOfMultiplesOfSeven(int a, int b) {
		int total = 0;
		int i=a;
		while(i != b + 1) {
			if(i%7 == 0) {
				total = total + 1;
				}
			i = i + 1;
			}
		return total;
		}
	
	static int f(int n) {
	    int a = 0;
	    int b = 0;
	    while(b != n + 1) {
	        if(b%2 == 0) {
	            a = a + b;
	        }
	        b = b + 1;
	    }
	    return a;
	}
	
	
	static int f2(int n) {
	    int a = 1;
	    int b = n;
	    while(b/10 != 0) {
	        a = a + 1;
	        b = b/10;
	    }
	    return a;
	}

}