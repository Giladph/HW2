package tasks;

public class NamedTasks extends Tasks {
	private String[] names;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}

	public boolean dependsOn(String task1, String task2) {

		int i = findIndex(task1);
		int j = findIndex(task2);

		if (i == -1 || j == -1) {
			return false;
		}

		return super.dependsOn(i, j);

	}


    	public String[] nameOrder() {
    	    int[] order = super.order();
    	    
    	    if (order == null) { //found circle
    	        return null;
    	    }
    	    
    	    String[] nameOrder = new String[order.length];
    	    for (int i = 0; i < order.length; i++) {
    	        nameOrder[i] = names[order[i]];
    	    }
    	    
    	    return nameOrder;
    	}
 	
    	
    	
    private int findIndex(String task) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(task)) {
                return i;
            }
        }
        return -1;
    }

		
		
		


}
