class miniteste4 {

	static void test2() {

		// has an error
		// double x = null;

		// no error
		int[] v = new int[10];
		v[0] = 7;
	}

	static void p(int[] v) {
		int aux = v[v.length - 1];
		for (int i = v.length - 1; i != 0; i--) {
			v[i] = v[i - 1];
		}
		v[0] = aux;
	}

	static void test3() {
		int[] u = { 1, 2, 3, 4, 5 };

		p(u);

		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}
	}

	static void p2(int[] v) {
		int aux = v[0];
		for (int i = 0; i != v.length - 1; i++) {
			v[i] = v[i + 1];
		}
		v[v.length - 1] = aux;
	}

	static void test4() {
		int[] u = { 5, 4, 3, 2, 1 };

		p2(u);
		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}
	}

	static int norm(double[] v) {
		return v.length;
	}

	static void normalize1(double[] v) {
		double norm = norm(v);
		for (int i = 0; i != v.length; i++) {
			v[i] /= norm;
		}
	}

	static void normalize2(double[] v) {
		for (int i = 0; i != v.length; i++) {
			v[i] = v[i] / norm(v);
		}
	}

	static void normalize3(double[] v) {
		double norm = norm(v);
		for (int i = 0; i != v.length; i++) {
			v[i] = v[i] / norm;
		}
	}

	static void normalize4(double[] v) {
		for (int i = 0; i != v.length; i++) {
			v[i] /= norm(v);
		}
	}

	static void test5() {
		double[] u = { 1.0, 2.0, 2.0, 4.0 };

		normalize4(u);

		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}
	}

}