package leetcode;

/* 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6] */

import java.util.ArrayList;

public class DisappearNum {

    static ArrayList<Integer> f(int[] arr) {
        for (int i : arr) {
            arr[Math.abs(i) - 1] *= arr[Math.abs(i) - 1] > 0 ? -1 : 1;
        }
        ArrayList<Integer> aList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                aList.add(i + 1);
            }
        }
        return aList;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(f(arr));
    }
}
