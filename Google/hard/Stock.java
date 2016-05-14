package hard;

/*
 * global[i][j]=max(local[i][j],global[i-1][j])，
 * 
 * diff = price[i]-price[i-1]
 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
 */
public class Stock {
	
	public static int understandProfit(int[] price, int k){
		if(price==null || price.length==0)
			return 0;
		int[][] global = new int[price.length][k+1];
		int[][] local = new int [price.length][k+1];
		
		for(int i = 1;i< price.length ; i++){
			int diff = price[i] - price[i-1];
			for(int j = 1;j <= k; j++){
				local[i][j] = Math.max(local[i-1][j]+diff, global[i-1][j-1]+Math.max(0, diff));
				global[i][j] = Math.max(local[i][j], global[i-1][j]);
			}
			//System.out.println(global[i][k]);
		}
		
		return global[price.length-1][k];
	}
	
	public static int maxProfit(int[] price, int k){
		if(price==null || price.length<k)
			return 0;
	    int[] local = new int[k+1];  
	    int[] global = new int[k+1];  
	    for(int i=0;i<price.length-1;i++) {  
	        int diff = price[i+1]-price[i];  
	        for(int j=k;j>0;j--) {  
	            local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
	            global[j] = Math.max(local[j],global[j]);
	        }
	    }  
	    return global[k];
	}
	
	public static void main(String[] args){
		int[] price = {1,3,3,4,1,1,6,5};
		System.out.println(maxProfit(price,4));
		System.out.println(understandProfit(price,4));
	}
}
