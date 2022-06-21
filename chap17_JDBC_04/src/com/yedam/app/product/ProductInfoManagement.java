package com.yedam.app.product;

//products의 정보를 관리
public class ProductInfoManagement extends Management {
	// 제품에 대한 정보를 등록, 수정, 삭제
	public ProductInfoManagement() {
		while (true) {
			menuPrint();

			int menuNo = menuSelect();
			if (menuNo == 1) {
				// 제품정보 등록
				insertProductInfo();
			} else if (menuNo == 2) {
				// 제품정보 수정
				updateProducInfo();
			} else if (menuNo == 3) {
				// 제품정보 삭제
				deleteProductInfo();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				// 입력오류
				showInputError();
			}
		}
	}

	// Management(부모)와 메뉴가 다르기 때문에
	// 다른것들은 같으니까??
	@Override
	protected void menuPrint() {
		System.out.println("=========================================");
		System.out.println(" 1.제품등록 | 2.제품수정 | 3.제품삭제 | 9.뒤로가기");
		System.out.println("=========================================");
	}

	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

	private void insertProductInfo() {
		// 제품정보 입력받고
		Product product = inputAll();
		// DB에 저장
		pDAO.insert(product);
	}

	private void deleteProductInfo() {
		// 제품이름을 입력받고
		String productName = inputName();
		// 제품정보를 검색
			// -1 products 테이블에서 정보를 검색
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
			// -2 입고내역이 있는지 검색
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		// DB에서 삭제
		// isSelected = true면 거래내역이 있으니까 삭제하면 안됨, 따라서 !반전연산자 사용
		if (!isSelected) {
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래내역이 존재합니다.");
		}
	}
	
	private void updateProducInfo(){
		//제품 이름을 입력받고
		String productName = inputName();
		//제품정보를 검색해옴
		Product product = pDAO.selectOne(productName);
		
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		//수정할 정보를 입력
		product = inputUpdateInfo(product);
		
		
		//DB에 업데이트
		pDAO.updateInfo(product);
		
	}
	private Product inputAll() {
		Product product = new Product();
		System.out.println("제품이름 > ");
		product.setProductName(sc.nextLine());
		System.out.println("제품가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		
		return product;
	}
	private String inputName() {
		System.out.println("제품이름 > ");
		return sc.nextLine();
	}
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존 : " + product.getProductName());
		System.out.println("수정(수정하지 않을 경우 0 입력)>");
		String name = sc.nextLine();
		if(!name.equals("0")) {
			product.setProductName(name);
		}
		System.out.println("기존 > " + product.getProductPrice());
		System.out.println("수정 (수정하지 않을 경우 -1 입력)>");
		int price = Integer.parseInt(sc.nextLine());
		if(price > -1) {
			product.setProductPrice(price);
		}
		return product;
	}
}
