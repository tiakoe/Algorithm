package design_pattern;

import java.util.ArrayList;
import java.util.List;

abstract class Product {
	public abstract void use();
}

abstract class Factory {
	public final Product create(String owner) {
		Product product = createProduct(owner);
		registerWeapon2(product);
		return product;
	}

	protected abstract Product createProduct(String owner);

	protected abstract void registerWeapon2(Product product);
}

class Weapon2Factory extends Factory {
	private List<Object> owners = new ArrayList<>();

	@Override
	protected Product createProduct(String owner) {
		
		return new Weapon2(owner);
	}

	@Override
	protected void registerWeapon2(Product product) {
		
		owners.add(((Weapon2) product).getOwner());
	}

	public List getOwners() {
		return owners;
	}

}

class Weapon2 extends Product {
	private String owner;

	Weapon2(String owner) {
		// TODO Auto-generated constructor stub
		System.out.println("����������" + owner);
		this.owner = owner;
	}

	@Override
	public void use() {
		
		System.out.println("ʹ��������" + owner);
	}

	public String getOwner() {
		return owner;
	}

}

public class FactoryMain {

	public static void main(String[] args) {
		
		Factory factory = new Weapon2Factory();
		Product product01 = factory.create("Sword");
		Product product02 = factory.create("Gun");
		Product product03 = factory.create("Knife");

		System.out.println();
		product01.use();
		product02.use();
		product03.use();

		/*
		 * �����
		 * 
		 * ����������Sword ����������Gun ����������Knife
		 * 
		 * ʹ��������Sword ʹ��������Gun ʹ��������Knife
		 */

	}

}
