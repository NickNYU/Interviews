package lesson16Reflection;


import java.lang.reflect.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		//Class cls1 = String.class;
		// field reflection
		/*ReflectPoint rp = new ReflectPoint(1, 2);
		Class fieldClass = rp.getClass();
		Field field = rp.getClass().getDeclaredField("x");
		//field.setAccessible(true);
		System.out.println(field.get(rp).toString());
		changeCharacter(rp);
		System.out.println(rp.getStr1() + " "+rp.getStr2());*/
		
		// method reflection
		
		
		//PropertyDescriptor pd = new PropertyDescriptor("x", rp.getClass());
		//Method method = pd.getReadMethod();
		//Object retrieval = method.invoke(rp);
		//
		List<Integer> list = new ArrayList<Integer> (10);
		System.out.println(list.size());
		printField(list);
		//for(int i : list)	System.out.println(i);
		//list.add(3);
		System.out.println(list.size());
		//System.out.println(retrieval);
	}
	
	private static void changeCharacter(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.getType() == String.class) {
				String oldStr = (String) field.get(obj);
				String newStr = oldStr.replace('a', 'b');
				field.set(obj, newStr);
			}
		}
	}
	
	public static void printField(Object obj) throws IllegalArgumentException, IllegalAccessException {
		int modifier = obj.getClass().getModifiers();
		System.out.println(Modifier.isAbstract(modifier));
		Field[] fields = obj.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(field.getName().endsWith("size")) {
				field.set(obj, 2);
			}
			System.out.println(field.toString());
			System.out.println(field.get(obj).toString());
		}
	}

}
