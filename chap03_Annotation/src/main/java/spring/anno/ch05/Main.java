package spring.anno.ch05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	// Main(View) -> Controller 계층 -> Service 계층 -> Dao 계층 -> (DB)
	
	public static void main(String[] args) {
		// 1. 스프링 설정파일로부터 스프링 컨테이너 생성
		AbstractApplicationContext context =
		new ClassPathXmlApplicationContext("applicationContext2.xml");
		// 2. JVM 종료될 때 ApplicationContext를 종료하는 작업
		context.registerShutdownHook();
		// 3. 스프링 컨테이너에서 빈(객체)를 가져온다.
		HomeController home = (HomeController)context.getBean("homeController");
		// 4. 스프링 빈으로 메서드 호출
		home.display();
		ComponentTest comp= (ComponentTest)context.getBean("componentTest");
	    System.out.println(comp);
		// 5. 어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체) 닫기
		context.close();
				
	}

}
