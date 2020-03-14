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

	Person buildPerson();// 组装
}

class ManBuilder implements PersonBuilder {

	Person person;

	public ManBuilder() {
		person = new Person();// 创建一个person实例，用于调用set方法
	}

	public void buildBody() {
		person.setBody("建造身体部分");
	}

	public void buildFoot() {
		person.setFoot("建造四肢部分");
	}

	public void buildHead() {
		person.setHead("建造头部部分");
	}

	public Person buildPerson() {
		return person;// 返回一个person实例
	}

}

class PersonDirector {
	public Person constructPerson(PersonBuilder pb) {
		// 按照 身体--->头部--->四肢 的顺序创建人物
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
