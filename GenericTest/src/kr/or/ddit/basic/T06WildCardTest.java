package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {
	/*
	 * 와일드 카드에 대하여...
	 * 
	 * 와일드카드(?)는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수(Argument)로서 변수선언, 객체생성 및
	 * 메서드 정의할 때 사용된다.(제너릭 타입 선언시에는 사용할 수 없다.)
	 * 
	 * <? extends T> => 와일드카드의 상한 제한. T와 그 자손들만 가능 <? super T> => 와일드카드의 하한 제한. T와 그
	 * 조상들만 가능 <?> => 모든 타입이 가능 <? extends Object>와 동일
	 * 
	 */

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

// 쥬서 클래스
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

/**
 * 과일 상자
 * 
 * @param <T>
 */
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