package design_pattern;

class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}
}

public class SingletonMain {

	public static void main(String[] args) {
		
		Singleton singleton01 = Singleton.getInstance();
		Singleton singleton02 = Singleton.getInstance();
		if (singleton01 == singleton02) {
			System.out.println("����ͬʵ��");
		} else {
			System.out.println("�ǲ�ͬʵ��");
		}

		/* ����ͬʵ�� */
	}

}
