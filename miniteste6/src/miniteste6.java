class miniteste6 {
	// a Create a random image
	static BinaryImage randomBinaryImage(int w, int h) {
		BinaryImage img = new BinaryImage(w, h);

		System.out.println(img.getWidth() + " " + img.getHeight());

		// SUPER IMPORTANT!!!
		for (int i = 0; i < img.getHeight(); i++) // rows = y axis
			for (int j = 0; j < img.getWidth(); j++) // columns = x axis
				if (Math.random() < 0.5) {
					// no need img.setBlack, 'cause it initiates with black
					img.setWhite(j, i);
				}

		return img;
	}

	static void paintSquare(BinaryImage img, int x, int y, int side) {
		for (int i = y; i < y + side; i++) // rows = y axis
			for (int j = x; j < x + side; j++) // columns = x axis
				img.setWhite(j, i);
	}

	static void testScale() {
		int w = 200, h = 200;
		BinaryImage img = randomBinaryImage(w, h);
		for (int y = 0; y != img.getHeight(); y++) {
			img.setBlack(0, y);
			img.setBlack(img.getWidth() - 1, y);
		}
		System.out.println('1');
	}

	static Color f(Color c, int value) {

		int r = Math.max(0, Math.min(255, c.getR() + value));

		int g = Math.max(0, Math.min(255, c.getG() + value));

		int b = Math.max(0, Math.min(255, c.getB() + value));

		return new Color(r, g, b);

	}

	static void test4() {
		Color c = new Color(255, 255, 255);
		f(c, -50);

		System.out.println('1');
	}

	static BinaryImage createChessBoard2(int side) {
		int a = 8 * side;

		// Black board by default
		BinaryImage board = new BinaryImage(a, a);

		// Now we paint the white squares
		for (int i = 0; i < board.getHeight(); i = i + 2 * side)
			for (int j = 0; j < board.getWidth(); j = j + 2 * side) {
				paintSquare(board, j, i, side);
				// No idea why this doesn't bug below, but I'm happy =)
				paintSquare(board, j + side, i + side, side);
			}

		// Paints the sides of the board

		return board;
	}

	static BinaryImage f(BinaryImage img) {

		BinaryImage result = new BinaryImage(img.getWidth(), img.getHeight());

		for (int x = 0; x != img.getWidth(); x++) {

			for (int y = 0; y != img.getHeight(); y++) {
				if (!img.isBlack(x, y)) {
					if (Math.random() < 0.8) {
						result.setWhite(x, y);
					}

				} else {
					result.setBlack(x, y);
				}
			}
		}
		return result;
	}

	static void teste4() {
		BinaryImage chess = createChessBoard2(15);

		f(chess);

	}
}