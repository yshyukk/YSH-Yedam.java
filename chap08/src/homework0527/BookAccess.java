package homework0527;

public interface BookAccess { 
	// 저장소 기능 : 등록 , 수정, 조회, 삭제

	// 등록
	public void insert(Book book);

	// 수정
	public void update(Book book);

	// 삭제
	public void delete(int ISBN);

	// 전체조회
	public Book[] selectAll(); //void X = void로하면 단순히 출력밖에 못함. 전체조회는 배열 내 정보를 돌려받아야 되기 때문에.

	// 단건조회 
	public Book selectOne(String bookName, int price); //void X = void로하면 단순히 출력밖에 못함. 전체조회는 배열 내 정보를 돌려받아야 되기 때문에.
	//int selectOne(int isbn);
}
