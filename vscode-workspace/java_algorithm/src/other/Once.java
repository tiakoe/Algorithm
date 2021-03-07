package other;

public class Once {
	public static void main(String[] args) {
		int[] a = new int[23];
		for (int i = 0; i < 10; i++) {
			a[i] = i;
		}
		for (int i = 10; i < 20; i++) {
			a[i] = i;
		}
		a[20] = 33;
		a[21] = 21;
		a[22] = 21;
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res ^= a[i];
		}
		System.out.println(res);
	}
}
