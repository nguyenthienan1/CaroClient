package client;

import java.awt.EventQueue;

import io.Session;
import mlib.mImage;
import mlib.mWindow;

public class CaroClient {
	public static Session conn = new Session();
	public static mWindow window = new mWindow();

	public static void main(String[] args) {
		mImage.gI().loadImage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setConnectUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}