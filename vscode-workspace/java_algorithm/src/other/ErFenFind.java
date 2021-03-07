package other;

/**
 * ���ֲ���
 * 
 * @author ASUS
 *
 */
public class ErFenFind {

	static int deal(int a[], int des) {
		int s = 0, e = a.length - 1;
		while (s <= e) {
			int middle = (s + e) >>> 1;
			if (des == a[middle]) {
				return middle;
			} else if (des > a[middle]) {
				s = middle + 1;
			} else {
				e = middle - 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.print(deal(a, 5));
	}

}
