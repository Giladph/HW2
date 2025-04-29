package game;

public class Board {
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {

		board = new Player[n][m];
	}

	protected boolean set(int i, int j, Player p) {
		if (board[i][j] == null) {
			board[i][j] = p;
			return true;
		}
		return false;

	}

	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null) {
			return true;
		}
		return false;
	}

	public Player get(int i, int j) {
		return board[i][j];
	}

	public boolean isFull() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(isEmpty(i,j)==true) { // if found empty cell not full
					return false;
				}
				
			}
			
		}
		return true;
	}
	
	
	
	
	public String toString() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
	}
		}
	
	

}
