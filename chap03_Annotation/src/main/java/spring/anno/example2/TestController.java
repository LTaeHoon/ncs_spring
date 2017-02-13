package spring.anno.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	public void display(){
		System.out.println("TestController 클래스 호출");
		this.testService.display();
	}
}
