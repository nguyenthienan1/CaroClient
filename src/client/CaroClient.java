package client;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import mlib.MyImage;
import mlib.MyWindow;
import network.Session;
import ui.GamePane;
import ui.LoginPane;
import ui.ListRoomPane;

public class CaroClient {
	public static Session conn = new Session();
	public static MyWindow window;
	public static LoginPane loginUI;
	public static ListRoomPane roomUI;
	public static GamePane gameUI;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		MyImage.loadImage();
		window = new MyWindow();
		loginUI = new LoginPane();
		roomUI = new ListRoomPane();
		gameUI = new GamePane();

		window.setContentPane(loginUI);
		window.setVisible(true);
	}
}