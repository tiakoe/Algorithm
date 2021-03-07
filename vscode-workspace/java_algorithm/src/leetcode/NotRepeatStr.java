package leetcode;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NotRepeatStr {

    // 方法一：
    static int f(String string) {
        Set<Character> set = new HashSet<Character>();
        int s = 0, pre = 0, res = 0;
        for (int i = 0; i < string.length(); i++) {
            pre = set.size();
            set.add(string.charAt(i));
            if (set.size() != pre) {
                res = Math.max(res, set.size());
            } else {
                while (set.contains(string.charAt(i))) {
                    set.remove(string.charAt(s));
                    s++;
                }
                set.add(string.charAt(i));
            }
        }
        return res;
    }

    // 方法二（优化版）：
    static int f2(String string) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int s = 0, res = 0;
        for (int i = 0; i < string.length(); i++) {
            if (hashMap.containsKey(string.charAt(i))) {
                s = hashMap.get(string.charAt(i));
            }
            hashMap.put(string.charAt(i), i);
            res = Math.max(res, i - s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(f2("bbbbb"));
    }
}
