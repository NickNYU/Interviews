package generic;

import java.util.*;

public class GenericTest {
	public static void test() {
		Set<Map.Entry<String, Integer>> set = new HashSet<> ();
		List<Map.Entry<?, ?>> list = new ArrayList<> ();
	}
	
	public static <T> T objToOther(Object obj) {
		if(obj == null)	return null;
		return (T) obj;
	}
}
