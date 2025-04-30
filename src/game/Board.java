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
	
	
	protected int maxLineContaining(int i, int j) {
	    if (!isInBoard(i, j) || isEmpty(i, j)) {
	        return 0;
	    }

	    int max = 0;

	    int h = rayLength(i, j, 0, 1) + rayLength(i, j, 0, -1) + 1;
	    if (h > max) {
	        max = h;
	    }

	    int v = rayLength(i, j, 1, 0) + rayLength(i, j, -1, 0) + 1;
	    if (v > max) {
	        max = v;
	    }

	    int d1 = rayLength(i, j, 1, 1) + rayLength(i, j, -1, -1) + 1;
	    if (d1 > max) {
	        max = d1;
	    }

	    int d2 = rayLength(i, j, 1, -1) + rayLength(i, j, -1, 1) + 1;
	    if (d2 > max) {
	        max = d2;
	    }

	    return max;
	}


	
	public static void main(String[] args) {
		Player p1 = new Player("Bibi", 'O');
		Player p2 = new Player("Gantz", 'X');
		Board b = new Board(3,3);
		b.set(0, 0, p1);
		b.set(1, 0, p1);
		b.set(2, 2, p2);
		b.set(0, 0, p2);
		b.set(0, 1, p1);
		System.out.print(b);

 	}
	
	
	private boolean isInBoard(int i, int j) {
	    return i >= 0 && i < board.length        // השורה קיימת
	        && j >= 0 && j < board[0].length;   // העמודה קיימת
	}

	
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
