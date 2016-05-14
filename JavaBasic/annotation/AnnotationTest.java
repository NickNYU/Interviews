package annotation;

@ItcastAnnotation(value = "abc", arrAtt = {1, 2, 3, 4})
public class AnnotationTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.runFinalizersOnExit(true);
		
		if (AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)) {
			ItcastAnnotation annotation = AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
			System.out.println(annotation.color());
		}
	}
}
