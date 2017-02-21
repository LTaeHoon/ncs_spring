package spring.join.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.join.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	//dao -> db
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 전체 회원 목록 가져오기
	@Override
	public List<MemberVO> findAllMember() {
		// TODO Auto-generated method stub
		String sql ="select * from spring_member";
		return jdbcTemplate.query(sql, new RowMapper<MemberVO>(){

			@Override
			public MemberVO mapRow(ResultSet rs, int rownum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
						
				return member;
			}
			
		});
		
	}

	@Override
	public MemberVO findMember_id(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from spring_member where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<MemberVO>(){

			@Override
			public MemberVO mapRow(ResultSet rs, int rownum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getString("reg_date"));
				
				return member;
			}
			
		}, id);
		
	}

	@Override
	public int insertMember(MemberVO vo) {
		
		String sql = "insert into spring_member values(?,?,?,sysdate)";
		return this.jdbcTemplate.update(sql,
				vo.getId(),
				vo.getPasswd(),
				vo.getName());
	}

	@Override
	public int updateMember(MemberVO vo) {
		String sql = "update spring_member set passwd=?,name=? where id=?";
		return this.jdbcTemplate.update(sql,
				vo.getPasswd(),
				vo.getName(),
				vo.getId());
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from spring_member where id=?";
		return this.jdbcTemplate.update(sql,
				id);
	}

}
