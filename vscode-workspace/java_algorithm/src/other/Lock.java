package other;

public class Lock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println("A:object1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object2) {
                        System.out.println("A:object2");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (object2) {
                    System.out.println("B:object1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object1) {
                        System.out.println("B:object2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}