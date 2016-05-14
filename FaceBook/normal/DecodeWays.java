package normal;

import java.util.*;

public class DecodeWays {
	public static List<String> findDecodes(String digits) {
		List<String> result = new ArrayList<String>();
		char[] map = new char[26];
		for (int i = 0; i < map.length; i++) {
			map[i] = (char) (i + 'A');
		}
		StringBuffer sb = new StringBuffer();
		findDecodesHelper(digits, result, 0, map, sb);
		return result;
	}

	public static void findDecodesHelper(String digits, List<String> result, int start, char[] map, StringBuffer sb) {
		if (start == digits.length()) {
			StringBuffer str = new StringBuffer(sb);
			result.add(str.toString());
		} else if (start < digits.length() - 1 && digits.charAt(start + 1) == '0') {
			int index = Integer.parseInt(digits.substring(start, start + 2)) - 1;
			sb.append(map[index]);
			findDecodesHelper(digits, result, start + 2, map, sb);
			sb.deleteCharAt(sb.length() - 1);
		} else {
			for (int i = 1; i <= 2; i++) {
				if (start + i > digits.length())
					break;
				int index = Integer.parseInt(digits.substring(start, start + i)) - 1;
				if (index > 26)
					return;
				sb.append(map[index]);
				findDecodesHelper(digits, result, start + i, map, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static int decodeWays(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int prev = 0;
		int cur = 1;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0')
				cur = 0;
			if (i < 1 || !(arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6')))
				prev = 0;
			int temp = cur;
			cur += prev;
			prev = temp;
		}
		return cur;
	}

	public static boolean isValid(String digits, int index) {
		if (index == 0)
			return true;
		int num = Integer.valueOf(digits.substring(index - 1, index + 1));
		if (num > 32)
			return false;
		if (digits.charAt(index) == 0)
			return false;
		return true;
	}

	public static String addBinary(String a, String b) {
		if (a.length() < b.length())
			return addBinary(b, a);
		a = new StringBuffer(a).reverse().toString();
		b = new StringBuffer(b).reverse().toString();
		StringBuffer sb = new StringBuffer();
		int index = 0, carry = 0;
		while (index < a.length()) {
			System.out.println((a.charAt(index) - '0'));
			int total = carry + (a.charAt(index) - '0');
			total += index < b.length() ? (b.charAt(index) - '0') : 0;
			System.out.println(total);
			sb.insert(0, total % 2);
			carry = total / 2;
			index++;
		}
		if (carry == 1)
			sb.insert(0, 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		// String digits = "1032";
		// List<String> codes = findDecodes(digits);
		// System.out.println(codes.toString());
		// System.out.println(decodeWays("123"));
		System.out.println(addBinary("1", "0"));
	}
}
