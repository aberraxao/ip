class Color {

	 static final Color RED = new Color(255, 0, 0);

	    int[] rgb;
    Color(int r, int g, int b) {
        //rgb[0] = r;
        //this.rgb[1] = g;
        //this.rgb[2] = b;
        this.rgb = new int[] {r, g, b};
    }

    boolean isEqualTo(Color c) {
        if(c == null) {
            return false;
        }
        return rgb[0] == c.rgb[0] && rgb[1] == c.rgb[1] && rgb[2] == c.rgb[2];
    }
}