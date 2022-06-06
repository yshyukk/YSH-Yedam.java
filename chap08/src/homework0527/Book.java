package homework0527;

public class Book {	//VO클래스(DTO) : 정보를 저장하는 용도로 가지는 클래스, 필드와 getter setter만 가짐.
					// VO와 DTO는 다르지만 정보를 저장하는 용도는 같다.
	// 필드
	
	//private static int serialNum = 1000; <== 부여한다 =static
	private int isbn;
	private String name;
	private int price;

	// 생성자
	public Book() {
		this.isbn = (int) (Math.random() * 100000000);
	}

	public Book(String name, int price, int isbn) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
		// 외부에서 들어오는 값은 name과 price이므로 
		//public Book(String name, int price){
		//this. serialNum = serialNum;
		//this. name = name;
		//this. price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void showInfo() {
		System.out.println(" 책이름 : " + name + " 가격 : " + price + " ISBN : " + isbn);
		
		//String info = "ISBN : " + this.isbn +"제목 : " + this.name + "가격 : " + this.price	 
								
						
	
	}

}
