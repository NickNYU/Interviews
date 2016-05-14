package normal;


public class CompressString {
	
	public static String compress(String word) {
		StringBuffer sb = new StringBuffer();
		int count = 0;
		char sample = word.charAt(0);
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == sample) {
				count++;
			} else {
				sb.append(count);
				sb.append(sample);
				sample = word.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(sample);
		String result = sb.toString();
		return result.length() < word.length() ? result : word;
	}
	
	public static void main(String[] args) {
		String str1 = "aabbbcccc";
		String str2 = "abc";
		System.out.println(str1+ "-> " + compress(str1));
		System.out.println(str2+ "-> " + compress(str2));
	}
}
