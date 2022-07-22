package mlib;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.ConnectUI;
import ui.GameUI;
import ui.LoginUI;
import ui.RoomUI;

public class mWindow extends JFrame {
	private static final long serialVersionUID = 8560587936628025228L;
	public ConnectUI connectUI = new ConnectUI();
	public LoginUI loginUI = new LoginUI();
	public RoomUI roomUI = new RoomUI();
	public GameUI gameUI = new GameUI();

	public mWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Caro Game");
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int exit = JOptionPane.showConfirmDialog(null, "Exit game?", "Warning", JOptionPane.YES_NO_OPTION);
				if (exit == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	private void setPanel(Container panel) {
		setContentPane(panel);
		pack();
	}

	public void setConnectUI() {
		setPanel(connectUI);
	}

	public void setLoginUI() {
		setPanel(loginUI);
	}

	public void setRoomUI() {
		setPanel(roomUI);
	}

	public void setGameUI() {
		setPanel(gameUI);
	}

}
