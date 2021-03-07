package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 桶排序 {
    public static double[] bucketSort(double[] array) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_EXPONENT;
        // 求出array数组的最大值和最小值
        for (double v : array) {
            if (v > max) {
                max = v;
            } else if (v < min) {
                min = v;
            }
        }
        // 计算出差值
        double d = max - min;
        // 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (double v : array) {
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }

        // JDK底层采用了归并排序或归并的优化版本进行排序
        for (LinkedList<Double> doubles : bucketList) {
            Collections.sort(doubles);
        }

        // 输出结果
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }

    // 主函数
    public static void main(String[] args) {
        double[] array = new double[] {3.14, 0.002, 6.6, 3.0, 10.01, 8.8, 4.55, 7.89};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
