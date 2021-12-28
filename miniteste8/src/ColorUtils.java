class ColorUtils {
	static final int MAX = 255;
	
	// B1 Check is a vector contains a certain Color
	static boolean contains(Color[] colors, Color c) {
		for(int i=0; i<colors.length; i++)
			if (c.isEqualTo(colors[i]))
				return true;
		return false;
	}
}