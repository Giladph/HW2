package game;

import java.util.Scanner;

public class Game extends Board {
	
    protected Player[] players; // array of 2 players
    protected Scanner s;        // for reading input from user
    
    // constructor - initializes board and players
    public Game(int n, int m, Player p1, Player p2) {
    	super(n, m);
    	this.players = new Player[2];
    	this.players[0] = p1;
    	this.players[1] = p2;
    	this.s = new Scanner(System.in);
    }
    
    // checks if the move at (i,j) is a winning move
    protected boolean doesWin(int i, int j) {
    	if (i == 0 && j == 0) {
    		return true;
    	}
    	return false;
    }
    
    // handles one move for the given player
    protected boolean onePlay(Player p) {
        int i, j;

        while (true) {
            System.out.printf("%s (%s), please enter row and column: ", p.getName(), p.getMark());
            i = s.nextInt();
            j = s.nextInt();

            if (isEmpty(i, j)) {
                break;
            } else {
                System.out.println("That position is already taken. Please try again.");
            }
        }

        set(i, j, p); // set the player on the board

        System.out.println(this); // print the current state of the board

        return doesWin(i, j); // return true if the move wins
    }
    
    // main game loop - returns the winner or null if board is full
    public Player play() {
        int turn = 0;

        while (true) {
            if (isFull()) {
                System.out.println("The board is full. No winner.");
                return null;
            }

            Player current = players[turn % 2]; // alternate between the two players

            if (onePlay(current)) {
                System.out.printf("%s (%s) Won!\n", current.getName(), current.getMark());
                return current;
            }

            turn++;
        }
    }
}
