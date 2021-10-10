class Functions {
	
	// EXEMPLE Returns the square of a number - corrected
	static int square (int x) {
		return x*x;
	}
	
	// A Calculates the double of a number - corrected
	static int dbl (int x) {
		return 2*x;
	}
	
	// B Calculates the difference between 2 integers - corrected
	static int diff (int a, int b) {
		return a-b;
	}
	
	// C Returns the proportion n / total - corrected
	static double percentage (int n, int total) {
		return (double)n/total;
	}
	static double percentage2 (int n, int total) {
		return n/(double)total;
	}
	
	// D Calculates the average between 2 numbers - corrected
	static double average (int a, int b) {
		return (double)(a+b)/2;
	}
	
	// E Rounds a decimal number to integer - corrected
	static int round (double a) {
		if (a-(int)a<=0.5) {
			return (int)a;
		}else {
			return (int)a+1;
			}
	}
	static int round2 (double a) {
		return (int)(a+.5);
	}
	
	// F Determines if a number is negative or not - corrected
	static boolean isNegative (int n) {
		return n<0;
	}
	
	// G Determines if a number is odd or not - corrected
	static boolean isOdd (int n) {
		return n%2!=0;
	}
	
	// H Determines if a number is even or not - corrected
	static boolean isEven (int n) {
		return n%2==0;
	}
	
	// I Determines if 'a' is multiple 'b' - corrected
	static boolean isMultiple (int a, int b) {
		return a%b==0;
	}
	
	// J Determines if an integer has one digit - corrected
	static boolean hasOneDigit (int n) {
		return 0<=n && n<=9;
	}
	
	// K Determines if a number is between 2 numbers, a<=b - corrected
	static boolean isIncluded (int n, int a, int b) {
		return a<=n && n<=b;
	}
	
	// L Determines if an integer doesn't belong to an interval, a<=b - corrected
	static boolean isExcluded (int n, int a, int b) {
		return n<a || n>b;
	}
	static boolean isExcluded2 (int n, int a, int b) {
		return !(a<=n && n<=b);
	}
	
	// M Logical disjunction: exclusive or - corrected
	static boolean xor (boolean a, boolean b) {
		return a!=b;
	}
	static boolean xor2 (boolean a, boolean b) {
		return a ^ b;
	}
	
	// N Determines if a char vowel is lower case - corrected
	static boolean isVowel (char a) {
		return a=='a' || a=='e' || a=='i' || a=='o' || a=='u';
	}
	
	// N Determines if a char is a letter - corrected
	static boolean isConsonant (char a) {
		return (a>='a' && a<='z') ^ (a>='A' && a<='Z');
	}
	// no need for brackets, because of the precedences rules
	static boolean isConsonant2 (char a) {
		return a>='a' && a<='z' || a>='A' && a<='Z';
	}
	
}