package game;

public class TicTacToe extends Game {

	// constructor - creates a 3x3 board with two players using fixed marks
	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}

	@Override
	protected boolean doesWin(int i, int j) {
		// checks if the player has a full line of 3
		return maxLineContaining(i, j) == 3;
	}
}
