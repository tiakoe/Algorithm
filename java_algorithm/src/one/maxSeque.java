
// public class maxSeque {

// 	static int maxFun(int[] arr) {
// 		int maxval = arr[0], dp[] = new int[arr.length];
// 		dp[0] = arr[0];
// 		for (int i = 1; i < arr.length; i++) {
// 			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
// 			maxval = Math.max(maxval, dp[i]);
// 		}
// 		return maxval;
// 	}

// 	public static void main(String[] args) {
// 		// System.out.print(maxFun(IntStream.range(-10, 5).toArray()));
// 	}

// }
