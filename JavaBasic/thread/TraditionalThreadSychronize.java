package thread;

public class TraditionalThreadSychronize {
	
	public static void main(String[] args) {
		new TraditionalThreadSychronize().init();
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
					Output.output2("thread2");
				}	
			}
		});
		
		thread1.start();
		thread2.start();
	}


	static class Output {
		public void output(String str) {
			int len = str.length();
			synchronized(Output.class) {
				for(int i = 0; i < len; i++) {
					System.out.print(str.charAt(i));
				}
				System.out.println();
			}
		}
		
		public static synchronized void output2 (String str) {
			int len = str.length();
			for(int i = 0; i < len; i++) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}
}
