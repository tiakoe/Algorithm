package poj;

import java.util.Scanner;

public class Main_1004 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		double s = 0.0;
		for (int i = 0; i < 12; i++) {
			s += in.nextDouble();
		}
		System.out.println(String.format("$%.2f", s / 12));
	}

}
