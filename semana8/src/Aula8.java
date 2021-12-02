class Aula8 {
	// Function to print a colour
	static void printColor(Color color) {
		System.out.println("red=" + color.getR() + ", "
					     + "green=" + color.getG() + ", "
					     + "blue=" + color.getB());
	}
	
	// A1 Add constants to represent the most common colours
	static void testColours() {
		printColor(Color.COLOR_RED);
		printColor(Color.COLOR_GREEN);
		printColor(Color.COLOR_BLUE);
		printColor(Color.COLOR_BLACK);
		printColor(Color.COLOR_WHITE);
	}
	
	// A2 Return the inverted colour, similar to Aula7
	static Color inverted(Color color) {
		return new Color(ColorUtils.MAX - color.getR(), 
					     ColorUtils.MAX - color.getG(), 
						 ColorUtils.MAX - color.getB());
	}
	
	static void testInvertedStatic() {
		Color c = new Color(123, 255, 0);
		printColor(c);
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
	static boolean contains(Color[] colors, Color c) {
		for(int i=0; i<colors.length; i++)
			if (c.isEqualTo(colors[i]))
				return true;
		return false;
	}
	
	static void testContains() {
		Color c = new Color(123, 255, 0);
		Color d = new Color(232, 23, 0);
		Color e = new Color(11, 22, 33);
		Color f = new Color(00, 22, 33);
		Color set[] = {c, d, e};
		System.out.println(contains(set, e));
		System.out.println(contains(set, f));
	}
}