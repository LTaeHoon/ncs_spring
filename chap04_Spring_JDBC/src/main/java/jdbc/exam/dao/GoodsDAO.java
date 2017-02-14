package jdbc.exam.dao;

import java.util.List;

import jdbc.exam.vo.GoodsVO;

public interface GoodsDAO {
	
	List<GoodsVO> getGoodsList();
	
	GoodsVO getGoodsSearch(String code);
	
	int goodsInsert(GoodsVO vo);
	
	int goodsUpdate(GoodsVO vo);
	
	int goodsDelete(String code);
}
