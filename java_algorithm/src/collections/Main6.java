package collections;
import java.math.BigInteger;
import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String aString = in.nextLine();
		String bString = in.nextLine();
		aString = aString.substring(1, aString.length() - 1);
		bString = bString.substring(1, bString.length() - 1);

		BigInteger aInteger = new BigInteger(aString);
		BigInteger bInteger = new BigInteger(bString);
		BigInteger res = aInteger.add(bInteger);
		System.out.println("\"" + res.toString() + "\"");
	}

}
