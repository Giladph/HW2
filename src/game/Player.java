package game;

public class Player {
	
	private String name; // player's name
	private char mark;   // symbol used on the board
	
	// constructor - initializes player's name and mark
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	// returns the player's name
	public String getName() {
		return this.name;
	}
	
	// returns the player's mark
	public char getMark() {
		return this.mark;
	}
	
	// returns a string representation of the player
	public String toString() {
		return String.format("%s(%c)", getName(), getMark());
	}
}
