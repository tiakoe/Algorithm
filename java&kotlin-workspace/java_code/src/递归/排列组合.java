package 递归;

import java.util.Stack;

public class 排列组合 {

    static Stack<Integer> stack = new Stack<>();

//    A5:5
    static void f(int[] a, int n, int c) {
        if (n == c) {
            System.out.println(stack);
            return;
        }
        for (Integer item : a) {
            if (!stack.contains(item)) {
                stack.add(item);
                f(a, n, c + 1);
                stack.pop();
            }
        }

    }

//    C5:2
    static void f2(int[]a,int s, int e, int h){
        if(s==e){
            System.out.println(stack);
            return;
        }
        for (int i = h; i < a.length; i++) {
            if(!stack.contains(a[i])){
                stack.add(a[i]);
                f2(a,s+1,e,i);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
//        f(a, a.length, 0);
        f2(a,0,2,0);
    }
}
