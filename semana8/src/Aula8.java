class Aula8 {
	// Function to print a colour
	static void printColor(Color color) {
		System.out.println("red=" + color.getR() + ", " + "green=" + color.getG() + ", " + "blue=" + color.getB());
	}

	// EXTRA EXERCISES ABOUT COLOURS

	// A1 Add constants to represent the most common colours
	static void testColours() {
		printColor(Color.RED);
		printColor(Color.GREEN);
		printColor(Color.BLUE);
		printColor(Color.BLACK);
		printColor(Color.WHITE);
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
		img.inversa();

		ColorImage img2 = new ColorImage("objc1.png");;
		img2.inversa();
		return;
	}

	// A2 Make an image brighter
	static void testBrightColorImage() {
		ColorImage img = new ColorImage("objc1.png");
		img.brighter(100);
		return;
	}

	// A3 Mirror an image
	static void testMirrorColorImage() {
		ColorImage img = new ColorImage("objc1.png");
		img.mirror();
		return;
	}

	// A4 Paste a picture on top of another, starting in a given point
	static void testPaste() {
		// ColorImage img = new ColorImage("objc1.png");
		// ColorImage imgSmall = new ColorImage("objc2.png");
		// img.paste(imgSmall, 100, 60);
		// img.paste(imgSmall, 20, 180);

		ColorImage img = new ColorImage("objc2.png");
		ColorImage imgBig = new ColorImage("objc1.png");
		img.paste(imgBig, -100, 60);
		img.paste(imgBig, 1, 30);
	}

	// A5 Black and White
	static void testBnW() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.blackWhite();
		return;
	}

	// A6 Return a copy
	static void testCopy() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.copy();
		return;
	}

	// A7 Returns a rectangle selection of an image
	static void testRectangle() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = img.selection(30, 10, 100, 200);
		return;
	}
	
	// B1 Posterize effect
	static void testPosterize() {
		ColorImage img = new ColorImage("objc1.png");
		Images.posterize(img, Color.BLUE, Color.WHITE);
		return;
	}
	
	// B2 Pop art effect
	static void testPopArt() {
		ColorImage img = new ColorImage("objc1.png");
		ColorImage imgNew = Images.popArt(img);
		return;
	}

}