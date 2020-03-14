package design_pattern;

interface Human {
	public void say();
}

class Man implements Human {

	@Override
	public void say() {
		System.out.println("男人");
	}
}

class Woman implements Human {
	@Override
	public void say() {
		System.out.println("女人");
	}
}

class SampleFactory {
	public static Human makeHuman(String type) {
		if (type.equals("man")) {
			Human man = new Man();
			return man;
		} else if (type.equals("womman")) {
			Human woman = new Woman();
			return woman;
		} else {
			System.out.println("生产不出来");
			return null;
		}
	}

}

class NormalFactory {
	public static void main(String[] args) {
		Human man = SampleFactory.makeHuman("man");
		man.say();
		Human womman = SampleFactory.makeHuman("womman");
		womman.say();
		Human test = SampleFactory.makeHuman("tttt");
	}
}
