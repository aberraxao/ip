class miniteste2 {
	
	static int numberOfDivisors(int n) {
		int count = 0;
		int i = 1;
		
		while (i <= n) {
			if(n%i == 0) {
				count = count + 1;
			}
			i = i + 1;
		}
		return count;
	}
	
	static boolean isPrime(int n) {
		return numberOfDivisors(n)==2;
	}
	
	static int f(int first, int last) {
	    int b = 0;
	    int a = first;
	    while(a != last + 1) {
	        if(isPrime(a)) {
	            b = b + a;
	        }
	        a = a + 1;
	    }
	    return b;
	}
	
	static boolean sameInt(double a, int b) {
	    return (int)a == b;
	}
	
	static boolean test() {
		return sameInt(2,3);
	}
	
	static boolean isPalindrome(int n) {
	    int number = 0;
	    int i = n;
	    while(i != 0) {
	        number = number*10 + i%10;
	        i = i/10;
	    }
	    return n == number;
	}
	
	static boolean existsPalindrome(int lower, int upper) {
	    int i = lower + 1;
	    while(i!=upper) {
	        if(isPalindrome(i)) {
	        	return true;
	        }
	        i = i + 1;
	    }
	    return false;
	}	
}