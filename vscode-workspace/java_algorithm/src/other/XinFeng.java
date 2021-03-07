package other;

import java.util.Arrays;
import java.util.Comparator;
// 信封嵌套问题
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // x 上 递增排序， 如果 x 相同的话，y 上递减排序，最后在 y 上求最大子序列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    // 寻找最长递增子序列
    public int lengthOfLIS(int[] nums) {

        System.out.println(Arrays.toString(nums));

        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}
