class miniteste7 {
	static void test01() {
		Color a = Color.RED;
		Color b = Color.RED;
		boolean sameObject = a == b;
		boolean equalObjects = a.isEqualTo(b);
		System.out.println("teste");
	}

	static void test02() {
		Color[] v = new Color[3];
		int i = 1;
		while (i != v.length) {
			v[i] = Color.RED;
			i = i + 1;
		}
		System.out.println(v[v.length - 1]);
		System.out.println(Color.RED);
	}
}

class Point2 {

	final int x;
	final int y;

	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

/*
 * class Point3 {
 * 
 * final int x; final int y;
 * 
 * Point3(int x, int y) { this.x = x; this.y = y; }
 * 
 * void setX(int x) { this.x = x; }
 * 
 * void setY(int y) { this.y = y; }
 * 
 * }
 */