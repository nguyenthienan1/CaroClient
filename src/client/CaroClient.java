package client;

import java.awt.EventQueue;

import io.Session;
import mlib.mImage;
import mlib.mWindow;
import ui.ConnectUI;
import ui.GameUI;
import ui.LoginUI;
import ui.RoomUI;

public class CaroClient {
	public static Session conn = new Session();
	public static mWindow window = new mWindow();
	public static ConnectUI connectUI = new ConnectUI();
	public static LoginUI loginUI = new LoginUI();
	public static RoomUI roomUI = new RoomUI();
	public static GameUI gameUI = new GameUI();

	public static void main(String[] args) {
		mImage image = new mImage();
		image.loadImage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setContentPane(connectUI);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}