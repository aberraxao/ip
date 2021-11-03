class Aula5 {
	// EXAMPLE 1: Define a function to create a vector with size n
	static char[] charVector(char c, int n) {
		char v[] = new char[n];
		for(int i = 0; i < n; i++) {
			v[i] = c;
		}
		return v;
	}
	
	static void testCharVector() {
		char[] w;
		char ch='d';
		int n=5;
		
		w=charVector(ch, n);
		System.out.println(w);
	}
	
	// EXAMPLE 2: Define a procedure to fill a vector with a given char
	static void fill(char c, char[] v) {
		for(int i = 0; i < v.length; i++) {
			v[i] = c;
		}
	}
	
	static void testFill() {
		char[] v = {'a', 'c', 'e', 'g', 'i'};
		
		// v passes by reference
		System.out.println(v);
		fill('c', v);
		System.out.println(v);
	}
	
	// EXAMPLE 3: Define a procedure to replace all the occurrences of a given char by another
	static void replace(char a, char b, char[] v) {
		for(int i = 0; i < v.length; i++) {
			v[i] = v[i]==a ? b : v[i];
		}
	}
	
	static void replace2(char a, char b, char[] v) {
		for(int i = 0; i < v.length; i++) 
			if (v[i] == a) 
				v[i] = b;
	}
	
	static void testReplace() {
		char[] v = {'a', 'c', 'e', 'g', 'i'};
		
		// v passes by reference
		System.out.println(v);
		replace2('a', 'b', v);
		System.out.println(v);
	}
	
	// A Build a function to create a vector with consecutive n chars 
	// starting on a given char c
	static char[] sequence(char c, int n) {
		char v[] = new char[n];
		for(int i = 0; i < n; i++) {
			v[i] = (char)(c + i);
		}
		return v;
	}
	
	static void testSequence() {
		// v passes by reference
		System.out.println(sequence('c', 3));
	}
	
	// B Define procedures on vectors that allow
	// a Replace the first occurrence of a given char by another
	static void replaceFirst(char a, char b, char[] v) {
		for(int i = 0; i < v.length; i++) {
			if (v[i] == a) {
				v[i] = b;
				return;
			}
		}
	}
	
	static void testReplaceFirst() {
		char[] v = {'a', 'c', 'c', 'g', 'i'};
		
		System.out.println(v);
		// v passes by reference
		replaceFirst('c', 'a', v);
		System.out.println(v);
	}
	
	// b Replace the last occurrence of a given char by another
	static void replaceLast(char a, char b, char[] v) {
		for(int i = v.length-1; i>=0; i--) {
			if (v[i] == a) {
				v[i] = b;
				return;
			}
		}
	}
	
	static void testReplaceLast() {
		char[] v = {'a', 'c', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		replaceLast('c', 'a', v);
		System.out.println(v);
	}
	
	// c Rotate the elements to the left => the first becomes the last
	static void shiftLeft(char[] v) {
		char aux = v[0];
		
		for(int i = 0; i < v.length-1; i++)
			v[i] = v[i+1];
		
		v[v.length-1] = aux;
	}
	
	static void testShiftLeft() {
		char[] v = {'a', 'c', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		shiftLeft(v);
		System.out.println(v);
	}
	
	// d Rotate the elements to the right => the last  becomes the first
	static void shiftRight(char[] v) {
		char aux = v[v.length-1];
		
		for(int i = v.length-1; i>0; i--)
			v[i] = v[i-1];
		
		v[0] = aux;
	}
	
	static void testShiftshiftRight() {
		char[] v = {'a', 'c', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		shiftRight(v);
		System.out.println(v);
	}
	
	// e Switch the values of 2 positions
	static void swap(int i, int j, char[] v) {
		char aux = v[j];
		
		v[j] = v[i];
		v[i] = aux;
	}
	
	static void testSwap() {
		char[] v = {'a', 'c', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		swap(1, 3, v);
		System.out.println(v);
	}
	
	// f Switch the values of 2 positions
	static void invert(char[] v) {
		char aux;
		
		for(int i = 0; i < v.length/2; i++) {
			aux = v[v.length - i - 1];
			v[v.length - i -1] = v[i];
			v[i] = aux;
		}
	}
	
	static void invert2(char[] v) {
		char[] w = new char[v.length];
		
		for(int i = 0; i < v.length; i++)
			w[i] = v[v.length - 1 - i];
		for(int i = 0; i < v.length; i++)
			v[i] = w[i];
	}
	
	static void testInvert() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		invert2(v);
		System.out.println(v);
	}
	
	// C Implement the 'Fisher–Yates shuffle' algorithm
	static int randomIndex(int n) {
		return (int)((n+1)*Math.random());
	}
	
	static void algFishYates(char[] v) {
		int j;
		
		for(int i = v.length-1; i>0; i--) {
			j = randomIndex(v.length-1);
			swap(i, j, v);
		}
	}
	
	static void testAlgFishYates() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		algFishYates(v);
		System.out.println(v);
	}
	
	// D Implement the 'Bubble Sort' algorithm
	static void bubbleSort(char[] v) {
		for(int i = 1; i < v.length; i++)
			for (int j = 1; j < v.length; j++)
				if (v[j-1] > v[j])
					swap(j-1, j, v);
	}
	
	static void bubbleSort2(char[] v) {
		for(int i = 0; i < v.length-1; i++)
			for (int j = 0; j < v.length-1; j++)
				if (v[j] > v[j+1])
					swap(j, j+1, v);
		}
	
	static void testBubbleSort() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		// v passes by reference
		bubbleSort2(v);
		System.out.println(v);
	}
	
	// EXTRA A: Define two functions that allow
	// a Add a char at the end of a vector of chars, obtaining a new vector
	static char[] concat(char[] v, char c) {
		char[] w = new char[v.length+1];
		
		for(int i = 0; i < v.length; i++)
			w[i] = v[i];
		
		w[v.length] = c;

		return w;
	}
	
	static void testConcat() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		System.out.println(concat(v, 'd'));
	}
	
	// b Add a char at the start of a vector of chars, obtaining a new vector
	static char[] concatStart(char c, char[] v) {
		char[] w = new char[v.length+1];
		
		w[0] = c;
		for(int i = 1; i < w.length; i++)
			w[i] = v[i-1];
		
		return w;
	}
	
	static void testConcatStart() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		System.out.println(concatStart('d', v));
	}
	
	// B Define a procedure that replaces the value of a random position by a given char c
	static void replaceRandom(char c, char[] v) {
		v[randomIndex(v.length-1)] = c;
	}
	
	static void replaceRandom2(char c, char[] v) {
		int index = (int) ((v.length)*Math.random());
		
		v[index] = c;
	}
	
	static void testReplaceRandom() {
		char[] v = {'a', 'e', 'c', 'g', 'c'};
		
		System.out.println(v);
		replaceRandom2('z', v);
		System.out.println(v);
	}
	
	// B Define a procedure that exchanges halves of a vector of chars
	static void swapHalfs(char[] v) {
				
		for(int i = 0; i < v.length/2; i++)
			swap(i, v.length/2 + i + v.length%2, v);
	}
	
	static void testSwapHalfs() {
		char[] v = {'a', 'b', 'c', 'd', 'e'};
		
		System.out.println(v);
		swapHalfs(v);
		System.out.println(v);
	}

}