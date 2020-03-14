package design_pattern;

/**
 * 
 * ����ʽ����ģʽ
 * 
 */
public class SingletonHunger {

	// ����ص�ʱ��ͽ���ʵ����
	private static final SingletonHunger instance = new SingletonHunger();

	private SingletonHunger() {
	}

	public static SingletonHunger getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		

	}

}
