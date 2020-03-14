package poj;

import java.util.Scanner;
import java.util.TreeMap;

public class Main_1009 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		int[][] arr = new int[1000 * 9][2];
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		int width, a, b, temp = 0, pos_sum = 0;
		while (in.hasNext()) {
			width = in.nextInt();
			if (width == 0) {
				break;
			}
			arr = new int[1000 * 9][2];
			while (in.hasNext()) {
				a = in.nextInt();
				b = in.nextInt();
				if (a == 0 && b == 0) {
					break;
				}
				arr[temp][0] = a;
				arr[temp++][1] = b;
			}
			for (int i = 0; i < temp; i++) {
				treeMap.put(pos_sum, arr[i][0]);
				pos_sum += arr[i][1];
			}
		}

	}

}
