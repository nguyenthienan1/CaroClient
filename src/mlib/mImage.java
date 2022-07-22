package mlib;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class mImage {
	public static Image imgX;
	public static Image imgO;
	public static mImage instance;

	public static mImage gI() {
		if (instance == null) {
			instance = new mImage();
		}
		return instance;
	}

	public void loadImage() {
		try {
			imgX = ImageIO.read(getClass().getResourceAsStream("/image/X.png"));
			imgO = ImageIO.read(getClass().getResourceAsStream("/image/O.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
