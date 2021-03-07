package collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);

		String str = "2020-03-12";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(str);
		System.out.println(date.toString().substring(0, 4));
	}
}
