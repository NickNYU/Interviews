package hard;

/*
 * 给定一个数组 A 和 一个target， 要求变换 A 里面的数，使得 任意 i > 0 有 Math.abs(A[i] - A[i-1]) <= target
 * 假设变换后为 B ， 求 Sum(A[i] - B[i]） 的最小值
 * 
 * DP 思想 ， cost[i][j] 代表了 A 的 第i位 如果变成 j，那么最小的cost 是多少
 * 计算 cost[i][j] 时， go through 一下 cost[i-1]， 如果 满足 j-k <= target， 算出差值 j-A[i]+cost[i][k]
 */

public class MiniAdjustCost {
	public static int minimumAdjustCost(int[] arr, int target) {
		if(arr == null || arr.length == 0)
			return 0;
		int[][] cost = new int[arr.length][101];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j <= 100; j++) {
				cost[i][j] = Integer.MAX_VALUE;
				if(i == 0) {
					cost[i][j] = Math.abs(j - arr[i]);
				} else {
					int diff = Math.abs(j - arr[i]);
					for(int k = 1; k <= 100; k++) {
						//查看是否满足条件 j 是现在的arr[i], k是arr[i-1]
						if(Math.abs(j - k) > target)
							continue;
						int costs = diff + cost[i-1][k];
						cost[i][j] = Math.min(costs, cost[i][j]);
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= 100; i++) {
			result = Math.min(cost[cost.length-1][i], result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,2,3,5};
		System.out.println(minimumAdjustCost(arr,1));
	}
}
