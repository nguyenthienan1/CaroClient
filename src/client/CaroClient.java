package client;

import javax.swing.UIManager;

import caro.BoardFrame;
import caro.ConnectFrame;
import caro.LoginFrame;
import caro.RoomFrame;
import io.Session;

public class CaroClient {
	public static Session conn = new Session();
	public static ConnectFrame connectFrame;
	public static BoardFrame boardFrame;
	public static LoginFrame loginFrame;
	public static RoomFrame roomFrame;

	public static void setLAF() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Failed to set LookAndFeel");
		}
	}

	public static void main(String[] args) {
		setLAF();
		connectFrame = new ConnectFrame();
		loginFrame = new LoginFrame();
		roomFrame = new RoomFrame();
		boardFrame = new BoardFrame();
		connectFrame.setVisible(true);
	}
}