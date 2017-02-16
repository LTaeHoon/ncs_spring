package mvc.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.jdbc.model.GoodsItemDao;
import mvc.jdbc.vo.GoodsItemVO;

@Service
public class GoodsItemServiceImpl implements GoodsItemService {
	// Service -> Dao
	
	// DB에 접근하기 위해서 ItemDao 객체 주입 설정 메서드
	@Autowired
	private GoodsItemDao itemDao; // DI	 
	
	@Override
	public GoodsItemVO getItem_id(int item_id) {
		// TODO Auto-generated method stub
		
		return this.itemDao.findItem_id(item_id);
		
	}

	@Override
	public List<GoodsItemVO> getItemList() {
		// GoodsItem 테이블의 전체 목록 리턴
		return this.itemDao.findAll();
	}	

}





