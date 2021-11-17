class Aula7 {
	// EXAMPLE COLOUR
	static void exemple() {
		Color c = new Color(255, 0, 0); // vermelho
		
		int r = c.getR(); // 255, componente de vermelho
		int g = c.getG();  // 0, componente de verde
		int b = c.getB(); // 0, componente de azul
		
		System.out.println("("+r+","+g+","+b+")");
	}
	
	// Colours
	
	// Function to print a colour
	static void printColor(Color color) {
		System.out.println("red=" + color.getR() + ", "
					     + "green=" + color.getG() + ", "
					     + "blue=" + color.getB());
	} 
	
	// a Build a random colour
	static Color randomColor() {
		int r = (int)(256*Math.random());
		int g = (int)(256*Math.random());
		int b = (int)(256*Math.random());
		
		Color c = new Color(r, g, b);
		
		return c;
	}
	
	static void testRandomColor() {
		Color c = randomColor();
		printColor(c);
	}
	
	// b Build a vector that contains random colours for
	// a given length
	
	static Color[] randomColorArray(int length) {
		Color c[] = new Color[length];
		
		for(int i=0; i<length; i++)
			c[i] = randomColor();
		
		return c;
	}
	
	static void testRandomColorArray() {
		int r = 5;
		Color[] c = randomColorArray(r);
		for(int i=0; i<r; i++)
			printColor(c[i]);
	}
	
	// c For a given colour, get the inverse colour
	// (255 - R, 255 - G, 255 - B)
	static Color inverted(Color color) {
		Color c = new Color(255 - color.getR(), 255 - color.getG(), 255 - color.getB());
		
		return c;
	}
	
	static void testInverted() {
		Color c = new Color(255, 0, 0);
		printColor(c);
		printColor(inverted(c));
	}
	
	// d For a given colour, obtain a lighter / darker
	// colour based on delta
	static Color changeBrightness (Color color, int delta) {
		Color c = new Color(
				Math.max(Math.min(color.getR() + delta,255),0), 
				Math.max(Math.min(color.getG() + delta,255),0), 
				Math.max(Math.min(color.getB() + delta,255),0));
					
		return c;
	}
	
	static void testChangeBrightness() {
		int delta = 40;
		Color c = new Color(255, 123, 0);
		
		printColor(c);
		
		printColor(changeBrightness(c, delta));
	}
	
	// EXAMPLE IMAGE, pixel = picture element
	static void testExample() {
		// dimensão 200x100, todos os pixeis a preto
		BinaryImage img = new BinaryImage(200, 100);
		
		// 200, largura em pixeis
		int w = img.getWidth();
		// 100, altura em pixeis
		int h = img.getHeight();
		// pinta o pixel do canto superior esquerdo de branco
		img.setWhite(0, 0); 
		// pinta  o pixel do canto inferior direito de preto
		img.setBlack(img.getWidth() - 1, img.getHeight() - 1);
		// false, dado que o pixel (0, 0) não tem a cor preta
		boolean b = img.isBlack(0, 0); 
		// true, dado que a coordenada (50, 50) é válida para uma imagem de 200x100
		boolean v = img.validPosition(50, 50);
	}
	
	// a Create a random image
	static BinaryImage randomBinaryImage (int w, int h) {
		BinaryImage img = new BinaryImage(w, h);
		
		System.out.println(img.getWidth() + " " + img.getHeight());
		
		// SUPER IMPORTANT!!!
		for (int i=0; i<img.getHeight(); i++) // rows = y axis
			for (int j=0; j<img.getWidth(); j++) // columns = x axis
				if (Math.random() < 0.5) {
					// no need img.setBlack, 'cause it initiates with black
					img.setWhite(j, i);
					}
		
		return img;
	}
	
	static void testRandomBinaryImage() {
		int w=200, h=100;
		randomBinaryImage(w, h);
	}
	
	// b Fill a white square for a given superior left edge (x,y)
	// and length
	static void paintSquare(BinaryImage img, int x, int y, int side) {
		for (int i=y; i<y+side; i++) // rows = y axis
			for (int j=x; j<x+side; j++) // columns = x axis
				img.setWhite(j, i);
	}
	
	static void testPaintSquare() {
		int w=200, h=100;
		int x=100, y=50, side=25;
		
		BinaryImage img = randomBinaryImage(w, h);
		
		paintSquare(img, x, y, side);
	}
	
	// c Limit the image with black
	static void paintSides(BinaryImage img) {
		for (int i=0; i<img.getHeight(); i++) // rows = y axis
			for (int j=0; j<img.getWidth(); j++) // columns = x axis
				if (i ==0 || i==img.getHeight()-1 || 
					j==0 || j==img.getWidth()-1)
						img.setBlack(j, i);

	}
	
	static void testPaintSides() {
		int w=200, h=100;
		
		BinaryImage img = randomBinaryImage(w, h);
		
		paintSides(img);
	}
	
	// d Create a chess board: 8x8
	static void createChessBoard(int side) {
		int a = 8 * side;
		
		// Black board by default
		BinaryImage board = new BinaryImage(a, a);
		
		// Now we paint the white squares of the odd rows
		for (int i=0; i<board.getHeight(); i=i+2*side) // rows = y axis
			for (int j=0; j<board.getWidth(); j=j+2*side) // columns = x axis
				paintSquare(board, j, i, side);
		
		// Now we paint the white squares of the even rows
		for (int i=side; i<board.getHeight(); i=i+2*side) // rows = y axis
			for (int j=side; j<board.getWidth(); j=j+2*side) // columns = x axis
				paintSquare(board, j, i, side);

		// Paints the sides of the board
		paintSides(board);
	}
	
	static BinaryImage createChessBoard2(int side) {
		int a = 8 * side;
		
		// Black board by default
		BinaryImage board = new BinaryImage(a, a);
		
		// Now we paint the white squares
		for (int i=0; i<board.getHeight(); i=i+2*side)
			for (int j=0; j<board.getWidth(); j=j+2*side) {
				paintSquare(board, j, i, side);
				// No idea why this doesn't bug below, but I'm happy =)
				paintSquare(board, j+side, i+side, side);
			}
		
		// Paints the sides of the board
		paintSides(board);
		
		return board;
	}
	
	static void testCreateChessBoard() {
		int side = 15;
		
		createChessBoard2(side);
	}
	
	// e Invert a binary image 
	static BinaryImage invertChess(BinaryImage board) {
		
		for (int i=0; i<board.getHeight(); i++)
			for (int j=0; j<board.getWidth(); j++) {
				if(board.isBlack(j,i))
					board.setWhite(j,i);
				else
					board.setBlack(j,i);
			}
		
		return board;
	}
	
	static void testInvertChess() {
		int side = 15;
		BinaryImage board = createChessBoard2(side);
		BinaryImage boardInverted =invertChess(board);
	}
	
	// f Create a scaled image by a factor
	static BinaryImage scale(BinaryImage img, int factor) {
		BinaryImage imgscaled = new BinaryImage(img.getWidth()*factor, 
												img.getHeight()*factor);
				
		for (int i=0; i<img.getHeight(); i++)
			for (int j=0; j<img.getWidth(); j++)
				if (img.isBlack(j,i) == false)
					paintSquare(imgscaled, j*factor, i*factor, factor);
		
		return imgscaled;
	}
	
	static void testScale() {
		BinaryImage chess = createChessBoard2(15);
		BinaryImage chessScaled = scale(chess, 2);
	}
	
	// g Create a binary image by overlapping 2 images
	// If a pixel is white on both => white
	// If a pixel is black in one => black
	static BinaryImage merge(BinaryImage img, BinaryImage imgBig) {

		for (int i=0; i<img.getHeight(); i++)
			for (int j=0; j<img.getWidth(); j++)
				if (img.isBlack(j,i) || imgBig.isBlack(j,i))
					imgBig.setBlack(j, i);
		
		return imgBig;
	}
	
	static void testMerge() {
		BinaryImage chess = createChessBoard2(15);
		BinaryImage chessScaled = scale(chess, 2);
		BinaryImage chessMerged = merge(chess, chessScaled);
	}
	
	// h Paint a circle of random points, for a given centre and radius
	// circumference: (x-x0)² + (y-y0)² = r²
	// circle: sqrt[(x-x0)² + (y-y0)²] < r
	static void paintCircle(BinaryImage img, int x, int y, int r) {

		for (int i=0; i<img.getHeight(); i++)
			for (int j=0; j<img.getWidth(); j++)
				if (Math.sqrt((x-j)*(x-j) + (y-i)*(y-i)) < r)
					if (Math.random()<0.5)
						img.setWhite(j, i);
	}
	
	static void testPaintCircle() {
		int w=100, h=200;
		int x=50, y=100, r=20;
		
		BinaryImage img = new BinaryImage(w, h);
		paintCircle(img, x, y, r);
	}
}