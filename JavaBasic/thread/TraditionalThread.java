package thread;

public class TraditionalThread {
	
	public static void main(String[] args) {
		/*Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread.start();*/
		//
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try{
						Thread.sleep(5000);
					} catch(Exception e) {
						
					}
					System.out.println("runnable : " + Thread.currentThread().getName());
				}
			}
		}){
			@Override
			public void run() {
				while(true) {
					try{
						Thread.sleep(5000);
					} catch(Exception e) {
						
					}
					System.out.println("thread : " + Thread.currentThread().getName());
				}
			}
		}.start();
	}
}
