package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TraditionalThreadCommunication {
	
	public static void main(String[] args) {
		roundRobin();
	}
	
	private static void roundRobin() {
		
		Output opt = new TraditionalThreadCommunication().new Output();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					opt.tens(i);
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					opt.twenties(i);
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
	}
	
	class Output {
		
		private boolean isTens = true;
		
		public synchronized void tens (int round) {
			if(!isTens) {
				try {
					this.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 10; i++) {
				System.out.println("10 times is processing Round " +round + "and it's "+ i);
			}
			isTens = false;
			this.notify();
		}
		
		public synchronized void twenties (int round) {
			if(isTens) {
				try {
					this.wait();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			for(int i = 0; i < 20; i++) {
				System.out.println("20 times is processing Round" + round + "and it's "+ i);
			}
			isTens = true;
			this.notify();
		}
	}
}
