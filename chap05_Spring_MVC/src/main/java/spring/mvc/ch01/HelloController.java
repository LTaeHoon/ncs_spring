package spring.mvc.ch01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	//요청 url =/hello.do, 전송 방식 : GET
	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public ModelAndView hello(){
		/*
		 * ModelAndView
		 *  - Model : DB의 리턴값
		 *  - View : 포워딩할 view page 정보
		 */
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","홍길동"); //Model 값 생성
		mav.setViewName("hello"); //view page 지정 - views/hello.jsp
		
		return mav; //실제 포워딩
	}
}
