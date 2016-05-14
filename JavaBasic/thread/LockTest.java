package thread;

import java.util.concurrent.locks.*;

public class LockTest {
	
	public static void main(String[] args) {
		new LockTest().init();
	}
	
	
	private void init() {
		Output opt = new Output();
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					opt.output("thread1");
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					opt.output2("thread2");
				}	
			}
		});
		
		thread1.start();
		thread2.start();
	}


	static class Output {
		Lock lock = new ReentrantLock();
		public void output(String str) {
			int len = str.length();
			lock.lock();
			try {
				for(int i = 0; i < len; i++) {
					System.out.print(str.charAt(i));
				}
				System.out.println();
			} finally {
				lock.unlock();
			}
		}
		
		public void output2 (String str) {
			int len = str.length();
			lock.lock();
			for(int i = 0; i < len; i++) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
			lock.unlock();
		}
	}
}
