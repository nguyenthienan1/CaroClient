package client;

import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import caro.Room;
import io.Message;
import ui.GameUI;

public class ReadMessage {
	private static ReadMessage instance;

	public static ReadMessage gI() {
		if (instance == null) {
			instance = new ReadMessage();
		}
		return instance;
	}

	public void loginOk() {
		CaroClient.window.setRoomUI();
	}

	public void logOutOk() {
		CaroClient.window.setLoginUI();
	}

	public void showMessageDialog(Message m) {
		try {
			JOptionPane.showMessageDialog(null, m.reader().readUTF());
		} catch (Exception e) {
		}
	}

	public void setBoard(Message m) {
		try {
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					CaroClient.window.gameUI.setPiece(i, j, m.reader().readShort());
				}
			}
			CaroClient.window.gameUI.setFlagPiece(m.reader().readInt(), m.reader().readInt());
		} catch (Exception e) {
		}
	}

	public void joinRoomOk(Message m) {
		try {
			m.reader().readInt();
			CaroClient.window.gameUI = new GameUI();
			CaroClient.window.setGameUI();
		} catch (Exception e) {
		}
	}

	public void listRoom(Message m) {
		try {
			Vector<Room> vRooms = new Vector<Room>();
			int size = m.reader().readInt();
			for (int i = 0; i < size; i++) {
				int rN = m.reader().readInt();
				int s = m.reader().readInt();
				boolean f = m.reader().readBoolean();
				vRooms.add(new Room(rN, s, f));
			}
			CaroClient.window.roomUI.setListRoom(vRooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leaveRoomOk() {
		CaroClient.window.setRoomUI();
	}

	public void setChatRoom(Message m) {
		try {
			CaroClient.window.gameUI.addTextChat(m.reader().readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
