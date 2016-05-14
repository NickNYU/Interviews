package normal;

public class LongestSubsequence {
	
	public static int longestSubsequence(String word1, String word2) {
        int[][] lcs = new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<word1.length()+1;i++) {
            for(int j=1;j<word2.length()+1;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }
                lcs[i][j] = Math.max(lcs[i][j],Math.max(lcs[i-1][j],lcs[i][j-1]));
            }
        }
        return lcs[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {
		String word1 = "a";
		String word2 = "a";
		System.out.println(longestSubsequence(word1,word2));
	}
}
