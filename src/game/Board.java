package game;

public class Board {
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		   this.n = n;
		    this.m = m;
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
				if (isEmpty(i, j) == true) { // if found empty cell not full
					return false;
				}

			}

		}
		return true;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (isEmpty(i, j)) {
	                sb.append("."); // מקום ריק
	            } else {
	                sb.append(board[i][j].getMark()); // מניח ש־Player עצמו יודע להחזיר משהו ב־toString
	            }
	            sb.append(" "); // רווח בין תאים
	        }
	        sb.append("\n"); // ירידת שורה בסוף כל שורה
	    }

	    return sb.toString();
	}

	
	public static void main(String[] args) {
		Player p1 = new Player("Bibi", 'B');
		Player p2 = new Player("Gantz", 'G');
		Board b = new Board(3,4);
		b.set(0, 0, p1);
		b.set(1, 0, p1);
		b.set(2, 2, p2);
		b.set(0, 0, p2);
		b.set(0, 1, p1);
		System.out.print(b);

	}

}
