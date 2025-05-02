package game;

public class FourInARow extends Game {

    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
    }

    @Override
    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) >= 4;
    }

    @Override
    protected boolean onePlay(Player p) {
        int col;

        while (true) {
            System.out.printf("%s (%s), please enter column: ", p.getName(), p.getMark());
            col = s.nextInt();

            // חפש את השורה הכי נמוכה הפנויה בעמודה
            for (int row = n - 1; row >= 0; row--) {
                if (isEmpty(row, col)) {
                    set(row, col, p);
                    System.out.println(this);
                    return doesWin(row, col);
                }
            }

            System.out.println("This column is full. Try another one.");
        }
    }
}
