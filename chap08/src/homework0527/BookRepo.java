package homework0527;
/*
 * BookRepo = DAO클래스 ; DB에 대응하는 클래스, 주로 싱글톤으로 작성
 */
public class BookRepo implements BookAccess {

	private static BookRepo instance = new BookRepo();

	private BookRepo() {
		init();	//생성자에서도 init을 호출해서 사용하도록.
	}

	public static BookRepo getInstance() {
		return instance;	//<--- 외부에서 호출할때는 instanace를 반환하는 용도로만 사용하도록.
	}

	// 실제사용 필드 및 메서드
	private Book[] dataList; //<= 저장할 공간
	private int listIndex;	

	// 초기화
	private void init() { // <=== 반복적으로 사용할 수 있도록 init
		dataList = new Book[100000000];
		listIndex = -1;
	}

	@Override
	public void insert(Book book) {
		dataList[++listIndex] = book;

	}

	@Override
	public void update(Book book) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getName() == book.getName()) {
				dataList[i] = book;
				/*교수님 if문
				if(dataList[i].getIsbn == book.getIsbn()
				*/
			}
		}

	}

	@Override
	public void delete(int isbn) {
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getIsbn() == isbn) {
				dataList[i] = null;	
				/* 배열안에는 데이터값이 듬성듬성 비어있기때문에 이것을 제거하기 위해서
				 * 데이터를 삭제하고 빈 공간을 찾아내서 밀어버려서 인덱스를 다 채우기 위함.
				 */
			}
		}
		cleanDataList();
	}

	private void cleanDataList() {
		/* 배열안에는 데이터값이 듬성듬성 비어있기때문에 이것을 제거하기 위해서
	 	* 데이터를 삭제하고 빈 공간을 찾아내서 밀어버려서 인덱스를 다 채우기 위함.
	    */
		
		//기존 필드 -> 임시변수로 값 복사
		Book[] tempList = dataList;
		int tempIndex = listIndex;
		
		//기존필드 초기화
		init();
		
		//임시변수 -> 기존필드로 값을 옮김
		for (int i = 0; i <= tempIndex; i++) {
			if(tempList[i] != null) { 	// null이 아닐떄 dataList의 index에 값 저장.
			dataList[++listIndex] = tempList[i];	//tempList와 dataList는 다름. tempList의 index는 null값까지 포함.
			}
		}
	}

	@Override
	public Book[] selectAll() {
		Book[] list = new Book[listIndex + 1];	//인덱스는 0부터 시작하지만 갯수는 1부터 시작하므로 
		
		for (int i = 0; i < list.length; i++) {
			list[i] = dataList[i];
		}
		return list;
		
	}


	@Override
	public Book selectOne(String bookName, int price) {
		Book selected = null;
		for (int i = 0; i <= listIndex; i++) {
			if (dataList[i].getName().equals(bookName) && dataList[i].getPrice() == price) {
				selected = dataList[i];
			}
		}
		return selected;
		
		/*public Book selectOne(int isbn){
		 * Book book = null;
		 * 
		 * for(int i=0; i<=listIndex; i++){
		 * 		if(dataList[i].getIsbn() == isbn){
		 * 			book = dataList[i];
		 *			 break;
		 * }
		 * }
		 * return book;
		*/
	}

}
