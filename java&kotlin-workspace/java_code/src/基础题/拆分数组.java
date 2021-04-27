package 基础题;

/*
输入
复制
5
1 3 1 1 4
输出
复制
5
说明
[1,3,1]  [ ]   [1,4] ，其中第可一组奖金和是5，等于第三组奖金和。所以小明以拿到5越南盾*/
public class 拆分数组 {
    private static void f(int[] a) {
        int i = 0, j = a.length - 1;
        int s = 0, e = 0, res = 0;
        while (i < j) {
            if (s > e) {
                e += a[j--];
            } else if (s < e) {
                s += a[i++];
            } else {
                res = Math.max(res, s);
                s+=a[i];
                e+=a[j];
                if (a[i] > a[j]) {
                    j--;
                }else if(a[i]<a[j]){
                    i++;
                }else{
                    i++;
                    j--;
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        f(new int[] {1, 3, 1, 4, 5});
    }
}
