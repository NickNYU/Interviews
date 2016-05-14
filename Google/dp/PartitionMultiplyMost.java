package dp;

public class PartitionMultiplyMost {
	
	public static int mostMultiply(int num){
		int[] f = new int[num+1];
		f[1] = 0;
		f[2] = 1;
		for(int i = 3; i < num+1; i++){
			for(int j = 1; j < i; j++){
				f[i] = Math.max( Math.max(f[i-j], i-j)*Math.max(f[j], j), f[i]);
			}
		}
		return f[num];
	}
	
	public static void main(String[] args){
		System.out.println(mostMultiply(12));
	}
}
