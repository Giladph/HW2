package game;

import java.util.Scanner;

public class Game extends Board {
	
    protected Player[] players;
    protected Scanner s;  
    
    public Game(int n, int m, Player p1, Player p2) {
    	super(n,m);
    	this.players= new Player[2];
    	this.players[0]=p1;
    	this.players[1]=p2;
    	this.s=new Scanner(System.in);
    }
    
    
    
    protected boolean doesWin(int i, int j) {
    	if(i==0 && j==0) {
    		return true;
    	}
    	return false;
    }
    
    
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

        set(i, j, p); // מציב את השחקן בלוח אם פנוי

        System.out.println(this); // מדפיס את הלוח לפי toString()

        return doesWin(i, j); // מחזיר האם זה מהלך מנצח
    }
    
    public Player play() {
        int turn = 0;

        while (true) {
            if (isFull()) {
                System.out.println("The board is full. No winner.");
                return null;
            }

            Player current = players[turn % 2];

            if (onePlay(current)) {
                System.out.printf("Congratulations %s! You won!\n", current.getName());
                return current;
            }

            turn++;
        }
    }
    
    

    }


    



