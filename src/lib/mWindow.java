package lib;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.ConnectUI;
import ui.GameUI;
import ui.LoginUI;
import ui.RoomUI;

public class mWindow extends JFrame {
	private static final long serialVersionUID = 8560587936628025228L;
	public ConnectUI connectUI;
	public LoginUI loginUI;
	public RoomUI roomUI;
	public GameUI gameUI;

	public mWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Caro Game");
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int exit = JOptionPane.showConfirmDialog(null, "Exit game?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		connectUI = new ConnectUI();
		loginUI = new LoginUI();
		roomUI = new RoomUI();
		gameUI = new GameUI();
		setConnectUI();
	}
	
	@Override
	public void setContentPane(Container contentPane) {
		super.setContentPane(contentPane);
		pack();
	}

	public void setConnectUI() {
		setContentPane(connectUI);
	}

	public void setLoginUI() {
		setContentPane(loginUI);
	}

	public void setRoomUI() {
		setContentPane(roomUI);
	}

	public void setBoardUI() {
		setContentPane(gameUI);
	}

}
