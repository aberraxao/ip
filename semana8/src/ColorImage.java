/**
 * Represents color images. Image data is represented as a matrix: - the number
 * of lines corresponds to the image height (data.length) - the length of the
 * lines corresponds to the image width (data[*].length) - pixel color is
 * encoded as integers (ARGB)
 */
class ColorImage {

	private int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}

	void inversa() {
		for (int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < this.getHeight(); y++)
				setColor(x, y, this.getColor(x, y).inverted());
	}

	void brighter(int value) {
		for (int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < this.getHeight(); y++)
				setColor(x, y, this.getColor(x, y).brighter(value));
	}

	void mirror() {
		for (int x = 0; x < this.getWidth() / 2; x++)
			for (int y = 0; y < this.getHeight(); y++) {
				Color auxColor = getColor(x, y);
				int pX = this.getWidth() - 1 - x;
				setColor(x, y, getColor(pX, y));
				setColor(pX, y, auxColor);
			}
	}

	void paste1(ColorImage img, int xi, int yi) {
		// Going through the big picture to ensure
		// that we are between bounds
		// if xi or yi negatives, make xi or yi = 0
		if (xi < 0)
			xi = 0;
		if (yi < 0)
			yi = 0;

		for (int x = xi; x < this.getWidth() & x - xi < img.getWidth(); x++)
			for (int y = yi; y < this.getHeight() & y - yi < img.getHeight(); y++)
				this.setColor(x, y, img.getColor(x - xi, y - yi));
	}

	void paste(ColorImage img, int xi, int yi) {
		// Going through the big picture to ensure
		// that we are between bounds
		for (int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < this.getHeight(); y++) {

				if (x > xi && x < xi + img.getWidth() && y > yi && y < yi + img.getHeight())
					this.setColor(x, y, img.getColor(x - xi, y - yi));
			}
	}

	ColorImage blackWhite() {
		ColorImage newImg = new ColorImage(this.getWidth(), this.getHeight());

		for (int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < this.getHeight(); y++)
				if (this.getColor(x, y).getLuminance() >= 128)
					newImg.setColor(x, y, Color.WHITE);

		return newImg;
	}

	ColorImage copy() {
		ColorImage newImg = new ColorImage(this.getWidth(), this.getHeight());

		for (int x = 0; x < this.getWidth(); x++)
			for (int y = 0; y < getHeight(); y++)
				newImg.setColor(x, y, this.getColor(x, y));

		return newImg;
	}

	ColorImage selection(int startx, int starty, int endx, int endy) {
		ColorImage newImg = new ColorImage(endx - startx + 1, endy - starty + 1);

		for (int x = startx; x < endx; x++)
			for (int y = starty; y < endy; y++)
				newImg.setColor(x- startx, y - starty, this.getColor(x, y));

		return newImg;
	}
}