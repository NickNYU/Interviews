package hard;

public class KSum {
	public static int kSum(int A[], int k, int target) {
        // write your code here
        int[][] count = new int[k+1][target+1];
        count[0][0] = 1;
        for(int i = 1; i < k+1; i++) {
            for(int j = 1; j < target+1; j++) {
                for(int index = 0; index < A.length; index++) {
                    if(A[index] > j || j == 2*A[index])    continue;
                    int position = j - A[index];
                    count[i][j] += count[i-1][position];
                    System.out.println("count["+i+"]["+j+"]  =  "+count[i][j]);
                }
            }
        }
        return count[k][target];
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(kSum(arr, 2, 5));
	}
}
