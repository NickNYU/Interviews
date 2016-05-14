package normal;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		String s = str.replaceAll("[^0-9a-zA-Z]", "").trim().toLowerCase();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (isLetter(s.charAt(left)) == false) {
				left++;
			} else if (isLetter(s.charAt(right)) == false) {
				right--;
			} else {
				if (s.charAt(left) == s.charAt(right) || Math.abs(s.charAt(left) - s.charAt(right)) == 'a' - 'A') {
					left++;
					right--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal -- Panama!"));
	}
}
