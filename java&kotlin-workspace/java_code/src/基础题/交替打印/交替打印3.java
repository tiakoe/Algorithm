package 基础题.交替打印;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 交替打印3 {

    static char ch = 'a';
    static char next = 'a';

    public static void main(String[] args) {
        Object lock = new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable a = () -> run(lock, 'a', 'b');
        Runnable b = () -> run(lock, 'b', 'c');
        Runnable c = () -> run(lock, 'c', 'a');
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);
        executorService.shutdown();
        System.out.println("showdown");
    }

    private static void run(Object lock, char a, char b) {
        while (ch < 'z') {
            synchronized (lock) {
                while (next != a || ch > 'z') {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(ch + " ");
                System.out.println(Thread.currentThread());
                ch = (char) (ch + 1);
                next = b;
                lock.notifyAll();
            }
        }
    }
}
