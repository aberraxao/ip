/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {
	
	/**
	* A1 Common colours
	**/
	static final Color COLOR_RED = new Color(255, 0, 0);
	static final Color COLOR_GREEN = new Color(0, 255, 0);
	static final Color COLOR_BLUE = new Color(0, 0, 255);
	static final Color COLOR_WHITE = new Color(255, 255, 255);
	static final Color COLOR_BLACK = new Color(0, 0, 0);
	
	// attribute
	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}
	
	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}
	
	/**
	 * A2 Invert a colour
	 */
	Color inverted() {
		int r = ColorUtils.MAX - this.rgb[0];
		int g = ColorUtils.MAX - this.rgb[1]; 
		int b = ColorUtils.MAX - this.rgb[2];
		
		return new Color(r, g, b);
	}
	
	/**
	 * A3 Brighter
	 */
	Color brighter (int value) {
		int r = Math.max(Math.min(this.getR() + value, ColorUtils.MAX), 0);
		int g = Math.max(Math.min(this.getG() + value, ColorUtils.MAX), 0); 
		int b = Math.max(Math.min(this.getB() + value, ColorUtils.MAX), 0);
		
		return new Color(r, g, b);
	}
	
	/**
	 * A4 Color A is equal to Color B
	 */
	boolean isEqualTo (Color c) {
		if (c == null)
			return false;
		return this.rgb[0]==c.rgb[0] &&
			   this.rgb[1]==c.rgb[1] &&
			   this.rgb[2]==c.rgb[2];
	}
	
}
