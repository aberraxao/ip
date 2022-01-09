class exercises1 {
	// Prints a matrix
	static void printMatrix(char[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++)
				System.out.printf("%c ", m[i][j]);
			System.out.println();
		}
		System.out.println();
	}

	// O Returns the difference between c and the char 'a'
	static int diff(char c) {
		return c - 'a';
	}

	// A Determines if the char 'c' is lower case
	static boolean isLower(char c) {
		if ((int) c >= 96 && (int) c <= 122)
			return true;
		else
			return false;
	}

	// B Returns the number of lower case chars in a vector
	static int nbLower(char[] c) {
		int count = 0;

		for (int i = 0; i < c.length; i++)
			if (isLower(c[i]))
				count++;

		return count;
	}

	// C Returns a vector with the lower case chars
	static char[] vectLower(char[] c) {
		char[] cLower = new char[nbLower(c)];
		int j = 0;

		for (int i = 0; i < c.length; i++)
			if (isLower(c[i])) {
				cLower[j] = c[i];
				j++;
			}

		return cLower;
	}

	// D Returns the number of lower case chars in a matrix
	static int nbLowerMatrix(char[][] c) {
		int count = 0;

		for (int i = 0; i < c.length; i++)
			count = count + nbLower(c[i]);

		return count;
	}

	// E Returns the nb of times that the char 'c'
	// appears in a vector
	static int nbCharInVector(char cc, char[] c) {
		int count = 0;

		for (int i = 0; i < c.length; i++)
			if (c[i] == cc) {
				count++;
			}

		return count;
	}

	// F Function that checks if there are repeated chars
	// in a vector
	static boolean checkDupes1(char[] c) {

		for (int i = 0; i < c.length; i++)
			if (nbCharInVector(c[i], c) > 1)
				return true;

		return false;
	}

	static boolean checkDupes2(char[] c) {

		for (int i = 0; i < c.length; i++)
			for (int j = 0; j < c.length; j++)
				if (c[i] == c[j] && i != j)
					return true;

		return false;
	}

	// G Upper case char
	static char uppercase(char c) {

		if (97 <= (int) c && (int) c <= 122)
			c = (char) (c - 32);

		return c;
	}

	// H Convert a vector of lower case chars into
	// a vector of upper case ones
	static void upperVector(char[] c) {

		for (int i = 0; i < c.length; i++)
			c[i] = uppercase(c[i]);

	}

	// I Convert a matrix of lower case chars into
	// a matrix of upper case ones
	static void upperMatrix1(char[][] c) {

		for (int i = 0; i < c.length; i++)
			upperVector(c[i]);

	}

	static void upperMatrix2(char[][] c) {

		for (int i = 0; i < c.length; i++)
			for (int j = 0; j < c.length; j++)
				c[i][j] = uppercase(c[i][j]);
	}

	// J Procedure that for a given vector and
	// 2 indices, sort the correspondent chars
	// if both lower case
	static void sort(char[] c, int i, int j) {
		char tmp = c[i];

		if (isLower(c[i]) && isLower(c[j]) && c[i] > c[j]) {
			c[i] = c[j];
			c[j] = tmp;
		}
	}

	static void tests() {
		System.out.println(diff('c'));
		System.out.println(diff('f'));
		System.out.println(diff('z') + 1);
		System.out.println(isLower('z'));
		System.out.println(isLower('Z'));
		char[] c = { 'a', 'a', 'Z', 'z' };
		System.out.println(nbLower(c));
		System.out.println(vectLower(c));

		char[][] c2 = { { 'z', 'B', 'c', 'Z' }, { 'A', 'f', 'c', 'Z' }, { 'i', 'B', 'c', 'K' } };
		System.out.println(nbLowerMatrix(c2));
		System.out.println(nbCharInVector('z', c));

		System.out.println(checkDupes1(c));
		System.out.println(checkDupes2(c));

		System.out.println(uppercase('%'));
		System.out.println(uppercase('c'));
		System.out.println(uppercase('A'));

		upperVector(c);
		System.out.println(c);

		printMatrix(c2);
		upperMatrix1(c2);
		printMatrix(c2);

		char[][] c3 = { { 'z', 'B', 'c', 'Z' }, { 'A', 'f', 'c', 'Z' }, { 'i', 'B', 'c', 'K' } };
		upperMatrix2(c3);
		printMatrix(c3);

		char[] c4 = { 'b', 'a', 'c', '+', '-' };
		sort(c4, 0, 1);
		System.out.println(c4);
		
		char[] c5 = { 'b', 'a', 'c', '+', '-' };
		sort(c5, 1, 2);
		System.out.println(c5);
	}
}