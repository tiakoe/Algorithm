package other;
class SingleStatic {

	private SingleStatic() {
		System.out.println("xx");
	}

	private static class InnerSingle {
		private static final SingleStatic instance = new SingleStatic();
	}

	public static SingleStatic getInstance() {
		return InnerSingle.instance;
	}
}

class Single {
	public static int value = -1;

	private Single(int value) {
		Single.value = value;
		System.out.println(value);
	}

	private static volatile Single instance;

	public static synchronized void getInstance(int i) {
		System.out.println(i);
		if (instance == null) {
			System.out.println("null");
			synchronized (Single.class) {
				if (instance == null) {
					instance = new Single(i);
				}
			}
		}
	}
}

public class SingleInstance {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int count = 0;
				while (count < 10) {
					Single.getInstance(count);
					count++;
					// System.out.print(Single.value);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				int count = 20;
				while (count < 30) {
					Single.getInstance(count);
					count++;
					// System.out.print(Single.value);
				}
			}
		}).start();
	}

}
