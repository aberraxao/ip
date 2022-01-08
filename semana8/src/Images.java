class Images {

	// B1 Posterize effect
	static void posterize(ColorImage img, Color dark, Color light) {
		for (int x = 0; x < img.getWidth(); x++)
			for (int y = 0; y < img.getHeight(); y++)
				if (img.getColor(x, y).getLuminance() < 128)
					img.setColor(x, y, dark);
				else
					img.setColor(x, y, light);
	}

	// B2 Pop art effect
	static final Color[][] popArtColors = { { Color.DARK_CYAN, Color.LIGHT_CYAN }, { Color.DARK_RED, Color.LIGHT_RED },
			{ Color.DARK_GREEN, Color.LIGHT_GREEN }, { Color.DARK_PURPLE, Color.LIGHT_PURPLE } };

	static ColorImage popArt(ColorImage img) {

		ColorImage newImg = new ColorImage(2 * img.getWidth(), 2 * img.getHeight());

		int i = 0;
		for (int x = 0; x < 2; x++)
			for (int y = 0; y < 2; y++) {
				ColorImage copy = img.copy();
				Images.posterize(copy, popArtColors[i][0], popArtColors[i][1]);
				if (x % 2 != 0)
					copy.mirror();
				newImg.paste(copy, x * img.getWidth(), y * img.getHeight());
				i++;
			}

		return newImg;
	}
	
	// C1 Image into a Vector of images
	static ColorImage[] imgVect(ColorImage img) {

		ColorImage[] newImg = new ColorImage[4];

		int i = 0;
		for (int x = 0; x < img.getWidth()-1; x = x + img.getWidth() / 2)
			for (int y = 0; y < img.getHeight()-1; y = y + img.getHeight() / 2) {
				newImg[i] = img.selection(x, y, x + img.getWidth() / 2, y + img.getHeight() / 2);
				i++;
			}

		return newImg;
	}
	
	// C2 Put 2 images together
	static ColorImage horizontalMerge(ColorImage img1, ColorImage img2) {

		ColorImage newImg = new ColorImage(img1.getWidth()+ img2.getWidth(), img1.getHeight());

		newImg.paste(img1, 0, 0);
		newImg.paste(img2, img1.getWidth(), 0);

		return newImg;
	}

}