package spring.di.ch03;

public class DaoImpl {  //멤버 :2개 
	//Dao -> DB
	
	public void insert(){
		System.out.println("Dao 계층의 클래스~~");
		System.out.println("두번째 레코드가 삽입되었습니다.");
	}
	public void test(){
		System.out.println("test");
	}
}
