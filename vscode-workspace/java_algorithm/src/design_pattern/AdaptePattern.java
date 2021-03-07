package design_pattern;

class Adaptee {
	public void method1() {
		System.out.println("method 1");
	}
}

interface Target {
	void method1();

	void method2();
}

class Adapter extends Adaptee implements Target {
	@Override
	public void method2() {
		System.out.println("method 2");
	}
}

// ����
public class AdaptePattern {

	public static void main(String[] args) {
		
		Adapter adapter = new Adapter();
		adapter.method1();
		adapter.method2();
	}

}
