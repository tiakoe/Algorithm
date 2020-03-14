package poj;

import java.util.Scanner;
import java.util.TreeMap;

public class Main_1002 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// key order by ��Ȼ˳��
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		int n = in.nextInt();
		String string = "22233344455566670778889990";
		String tres;
		Integer k = 0;
		for (int i = 0; i < n; i++) {
			String temp = in.next();
			char[] arr = temp.toCharArray();
			tres = "";
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] >= 'A' && arr[j] <= 'Z') {
					tres += String.valueOf(string.charAt(arr[j] - 'A'));
				}
				if (arr[j] >= '0' && arr[j] <= '9') {
					tres += String.valueOf(arr[j]);
				}
				if (tres.length() == 3) {
					tres += "-";
				}
			}
			k = treeMap.get(tres);
			if (k != null) {
				treeMap.put(tres, k + 1);
			} else {
				treeMap.put(tres, 1);
			}
		}
		int flag = 0;
		for (String string2 : treeMap.keySet()) {
			if (treeMap.get(string2) > 1) {
				System.out.println(string2 + " " + treeMap.get(string2));
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("No duplicates.");
		}
	}

}
