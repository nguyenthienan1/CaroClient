package client;

import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import caro.Room;
import io.Message;
import ui.GamePane;

public class ReadMessage {
	private static ReadMessage instance;

	public static ReadMessage gI() {
		if (instance == null) {
			instance = new ReadMessage();
		}
		return instance;
	}

	public void loginSuccess() {
		CaroClient.window.setContentPane(CaroClient.roomUI);
	}

	public void logOutSuccess() {
		CaroClient.window.setContentPane(CaroClient.loginUI);
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
					CaroClient.gameUI.setPiece(i, j, m.reader().readShort());
				}
			}
			CaroClient.gameUI.setFlagPiece(m.reader().readInt(), m.reader().readInt());
		} catch (Exception e) {
		}
	}

	public void joinRoomSuccess(Message m) {
		try {
			m.reader().readInt();
			CaroClient.gameUI = new GamePane();
			CaroClient.window.setContentPane(CaroClient.gameUI);
			CaroClient.window.setBounds(CaroClient.window.getBounds().x, CaroClient.window.getBounds().y, 900, 700);
		} catch (Exception e) {
		}
	}

	public void setListRoom(Message m) {
		try {
			Vector<Room> vRooms = new Vector<Room>();
			int size = m.reader().readInt();
			for (int i = 0; i < size; i++) {
				int rN = m.reader().readInt();
				int s = m.reader().readInt();
				boolean f = m.reader().readBoolean();
				vRooms.add(new Room(rN, s, f));
			}
			CaroClient.roomUI.setListRoom(vRooms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leaveRoomSuccess() {
		CaroClient.window.setContentPane(CaroClient.roomUI);
	}

	public void setChatRoom(Message m) {
		try {
			CaroClient.gameUI.addTextChat(m.reader().readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void resetBoard() {
		if (CaroClient.window.getContentPane() == CaroClient.gameUI) {
			CaroClient.gameUI.resetBoard();
		}
	}
	
	public void updateListPlayer(Message m) {
		try {
			int type = m.reader().readByte();
			int size = m.reader().readInt();
			Vector<String> players = new Vector<>();
			for (int i = 0; i < size; i++) {
				players.add(m.reader().readUTF());
			}
			
			if (type == 0) {
				CaroClient.gameUI.updatePlayerRoom(players);
			} else if (type == 1){
				CaroClient.gameUI.updateSpectatingPlayer(players);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateLabelInfoRoom(Message m) {
		try {
			String info = m.reader().readUTF();
			CaroClient.gameUI.setInfo(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
