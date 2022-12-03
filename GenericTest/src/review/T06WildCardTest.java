package review;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	public static void main(String[] args) {

		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Garbage> garbegeBox = new FruitBox<>();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

//		appleBox.add(new Grape()); => appleBox는 Apple 타입만 받는다고 선언해서 Grape를 못 넣음

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		Juicer.makeJuice(fruitBox);
//		Juicer.makeJuice(appleBox); => 컴파일에러! 제너릭 타입이 맞지 않음!
		Juicer.makeJuice(appleBox);
//		Juicer.makeJuice(garbegeBox); => fruit로 제한하여 에러 발생

	}
}

class Juicer {
//	static void makeJuice(FruitBox<Fruit> box) {
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<? extends Fruit> box) {

		String fruitStr = ""; // 과일목록

		int cnt = 0;
		for (Object f : box.getFruitList()) {
			if (cnt == 0) {
				fruitStr += f;
			} else {
				fruitStr += "," + f;
			}
			cnt++;
		}

		System.out.println(fruitStr + " => 쥬스 완성!!!");
	}
}

class FruitBox<T> {

	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void add(T fruit) {
		this.fruitList.add(fruit);
	}
}

class Garbage {
	private String name;

	public Garbage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Fruit {
	private String name;

	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {

	public Grape() {
		super("포도");
	}
}