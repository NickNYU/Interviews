package zenefits;

public class MinimumIntersectionPalindrome {
	
	public static int minimumInsert(String word) {
		
		// word[i] == word[j] then f[i][j] = f[i-1][j-1]
		// word[i] != word[j] then f[i][j] = Math.min(f[i+1][j], f[i][j-1]) + 1
		
		int[][] f = new int[word.length()][word.length()];
		int n = word.length();
		for (int gap = 1; gap < n; ++gap)
	        for (int left = 0, right = gap; right < n; left++, right++)
	            f[left][right] = (word.charAt(left) == word.charAt(right)) ? f[left+1][right-1] :
	                          (Math.min(f[left][right-1], f[left+1][right]) + 1);
	 
		
		return f[0][n-1];
	}
	
	public static int minInsert(String word) {
		return minInsert(word, 0, word.length()-1);
	}
	
	public static int minInsert(String word, int left, int right) {
		if(left > right)	return Integer.MAX_VALUE;
		if(left == right)	return 0;
		if(right - left == 1)	return word.charAt(left) == word.charAt(right) ? 0 : 1;
		
		return word.charAt(left) == word.charAt(right) ? minInsert(word, left+1, right-1) :
				Math.min(minInsert(word, left+1, right), minInsert(word, left, right-1)) + 1;
	}
	
	public static void main(String[] args) {
		String source = "abcdbdscba";
		System.out.println(minInsert(source));
		System.out.println(minimumInsert(source));
		
	}
}
