package mvc.jdbc.service;

import java.util.List;

import mvc.jdbc.vo.GoodsItemVO;

/*
 * 상품 목록 인터페이스
 *  - 상점(shop)에서 취급하는 모든 상품을  참조할 수 있는 인터페이스
 */
public interface GoodsItemService {
	
	List<GoodsItemVO> getItemList(); // 1차(전체 검색
	GoodsItemVO getItem_id(int item_id); // 2차(조건 검색)
	

}







