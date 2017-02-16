package spring.mvc.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelController {
	
	@RequestMapping("/model.do")
	public String divide(@RequestParam("op1") int op1,
			@RequestParam("op2") int op2,
			Model model){
		
		model.addAttribute("result",op2/op1);
		
		return "match/result";
	}
}
