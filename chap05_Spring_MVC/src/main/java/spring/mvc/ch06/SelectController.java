package spring.mvc.ch06;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SelectController {//3번
	
	/*
	 * @ModelAttribute("참조변수")
	 *  - 객체 생성 결과 저장 변수
	 *  - view page 포워딩 시 함께 전달됨
	 */
	@ModelAttribute("searchTypeList") 
	public List<SearchType> search(){
		List<SearchType> list = new ArrayList<SearchType>();
		list.add(new SearchType(1, "아케이드 게임"));
		list.add(new SearchType(2, "온라인 게임"));
		list.add(new SearchType(3, "닌텐도 게임"));
		return list;
	}
	
	@RequestMapping(value="/select/main.do")
	public String main(){
		
		return "select/main"; //views/select/main.jsp
	}
	
	@RequestMapping(value="/select/game.do",method=RequestMethod.POST)
	public String game(@ModelAttribute("search") SearchVO vo){
		
		String name = null;
		System.out.println("name size =" +name.length()); //null 예외발생
		
		/*//산술적 예외
		int result=10/0;*/
		return "select/game"; //game.jsp("search")
	}
	/*
	@ExceptionHandler(NullPointerException.class)
	public String handler(NullPointerException e){
		return "error/null"; //null.jsp
	}
	*/
	
}
