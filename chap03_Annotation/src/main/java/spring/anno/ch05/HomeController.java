package spring.anno.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {//<bean id="homeController" class=""/>
	//Main -> Controller -> Service
	@Autowired
	private ServiceImpl serviceImpl;
	
	public void display(){
		System.out.println("HomeController 클래스 실행");
		this.serviceImpl.display(); //Service 멤버 호출
	}
	
		
}
