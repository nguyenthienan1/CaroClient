package client;

import javax.swing.UIManager;

import io.Session;
import mlib.MyImage;
import mlib.MyWindow;
import ui.ConnectUI;
import ui.GameUI;
import ui.LoginUI;
import ui.RoomUI;

public class CaroClient {
	public static Session conn = new Session();
	public static MyWindow window;
	public static ConnectUI connectUI;
	public static LoginUI loginUI;
	public static RoomUI roomUI;
	public static GameUI gameUI;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MyImage().loadImage();
		window = new MyWindow();
		connectUI = new ConnectUI();
		loginUI = new LoginUI();
		roomUI = new RoomUI();
		gameUI = new GameUI();
		
		window.setContentPane(connectUI);
		window.setVisible(true);
	}
}