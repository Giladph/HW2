package tasks;

public class Tasks {

	private int num; // number of tasks
	private int[][] graph; // dependency graph (adjacency matrix)
	private int[] tasks; // array to store the final task order

	// constructor - initializes graph and result array
	public Tasks(int num) {
		this.num = num;
		graph = new int[num][num];
		tasks = new int[num];
	}

	// adds a dependency: task1 depends on task2
	public boolean dependsOn(int task1, int task2) {
		if (task1 < 0 || task1 >= num || task2 < 0 || task2 >= num)
			return false;

		graph[task2][task1] = 1; // edge from task2 to task1
		return true;
	}

	// returns a valid order of tasks if possible, otherwise returns null if there
	// is a cycle
	public int[] order() {
		int count = 0;
		int index = 0;

		while (index < num) {
			int prevIndex = index; // used to detect cycles

			for (int i = 0; i < num; i++) {
				if (graph[i][i] == -1) {
					continue; // task already handled
				}

				count = 0;
				for (int j = 0; j < num; j++) {
					if (graph[j][i] != 0) {
						count++; // incoming edge to task i
					}
				}

				if (count == 0) { // task i has no incoming edges
					tasks[index] = i;
					index++;

					// remove all edges related to task i
					for (int j = 0; j < num; j++) {
						graph[i][j] = 0;
						graph[j][i] = 0;
					}

					graph[i][i] = -1; // mark as handled
				}
			}

			if (index == prevIndex) {
				// no progress in this iteration → cycle detected
				return null;
			}
		}

		return tasks;
	}
}
