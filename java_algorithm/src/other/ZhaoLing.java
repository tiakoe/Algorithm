package other;
import java.util.Arrays;

/**
 * Ӳ������ 1 3 5������������������k�����������������
 * 
 * @author ASUS
 *
 */
public class ZhaoLing {

	static int deal(int money) {
		int[] cost = new int[money + 1];
		int[] coin = new int[] { 2, 3, 5, 1 };
		// int[] coin = new int[] { 5, 3, 2, 1 };
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;
		/**
		 * i����ǰ����Ǯ��coin[j]����ǰ��ֵ
		 */
		for (int i = 1; i <= money; i++) {
			for (int j = 0; j < coin.length; j++) {
				if (i >= coin[j]) {
					cost[i] = Math.min(cost[i], cost[i - coin[j]] + 1);
					if (cost[i] < 0) {
						cost[i] = Integer.MAX_VALUE;
					}
				}
			}
		}

		// for (int i : cost) {
		// System.out.print(i + " ");
		// }
		return cost[money];
	}

	public static void main(String[] args) {
		
		System.out.println(deal(13));
	}

}
