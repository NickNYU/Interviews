package thread;

import java.util.*;

public class ThreadScopeShareData {
	private static int data = 0;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				data = new Random().nextInt();
				System.out.println(Thread.currentThread().getName() + "has set data : " + data);
				new A().get();
				new B().get();
			}
		}).start();
	}
	
	static class A {
		public void get() {
			System.out.println(Thread.currentThread().getName() + "A has get data : " + data);
		}
	}
	
	static class B {
		public void get() {
			System.out.println(Thread.currentThread().getName() + "B has get data : " + data);
		}

	}
}
