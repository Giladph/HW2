package tasks;

public class NamedTasks extends Tasks {
	String[] names;

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

	
	public int findIndex(String task) {
		
		for(int i=0; i<names.length; i++) {
			
			if(names[i].equals(task)) {
				return i;
			}
			
		return -1;
		 
			
		}
		
		
		
	}

}

}
