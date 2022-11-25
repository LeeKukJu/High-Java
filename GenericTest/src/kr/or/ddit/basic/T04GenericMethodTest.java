package kr.or.ddit.basic;

class Util{
	
	/*
	 * 제네릭 메서드<T, R> R method(T t)
	 * 
	 * 파라미터 타입과 리턴타입 파라미터를 가지는 메서드.
	 * 
	 * 선언방법 => 리턴타입 앞에 <> 기호를 추가하고 타입글자를 기술 후 사용한다.
	 * 
	 */
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/**
 * 멀티타입<K, V>를 가지는 제너릭 클래스
 */
class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	// 키와 값을 모두 출력
	public <K, V>void printAll(K key, V val) {
		System.out.println(key + " : " + val);
	}
}

public class T04GenericMethodTest {
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<>(1, "홍길동");
		
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		
		if(result1) {
			System.out.println("두 객체는 의미적으로 같은 객체임.");
		}else {
			System.out.println("두 객체는 의미적으로 다른 객체임.");
		}
		
		Pair<String, String> p3 =
				new Pair<>("001", "홍길동");
		Pair<String, String> p4 =
				new Pair<>("002", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("두 객체는 의미적으로 같은 객체임.");
		}else {
			System.out.println("두 객체는 의미적으로 다른 객체임.");
		}
		
//		p1.printAll(100, "키");
		p1.<String, Integer>printAll("키", 100);
	}
}
