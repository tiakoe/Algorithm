package design_pattern;

//�������Լ��ͺ�  
interface Engine {

}

class EngineA implements Engine {
	EngineA() {
		System.out.println("����-->EngineA");
	}
}

class EngineB implements Engine {
	EngineB() {
		System.out.println("����-->EngineB");
	}
}

// �յ��Լ��ͺ�
interface Aircondition {

}

class AirconditionA implements Aircondition {
	AirconditionA() {
		System.out.println("����-->AirconditionA");
	}
}

class AirconditionB implements Aircondition {
	AirconditionB() {
		System.out.println("����-->AirconditionB");
	}
}

// ���������Ľӿ�
interface AbstractFactory {
	// ���췢����
	Engine createEngine();

	// ����յ�
	Aircondition createAircondition();
}

// Ϊ����320ϵ���������
class FactoryBMW320 implements AbstractFactory {
	@Override
	public Engine createEngine() {
		return new EngineA();
	}

	@Override
	public Aircondition createAircondition() {
		return new AirconditionA();
	}
}

// ����523ϵ��
class FactoryBMW523 implements AbstractFactory {

	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public Aircondition createAircondition() {
		return new AirconditionB();
	}

}

public class AbstractFactoryClass {
	public static void main(String[] args) {
		// ��������320ϵ�����
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();
		factoryBMW320.createEngine();
		factoryBMW320.createAircondition();

		// ��������523ϵ�����
		FactoryBMW523 factoryBMW523 = new FactoryBMW523();
		factoryBMW320.createEngine();
		factoryBMW320.createAircondition();
	}
}
