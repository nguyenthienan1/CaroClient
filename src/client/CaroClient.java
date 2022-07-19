package client;

import java.awt.EventQueue;

import io.Session;
import lib.mImage;
import lib.mWindow;
import ui.RegisterFrame;

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