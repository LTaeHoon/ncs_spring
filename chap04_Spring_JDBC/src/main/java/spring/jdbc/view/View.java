package spring.jdbc.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import spring.jdbc.service.TeamService;

@Component
public class View { // id ="view"
	// View -> Service -> Dao -> Spring JDBC(DTO)
	private int number;
	
	@Autowired
	TeamService teamService;  //외부 클래스 포함관계
	
	// 메뉴를 보여주는 메소드
	public void showMenu() throws Exception{
		while(true){
			System.out.println("===============");			
			System.out.println("1. KBO 구단보기"); 
			System.out.println("2. KBO 구단추가"); 
			System.out.println("3. KBO 구단검색"); 
			System.out.println("4. KBO 구단수정"); 
			System.out.println("5. KBO 구단삭제"); 
			System.out.println("6. 프로그램 종료");
			System.out.println("===============");
			System.out.print("번호 입력 후 Enter : ");
			
			// 키보드로 번호 입력받기
			BufferedReader input =new BufferedReader(
					new InputStreamReader(System.in));
			
			// 키보드로 입력받은 값을 정수형으로 형변환
			number = Integer.parseInt(input.readLine());
			execute(number); // execute()메소드 호출		
		}
	}
	// 메뉴 선택 처리하기
	void execute(int number){
	 
		switch(number){		
		// 1. KBO 구단 보기 
		case 1:			
			teamService.teamList();
			break;
		// 2. KBO 구단 추가 	
		case 2:			
			teamService.teamInsert();
			break;
		// 3. KBO 구단 검색 	
		case 3:			
			teamService.teamSearch();
			break;	
		// 4. KBO 구단 수정 	
		case 4:			
			teamService.teamUpdate();
		   break;		
		// 5. KBO 구단 수정 
		case 5:			
			teamService.teamDelete();
		   break;
		// 6. 프로그램 종료
		case 6:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0); // 종료됨
		}	
		
	}
	public static void main(String[] args) throws Exception {
		
		//xml 파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
		//JVM 종료될 때 ApplicationCOntext를 종료하는 작업
		context.registerShutdownHook();

		View view = (View)context.getBean("view");
		view.showMenu();  // 메뉴를 보여주는 메소드 호출	

		//어플리케리션 종료시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
		
	}

}

