package other;

import java.util.Arrays;

/**
 * 硬币找零 1 3 5，无穷数量，给定数k，求找零的最少张数
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
		 * i：当前的总钱，coin[j]：当前面值
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
		// TODO Auto-generated method stub
		System.out.println(deal(13));
	}

}
