package client;

import java.io.IOException;

import io.Cmd_Client2Server;
import io.Message;

public class GlobalService {
	private static GlobalService instance;

	public static GlobalService gI() {
		if (instance == null) {
			instance = new GlobalService();
		}
		return instance;
	}

	public void Login(String username, String password) {
		try {
			Message m = new Message(Cmd_Client2Server.LOGIN);
			m.writer().writeUTF(username);
			m.writer().writeUTF(password);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (IOException e) {
		}
	}

	public void Piece(int x, int y) {
		try {
			Message m = new Message(Cmd_Client2Server.PIECE);
			m.writer().writeInt(x);
			m.writer().writeInt(y);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
		}
	}

	public void CreateRoom() {
		try {
			Message m = new Message(Cmd_Client2Server.CREATE_ROOM);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
		}
	}

	public void JoinRoom(int RoomNumber) {
		try {
			Message m = new Message(Cmd_Client2Server.JOIN_ROOM);
			m.writer().writeInt(RoomNumber);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
		}
	}

	public void UpdateListRoom() {
		try {
			Message m = new Message(Cmd_Client2Server.UPDATE_LIST_ROOM);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void LeaveRoom() {
		try {
			Message m = new Message(Cmd_Client2Server.LEAVE_ROOM);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void ChatRoom(String content) {
		try {
			Message m = new Message(Cmd_Client2Server.CHAT_ROOM);
			m.writer().writeUTF(content);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
		}
	}

	public void Ready() {
		try {
			Message m = new Message(Cmd_Client2Server.READY);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
