package client;

import io.Cmd_Server2Client;
import io.Message;

public class HandleMessage extends Cmd_Server2Client {
	private static HandleMessage instance;

	public static HandleMessage gI() {
		if (instance == null) {
			instance = new HandleMessage();
		}
		return instance;
	}

	public void processMessage(Message m) {
		switch (m.command) {
		case Cmd_Server2Client.LOGIN:
			ReadMessage.gI().loginOk();
			break;
		case Cmd_Server2Client.LOG_OUT_OK:
			ReadMessage.gI().logOutOk();
			break;
		case Cmd_Server2Client.SHOW_MESSAGE_DIALOG:
			ReadMessage.gI().showMessageDialog(m);
			break;
		case Cmd_Server2Client.SEND_BOARD:
			ReadMessage.gI().setBoard(m);
			break;
		case Cmd_Server2Client.JOIN_ROOM_OK:
			ReadMessage.gI().joinRoomOk(m);
			break;
		case Cmd_Server2Client.SEND_LIST_ROOM:
			ReadMessage.gI().listRoom(m);
			break;
		case Cmd_Server2Client.LEAVE_ROOM_OK:
			ReadMessage.gI().leaveRoomOk();
			break;
		case Cmd_Server2Client.CHAT_ROOM:
			ReadMessage.gI().setChatRoom(m);
			break;
		}
	}
}
