package com.yedam.java.example1;

//고객정보를 저장하는 저장소
public class Repo {
	// 필드
	private Customer[] dataList;
	private int listIndex;

	// 생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}

	// 메소드
	// 등록
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;
	}

	// 수정
	public void update(Customer customer) { // 기존에 있던 정보를 수정
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customer.getCustomerId()) { // dataList에 있는 정보를 불러와서 customer안에있는 것과 비교
				dataList[i] = customer;
			}
		}

	}

	// 삭제
	public void delete(int customerId) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				dataList[i] = null;
			}
		}
		cleanDataList();

	}

	private void cleanDataList() {
		// 기존 데이터, 임시 변수에 복사
		Customer[] temp = dataList;
		int tempIndex = listIndex;

		// 기존 데이터를 초기화 0
		this.dataList = new Customer[100];
		this.listIndex = -1;

		for (int i = 0; i <= tempIndex; i++) {
			if (temp[i] == null) {
				continue;
			}
			dataList[++listIndex] = temp[i];
		}

	}

	// 조회
	// 전체조회
	public Customer[] selectAll() { // 배열자체를 넘겨줌.
		return dataList;
	}

	public Customer selectOne(int customerId) { // 내가 다시 반환
		Customer selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getCustomerId() == customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}

}
