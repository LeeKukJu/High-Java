package kr.or.ddit.basic;

public class T03GenericClassTest {
/*
 * 제네릭 클래스를 생성하는 방법
 * 
 * 형식)
 * 		class 클래스명<제네릭타입글자> {
 * 
 * 		제네릭타입글자 변수명;  // 변수 선언에서 제네릭을 사요하는 경우...
 * 
 * 		제네릭타입글자 메서드명() {
 * 			...
 * 		  return 값;
 * 		}
 * 		...
 * 	}
 * 
 * - 제너릭타입글자 -
 * T => Type
 * K => Key
 * V => Value
 * E => Element
 * 
 */
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnVal1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 => " + rtnVal1);
		
		Integer iRtnVal2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 iRtnVal2 => " + iRtnVal2);
		
		//////////////////////////////////////////////////////
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnVal1 = mg1.getVal();
		iRtnVal2 = mg2.getVal();
		
		System.out.println("제네릭 문자열 반환값 => " + rtnVal1);
		System.out.println("제네릭 정수형 반환값 => " + iRtnVal2);
		
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

class MyGeneric<T>{
	
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}