package design_pattern;

/*
 * װ����ģʽ��
 * �ص㣺������ʱ��̬�ظ�һ�����ж������ӹ���
 * װ��������������ϴ���ԭ��
 * װ������븲д����ŷ�̳еķ���
 * 
 * */
//Hamburg ����

//Ausstattung  װ��  ������

//VegeScheme  ��ʳ����
//Cabbage  ���Ĳ�
//Egg    ����

//MeatScheme  ��˺���
//Beef   ţ��

interface Hamburg {
	public String getName();

	public int getPrice();
}

class VegeScheme implements Hamburg {

	@Override
	public String getName() {
		
		return "��ʳ����";
	}

	@Override
	public int getPrice() {
		
		return 20;
	}

}

class MeatScheme implements Hamburg {

	@Override
	public String getName() {
		
		return "��˺���";
	}

	@Override
	public int getPrice() {
		
		return 40;
	}

}

abstract class Ausstattung implements Hamburg {
	protected Hamburg hamburg;

	public Ausstattung(Hamburg p_hamburg) {
		hamburg = p_hamburg;
	}
}

class Cabbage extends Ausstattung {

	public Cabbage(Hamburg p_hamburg) {
		super(p_hamburg);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		
		return hamburg.getName() + "+���Ĳ�";
	}

	public int getPrice() {
		
		return hamburg.getPrice() + 10;
	}
}

class Egg extends Ausstattung {

	public Egg(Hamburg p_hamburg) {
		super(p_hamburg);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		
		return hamburg.getName() + "+����";
	}

	public int getPrice() {
		
		return hamburg.getPrice() + 5;
	}
}

class Beef extends Ausstattung {

	public Beef(Hamburg p_hamburg) {
		super(p_hamburg);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		
		return hamburg.getName() + "+ţ��";
	}

	public int getPrice() {
		
		return hamburg.getPrice() + 20;
	}
}

public class Decorator {

	public static void main(String[] args) {
		
		Hamburg hb = new Cabbage(new VegeScheme());
		System.out.println(hb.getName() + ":" + hb.getPrice());

		hb = new Beef(new Egg(hb));
		System.out.println(hb.getName() + ":" + hb.getPrice());
	}
	// ��ʳ����+���Ĳ�:30
	// ��ʳ����+���Ĳ�+����+ţ��:55

}
