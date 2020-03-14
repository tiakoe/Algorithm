package other;
class ValueObject {
	public static String value = "";
}

class Producer {
	private Object lock;

	public Producer(Object lock) {
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("Set��ֵ�ǣ�" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Customer {
	private Object lock;

	public Customer(Object lock) {
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("Get��ֵ�ǣ�" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProducerCustomer {

	public static void main(String[] args) {
		
		Object lock = new Object();
		final Producer producer = new Producer(lock);
		final Customer customer = new Customer(lock);
		Runnable producerRunnable = new Runnable() {
			public void run() {
				while (true) {
					producer.setValue();
				}
			}
		};
		Runnable customerRunnable = new Runnable() {
			public void run() {
				while (true) {
					customer.getValue();
				}
			}
		};
		Thread producerThread = new Thread(producerRunnable);
		Thread CustomerThread = new Thread(customerRunnable);
		producerThread.start();
		CustomerThread.start();
	}

}
