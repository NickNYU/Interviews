package thread;

import java.util.Random;

import thread.ThreadScopeShareData.A;
import thread.ThreadScopeShareData.B;

public class ThreadLocalTest {
	
	private static ThreadLocal<Long> threadLocal = new ThreadLocal<> ();
	private static long data = 0;
	public static void main(String[] args) {
		for(int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					data = Thread.currentThread().getId();
					threadLocal.set(data);
					System.out.println(Thread.currentThread().getName() + " has set data : " + data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A {
		public void get() {
			System.out.println(Thread.currentThread().getName() + " A has get data : " + threadLocal.get());
		}
	}
	
	static class B {
		public void get() {
			System.out.println(Thread.currentThread().getName() + " B has get data : " + threadLocal.get());
		}

	}
}
