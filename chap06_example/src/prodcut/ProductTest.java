package prodcut;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		ProductSystem system = new ProductSystem();

		boolean run = true; // <-- while문 돌리기 위한 변수 선언
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println(" 1. 상품 수 | 2. 상품 및 가격  | 3. 제품별 가격 | 4. 분석 | 5. 종료");
			System.out.println("선택 > ");

			int selNum = sc.nextInt();

			if (selNum == 1) {
				System.out.println("상품 수 > ");
				int size = sc.nextInt();
				system.setListSize(size);
				System.out.println();
			} else if (selNum == 2) {
				System.out.println("상품명 > ");
				String name = sc.next();
				System.out.println("상품가격 > ");
				int price = sc.nextInt();
				system.putProduct(name, price); // 위에서 입력받은 정보를 system안에 Product로 넘겨줌.
			} else if (selNum == 3) {
				System.out.println("제품별 가격 > ");
				system.pricetList();
				System.out.println();
			} else if (selNum == 4) {
				Product maxInfo = system.getMaxPriceInfo();
				System.out.println("최고가격 : " + maxInfo.getPrice());

				System.out.println("최고가를 제외한 총합 : " + system.getTotalPrice());
			} else if (selNum == 5) {
				run = false;
				System.out.println("프로그램 종료");
				{
				}

			}
		}

	}

}
