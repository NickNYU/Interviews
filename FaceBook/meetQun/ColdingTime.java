package meetQun;

public class ColdingTime {
	public static int coldingTime(char[] arr) {
		char cold1 = '*', cold2 = '*';
		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == cold2) {
				result += 3;
				cold1 = '*';
				cold2 = '*';
			} else if (arr[i] == cold1) {
				result += 2;
				cold1 = cold2;
				cold2 = '*';
			} else {
				result += 1;
				cold1 = cold2;
				cold2 = arr[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		char[] arr = "ABABC".toCharArray();
		System.out.println(coldingTime(arr));
	}
}
