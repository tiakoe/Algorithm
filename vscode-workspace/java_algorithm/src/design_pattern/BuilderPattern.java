package design_pattern;

class Person {

	private String head;
	private String body;
	private String foot;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}
}

interface PersonBuilder {
	void buildHead();

	void buildBody();

	void buildFoot();

	Person buildPerson();// ��װ
}

class ManBuilder implements PersonBuilder {

	Person person;

	public ManBuilder() {
		person = new Person();// ����һ��personʵ�������ڵ���set����
	}

	public void buildBody() {
		person.setBody("�������岿��");
	}

	public void buildFoot() {
		person.setFoot("������֫����");
	}

	public void buildHead() {
		person.setHead("����ͷ������");
	}

	public Person buildPerson() {
		return person;// ����һ��personʵ��
	}

}

class PersonDirector {
	public Person constructPerson(PersonBuilder pb) {
		// ���� ����--->ͷ��--->��֫ ��˳�򴴽�����
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector();
		Person person = pd.constructPerson(new ManBuilder());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
		System.out.println(person.getHead());
	}
}
