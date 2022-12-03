package kr.or.ddit.basic;

import java.util.ArrayList;

public class Ex01Generic {
	public static void main(String[] args) {

		AnimalList<LandAnimal> landAnimal = new AnimalList<>(); 
		// Java SE <>타입 명시 7부터 생략가능함.

		landAnimal.add(new LandAnimal());

		landAnimal.add(new Cat());

		landAnimal.add(new Dog());

		// landAnimal.add(new Sparrow()); // 오류가 발생함.

		for (int i = 0; i < landAnimal.size(); i++) {

			landAnimal.get(i).crying();

		}

	}
}

class LandAnimal {
	public void crying() {
		System.out.println("육지동물");
	}
}

class Dog extends LandAnimal {
	public void crying() {
		System.out.println("멍멍");
	}
}

class Cat extends LandAnimal {
	public void crying() {
		System.out.println("냐옹냐옹");
	}
}

class Sparrow {
	public void crying() {
		System.out.println("짹짹");
	}
}

class AnimalList<T extends LandAnimal> {

	ArrayList<T> al = new ArrayList<T>();

	void add(T animal) {
		al.add(animal);
	}

	T get(int index) {
		return al.get(index);
	}

	boolean remove(T animal) {
		return al.remove(animal);
	}

	int size() {
		return al.size();
	}

}