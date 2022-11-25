package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentExample {
	public static void main(String[] args) {

		List<Student> student = new ArrayList<Student>();

		student.add(new Student(4, "양국자", 70, 85, 95)); // 총점 : 250
		student.add(new Student(2, "김민수", 85, 75, 85)); // 총점 : 245
		student.add(new Student(5, "강백호", 65, 60, 90)); // 총점 : 215
		student.add(new Student(1, "이국주", 70, 65, 90)); // 총점 : 225
		student.add(new Student(3, "송지나", 75, 75, 95)); // 총점 : 245

		System.out.println("<이름 정렬 전>");
		for (Student s : student) {
			int totScore = s.getEngScore() + s.getKorScore() + s.getMathScore();
			s.setTotScore(totScore);
			System.out.println(s);
		}
		System.out.println("----------------------------");

		Collections.sort(student);
		System.out.println("<학번 오름차순 정렬 후>");
		for (Student s : student) {
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
		System.out.println("<총점 내림차순 정렬>");
		Collections.sort(student, new sortTotScore());
		int i = 1;
		for (Student s : student) {
			s.setRank(i);
			i++;
			System.out.println(s);
		}
	}
}

class sortTotScore implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		//총점 같을 때, 학번 기준으로 내림차순
		if (s1.getTotScore() == s2.getTotScore()) {
			return Integer.compare(s1.getClassNo(), s2.getClassNo()) * -1;
		}
		// 총점 기준 내림차순
		return Integer.compare(s1.getTotScore(), s2.getTotScore()) * -1;
	}
}
