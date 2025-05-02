package bank;

public class Account {
	private String name;   // the name of the account owner
	private int amount;    // the current balance in shekels

	// constructor - creates a new account with given name and 0 balance
	public Account(String name) {
		this.name = name;
		this.amount = 0;
	}

	// getter for the balance
	public int getShekels() {
		return amount;
	}

	// getter for the account name
	public String getName() {
		return name;
	}
	
	// adds money to the balance
	public void add(int amount) {
	    this.amount += amount;
	}
	
	// returns a string representation of the account
	public String toString() {
		return String.format("%s has %d shekels", getName(), getShekels());
	}
}
