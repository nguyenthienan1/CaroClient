package mlib;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {
	public static Image imgX;
	public static Image imgO;

	public static void loadImage() {
		try {
			imgX = ImageIO.read(MyImage.class.getResource("/image/X.png"));
			imgO = ImageIO.read(MyImage.class.getResource("/image/O.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
