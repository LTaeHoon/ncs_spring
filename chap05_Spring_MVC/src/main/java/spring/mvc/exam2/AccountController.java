package spring.mvc.exam2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/account/create.do")
public class AccountController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String account(){
		return "/account/Form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@ModelAttribute("account") AccountVO vo){
		return "/account/create";
	}
}
