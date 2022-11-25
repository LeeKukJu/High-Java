package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {

		List list1 = new ArrayList(); //DEFAULT_CAPACITY = 10;

		// add()메서드를 사용하여 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		// object를 생성해야 하지만 알아서 해준다...
		list1.add(new Integer(111));
		list1.add(new Character('k'));
		list1.add(new Boolean(true));
		list1.add(new Double(12.34));

		// size() ==> 데이터 개수
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);

		// get()으로 데이터 꺼내오기
		System.out.println("[1]번째 자료 : " + list1.get(1));

		// 데이터 끼워 넣기도 같다.
		list1.add(0, "zzz");
		System.out.println("list1 => " + list1);
		
		// 데이터 변경하기
		String temp = (String) list1.set(0, "YYY");
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);
		
		// 삭제하기
		list1.remove(0);
		System.out.println("list1[0] 삭제 후 : " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 : "+ list1);
		System.out.println("----------------------------------------------");
		
//		list1.remove(111);
//		System.out.println("그냥 111" + list1);
		
		//기본이 인덱스라서 int값을 지우려면 오브젝트를 생성해서 넣어줘야함
		list1.remove(new Integer(111));
		System.out.println("오브젝트 생성으로 111 제거 : " + list1);
		System.out.println("----------------------------------------------");
		
		// contains(비교객체) => 리스트에 '비교객체'가 있으면 true 없으면 false
		System.out.println(list1.contains("aaa"));
		System.out.println(list1.contains("ccc"));
		
		// indexOf(비교객체) => 리스트에 '비교객체'를 찾아 '비교객체'가 있는 index값을 반환하다.
		System.out.println("aaa의 index값 : " + list1.indexOf("aaa"));
		System.out.println();
		
		//list에서 모든 데이터를 지울때 주의할 점 
		// 마지막 인덱스 부터 지워야함
//		for (int i = 0; i < list1.size(); i++) {
//			list1.remove(i);
//		}
//		System.out.println("list1의 개수 : " + list1.size());
//		System.out.println(list1);
		
//		for (int i = list1.size()-1; i >0; i--) {
//			list1.remove(i);
//		}
//		System.out.println("list1의 개수 : " + list1.size());
//		System.out.println(list1);
	}
}
