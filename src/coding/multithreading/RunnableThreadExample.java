package coding.multithreading;

public class RunnableThreadExample {

	public static void main(String[] args) {

		Runnable threadOne = new Runnable() {

			@Override
			public void run() {

				System.out.println("thread one is created");
			}
		};
		new Thread(threadOne).start();
		Runnable threadTwo = () -> {
			System.out.println("Thread two is created");
		};
		new Thread(threadTwo).start();

		Runnable threadThired = () -> {
			System.out.println("Thread  thread is created");
			System.out.println("Thread 3.1 is Created");
		};
		new Thread(threadThired).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread 4 is Created");
			}
		}).start();

		new Thread(() -> {
			System.out.println("new 5 created");
			System.out.println("new 5.1 created");
		}).start();
	}
}
