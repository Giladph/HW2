
package tasks;

public class Tasks {

	private int num; // כמות המשימות
	private int[][] graph; // מערך של רשימות שכנים (גרף)
	private int[] tasks;

	public Tasks(int num) {
		this.num = num;
		graph = new int[num][num]; // כאן אתה מאתחל את המערך לפי מספר המשימות
		tasks = new int[num];
	}

	boolean dependsOn(int task1, int task2) {
		if (task1 < 0 || task1 > num || task2 < 0 || task2 > num)
			return false;

		graph[task2][task1] = 1; // there is an Road between

		return true;

	}

	public int[] order() {
		int count = 0;
		int index = 0;
		while (index < num) {
			 int prevIndex = index; //for checking circles
			for (int i = 0; i < num; i++) {
				  if (graph[i][i] == -1) {
		                continue; //  if we already checked the task
		            }
				count = 0;
				for (int j = 0; j < num; j++) {
					if (graph[j][i] != 0) {
						count++; // there is entering neighbors to tasks i
					}

				}
				if (count == 0) { // there is no entering neighbors to i

					tasks[index] = i;
					index++;
					for (int j = 0; j < num; j++) {
						graph[i][j] = 0; // מאפס את השורה של i
						graph[j][i] = 0; // מאפס את העמודה של i
					}
					graph[i][i] = -1; // we already checked the task
				}
			}
		    if (index == prevIndex) {
	            // לא הצלחנו להוסיף אף משימה בסיבוב הזה → יש מחזור
	            return null;
	        }
		}
		return tasks;
	}
	
	
	public void printTasks() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Tasks: [");

	    for (int i = 0; i < tasks.length; i++) {
	        sb.append(tasks[i]);
	        if (i < tasks.length - 1) {
	            sb.append(", ");
	        }
	    }

	    sb.append("]");
	    System.out.println(sb.toString());
	}



// ====== הנה ה-main שהוספתי עבורך ======
    public static void main(String[] args) {
        Tasks t = new Tasks(6);

        t.dependsOn(3, 2); // כדי לבצע 2 צריך קודם את 3
        t.dependsOn(0, 3); // כדי לבצע 3 צריך קודם את 0
        t.dependsOn(2, 5); // כדי לבצע 5 צריך קודם את 2
        t.dependsOn(4, 5); // כדי לבצע 5 צריך קודם את 4
        int[] order = t.order();

        if (order != null) {
            for (int i = 0; i < order.length; i++) {
                System.out.print(order[i]);
                if (i < order.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(); // מעבר שורה בסוף
        } else {
            System.out.println("There is a cycle, tasks cannot be ordered.");
        }
}
}


