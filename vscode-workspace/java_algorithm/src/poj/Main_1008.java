package poj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main_1008 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> aHashMap = new HashMap<String, Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();
		String[] bStringArr = new String[21];
		int n, sum = 0;
		String d, m;

		int y, temp = 0;
		String aString = "pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, zac, ceh, mac, kankin, muan, pax, koyab, cumhu, uayet";
		String bString = "imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen, eb, ben, ix, mem, cib, caban, eznab, canac, ahau";
		for (String string : aString.split(", ")) {
			aHashMap.put(string, temp);
			temp++;
		}
		temp = 0;
		for (String string : bString.split(", ")) {
			temp++;
			bStringArr[temp] = string;
		}

		while (in.hasNext()) {
			n = in.nextInt();
			for (int i = 0; i < n; i++) {
				sum = 0;
				d = in.next();
				m = in.next();
				y = in.nextInt();
				sum += (Integer.parseInt(d.substring(0, d.length() - 1)) + 1 + aHashMap.get(m) * 20 + y * 365);
				arrayList.add(String.valueOf(sum % 13 == 0 ? 13 : sum % 13) + " "
						+ bStringArr[sum % 20 == 0 ? 20 : sum % 20] + " " + (sum - 1) / 260);
			}
			System.out.println(n);
			for (int i = 0; i < n; i++) {
				System.out.println(arrayList.get(i));
			}
		}
	}

}
