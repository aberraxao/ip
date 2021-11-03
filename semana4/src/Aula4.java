class Aula4 {
	// EXAMPLE 1: Build a vector with the natural numbers until a given n
	 static int[] naturals(int n) {
		 int i = 0, v[] = new int[n];
		 
		 while (i < n) {
			 v[i] = i + 1;
			 i = i + 1;
		 }
		 return v;
	 }
	 
	 // EXAMPLE 2: Calculate the sum of the values of a vector
	 static int sum(int[] v) {
		 int i = 0, sum = 0;
		 
		 while (i < v.length) {
			 sum = sum + v[i];
			 i = i + 1;
		 }
		 return sum;
	 }
	 
	 // EXAMPLE 3: Build a vector with random digits from 0 to 9, for a given length
	 // Math.random() generates pseudo-random numbers between [0,1)
	 static int[] randomDigits(int n) {
		 int[] v = new int[n];
		 int i = 0;
		 
		 while (i < n) {
			 v[i] = (int)(10*Math.random());
			 i = i + 1;
		 }
		 return v;
	 }
	 
	 // A Calculate the average of the values of a vector
	 static double mean(int[] v) {
		 int i = 0;
		 double sum = 0;
		 
		 while (i < v.length) {
			 sum = sum + v[i];
			 i = i + 1;
		 }
		 return sum/v.length;
	 }
	 
	 static double mean2(int[] v) {		 
		 return (double)sum(v)/v.length;
	 }
	 
	 // B Calculate the average of the values of a vector
	 static int[] copy(int[] v, int n) {
		 int w[] = new int[n];
		 int i = 0;
		 
		 while (i < n) {
			if (i < v.length)
				 w[i] = v[i];
			else
				w[i] = 0;
			i = i + 1;
		 }
		 return w;
	 }
	 
	 // C Copy a vector of integers, keep the same size as the original
	 static int[] copy2(int[] v) {
		 return (copy(v, v.length));
	 }
	 
	 // D Check if exists a number in a vector
	 static boolean exists(int n, int[] v) {
		 int i = 0;
		 
		 while (i < v.length) {
			 if (n == v[i])
				 return true;
			 i = i + 1;
		 }
		 return false;
	 }
	 
	 // E Count the number of occurrences of a number for a given vector
	 static int count(int n, int[] v) {
		 int i = 0, count = 0;
		 
		 while (i < v.length) {
			if (n == v[i])
				 count = count + 1;
			i = i + 1;
		 }
		 return count;
	 }
	 
	 // F Function that returns the max of a vector
	 static int max(int[] v) {
		 int i = 1, max = v[0];
		 
		 while (i < v.length) {
			if (max < v[i])
				 max = v[i];
			i = i + 1;
		 }
		 return max;
	 }
	 
	 // G Function that builds a sub-vector of another, for a given first and last element (included)
	 static int[] subArray(int a, int b, int[] v) {

		 int w[] = new int[b-a+1];
		 int i = a;
		 
		 while (i <= b) {
			w[i-a] = v[i];
			i = i + 1;
		 }
		 return w;
	 }
	 
	 // H Obtain the first half of a vector.
	 // Include a boolean parameter to include the middle element - for odd lenghts
	 static int[] firstHalf(int[] v, boolean include) {
		 if (include && (v.length%2 != 0))
			 return subArray(0, v.length/2, v);
		 else
			 return subArray(0, (v.length)/2-1, v);
	 }
	 
	 // I Obtains the second half of a vector, with similar logic as H
	 static int[] secondHalf(int[] v, boolean include) {
		 if (include || (v.length%2 == 0))
			 return subArray(v.length/2, v.length-1, v);
		 else
			 return subArray((v.length)/2+1, v.length-1, v);
	 }
	 
	 // J Build a vector that merges 2 vectors
	 static int[] merge(int[] v, int[] w) {
		 int x[] = new int[v.length + w.length];
		 int i = 0;
		 
		 while (i < x.length) {
			 if (i < v.length)
				 x[i] = v[i];
			 else
				 x[i] = w[i - v.length];
			 i = i + 1;
		 }
		 return x;
	 }
	 
	 
	 // K Build a vector based on another. The new vector's elements are in reverse order
	 static int[] invert(int[] v) {
		 int w[] = new int[v.length];
		 int i = 0;
		 
		 while (i < v.length) {
			 w[i] = v[v.length - i - 1];
			 i = i + 1;
		 }
		 return w;
	 }
	 
	 // L Return random number of a vector
	 static int random(int[] v) {
		 return v[(int)(v.length*Math.random())];
	 }
	 
	 // EXTRA A: Build a vector with duplicated size and elements
	 static int[] duplicateEveryElement(int[] v) {
		 int w[] = new int[2*v.length];
		 int i = 0;
		 
		 while (i < 2*v.length) {
			 w[i] = v[(int)(i/2)];
			 i = i + 1;
		 }
		 return w;
	 }
	 
	 // EXTRA B: Build a vector with duplicated size
	 // where the first half is a copy and the second half is the inverse
	 static int[] duplicateInverted(int[] v) {
		 int w[] = new int[2*v.length];
		 int i = 0;
		 
		 while (i < 2*v.length) {
			 if (i < v.length) {
				 w[i] = v[i];
			 }
			 else {
				 w[i] = v[2*v.length - i - 1];
			 }
			 i = i + 1;
		 }
		 return w;
	 }
	 
	 static int[] duplicateInverted2(int[] v) {
		 return merge(v, invert(v));
	 }
	 
	 // EXTRA C: Build a vector with a copy of another without 
	 // the element of the middle in case it has odd length
	 static int[] copyWithoutMiddleElement(int[] v) {
		 int w[] = new int[2*(int)(v.length/2)];
		 int i = 0, j = 0;
		 
		 while (i < v.length) {
			 if (v.length%2==0 || i!= (int)(v.length/2)) {
				 w[j] = v[i];
				 j = j + 1;
				 }
			 i = i + 1;
		 }
		 return w;
	 }
	 
	 static int[] copyWithoutMiddleElement2(int[] v) {
		 return merge(firstHalf(v, false), secondHalf(v,false));
	 }
	 
	 // EXTRA D: Build a vector with the sequence of Fibonacci
	 static int fibonacci(int n) {
		if (n==0 || n==1)
			return n;
		else
			return fibonacci(n-1)+fibonacci(n-2);
	 }
	 
	 static int[] fibonacciSequence(int n) {
		 int v[] = new int[n];
		 int i = 0;
		 
		 while (i < n) {
			 v[i] = fibonacci(i);
			 i = i + 1;
		 }
		 return v;
	 }
}
