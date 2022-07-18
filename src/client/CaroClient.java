package client;

import java.awt.EventQueue;

import caro.RegisterFrame;
import io.Session;
import lib.mImage;
import lib.mWindow;

public class CaroClient {
	public static Session conn = new Session();
	public static mWindow window = new mWindow();
	public static RegisterFrame registerFrame = new RegisterFrame();

	public static void main(String[] args) {
		mImage.gI().loadImage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}