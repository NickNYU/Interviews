package hard;

public class LongestPalindromeSubstring {
	public static String longestPalindromeSubstring(String S) {
		StringBuffer sb = new StringBuffer("#");
		for(int i = 0; i < S.length(); i++) {
			sb.append(S.charAt(i));
			sb.append('#');
		}
		String str = sb.toString();
		int n = str.length();
		char[] s = str.toCharArray();
		int center = 0,right = 0;
		int result = 0;
		int[] p = new int[n];
		for(int i = 0; i < n; i++) {
			// (i + i_mirror) / 2 = center, i_mirror是 i 对应的对称点
			int i_mirror = (center * 2) - i;
			p[i] = (right > i) ? Math.min(right-i, p[i_mirror]) : 0;
			while(i-p[i]-1 >= 0 && i+p[i]+1 < n && s[i-p[i]-1] == s[i+p[i]+1]) {
				p[i]++;
			}
			if(i + p[i] > right) {
				right = i + p[i];
				center = i;
			}
		}
		for(int i = 0; i < n; i++) {
			if(result < p[i]) {
				center = i;
				result = p[i];
			}
		}
		//System.out.println(result);
		int left = (center-result)/2;
		right = (center+result)/2;
		return S.substring(left, right);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubstring("ablbacabaca"));
	}
}
