package hard;

public class WordWrapProblem {
	public static void solveWordWrap(int[] l, int n, int M) {
		int[][] extra = new int[n+1][n+1];
		int[][] lineCost = new int[n+1][n+1];
		int[] cost = new int[n+1];
		int[] printSol = new int[n+1];
		
		for(int i = 1; i < n+1; i++) {
			extra[i][i] = M - l[i-1];
			for(int j = i+1; j < n+1; j++) {
				extra[i][j] = extra[i][j-1] - l[j-1] - 1;
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = i; j < n+1; j++) {
				if(extra[i][j] < 0) {
					lineCost[i][j] = Integer.MAX_VALUE;
				} else if(j == n && extra[i][j] >= 0) {
					lineCost[i][j] = 0;
				} else {
					lineCost[i][j] = (int)Math.pow(extra[i][j], 3);
				}
			}
		}
		
		for(int j = 1; j < n+1; j++) {
			cost[j] = Integer.MAX_VALUE;
			for(int i = 1; i < j+1; i++) {
				if(cost[i-1] != Integer.MAX_VALUE && lineCost[i][j] != Integer.MAX_VALUE 
						&& (cost[i - 1] + lineCost[i][j] < cost[j])) {
					cost[j] = cost[i-1] + lineCost[i][j];
					printSol[j] = i;
				}
			}
		}
		
		printSolution(printSol, n);
	}
	
	public static int printSolution(int[] print, int n) {
		int k = 0;
		if(print[n] == 1) {
			k = 1;
		} else {
			k = printSolution(print, print[n] - 1) + 1;
		}
		System.out.println("Line number " + k + " From word no " + print[n] + " to " + n);
		return k;
	}
	
	public static void main(String[] args) {
		int l[]  = {3,2,2,5};
		int n = 4;
		int M = 6;
		solveWordWrap(l, n, M);
	}
}
