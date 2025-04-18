package bank;


public class ProAccount extends Account {
	private int[] totalAmount;

	public ProAccount(String name) {
		super(name);
		totalAmount = new int[0];
	}

	@Override
	public void add(int amount) {

		super.add(amount);
		int[] tempAmount = new int[totalAmount.length + 1];
		for (int i = 0; i < totalAmount.length; i++) {
			tempAmount[i] = totalAmount[i];
		}
		totalAmount = tempAmount;
		totalAmount[totalAmount.length - 1] = getShekels();

	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add((-1) * amount);
		to.add(amount);

	}
    @Override
	public String toString() {

		return super.toString() + " " + printTotalAmount();
	}

	private String printTotalAmount() {
	    String s = "[";
	    for (int i = 0; i < totalAmount.length; i++) {
	        s += totalAmount[i];
	        if (i < totalAmount.length - 1) {
	            s += ",";
	        }
	    }
	    s += "]";
	    System.out.println("test");
	    return s;
	}
}
