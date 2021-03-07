package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ValueObjectNew {
	public static String value = "";
}

class ThreadDomain41 extends ReentrantLock {
	private Condition condition = newCondition();

	public void set() {
		try {
			lock();
			while (!"".equals(ValueObjectNew.value))
				condition.await();
			ValueObjectNew.value = "123";
			System.out.println(Thread.currentThread().getName() + "生产了value, value的当前值是" + ValueObjectNew.value);
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}

	public void get() {
		try {
			lock();
			while ("".equals(ValueObjectNew.value))
				condition.await();
			ValueObjectNew.value = "";
			System.out.println(Thread.currentThread().getName() + "消费了value, value的当前值是" + ValueObjectNew.value);
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			unlock();
		}
	}
}

public class ProducerCustomerReentrantLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ThreadDomain41 td = new ThreadDomain41();
		Runnable producerRunnable = new Runnable() {
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++)
					td.set();
			}
		};
		Runnable customerRunnable = new Runnable() {
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++)
					td.get();
			}
		};
		Thread ProducerThread = new Thread(producerRunnable);
		ProducerThread.setName("Producer");
		Thread ConsumerThread = new Thread(customerRunnable);
		ConsumerThread.setName("Consumer");
		ProducerThread.start();
		ConsumerThread.start();
	}

}
