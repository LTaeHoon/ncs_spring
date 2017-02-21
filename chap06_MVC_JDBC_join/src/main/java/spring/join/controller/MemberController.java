package spring.join.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import spring.join.service.MemberService;
import spring.join.vo.MemberVO;

@Controller
public class MemberController {
	// view -> Controller -> service
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/main.do")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		List<MemberVO> list = this.memberService.getMemberList(); //전체 회원 리스트
		mav.addObject("memberList", list);
		mav.setViewName("/selectList"); //views/jsp/main.jsp
		
		return mav;
	}
	
	@RequestMapping("/reg.do")
	public String reg_form(){
		return "/insertForm";
	}
	
	@RequestMapping(value="/reg.do",method=RequestMethod.POST)
	public ModelAndView insert(@RequestParam("id") String id,
					@RequestParam("passwd") String passwd,
					@RequestParam("name") String name){
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		
		/*long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String str = dayTime.format(new Date(time));
		vo.setReg_date(str.substring(0,9));
		*/
		this.memberService.regMember(vo);

		ModelAndView mav = new ModelAndView();
		List<MemberVO> list = this.memberService.getMemberList(); //전체 회원 리스트
		mav.addObject("memberList", list);
		mav.setViewName("/selectList"); //views/jsp/main.jsp
		
		return mav;
		
	}
	
	@RequestMapping("/seldetail.do")
	public ModelAndView sel_detail(@RequestParam("id") String id){
		ModelAndView mav = new ModelAndView();
		MemberVO vo=this.memberService.getMember_id(id);
		mav.addObject("member",vo);
		mav.setViewName("/selectDetail");
		
		return mav;
	}
	
	@RequestMapping("/up.do")
	public ModelAndView up(@RequestParam("id") String id){
		
		ModelAndView mav = new ModelAndView();
		MemberVO vo=this.memberService.getMember_id(id);
		mav.addObject("member",vo);
		mav.setViewName("/updateForm");
		
		return mav;
	}
	@RequestMapping("/update.do")
	public String update(@RequestParam("id") String id,
			@RequestParam("passwd") String passwd,
			@RequestParam("name") String name){
		System.err.println("이쪽으로 오냐");
		MemberVO vo = new MemberVO();
		vo.setId(id);vo.setName(name);vo.setPasswd(passwd);
		this.memberService.modifyMember(vo);
		/*int sum= 10/0;*/
		return "redirect:main.do"; //view page
		}
	
	@RequestMapping("/del.do")
	public String del(@RequestParam("id") String id, Model model){
		model.addAttribute("id",id);
		return "/deleteForm";
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(@RequestParam("id") String id){
		this.memberService.delMember(id);
		ModelAndView mav = new ModelAndView();
		List<MemberVO> list = this.memberService.getMemberList(); //전체 회원 리스트
		mav.addObject("memberList", list);
		mav.setViewName("/selectList"); //views/jsp/main.jsp
		return mav;
	}
	

}
