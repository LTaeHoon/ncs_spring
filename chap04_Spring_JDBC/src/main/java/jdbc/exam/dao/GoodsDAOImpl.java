package jdbc.exam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jdbc.exam.vo.GoodsVO;


@Repository
public class GoodsDAOImpl implements GoodsDAO {
	

	List<GoodsVO> list = null; //전체 레코드 반환
	String sql =null;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<GoodsVO> getGoodsList() {
		// TODO Auto-generated method stub
		sql = "select * from spring_goods";
		return this.jdbcTemplate.query(sql, new RowMapper<GoodsVO>(){
			@Override
			public GoodsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				
				return vo;
			}
			
		});
		//return null;
	}

	@Override
	public GoodsVO getGoodsSearch(String code) {
		// TODO Auto-generated method stub
		sql ="select * from spring_goods where code=?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<GoodsVO>(){

			@Override
			public GoodsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setMaker(rs.getString("maker"));
				
				return vo;
			}
			
		},code);
		//return null;
	}
	
	@Override
	public int goodsInsert(GoodsVO vo) {
		
		sql ="insert into spring_goods values(?,?,?,?)";
		return this.jdbcTemplate.update(sql,vo.getCode(),vo.getName(),vo.getPrice(),vo.getMaker());
		
	}

	@Override
	public int goodsUpdate(GoodsVO vo) {
		sql ="update spring_goods set name=?,price=?,maker=? where code=?";
		return this.jdbcTemplate.update(sql,vo.getName(),vo.getPrice(),vo.getMaker(),vo.getCode());
		
	}

	@Override
	public int goodsDelete(String code) {
		// TODO Auto-generated method stub
		sql = "delete from spring_goods where code=?";
		return this.jdbcTemplate.update(sql,code);
	}

}
