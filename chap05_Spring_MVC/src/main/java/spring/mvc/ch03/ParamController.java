package spring.mvc.ch03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
	
	@RequestMapping("/param/userInfo.do")
	public ModelAndView param(@RequestParam("name") String name,
			@RequestParam(value="age",required=false, defaultValue="25") int age){ //name, age
			//name 필수사항, age없는 경우 예외 처리
		ModelAndView mav = new ModelAndView("param/result");
		mav.addObject("name",name);
		mav.addObject("age",age);
		//mav.setViewName("param/result");
		
		return mav; // views/param/result.jsp
	}

}
