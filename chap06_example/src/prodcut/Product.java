package prodcut;

public class Product {
	
	// 필드 - 상품명, 가격
		private String name;
		private int price;

		// 생성자
		public Product() {
		}

		public Product(String name, int price) {
			this.name = name; //
			this.price = price;
		}

		// 메소드
		public void setName(String name) { // 제품명 설정
			this.name = name;
		}

		public void setPrice(int price) { // 제품 가격 설정
			this.price = price;
		}

		public String getName() { // 제품이름 출력
			return name;
		}

		public int getPrice() { // 제품 가격 출력
			return price;
		}

		// 제품별 가격 출력
		public void showInfo() { // ->이거나 위에꺼나 사용하기.
			System.out.println(name + ":" + price);
		}

	}


