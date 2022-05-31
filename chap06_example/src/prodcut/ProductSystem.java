package prodcut;

public class ProductSystem {
	private Product[] list;
	private int index;

	public ProductSystem() {
		index = -1;
	}

	// 1. 상품 수 입력
	public void setListSize(int size) {
		list = new Product[size];
	}

	// 2. 상품 및 가격 입력
	public void putProduct(String name, int price) {
		Product product = new Product();// 들어올 값 담기위한 임시변수
		product.setName(name);
		product.setPrice(price);

		list[++index] = product;
	}

	// 3.제품별 가격 출력
	public void pricetList() {
		for (int i = 0; i <= index; i++) {
			Product product = list[i];// product의 필드값 어떻게 출력할것인가?
			// System.out.println(product.getName() + ":" + product.getPrice());
			list[i].showInfo();
		}
	}

	// 4. 최고가격

	public Product getMaxPriceInfo() {
		Product maxInfo = list[0];
		for (int i = 1; i <= index; i++) { // <-- list값을 0부터 했으므로 이미 0번째 index 값은 있음, 따라서 i=1부터 시작해야함.
			if (maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}

		
		return maxInfo;

		/*
		 * int printMax() { int max = list[0].getPrice(); for (int i = 0; i < index;
		 * i++) { if (max < list[i].getPrice()) { max = list[i].getPrice(); } } return
		 * max;
		 */

	}// 4. 분석. 종합

	public int getTotalPrice() {
		int sum = 0;
		for (Product temp : list) { // <---향상된 for문
			sum += temp.getPrice();
		}
		Product maxInfo = getMaxPriceInfo();
		int result = sum - maxInfo.getPrice();

		// int result = sum - getMaxPriceInfo().getPrice();
		result = 0; // result값을 초기화 시켜야 누적값이 나옴.
		for (Product temp : list) {
			if (temp.getPrice() == maxInfo.getPrice())
				continue; // <-- 반복문 안에서 다시 올라가게 = 이 조건 일때는 다음을 실행시키지 않겠다.
						// <-- break는 반복문을 나가버림.
		result += temp.getPrice();
		} 
			
		return result;
	}

	/*
	 * int printSum() { int sum =0; int result = 0; for(int i=0; i<index; i++) { sum
	 * += (list[i].getPrice()); //list에는 name과 price가 있으니까get.Price } result = (sum
	 * - printMax()); return result; }
	 */
}
