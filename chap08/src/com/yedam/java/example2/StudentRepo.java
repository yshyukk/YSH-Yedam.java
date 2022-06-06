package com.yedam.java.example2;

public class StudentRepo implements Access {
	// 저장소는 분산X (=인스턴스가 하나) ---> 싱글톤으로
	// 싱글톤
	private static StudentRepo instance = new StudentRepo(); // 클래스 명으로 메서드로 접근
	private Student[] dataList; // data를 저장하기 위한 배열 선언
	private int listIndex;

	private StudentRepo() {
		init();

	}

	public static StudentRepo getInstance() {
		return instance; // <--외부에서 사용하기 위해 instance

	}

	private void init() {
		dataList = new Student[100];
		listIndex = -1;
	}

	@Override
	public void insert(Student student) {
		dataList[++listIndex] = student;
	}

	@Override
	public void update(Student student) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == student.getId()) {
				dataList[i] = student;

			}
		}
	}

	@Override
	public void delete(int studentId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == studentId) {
				dataList[i] = null;
			}
		}
		cleanDataList(); // clean : 기존에 있던 데이터 다 지우고 새로 만듦.
	}

	private void cleanDataList() {
		// 기존데이터 -> 임시변수
		Student[] tempList = dataList;
		int tempIndex = listIndex;

		// 기존 필드 초기화
		init();

		// 임시변수에서 데이터만 기존 필드로 복사
		for (int i = 0; i <= tempIndex; i++) {
			if (tempList[i] != null) {
				dataList[++listIndex] = tempList[i];
			}
		}
	}

	@Override
	public Student[] selectAll() {
		Student[] list = new Student[listIndex + 1]; // Index와 length와 1개 차이나기때문에.
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
	}

	@Override
	public Student selectOne(int studentId) {
		Student selected = null;
		/*
		 * for(Student student : dataList) { //향상된 for문 XXX 수정 필요. 
		 * if(student.getId() ==studentId) {
		 *  selected = student; }
		 *  } 
		 */
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getId() == studentId)
				selected = dataList[i];
		}
		return selected;
	}

}
