package mvc.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc.jdbc.service.GoodsItemService;
import mvc.jdbc.vo.GoodsItemVO;

@Controller
public class GoodsItemController {
	// view page(*.do) -> Controller -> Service -> Dao(JDBC)
	
	@Autowired
	private GoodsItemService goodsItemService;
	
	@RequestMapping(value="/main.do")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		List<GoodsItemVO> list = this.goodsItemService.getItemList(); //전체 상품 리스트
		mav.addObject("itemList", list);
		mav.setViewName("jsp/main"); //views/jsp/main.jsp
		
		return mav;
	}
	@RequestMapping(value="content.do")
	public ModelAndView content(@RequestParam("item_id") int item_id){
		ModelAndView mav = new ModelAndView();
		
		//조건검색 메서드 호출 -> 해당 레코드 리턴
		GoodsItemVO vo = this.goodsItemService.getItem_id(item_id);
		mav.addObject("item", vo);
		mav.setViewName("jsp/content"); //jsp/content.jsp
		
		return mav;
	}
}
