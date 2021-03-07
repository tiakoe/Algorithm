package collections;

import java.text.DecimalFormat;
import java.util.Scanner;

 class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DecimalFormat df = new DecimalFormat("0.000000");
        float h = 100;
        float res1 = 100, res2 = h / 2;
        for (int i = 2; i <= n; i++) {
            res2 = res2 / 2;
            res1 += (res2 * 4);
        }
        System.out.println(df.format(res1) + " " + df.format(res2));
    }

}