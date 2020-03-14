package other;
public class QuickSort {

	static int[] quickSort(int[] a, int start, int end) {
		int i = start, j = end, p = a[start];
		while (i < j) {
			while (i < j && a[j] > p) {
				j--;
			}
			while (i < j && a[i] < p) {
				i++;
			}
			if (i < j && a[i] == a[j]) {
				i++;
			} else {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		if (start < i - 1) {
			quickSort(a, start, i - 1);
		}
		if (j + 1 < end) {
			quickSort(a, j + 1, end);
		}
		return a;
	}

	public static void main(String[] args) {
		
		int[] a = new int[] { 1, 3, 2, 4 };
		for (int i : quickSort(a, 0, 3)) {
			System.out.print(i + " ");
		}
	}

}
