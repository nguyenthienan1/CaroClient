package mlib;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {
	public static Image imgX;
	public static Image imgO;

	public void loadImage() {
		try {
			imgX = ImageIO.read(getClass().getResource("/image/X.png"));
			imgO = ImageIO.read(getClass().getResource("/image/O.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
