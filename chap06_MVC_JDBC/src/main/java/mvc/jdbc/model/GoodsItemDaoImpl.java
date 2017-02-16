package mvc.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mvc.jdbc.vo.GoodsItemVO;

/*
 * ItemDaoImpl 클래스
 *  - Spring JDBC를 사용해서 DB에 접근하는 클래스
 */

@Repository
public class GoodsItemDaoImpl implements GoodsItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate; // DI
		
	/* 해당 상품 id 레코드만 조회하는 메서드 */
	@Override
	public GoodsItemVO findItem_id(int item_id) {
		String 
		   sql="select * from goodsItem where item_id=?";
		return jdbcTemplate.queryForObject(sql,
				new RowMapper<GoodsItemVO>(){

					@Override
					public GoodsItemVO mapRow(ResultSet rs, int rownum)
							throws SQLException {
						GoodsItemVO item = new GoodsItemVO(); // dto
						item.setItem_id(rs.getInt("item_id"));
						item.setItem_name(rs.getString("item_name"));
						item.setItem_price(rs.getInt("item_price"));
						item.setItem_des(rs.getString("item_des"));
						item.setItem_pic(rs.getString("item_pic"));
						return item; // DTO 객체 리턴
					}			
		}, item_id);
	}

	/* 상품 전체를 조회하는 메서드 재정의 */
	@Override
	public List<GoodsItemVO> findAll() {
		String 
		sql="select * from GoodsItem order by item_id asc";
		return jdbcTemplate.query(sql,
				new RowMapper<GoodsItemVO>(){

					@Override
					public GoodsItemVO mapRow(ResultSet rs, int rownum)
							throws SQLException {
						GoodsItemVO item = new GoodsItemVO(); // dto
						item.setItem_id(rs.getInt("item_id"));
						item.setItem_name(rs.getString("item_name"));
						item.setItem_price(rs.getInt("item_price"));
						item.setItem_des(rs.getString("item_des"));
						item.setItem_pic(rs.getString("item_pic"));
						return item; // DTO 객체 리턴
					}
			
		});
	}
	

}
