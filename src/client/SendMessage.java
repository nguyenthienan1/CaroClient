package client;

import java.io.DataOutputStream;
import java.io.IOException;

import static io.Cmd_Client2Server.*;
import io.Message;

public class SendMessage {
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

	public void login(String username, String password) {
		try {
			init(LOGIN);
			writer().writeUTF(username);
			writer().writeUTF(password);
			send();
		} catch (IOException e) {
		}
	}

	public void register(String user, String pass, String repass) {
		try {
			init(REGISTER);
			writer().writeUTF(user);
			writer().writeUTF(pass);
			writer().writeUTF(repass);
			send();
		} catch (IOException e) {
		}
	}

	public void logOut() {
		try {
			init(LOG_OUT);
			send();
		} catch (Exception e) {
		}
	}

	public void piece(int x, int y) {
		try {
			init(PIECE);
			writer().writeInt(x);
			writer().writeInt(y);
			send();
		} catch (Exception e) {
		}
	}

	public void createRoom() {
		try {
			init(CREATE_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void joinRoom(int RoomNumber) {
		try {
			init(JOIN_ROOM);
			writer().writeInt(RoomNumber);
			send();
		} catch (Exception e) {
		}
	}

	public void updateListRoom() {
		try {
			init(UPDATE_LIST_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void leaveRoom() {
		try {
			init(LEAVE_ROOM);
			send();
		} catch (Exception e) {
		}
	}

	public void chatRoom(String content) {
		try {
			init(CHAT_ROOM);
			writer().writeUTF(content);
			send();
		} catch (Exception e) {
		}
	}

	public void ready() {
		try {
			init(READY);
			send();
		} catch (Exception e) {
		}
	}
	
	public void addBot() {
		try {
			init(ADD_BOT);
			send();
		} catch (Exception e) {
		}
	}
}
