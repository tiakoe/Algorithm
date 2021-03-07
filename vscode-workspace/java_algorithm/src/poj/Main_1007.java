package poj;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_1007 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2))
					return 1;
				else
					return o1 - o2;
			}
		});
		int m, n, sum;
		String aString;
		char[] b;
		while (in.hasNext()) {
			m = in.nextInt();
			n = in.nextInt();
			b = new char[m];
			for (int i = 0; i < n; i++) {
				aString = in.next();
				b = aString.toCharArray();
				sum = 0;
				for (int j = 0; j < b.length - 1; j++) {
					for (int k = j + 1; k < b.length; k++) {
						if (b[j] > b[k]) {
							sum++;
						}
					}
				}
				treeMap.put(sum, aString);
			}
			for (String i : treeMap.values()) {
				System.out.println(i);
			}
		}

	}

}
