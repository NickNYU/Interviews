package thread;

import java.util.concurrent.*;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++)
						System.out.println(Thread.currentThread().getName()
								+ " " + i + " th");
				}
			});
		}
	}

}
