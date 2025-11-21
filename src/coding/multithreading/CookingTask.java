package coding.multithreading;

public class CookingTask extends Thread {
	
	private String task ;
	
	public CookingTask(String task) {
		this.task = task;
	}

	public void run() {
		System.out.println(task + " is being prepared by " + Thread.currentThread().getName());
	}
	public static void main(String args[]) {
	   Thread t1 = new CookingTask("pasta");
	   Thread t2 = new CookingTask("Salad");
	   Thread t3 = new CookingTask("Dessert");
	   Thread t4 = new CookingTask("Rice");
	   
	   t1.start();
	   t2.start();
	   t3.start();
	   t4.start();
	}
}
