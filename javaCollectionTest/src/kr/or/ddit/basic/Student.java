package kr.or.ddit.basic;

public class Student implements Comparable<Student>{
	private int classNo;
	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int totScore;
	private int rank;
	
	public Student(int classNo, String name, int korScore, int engScore, int mathScore) {
		this.classNo = classNo;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotScore() {
		return totScore;
	}

	public void setTotScore(int totScore) {
		this.totScore = totScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [학번=" + classNo + ", 이름=" + name + ", 국어점수=" + korScore + ", 영어점수=" + engScore
				+ ", 수학점수=" + mathScore + ", 총점=" + totScore + ", 등수=" + rank + "]";
	}

	@Override
	public int compareTo(Student s) {
		Integer stu = new Integer(getClassNo());
		return stu.compareTo(s.getClassNo());
	}
	
	
}
