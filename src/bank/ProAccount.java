package bank;

public class ProAccount extends Account {
	private int[] totalAmount; // saves the balance after each add operation

	// constructor - creates a ProAccount with empty totalAmount history
	public ProAccount(String name) {
		super(name);
		totalAmount = new int[0];
	}

	@Override
	public void add(int amount) {
		super.add(amount); // update balance using parent's method

		// copy totalAmount to a bigger array and add the new balance at the end
		int[] tempAmount = new int[totalAmount.length + 1];
		for (int i = 0; i < totalAmount.length; i++) {
			tempAmount[i] = totalAmount[i];
		}
		totalAmount = tempAmount;
		totalAmount[totalAmount.length - 1] = getShekels(); // save current balance
	}

	// transfers money from one ProAccount to another
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add((-1) * amount);
		to.add(amount);
	}

	@Override
	public String toString() {
		return super.toString() + " " + printTotalAmount(); // add history to string
	}

	// returns string with all past balances
	private String printTotalAmount() {
	    String s = "[";
	    for (int i = 0; i < totalAmount.length; i++) {
	        s += totalAmount[i];
	        if (i < totalAmount.length - 1) {
	            s += ",";
	        }
	    }
	    s += "]";
	    return s;
	}
}
