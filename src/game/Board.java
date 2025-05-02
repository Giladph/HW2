package game;

public class Board {
	protected Player[][] board; // the board itself (2D array of players)
	protected int n, m;         // board dimensions: rows (n) and columns (m)

	// constructor - creates an empty board of size n x m
	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	// tries to place a player in (i,j), returns true if successful
	protected boolean set(int i, int j, Player p) {
		if (board[i][j] == null) {
			board[i][j] = p;
			return true;
		}
		return false;
	}

	// checks if cell (i,j) is empty
	public boolean isEmpty(int i, int j) {
		return board[i][j] == null;
	}

	// returns the player in cell (i,j)
	public Player get(int i, int j) {
		return board[i][j];
	}

	// returns true if all cells are filled
	public boolean isFull() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	// returns a string representation of the board
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (isEmpty(i, j)) {
	                sb.append("."); // empty cell
	            } else {
	                sb.append(board[i][j].getMark()); // show player mark
	            }
	        }
	        sb.append("\n");
	    }

	    return sb.toString();
	}

	// returns the longest line passing through (i,j) for the same player
	protected int maxLineContaining(int i, int j) {
	    if (!isInBoard(i, j) || isEmpty(i, j)) {
	        return 0;
	    }

	    int max = 0;

	    int h = rayLength(i, j, 0, 1) + rayLength(i, j, 0, -1) + 1;
	    if (h > max) max = h;

	    int v = rayLength(i, j, 1, 0) + rayLength(i, j, -1, 0) + 1;
	    if (v > max) max = v;

	    int d1 = rayLength(i, j, 1, 1) + rayLength(i, j, -1, -1) + 1;
	    if (d1 > max) max = d1;

	    int d2 = rayLength(i, j, 1, -1) + rayLength(i, j, -1, 1) + 1;
	    if (d2 > max) max = d2;

	    return max;
	}

	// checks if (i,j) is a valid cell inside the board
	private boolean isInBoard(int i, int j) {
	    return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
	}

	// returns how many same-player cells exist in direction (di,dj) from (i,j)
	private int rayLength(int i, int j, int di, int dj) {
	    if (di == 0 && dj == 0) return 0;
	    if (!isInBoard(i, j) || isEmpty(i, j)) return 0;

	    Player current = get(i, j);
	    int count = 0;

	    i += di;
	    j += dj;

	    while (isInBoard(i, j) && get(i, j) == current) {
	        count++;
	        i += di;
	        j += dj;
	    }

	    return count;
	}
}
