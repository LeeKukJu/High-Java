package review;

public class T03GenericClassTest {
	public static void main(String[] args) {
		
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 => " + rtnVal1);
		
		Integer irtnVal2 = (Integer) ng2.getVal();
		System.out.println("문자열 반환값 rtnVal2 => " + irtnVal2);
		
		System.out.println("-------------------------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		irtnVal2 = mg2.getVal();
		
		System.out.println("제네릭 문자열 반환값 => " + rtnVal1);
		System.out.println("제네릭 문자열 반환값 => " + irtnVal2);
	}
}

class NonGenericClass {
	
	private Object val;
	
	public Object getVal() {
		return val;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T> {
	
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
	
}