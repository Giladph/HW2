package bank;

public class Account {
	private String name;
	private int amount;

	public Account(String name) {
		this.name = name;
		this.amount = 0;
	}

	public int getShekels() {

		return amount;

	}

	public String getName() {
		return name;
	}
	
	public void add(int amount) {
	    this.amount += amount;
	}
	
	public String toString() {
		return String.format("%s has %d shekels",getName(),getShekels());
	}
}

