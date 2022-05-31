package homework0527;

public interface BookProgram {
	// 메뉴출력
	public void menuPrint();

	// 정보입력
	public void inputInfo(BookAccess access);

	// 전체정보 출력
	public void printAllInfo(BookAccess access);

	// 특정 조건정보 출력
	public void printInfo(BookAccess access);

	// 분석
	public void printRepo(BookAccess access);

}
