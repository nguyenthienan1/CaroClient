package caro;

public class Room {
	private int roomNumber;
	private int numPlayers;
	private boolean status;

	public Room(int number, int numplayer, boolean stas) {
		roomNumber = number;
		numPlayers = numplayer;
		status = stas;
	}

	public int getNumber() {
		return roomNumber;
	}

	public int getNumOfPlayer() {
		return numPlayers;
	}

	public String getStatus() {
		return status ? "fighting" : "waiting";
	}

	@Override
	public String toString() {
		return "Room number: " + roomNumber + " - " + "Number of players: " + numPlayers;
	}
}
