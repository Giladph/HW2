package tasks;

public class Tasks {

	private int num; // כמות המשימות
	private int[][] graph; // מערך של רשימות שכנים (גרף)

	public Tasks(int num) {
		this.num = num;
		graph = new int[num][num]; // כאן אתה מאתחל את המערך לפי מספר המשימות
	}

	boolean dependsOn(int task1, int task2) {
		System.out.print("Try");
		if (task1 < 0 || task1 >= num || task2 < 0 || task2 >= num) 
			return false;
			
		graph[task2][task1]=1; //there is an edge between
		
		return true;
			
		
		}
		
	
}
		
		

