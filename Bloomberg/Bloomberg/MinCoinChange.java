package Bloomberg;

import java.util.Arrays;

public class MinCoinChange {
	
	public static int minCoinChanges(int[] coins, int target){
		int[] num = new int[target+1];
		Arrays.fill(num, -1);
		num[0] = 0;
		for(int i=1;i<=target;i++){
			for(int coin : coins){
				if(i-coin>=0&&num[i-coin] != -1){
					if(num[i] == -1)	num[i] = num[i-coin]+1;
					else num[i] = Math.min(num[i], num[i-coin]+1);
				}
			}
		}
		return num[target];
	}
	
	public static void main(String[] args){
		int[] coins = {1,5,100,101};
		System.out.println(minCoinChanges(coins,105));
	}
}
