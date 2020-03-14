package design_pattern;

/**
 * 
 * ����ʽ����ģʽ �����synchronized�൱��һ��ȫ����
 * 
 * 
 */
public class SingletonLazy {

	private static SingletonLazy instance;

	private SingletonLazy() {
	}

	// Ϊ��֤ͬ��,���˷������ӹؼ���:synchronized
	public static synchronized SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

	public static void main(String[] args) {
		

	}

}
