package homework;

public class EnumHomework {

	public enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);
		
		// 괄호속 반지름을 저장할 변수 선언
		private double radius;
		
		//생성자
		private Planet(double data) {
			radius = data;
		}
		
		//값을 반환하는 메서드
		public double getRadius() {
			return radius;
		}
		
	}
	
	public static void main(String[] args) {
		
		// 열거형이름.values() => 데이터를 배열로 가져온다.
		Planet[] planetArr = Planet.values();
		for (int i = 0; i < planetArr.length; i++) {
			System.out.println(planetArr[i].name() + "의 면적 : " 
		+ (4 * Math.PI * planetArr[i].getRadius() * planetArr[i].getRadius()) + "[㎢]");
		}
		
		System.out.println();
		System.out.println("----------------------------------------------");
		for(Planet p : Planet.values()) {
			System.out.println(p + "의 면적 : " + (4 * Math.PI * p.getRadius() * p.getRadius() + "[㎢]"));
		}
	}
	
}
