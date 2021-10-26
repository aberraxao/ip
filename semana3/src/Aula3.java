class Aula3 {
	// EXAMPLE 1: Number of divisors of an integer n
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
	
	// EXAMPLE 2: Sum of divisors of an integer n, excluding n
	static int sumOfDivisors(int n) {
		int sum = 0;
		int i = 1;
		
		while (i < n) {
			if(n%i == 0) {
				sum = sum + i;
			}
			i = i+1;
		}
		return sum;
	}
	
	static int sumOfDivisors2(int n) {
		int sum = 0;
		int i = 1;
		
		while (i <= (n/2)) {
			if(n%i == 0) {
				sum = sum + i;
			}
			i = i+1;
		}
		return sum;
	}

	// A Checks if an integer n is prime or not
	static boolean isPrime(int n) {
		return numberOfDivisors(n)==2;
	}
	
	// B Function that sums the number of primes smaller than n, included
	static int sumOfPrimesSmallerThan(int n) {
		int i = 1;
		int sum = 0;
		
		while (i < n) {
			if (isPrime(i)) {
				sum = sum + i;
			}
			i = i + 1;
		}
		return sum;
		
	}
	
	// C Function that receives a natural n and returns the prime numbers until n (included)
	static int numberOfPrimesUpTo(int n) {
		int i = 1;
		int count = 0;
		
		while (i <= n) {
			if (isPrime(i)) {
				count = count + 1;
			}
			i = i + 1;
		}
		return count;
	}
	
	// D Function to determine if a number is perfect
	static boolean isPerfect(int n) {
		return sumOfDivisors(n) == n;
	}
	
	// E Returns the number of perfect numbers until n, included
	static int numberOfPerfectNumbersUpTo(int n) {
		int i = 1;
		int count = 0;
		
		while (i <= n) {
			if (isPerfect(i)) {
				count = count + 1;
			}
			i = i + 1;
		}
		return count;
	}
	
	// F Is there a prime in the interval (m,n]?
	static boolean existsPrimeBetween(int m, int n) {
		int i = m+1;
		
		while (i <= n) {
			if (isPrime(i)) {
				return true;
			}
			i = i + 1;
		}
		return false;
	}
	
	static boolean existsPrimeBetween2(int m, int n) {
		while (++m <= n) {
			if (isPrime(m)) {
				return true;
			}
		}
		return false;
	}
	
	// G Recursive functions to calculate:
	// a) n-number of Fibonacci - corrected
	static long fibonacci(int n) {
		if (n==0 || n==1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
	
	// b) The factorial of an integer n - corrected
	static long factorial(int n) {
		if (n == 0)
			return 1;
		else 
			return n * factorial(n - 1);
	}

	// c) The max common divisor between 2 numbers - corrected
	static int gcd(int m, int n) {
		if (n == 0)
			return m;
		else
	       return gcd(n, m%n);
	}
	
	// EXTRA A: Function that receives a natural n and returns the biggest difference
	// between 2 consecutive number primes until n, excluded
	static int largerDifferenceBetweenPrimes(int n) {
		int i = 2, dif = 0, a = 2;
		
		while (i < n) {
			if (isPrime(i)) {
				if (dif < i - a)
					dif = i - a;
				a = i;
			}
			i = i + 1;
		}
		return dif;
	}
}