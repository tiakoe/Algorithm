package other;
public class FastPower {

	/**
	 * ����a^n%b==?
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	static int fastPower(int a, int b, int n) {
		if (n == 1) {
			return a % b;
		}
		if (n == 0) {
			return 1 % b;
		}

		/**
		 * (a * b) % p = (a % p * b % p) % p ��nΪ������ʱ��n = n / 2 + n / 2 +1 ��
		 */
		long product = fastPower(a, b, n / 2);
		product = (product * product) % b;
		if (n % 2 == 1) {
			product = (product * a) % b;
		}
		return (int) product;
	}

	public static void main(String[] args) {
		
		System.out.println(fastPower(122, 2, 1));
	}

}
