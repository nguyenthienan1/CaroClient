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
		case LOGIN:
			ReadMessage.gI().loginSuccess();
			break;
		case LOG_OUT_SUCCESS:
			ReadMessage.gI().logOutSuccess();
			break;
		case SHOW_MESSAGE_DIALOG:
			ReadMessage.gI().showMessageDialog(m);
			break;
		case SEND_BOARD:
			ReadMessage.gI().setBoard(m);
			break;
		case JOIN_ROOM_SUCCESS:
			ReadMessage.gI().joinRoomSuccess(m);
			break;
		case SEND_LIST_ROOM:
			ReadMessage.gI().setListRoom(m);
			break;
		case LEAVE_ROOM_SUCCESS:
			ReadMessage.gI().leaveRoomSuccess();
			break;
		case CHAT_ROOM:
			ReadMessage.gI().setChatRoom(m);
			break;
		case RESET_BOARD:
			ReadMessage.gI().resetBoard();
			break;
		case LIST_PLAYER_ROOM:
			ReadMessage.gI().updateListPlayer(m);
			break;
		}
	}
}
