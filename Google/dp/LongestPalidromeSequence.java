package dp;

public class LongestPalidromeSequence {
	public static int longestPalindromeSequence(String word) {
		int n = word.length();
		int[][] lps = new int[n+1][n+1];
		
		for(int i = 0; i < n+1; i++) {
			lps[i][i] = 1;
		}
		for(int i = 1; i < word.length()+1; i++) {
			for(int j = i; j < word.length()+1; j++) {
				if(j == i) {
					lps[i][j] = 1;
					continue;
				} else if(word.charAt(i-1) == word.charAt(j-1) && j - i == 1) {
					lps[i][j] = 2;
				} else if(word.charAt(i-1) == word.charAt(j-1)) {
					lps[i][j] = 2 + lps[i+1][j-1];
				} else {
					lps[i][j] = Math.max(lps[i+1][j], lps[i][j-1]);
				}
			}
		}
		return lps[1][n];
	}
	
	public static int copy(String str) {
		int len = str.length();
		int[][] table = new int[len][len];
		  
		for(int i = 0; i < len; i++)
			table[i][i] = 1;
		  
		for(int cl = 2; cl <= len; cl++) {
			for(int i = 0; i < len-cl+1; i++){
				int j = i+cl-1;
				if(str.charAt(i) == str.charAt(j) && i == j-1)
					table[i][j] = 2;
				else if(str.charAt(i) == str.charAt(j))
					table[i][j] = table[i+1][j-1] + 2;
				else
					table[i][j] = Math.max(table[i+1][j], table[i][j-1]);
			}
		}
		return table[0][len-1];
	}
	
	
	
	public static void main(String[] args) {
		String word = "character";
		System.out.println(copy(word));
		System.out.println(longestPalindromeSequence(word));
	}
}
