package spring.mvc.ch05;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CookieController {

	@RequestMapping(value="/cookie/make.do")
	public String make(HttpServletResponse response){
		// 쿠키 생성
		response.addCookie(new Cookie("userId","HONGKILDONG"));
		
		return "cookie/make"; //views/cookie/make.jsp
	}
	
	@RequestMapping(value="/cookie/view.do")
	public ModelAndView view(@CookieValue(value="userId",defaultValue="0")String userId){
		ModelAndView model = new ModelAndView("cookie/view"); //jsp페이지
		model.addObject("userId", userId); //view page에 쿠키 넘김
		return model;
	}

}
