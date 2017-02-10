package spring.di.exam;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ch05.SystemMoniter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("example.xml");
		// 2. JVM 종료될 때 ApplicationContext를 종료하는 작업
		context.registerShutdownHook();
		Message msg= (Message)context.getBean("msg");
		// 4. 스프링 빈으로 메서드 호출
		msg.sayHello();
		// 5. 어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체) 닫기
		context.close();
						
				
	}

}
