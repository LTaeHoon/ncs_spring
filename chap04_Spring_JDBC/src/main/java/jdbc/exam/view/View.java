package jdbc.exam.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import jdbc.exam.service.GoodsService;
import jdbc.exam.view.View;

@Component
public class View {
	// 메뉴를 보여주는 메소드
	
	private int number;
	
	@Autowired
	GoodsService goodsService;
	
		public void showMenu() throws Exception{
			while(true){
				System.out.println("===============");			
				System.out.println("1. 전체 상품목록 보기"); 
				System.out.println("2. 등록 상품 검색"); 
				System.out.println("3. 쇼핑몰 상품 추가"); 
				System.out.println("4. 쇼핑몰 상품 수정"); 
				System.out.println("5. 쇼핑몰 상품 삭제"); 
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
			// 1. 상품 보기 
			case 1:			
				goodsService.goodsList();
				break;
			// 2. 상품 추가 	
			case 2:			
				goodsService.goodsSearch();
				break;
			// 3. 상품 검색 	
			case 3:			
				goodsService.goodsInsert();
				break;	
			// 4. 상품 수정 	
			case 4:			
				goodsService.goodsUpdate();
			   break;		
			// 5. 상품 삭제 
			case 5:			
				goodsService.goodsDelete();
			   break;
			// 6. 프로그램 종료
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); // 종료됨
			}	
			
		}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//xml 파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext2.xml");
	
		//JVM 종료될 때 ApplicationCOntext를 종료하는 작업
		context.registerShutdownHook();

		View view = (View)context.getBean("view");
		view.showMenu();  // 메뉴를 보여주는 메소드 호출	

		//어플리케리션 종료시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
	}

}
