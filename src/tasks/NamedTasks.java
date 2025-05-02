package tasks;

public class NamedTasks extends Tasks {
	private String[] names; // task names, mapped by index

	// constructor - initializes the base Tasks class and stores task names
	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}

	// adds a dependency between two tasks by name
	public boolean dependsOn(String task1, String task2) {
		int i = findIndex(task1);
		int j = findIndex(task2);

		if (i == -1 || j == -1) {
			return false; // at least one task name doesn't exist
		}

		return super.dependsOn(i, j);
	}

	// returns the task order by names, or null if there is a cycle
	public String[] nameOrder() {
	    int[] order = super.order();
	    
	    if (order == null) {
	        return null;
	    }
	    
	    String[] nameOrder = new String[order.length];
	    for (int i = 0; i < order.length; i++) {
	        nameOrder[i] = names[order[i]];
	    }
	    
	    return nameOrder;
	}

	// returns the index of the task name in the array, or -1 if not found
	private int findIndex(String task) {
	    for (int i = 0; i < names.length; i++) {
	        if (names[i].equals(task)) {
	            return i;
	        }
	    }
	    return -1;
	}
}
