package review;

public class T04GenericMethodTest {
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<>(1, "홍길동");
		
		boolean result1 = Util.compare(p1, p2);
		
		if(result1) {
			System.out.println("두 객체는 의미적으로 같은 객체");
		}else {
			System.out.println("두 객체는 의미적으로 다른 객체");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<>("002", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("두 객체는 의미적으로 같은 객체");
		}else {
			System.out.println("두 객체는 의미적으로 다른 객체");
		}
		
		p1.<String, Integer>printAll("키", 100);
	}
}

class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

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
	
	public <K, V>void printAll(K key, V val){
		System.out.println(key + " : " + val);
	}
	
}