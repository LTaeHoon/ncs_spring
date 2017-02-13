package spring.anno.ch06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
	
	//main(vo) -> controller(vo) -> service(vo)
	
	@Autowired
	private MemberService memberService;
	
	public void callService(MemberVo vo){
		System.out.println("MemberController 클래스 수행");
		this.memberService.login(vo); //로그인 메서드 호출
	}
	
	
}
