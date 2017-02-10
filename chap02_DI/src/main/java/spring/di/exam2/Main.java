package spring.di.exam2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.exam.Message;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("example.xml");
		// 2. JVM 종료될 때 ApplicationContext를 종료하는 작업
		context.registerShutdownHook();
		
		Call call = (Call)context.getBean("call");
		call.calc.sum();
		call.calc.display();
			
	}

}
