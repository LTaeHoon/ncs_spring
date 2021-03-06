package example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class PrintUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource resource = new FileSystemResource("src/config/example.xml");
		
		BeanFactory bean = new XmlBeanFactory(resource);
		
		// (1) getBean()에서 2개 인수 사용 - Casting 생략
		System.out.println("2개의 인수를 사용한 경우");
		Print printer1 = bean.getBean("printer", Print.class); 
		printer1.printer(); //프린터 출력
		
		// (1) getBean()에서 1개 인수 사용 - Casting 필요
		System.out.println("1개의 인수를 사용한 경우");
		Print console = (Print)bean.getBean("console");
		console.printer(); //콘솔 출력
	}

}
