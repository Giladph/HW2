package game;

public class TicTacToe extends Game {

	public TicTacToe(String player1, String player2) {
		// לוח 3 על 3, שחקנים עם סימנים קבועים
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}

	@Override
	protected boolean doesWin(int i, int j) {
		// משתמשים בפונקציה maxLineContaining מהמחלקה Board
		return maxLineContaining(i, j) == 3;
	}
}
