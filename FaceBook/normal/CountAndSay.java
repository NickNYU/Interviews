package normal;

public class CountAndSay {
	public static String countAndSay(int n) {
		String rs = "1";
		for (int i = 0; i < n; i++) {
			System.out.println(i + "  " + rs);
			char[] arr = rs.toCharArray();
			StringBuffer sb = new StringBuffer();
			char pattern = arr[0];
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				char c = arr[j];
				if (c == pattern) {
					count++;
				} else {
					sb.append(count);
					sb.append(pattern);
					count = 1;
					pattern = c;
				}
			}
			sb.append(count);
			sb.append(arr[arr.length - 1]);
			rs = sb.toString();
		}
		return rs;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(3));
	}
}
