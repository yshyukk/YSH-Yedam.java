package test_shy;

import java.util.List;
import java.util.Scanner;

public class Management {

	private Scanner sc = new Scanner(System.in);
	private BookDAO bDAO = BookDAO.getInstace();

	public Management() {
		while (true) {
			menuPrint();

			int menuNo = selectMenu();

			if (menuNo == 1) {
				// 전체조회
				selectAll();
			} else if (menuNo == 2) {
				// 단건조회
				selectOne();
			} else if (menuNo == 3) {
				// 내용검색
				selectContents();
			} else if (menuNo == 4) {
				// 대여가능
				Rental();
			} else if (menuNo == 5) {
				// 책 대여
				bookRental();
			} else if (menuNo == 6) {
				// 책 반납
				bookReturn();
			} else if (menuNo == 7) {
				// 책등록
				inBook();
			} else if (menuNo == 9) {
				// 종료
				exit();
				break;
			} else {
				showInfoError();
				break;
			}
		}
	}

	private void menuPrint() {
		System.out.println("============================================================================");
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5.책 대여 | 6.책 반납 | 7.책 등록 | 9.종료");
		System.out.println("============================================================================");

	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menu;
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void showInfoError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다.");
	}

	// 전체조회
	private void selectAll() {
		List<Book> list = bDAO.selectAll();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	// 단건조회
	private void selectOne() {

		// 책이름 입력 ,DB 검색
		Book book = bDAO.selectOne(inputBookName());
		// 결과출력
		//
		if (book != null) {
			System.out.println(book);
		} else {
			System.out.println("등록되지 않은 도서입니다.");
		}
	}

	private String inputBookName() {
		System.out.println("책 제목 > ");
		return sc.nextLine();
	}

	// 내용 검색
	private void selectContents() {
		List<Book> list = bDAO.selectBookContent(inputBookContent());
		for (Book book : list) {
			System.out.println(book);
		}

	}

	private String inputBookContent() {
		System.out.println("검색 내용 > ");
		return sc.nextLine();
	}

	// 4. 대여가능
	private void Rental() {

		List<Book> list = bDAO.bookRental();
		for (Book book : list) {
			System.out.println(book);

		}
	}

	// 5.책 대여
	private void bookRental() {
		String bookName = inputBookName();
		bDAO.bookOut(bookName);
	}

	// 6. 책 반납
	private void bookReturn() {
		String bookName = inputBookName();
		bDAO.bookIn(bookName);
	}

	// 7. 책 정보등록
	private void inBook() {
		// 책제목 저자 내용 입력
		Book book = infoBook();
		// 등록되어있는지?
		bDAO.insert(book);

	}

	private Book infoBook() {
		Book book = new Book();

		System.out.println("책 제목 > ");
		book.setBookName(sc.nextLine());
		System.out.println("저자명 > ");
		book.setBookWriter(sc.nextLine());
		System.out.println("내용 > ");
		book.setBookContent(sc.nextLine());
		return book;
	}

}
