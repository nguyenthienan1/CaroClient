package client;

import java.io.IOException;

import io.Cmd_Client2Server;
import io.Message;

public class GlobalService extends Cmd_Client2Server {
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

	public void Register(String user, String pass, String repass) {
		try {
			Message m = new Message(Cmd_Client2Server.REGISTER);
			m.writer().writeUTF(user);
			m.writer().writeUTF(pass);
			m.writer().writeUTF(repass);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (IOException e) {
		}
	}

	public void LogOut() {
		Message m = new Message(Cmd_Client2Server.LOG_OUT);
		CaroClient.conn.sendMessage(m);
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
		}
	}

	public void LeaveRoom() {
		try {
			Message m = new Message(Cmd_Client2Server.LEAVE_ROOM);
			CaroClient.conn.sendMessage(m);
			m.cleanup();
		} catch (Exception e) {
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
		}
	}
}
