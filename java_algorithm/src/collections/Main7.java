package collections;
import java.util.ArrayList;
import java.util.Scanner;

//s ="catsanddog"
//dict ="cat", "cats", "and", "sand", "dog"
//[cats and dog, cat sand dog]
public class Main7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = "catsanddog";
		String b = in.nextLine();
		String[] temp = b.split("=")[1].replaceAll("\"", "").split(",");

		ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();
		ArrayList<String> bList = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			if (aList.get(i) != null) {
				for (int j = i + 1; j < a.length(); j++) {
					String tString = a.substring(i, j);
					if (a.contains(tString)) {
						if (aList == null) {
							ArrayList<String> tList = new ArrayList<>();
							tList.add(tString + " ");
							aList.set(j, tList);
						} else {
							aList.get(j).add(tString);
						}
					}
				}
			}

		}

	}

}
