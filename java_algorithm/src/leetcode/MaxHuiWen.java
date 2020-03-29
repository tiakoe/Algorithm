package leetcode;

/* 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。 */

public class MaxHuiWen {
    static int f(String string) {
        int[] arr = new int[58];
        int res = 0;
        for (char i : string.toCharArray()) {
            arr[i - 'A']++;
        }
        for (int i : arr) {
            res += (i & 1) == 1 ? i - 1 : i;
        }
        return res == string.length() ? res : res + 1;
    }

    public static void main(String[] args) {
        System.out.println(f("abccccdd"));
    }
}