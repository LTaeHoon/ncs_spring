package spring.mvc.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login.do")
public class LoginController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		//view page 포워딩 
		return "exam/login"; //views/exam/login.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginVO vo){
		return "exam/result";
	}
}
