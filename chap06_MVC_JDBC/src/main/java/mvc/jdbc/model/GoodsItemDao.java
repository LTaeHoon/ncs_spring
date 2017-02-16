package mvc.jdbc.model;

import java.util.List;

import mvc.jdbc.vo.GoodsItemVO;

// GoodsItem 테이블에 접근하기 위한 인터페이스
public interface GoodsItemDao {
	
	List<GoodsItemVO> findAll(); // 1차
	GoodsItemVO findItem_id(int item_id); // 2차
	

}
