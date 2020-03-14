package other;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * �Ӵ��Ѷȣ����Ӧ�õ�������ֵ
 * 
 * @author ASUS
 *
 */
public class ZhaoLing2 {

	static void deal(int money) {
		int[] cost = new int[money + 1];
		// Ĭ�ϴ�С��������
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
					// ����������£�ѡ�������ֵ�ϴ�ģ����ڴ˴�д<=
					if (cost[i] < temp) {
						value = coin[j];
					}
				}
			}
			arrayList.get(i).addAll(arrayList.get(i - value));
			arrayList.get(i).add(value);
		}
		System.out.println("������ " + cost[money]);
		IntStream.range(0, arrayList.get(money).size())
				.forEach(i -> System.out.print("��ֵ��" + arrayList.get(money).get(i) + " "));
		System.out.println();

	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int money = in.nextInt();
			deal(money);
		}

	}

}
