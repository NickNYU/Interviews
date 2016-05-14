package tools;


public class AssociatedMethod {
	public static int randomInt(int n) {
        return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
	}

	public static boolean randomBoolean() {
        return randomIntInRange(0, 1) == 0;
	}       

	public static boolean randomBoolean(int percentTrue) {
        return randomIntInRange(1, 100) <= percentTrue;
	}               

	public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                        matrix[i][j] = randomIntInRange(min, max);
                }
        }
        return matrix;
	}

	public static int[] randomArray(int N, int min, int max) {
        int[] array = new int[N];
        for (int j = 0; j < N; j++) {
                array[j] = randomIntInRange(min, max);
        }
        return array;
	}
	
	
	
	public static TreeNode generateTree(int N){
		int[] arr = randomArray(N,0,100);
		return generateTreeHelper(arr,0,arr.length-1);
	}
	
	public static TreeNode generateTreeHelper(int[] arr,int left, int right){
		if(left>right)	return null;
		int mid = (left+right)>>1;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = generateTreeHelper(arr,left,mid-1);
		root.right = generateTreeHelper(arr,mid+1,right);
		return root;
	}
	
	
	
	public static boolean isDigit(String str){
		try{
			Integer.parseInt(str);
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	
	
	public static void printIntArray(int[] arr){
		for(int element : arr)	System.out.print(element+"  ");
		System.out.println();
	}
}
