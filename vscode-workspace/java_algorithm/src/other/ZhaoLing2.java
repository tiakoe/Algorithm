package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 加大难度，输出应该的找零数值
 * 
 * @author ASUS
 *
 */
public class ZhaoLing2 {

	static void deal(int money) {
		int[] cost = new int[money + 1];
		// 默认从小到大排序
		int[] coin = new int[] { 1, 3, 5 };
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;
		arrayList.add(new ArrayList<>());
		for (int i = 1; i <= money; i++) {
			int value = 0;
			arrayList.add(new ArrayList<>());
			for (int j = 0; j < coin.length; j++) {
				if (i >= coin[j]) {
					int temp = cost[i];
					cost[i] = Math.min(cost[i], cost[i - coin[j]] + 1);
					// 如果相等情况下，选择最大面值较大的，则在此处写<=
					if (cost[i] < temp) {
						value = coin[j];
					}
				}
			}
			arrayList.get(i).addAll(arrayList.get(i - value));
			arrayList.get(i).add(value);
		}
		System.out.println("张数： " + cost[money]);
		IntStream.range(0, arrayList.get(money).size())
				.forEach(i -> System.out.print("面值：" + arrayList.get(money).get(i) + " "));
		System.out.println();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int money = in.nextInt();
			deal(money);
		}

	}

}
