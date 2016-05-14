package thread;

import java.util.*;

public class TraditionalTimerTest {
	
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("Booming");
			}
		}, 1000);
		
		while(true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				System.err.println(e);
			}
			
		}
	}
}
