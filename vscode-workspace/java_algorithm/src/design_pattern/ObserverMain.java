package design_pattern;

import java.util.ArrayList;
import java.util.Iterator;

interface Observer {
	public abstract void notifyMessages(War war);
}

abstract class War {
	private ArrayList observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	public void execute() {
		System.out.println("ս������");
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer) iterator.next();
			observer.notifyMessages(this);
		}
	}

	public abstract void notifyPeople();

	public abstract void getCurrentStatus();
}

class WarGenerator extends War {

	public void getCurrentStatus() {
		System.out.println("ս����ʼ��...");
	}

	@Override
	public void notifyPeople() {
		
		execute();
	}

}

class Villager implements Observer {

	@Override
	public void notifyMessages(War war) {
		
		System.out.println("�����ȡ������Ϣ��");
		war.getCurrentStatus();
	}

}

class Student implements Observer {

	@Override
	public void notifyMessages(War war) {
		
		System.out.println("ѧ����ȡ������Ϣ��");
		war.getCurrentStatus();
	}

}

public class ObserverMain {

	public static void main(String[] args) {
		
		War war = new WarGenerator();
		Observer observer01 = new Villager();
		Observer observer02 = new Student();
		war.addObserver(observer01);
		war.addObserver(observer02);

		war.execute();

		/*
		 * ս������ �����ȡ������Ϣ�� ս����ʼ��... ѧ����ȡ������Ϣ�� ս����ʼ��...
		 */
	}

}
