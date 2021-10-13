class EstruturasControlo {
  
	// WORK BEFORE CLASS: A Returns the max of a function
    // We don't need braces when it's just one line - corrected
	static int max(int a, int b) {
		if (a>b)
			return a;
		else
			return b;
	}
	
	// WORK BEFORE CLASS: Multiple of a number without using the '%' - corrected
	static boolean isMultiple(int a, int b) {
		while (a>=b){
			if (a==b)
				return true;
			else
				a=a-b;
		}
		return false;
	}
	
	// A Obtain the absolute of a number - corrected
	static int abs(int a) {
		if (a>=0)
			return a;
		else
			return -a;
	}
	
	// B Obtain the coefficient of the integer division without using '/' - corrected
	static int divide(int a, int b) {
		int count = 0;
		while (a>=b){
			a=a-b;
			count=count+1;
		}
		return count;
	}
	
	// C Obtain the result of 2 powered by a natural number - corrected
	static int powerOfTwo(int n) {
		int i=0;
		int power=1;
		while (i<n){
			power=power*2;
			i=i+1;
		}
		return power;
	}
	
	static int powerOfTwo2(int n) {
		int power=1;
		while (n>0){
			power=power*2;
			n=n-1;
		}
		return power;
	}
	
	// D Obtain the sum of the natural numbers until a given n - corrected
	static int sumOfNaturalsUpTo(int n) {
		int i=1;
		int sum=0;
		while (i<=n) {
			sum=sum+i;
			i=i+1;
		}
		return sum;
	}
	
	static int sumOfNaturalsUpTo2(int n) {
		int sum=0;
		while (n>0) {
			sum=sum+n;
			n=n-1;
		}
		return sum;
	}
	
	// E Obtain the sum of the natural even numbers between a closed interval - better than corrected
	static int sumOfEvenNumbersBetween(int a, int b) {
		int i=a;
		int sum=0;
		while (i<=b) {
			if (i%2==0)
				sum=sum+i;
			i=i+1;
		}
		return sum;
		
	}
	
	// F Obtain the first digit of the decimal representation of a number - better than corrected
	// The first digit of an integer
	static int firstDigit (int n) {
		int divisor=1;
		while ((n/divisor)>=10){
			divisor=divisor*10;
			}
		return (n/divisor);
	}
	
	static int firstDigit2 (int n) {
		while (n>=10){
			n=n/10;
			}
		return n;
	}
	
	// G Obtain the n-number of the Fibonacci sequence - corrected
	static long fibonacci(int n) {
		long f1=0, f2=1, aux=0;
		
		if (n==1)
			return f1;
		if (n==2)
			return f2;
		else {
			while (n>1) {
				aux=f1+f2;
				f1=f2;
				f2=aux;
				n=n-1;
			}
			return aux;
		}
	}
	
	static long fibonacci2(int n) {
		if (n==0 || n==1)
			return n;
		else
			return fibonacci2(n-1)+fibonacci2(n-2);
	}
	
	// EXTRA EXERCISE: Function that calculates the maximum divisor of 2 numbers using the Euclidean algorithm - corrected
	static int gdc(int m, int n) {
		int r = 0;
		if (n == 0)
			return n;
		else {
			while (n != 0) {
		       r = m%n;
		       m = n;
		       n = r;
			}
			return m;
			}

	}	
	
	static int gdc2(int a, int b) {
		while (a>1 && b>1) {
			if (a>b)
				a=a-b;
			else if (a<b)
				b=b-a;
			else
				return a;
		}
		return 1;
	}
	
}