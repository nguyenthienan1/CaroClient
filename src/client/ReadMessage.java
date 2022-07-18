package client;

import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import caro.GameUI;
import caro.Room;
import io.Message;

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
					CaroClient.window.gameUI.boardPanel.matrix[i][j] = m.reader().readShort();
				}
			}
			CaroClient.window.gameUI.boardPanel.flagPiece.x = m.reader().readInt();
			CaroClient.window.gameUI.boardPanel.flagPiece.y = m.reader().readInt();
			CaroClient.window.gameUI.boardPanel.repaint();
		} catch (Exception e) {
		}
	}

	public void joinRoomOk(Message m) {
		try {
			m.reader().readInt();
			CaroClient.window.gameUI = new GameUI();
			CaroClient.window.setBoardUI();
		} catch (Exception e) {
		}
	}

	public void listRoom(Message m) {
		try {
			Vector<Room> listRooms = new Vector<Room>();
			int size = m.reader().readInt();
			for (int i = 0; i < size; i++) {
				int rN = m.reader().readInt();
				int s = m.reader().readInt();
				Room r = new Room(rN, s);
				listRooms.add(r);
			}
			CaroClient.window.roomUI.jlistRoom.setListData(listRooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBoard() {
		CaroClient.window.setRoomUI();
	}

	public void setChatRoom(Message m) {
		try {
			String content = m.reader().readUTF();
			content = CaroClient.window.gameUI.textShowChat.getText() + content + "\n";
			CaroClient.window.gameUI.textShowChat.setText(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
