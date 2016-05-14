package lesson45ClassLoad;

public class ClassLoadTest {
	
	public static void main(String[] args) {
		//APPClassLoader
		System.out.println(ClassLoadTest.class.getClassLoader().getClass().getName());
		
		ClassLoader loader = ClassLoadTest.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
	}
}

