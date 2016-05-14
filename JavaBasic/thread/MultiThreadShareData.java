package thread;

public class MultiThreadShareData {
	
	public static void main(String[] args) {
		final ShareData data = new MultiThreadShareData().new ShareData();
		Thread thread1 = new Thread(new MultiThreadShareData().new MyRunnable1(data));
		Thread thread2 = new Thread(new MultiThreadShareData().new MyRunnable2(data));
		thread1.start();
		thread2.start();
	}
	
	class ShareData {
		int j = 0;
		
		public synchronized void increase() {
			j ++;
			System.out.println(Thread.currentThread().getName() + " : " + j);
		}
		
		public synchronized void decrease() {
			j --;
			System.out.println(Thread.currentThread().getName() + " : " + j);
		}
	}
	
	class MyRunnable1 implements Runnable {
		private ShareData data;
		public MyRunnable1 (ShareData data) {
			this.data = data;
		}
		@Override
		public void run() {
			data.increase();
		}
	}
	
	class MyRunnable2 implements Runnable {
		private ShareData data;
		public MyRunnable2 (ShareData data) {
			this.data = data;
		}
		@Override
		public void run() {
			data.decrease();
		}
	}
}
