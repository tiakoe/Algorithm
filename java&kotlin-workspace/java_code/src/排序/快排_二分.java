package 排序;

import java.util.Scanner;

public class 快排_二分 {

    public static int[] quickSort(int[] a, int s, int e) {
        int i = s, j = e, p = a[s];
        while (i < j) {
            while (i < j && a[j] > p) {
                j--;
            }
            while (i < j && a[i] < p) {
                i++;
            }
            if (i < j && a[i] == a[j]) {
                i++;
            } else {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        if (s < i - 1) {
            quickSort(a, s, i - 1);
        }
        if (j + 1 < e) {
            quickSort(a, j + 1, e);
        }
        return a;
    }

    static int erFen(int[] a, int t) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[] {43, 4, 42, 5, 7, 1, 3, 0};
        for (int i : quickSort(a, 0, a.length - 1)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(erFen(a, 7));
    }
}
