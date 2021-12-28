class Aula8 {
	
	 static void teste(){
	    	Rational0 a = new Rational0(5,6);
	    	Rational0 b = new Rational0(5,6);
	    	a.isEqualTo(b);
	    	System.out.println(a.isEqualTo(b));
	    }

	// Function to print a colour
	static void printColor(Color color) {
		System.out.println("red=" + color.getR() + ", " + "green=" + color.getG() + ", " + "blue=" + color.getB());
	}

	// EXTRA EXERCISES ABOUT COLOURS

	// A1 Add constants to represent the most common colours
	static void testColours() {
		printColor(Color.COLOR_RED);
		printColor(Color.COLOR_GREEN);
		printColor(Color.COLOR_BLUE);
		printColor(Color.COLOR_BLACK);
		printColor(Color.COLOR_WHITE);
	}

	// A2 - option 1 Return the inverted colour, similar to Aula7
	static Color inverted(Color color) {
		return new Color(ColorUtils.MAX - color.getR(), ColorUtils.MAX - color.getG(), ColorUtils.MAX - color.getB());
	}

	static void testInvertedStatic() {
		Color c = new Color(123, 255, 0);
		// option 1
		printColor(c);
		// option 2
		printColor(inverted(c));
	}

	static void testInvertedNonStatic() {
		Color c = new Color(123, 255, 0);
		printColor(c);
		printColor(c.inverted());
	}

	// A3 Return a brighter colour, similar to Aula7
	static void testBrighter() {
		Color c = new Color(123, 255, 0);
		printColor(c);
		printColor(c.brighter(40));
	}

	// A4 Color A is equal to Color B
	static void testIsEqual() {
		Color c = new Color(123, 255, 0);
		Color d = new Color(123, 255, 0);
		Color e = new Color(123, 255, 1);
		System.out.println(c.isEqualTo(d));
		System.out.println(c.isEqualTo(e));
	}

	// B1 Check is a vector contains a certain Color
	static void testContains() {
		Color c = new Color(123, 255, 0);
		Color d = new Color(232, 23, 0);
		Color e = new Color(11, 22, 33);
		Color f = new Color(00, 22, 33);
		Color set[] = { c, d, e };
		System.out.println(ColorUtils.contains(set, e));
		System.out.println(ColorUtils.contains(set, f));
	}

	// COLOR IMAGE
	// A1 Invert the colours of an image
	static void testInvertColorImage() {
		ColorImage img = new ColorImage(100, 200);
		System.out.println("before");
		img.inversa();
		System.out.println("after");

		ColorImage img2 = new ColorImage("objc1.png");
		System.out.println("before");
		img2.inversa();
		System.out.println("after");
	}

	// A2 Make an image brighter
	static void testBrightColorImage() {
		ColorImage img = new ColorImage("objc1.png");
		System.out.println("before");
		img.brighter(100);
		System.out.println("after");
	}

	// A3 Mirror an image
	static void testMirrorColorImage() {
		ColorImage img = new ColorImage("objc1.png");
		System.out.println("before");
		img.mirror();
		System.out.println("after");
	}

	// A4 Paste a picture on top of another, starting in a given point
	static void testPaste() {
		// ColorImage img = new ColorImage("objc1.png");
		// ColorImage imgSmall = new ColorImage("objc2.png");
		// img.paste2(imgSmall, 100, 60);
		// img.paste2(imgSmall, 20, 180);

		ColorImage img = new ColorImage("objc2.png");
		ColorImage imgBig = new ColorImage("objc1.png");
		img.paste2(imgBig, -100, 60);
		img.paste2(imgBig, 1, 30);
	}

	// A5 Black and White
	static void testBnW() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.blackWhite();
		System.out.println("after");
	}

	// A6 Return a copy
	static void testCopy() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.copy();
		System.out.println("after");
	}

	// A7 Returns a rectangle selection of an image
	static void testRectangle() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.selection(30, 10, 100, 200);
		System.out.println("after");
	}

}