package caro;

public class Room {
	private int RoomNumber;
	private int NumPlayers;

	public Room(int roomNum, int numPlayer) {
		RoomNumber = roomNum;
		NumPlayers = numPlayer;
	}

	public int getNumber() {
		return RoomNumber;
	}

	public int getNumOfPlayer() {
		return NumPlayers;
	}

	@Override
	public String toString() {
		return "Room number: " + RoomNumber + " - " + "Number of players: " + NumPlayers;
	}
}
