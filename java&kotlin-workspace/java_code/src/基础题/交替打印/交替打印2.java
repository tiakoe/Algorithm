package 基础题.交替打印;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印2 {
//  同类任务多个线程交替打印
    static int times = 9;
    static int state = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void print(int id) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == id) {
                if (state != 26) {
                    System.out.print((char) ('A' + state));
                }
                state++;
                i++;
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            executorService.execute(() -> print(finalI));
        }
        executorService.shutdown();
    }
}
