package spring.anno.example2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	// Main(View) -> Controller 계층 -> Service 계층 -> Dao 계층 -> (DB)
	
	public static void main(String[] args) {
		// 1. 스프링 설정파일로부터 스프링 컨테이너 생성
		AbstractApplicationContext context =
		new ClassPathXmlApplicationContext("example2.xml");
		// 2. JVM 종료될 때 ApplicationContext를 종료하는 작업
		context.registerShutdownHook();
		// 3. 스프링 컨테이너에서 빈(객체)를 가져온다.
		TestController controller = (TestController)context.getBean("testController");
		// 4. 스프링 빈으로 메서드 호출
		controller.display();
		
	    // 5. 어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체) 닫기
		context.close();
				
	}

}
