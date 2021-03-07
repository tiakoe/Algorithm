package design_pattern;

//�е�ǹ�������������Ӣ�ۿ�������ѡ���Ӧ����
//��Ӧ����  Knife��Gun��Sword��Halberd
//�������ԣ�ʹ������useWeapon��

interface Weapon {
	public void useWeapon();
}

class Knife implements Weapon {
	@Override
	public void useWeapon() {
		
		System.out.println("ʹ����Knife");
	}
}

class Gun implements Weapon {
	@Override
	public void useWeapon() {
		
		System.out.println("ʹ����Gun");
	}
}

class Sword implements Weapon {
	@Override
	public void useWeapon() {
		
		System.out.println("ʹ����Sword");
	}
}

class Halberd implements Weapon {
	@Override
	public void useWeapon() {
		
		System.out.println("ʹ����Halberd");
	}
}

class Strategy {
	private Weapon weapon;

	Strategy(Weapon weapon) {
		this.weapon = weapon;
	}

	public void useWeapon() {
		weapon.useWeapon();
	}
}

public class StrategyMain {

	public static void main(String[] args) {
		
		Strategy strategy;

		strategy = new Strategy(new Sword());
		strategy.useWeapon();
		strategy = new Strategy(new Knife());
		strategy.useWeapon();
		strategy = new Strategy(new Gun());
		strategy.useWeapon();

		// ��������
		// ʹ����Sword
		// ʹ����Knife
		// ʹ����Gun
	}

}
