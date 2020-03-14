package other;
public class Sort {

	/**
	 * 时间复杂度：n^2
	 * 
	 * @param arr
	 * @return
	 */
	static int[] selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		return arr;
	}

	static int[] maoPaoSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] < arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		
		int[] a = new int[] { 2, 34, 3, 22, 76, 4 };
		for (int i : selectSort(a)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : maoPaoSort(a)) {
			System.out.print(i + " ");
		}

	}

}
