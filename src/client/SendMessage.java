package client;

import java.io.DataOutputStream;
import java.io.IOException;

import io.Cmd_Client2Server;
import io.Message;

public class SendMessage extends Cmd_Client2Server {
	private static SendMessage instance;
	private Message message = null;

	public static SendMessage gI() {
		if (instance == null) {
			instance = new SendMessage();
		}
		return instance;
	}

	private void init(int cmd) {
		message = new Message(cmd);
	}

	private DataOutputStream writer() {
		return message.writer();
	}

	private void send() {
		CaroClient.conn.sendMessage(message);
	}

	public void Login(String username, String password) {
		try {
			init(LOGIN);
			writer().writeUTF(username);
			writer().writeUTF(password);
			send();
		} catch (IOException e) {
		}
	}

	public void Register(String user, String pass, String repass) {
		try {
			init(REGISTER);
			writer().writeUTF(user);
			writer().writeUTF(pass);
			writer().writeUTF(repass);
			send();
		} catch (IOException e) {
		}
	}

	public void LogOut() {
		try {
			init(LOG_OUT);
			send();
		} catch (Exception e) {
		}
	}

	public void Piece(int x, int y) {
		try {
			init(PIECE);
			writer().writeInt(x);
			writer().writeInt(y);
			send();
		} catch (Exception e) {
		}
	}

	public void CreateRoom() {
		try {
			init(CREATE_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void JoinRoom(int RoomNumber) {
		try {
			init(JOIN_ROOM);
			writer().writeInt(RoomNumber);
			send();
		} catch (Exception e) {
		}
	}

	public void UpdateListRoom() {
		try {
			init(UPDATE_LIST_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void LeaveRoom() {
		try {
			init(LEAVE_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void ChatRoom(String content) {
		try {
			init(CHAT_ROOM);
			writer().writeUTF(content);
			send();
		} catch (Exception e) {
		}
	}

	public void Ready() {
		try {
			init(READY);
			send();
		} catch (Exception e) {
		}
	}
}
