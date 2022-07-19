package caro;

public class Room {
	private int RoomNumber;
	private int NumPlayers;
	private boolean Status;

	public Room(int roomNum, int numPlayer, boolean status) {
		RoomNumber = roomNum;
		NumPlayers = numPlayer;
		Status = status;
	}

	public int getNumber() {
		return RoomNumber;
	}

	public int getNumOfPlayer() {
		return NumPlayers;
	}
	
	public String getStatus() {
		return Status ? "Fight" : "Wait";
	}

	@Override
	public String toString() {
		return "Room number: " + RoomNumber + " - " + "Number of players: " + NumPlayers;
	}
}
