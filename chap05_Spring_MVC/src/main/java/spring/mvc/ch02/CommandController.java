package spring.mvc.ch02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/command/object.do")
public class CommandController {
	
	/*
	 * @ModelAttribute("참조변수")
	 * 	- 요청 파라미터를 처리하는 애노테이션 
	 * 	- 파라미터와 VO 멤버와 자동 바인딩 되어 객체 생성
	 *  - 이렇게 생성된 객체는 "참조변수"에 저장되어 view page에 포워딩 됨
	 *  - 이렇게 생성된 객체 = Command Object
	 */
	
	// 요청 url ="/command/object.do" 전송방식 : GET
	@RequestMapping(method=RequestMethod.GET)
	public String form(){
		//view page 포워딩 
		return "command/form"; //views/command/form.jsp
	}
	
	// 요청 url ="/command/object.do" 전송방식 : POST
	@RequestMapping(method=RequestMethod.POST)
	//3개 파라미터 넘어옴 (bno,title,content)
	public String submit(@ModelAttribute("vo2") CommandVO vo){
		
		/* * 1. 파라미터 넘어온다.(bno=0,title="제목",content="내용")
		 * 2. CommandVO 타입에 객체 생성(vo) -> 자동바인딩
		 * 	  vo(bno(0),title(제목),content(내용)) 
		 * 3. vo2 참조변수에 저장 -> view page 포워딩*/
		 
		return "command/result"; //views/command/result.jsp
	}
	
	
	/*jsp방식*/
/*	public String submit(HttpServletRequest request,
			HttpServletRequest response){
		//1. 파라미터 받기
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//2. vo 객체 바인딩
		CommandVO vo = new CommandVO();
		vo.setBno(bno);
		vo.setTitle(title);
		vo.setContent(content);
		
		//3. key 생성 & 포워딩
		request.setAttribute("vo2", vo);
		
		return "command/result"; 
	}*/
	
}
