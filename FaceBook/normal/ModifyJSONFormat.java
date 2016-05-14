package normal;


public class ModifyJSONFormat {
	public static String prettyJson(String input) {
		StringBuffer sb = new StringBuffer ();
		int i = 0, space = 0;
		while(i < input.length()) {
			int j = 0;
			while(j < space) {
				sb.append(' ');
				j++;
			}
			while(i < input.length()) {
				//char c = input.charAt(i);
				
			}
		}
		return sb.toString();
	}
}
