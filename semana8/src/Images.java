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
	static final Color[][] popArtColors = { 
			{ Color.DARK_CYAN, Color.LIGHT_CYAN },
			{ Color.DARK_RED, Color.LIGHT_RED },
			{ Color.DARK_GREEN, Color.LIGHT_GREEN }, 
			{ Color.DARK_PURPLE, Color.LIGHT_PURPLE } };

	static ColorImage popArt(ColorImage img) {

		ColorImage newImg = new ColorImage(2 * img.getWidth(), 2 * img.getHeight());

		int i = 0;
		for (int x = 0; x < 2; x++)
			for (int y = 0; y < 2; y++) {
				ColorImage copy = img.copy();
				Images.posterize(copy, popArtColors[i][0], popArtColors[i][1]);
				if (x%2 != 0)
					copy.mirror();
				newImg.paste(copy, x * img.getWidth(), y * img.getHeight());
				i++;
			}

		return newImg;
	}

}