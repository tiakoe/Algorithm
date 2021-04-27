package 基础题.交替打印;

import java.util.concurrent.locks.LockSupport;

public class 交替打印1 {
    private static Thread a, b, c;
//     不同任务交替打印: 1A1 2B2 3C3 4D4...26Z26
    public static void main(String[] args) {

        a = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.unpark(b);
                LockSupport.park();
            }
        });

        b = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                LockSupport.park();
                System.out.print((char) ('A' + i));
                LockSupport.unpark(c);
            }
        });

        c = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                LockSupport.park();
                System.out.print(i+" ");
                LockSupport.unpark(a);
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
