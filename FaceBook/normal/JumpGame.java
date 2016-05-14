package normal;


public class JumpGame {
	public static boolean jumpGame(int[] arr){
		if(arr==null||arr.length==0)	return false;
		int longest = 0;
		for(int i=0;i<arr.length;i++){
			if(longest<i)	return false;
			longest = Math.max(longest, i+arr[i]);
		}
		return true;
	}
	
	public static int miniStep(int[] arr){
		if(arr==null||arr.length==0)	return 0;
		int longest = 0;
		int local = 0;
		int count = 0;
		for(int i=0;i<arr.length;i++){
			if(longest<i)	return Integer.MAX_VALUE;
			if(local<i){
				local = longest;
				count++;
			}
			longest = Math.max(longest, i+arr[i]);
		}
		return count;
	}
	
	public static int jumpGameFollowUp(int[][] matrix){
		int[][] step = new int[matrix.length][matrix[0].length];
		InitStep(step);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				int len = matrix[i][j];
				for(int k=1;k<len+1;k++){
					if(j+k<matrix[0].length)
						step[i][j+k] = Math.min(step[i][j+k], step[i][j]+1);
					if(j-k>=0)
						step[i][j-k] = Math.min(step[i][j-k], step[i][j]+1);
					if(i+k<matrix.length)
						step[i+k][j] = Math.min(step[i+k][j], step[i][j]+1);
					if(i-k>=0)
						step[i-k][j] = Math.min(step[i-k][j], step[i][j]+1);
				}
			}
		}
		
		return step[step.length-1][step[0].length-1];
	}
	
	public static void InitStep(int[][] step){
		for(int i=0;i<step.length;i++){
			for(int j=0;j<step[0].length;j++){
				step[i][j] = i+j;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {9, 6, 0, 2, 0, 2};
		System.out.println(jumpGame(arr));
		System.out.println(miniStep(arr));
		int[][] matrix = {
				{1,2,1,2},
				{5,4,3,4},
				{1,1,1,1},
				{1,1,1,1}
		};
		System.out.println(jumpGameFollowUp(matrix));
	}
}
