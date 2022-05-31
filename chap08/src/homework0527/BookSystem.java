package homework0527;

import java.util.Scanner;

public class BookSystem implements BookProgram {
	private Scanner sc = new Scanner(System.in);

	// private Access Repo = BookRepo.getInstance(); <--------저장소로 바로 연결
	
	
	
	@Override
	public void menuPrint() {
		System.out.println("===================================");
		System.out.println("1.정보입력 | 2.전체조회 | 3. 검색 | 4.분석 ");
		System.out.println("===================================");

	}// 정보입력

	@Override
	public void inputInfo(BookAccess access) {
		Book info = inputAll();
		access.insert(info);

	}

	private Book inputAll() {

		System.out.println("책 제목 > \t");
		String name = sc.next();
		System.out.println("가격 > \t");
		int price = sc.nextInt();
		int isbn = (int) (Math.random() * 100000000);
		return new Book(name, price, isbn);
		
		/* System.out.println("책 제목 > \t");
		String name = sc.next();
		System.out.println("가격 > \t");
		int price = Integer.parseInt(sc.nextLine());
		
		return new Book(name, price);
		
		*/
	} // 전체조회

	@Override
	public void printAllInfo(BookAccess access) {
		Book[] list = access.selectAll();

		for (Book book : list) { //향상된 포문을 사용하는 전제조건은 배열안에 null값이 없어야 함.
			book.showInfo();
			
			/*Book[] list = dao.selectAll();
			 * for(Book data : list) {
			 * data.shoinfo());
			 * 
			 */
		}

	}
	// 검색

	@Override
	public void printInfo(BookAccess access) {
		// 검색조건 입력
		String name = inputName();
		int price = inputPrice();

		// 저장소에 등록

		// 저장소에서 검색
		Book info = access.selectOne(name, price);
		info.showInfo();
		/* isbn 정보 입력
		 *  		int keyword = inputone(); <---inputone매써드를 하나 만들어버림.
		 * 
		 * dao에서 검색
		 * 			Book data = dao.selectOne(keyword);
		 * 출력
		 * 			data.showInfo();
		 * 
		 * 
		 * public int inputOne() {
		 * system.out.print()
		 */
		

	}

	private String inputName() {
		System.out.println("검색. 책 제목 > ");
		return sc.next();
	}

	private int inputPrice() {
		System.out.println("검색. 가격 > ");
		return sc.nextInt();
	}

	private int inputIsbn() {
		System.out.println("검색. ISBN > ");
		int isbn = (int) (Math.random() * 100000000);
		return isbn;

	}

	@Override
	public void printRepo(BookAccess access) {
		// 최고가격 ㅇㅇ?
		System.out.println("최고 가격> ");
		Book maxInfo = selectMaxPrice(access);
		maxInfo.showInfo();

		// 최저가격
		System.out.println("최저 가격> ");
		Book minInfo = selectMinPrice(access);
		minInfo.showInfo();

		// 평균가격
		System.out.println("평균 가격> ");
		Book[] list = access.selectAll();

		int sum = 0;
		for (Book info : list) {
			sum += info.getPrice();
		}
		System.out.println((double) (sum - (maxInfo.getPrice() + minInfo.getPrice())) / (list.length - 2));
		//
		System.out.println("최대, 최소 가격 책의 정보를 제외한 책들의 정보 >");

		/*최대 최소 책 정보를 제외한 책들의 평균과 가격
		 * calAvgInfo();
		 * 
		 * private Book SelectMaxInfo() { <---최대값 구하기, 최소값도 동일.
		 *  <전체조회>
		 *  	Book[] list = access.selectAll();
		 *  <검색>
		 *  	Book max = list[0].getPrice(); 
		 * 		for(Book data : list) {
		 * 			if(maxInfo.getPrice() < data.getPrice()){
		 * 				maxInfo = data;
		 * 		}
		 * }
		 * return maxInfo;
		 * 
		 * private calAvgInfo() {
		 * 		Book maxInfo = selectMaxInfo();
		 * 		Book minInfo = selectMinInfo();
		 * 
		 * 		Book[] list = access.selectAll();
		 * 		
		 * 		최대값, 최소값도 아닌 값의 정보를 출력
		 * 		int sum = 0;
		 * 		for(Book data : list) {
		 * 			if(data.getPrice() > minInfo.getPrice() && data.getPrcie() < maxInfo.getPrice()) {
		 * 				<조건에 만족하는 경우의 총합>
		 * 				sum += data.getPrice();
		 * 				<조건에 만족하는 경우의 정보를 출력>
		 * 				data.showInfo();
		 * }
		 * }
		 * 		<평균구하기>
		 * 		double avg = (double)sum / (list.length -2);
		 * 		System.out.print("최고 가격과 최저 가격을 제외한 평균 > ")
		 * 		System.out.printf("%.2f\n, avg);
		 * }
		 * 
		 */
	}
	
	

	private static Book selectMaxPrice(BookAccess access) {
		Book[] list = access.selectAll();

		Book maxInfo = list[0];
		for (int i = 0; i < list.length; i++) {
			if (maxInfo.getPrice() < list[i].getPrice()) {
				maxInfo = list[i];
			}

		}
		return maxInfo;

	}

	private static Book selectMinPrice(BookAccess access) {
		Book[] list = access.selectAll();

		Book minInfo = list[0];
		for (int i = 0; i < list.length; i++) {
			if (minInfo.getPrice() > list[i].getPrice()) {
				minInfo = list[i];
			}

		}
		return minInfo;
	}

}
