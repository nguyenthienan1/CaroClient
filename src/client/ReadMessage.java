package client;

import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import caro.BoardFrame;
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
		CaroClient.loginFrame.setVisible(false);
		CaroClient.roomFrame.setVisible(true);
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
					CaroClient.boardFrame.boardPanel.matrix[i][j] = m.reader().readShort();
				}
			}
			CaroClient.boardFrame.boardPanel.flagPiece.x = m.reader().readInt();
			CaroClient.boardFrame.boardPanel.flagPiece.y = m.reader().readInt();
			CaroClient.boardFrame.boardPanel.repaint();
		} catch (Exception e) {
		}
	}

	public void joinRoomOk(Message m) {
		try {
			int num = m.reader().readInt();
			CaroClient.roomFrame.setVisible(false);
			CaroClient.boardFrame = new BoardFrame();
			CaroClient.boardFrame.setTitle("Room: " + num);
			CaroClient.boardFrame.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
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
			CaroClient.roomFrame.jlistRoom.setListData(listRooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBoard() {
		CaroClient.boardFrame.setVisible(false);
		CaroClient.roomFrame.setVisible(true);
	}

	public void setChatRoom(Message m) {
		try {
			String content = m.reader().readUTF();
			content = CaroClient.boardFrame.textShowChat.getText() + content + "\n";
			CaroClient.boardFrame.textShowChat.setText(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
