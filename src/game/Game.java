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
    	
       String.format("%s(%s), please enter row and coloumn: ",p.getName(),p.getMark());
       
       int i= s.nextInt();
       int j=s.nextInt();
       
       
       
       return doesWin(i, j);
    }
}
