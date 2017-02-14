package spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.jdbc.vo.TeamVO;

@Repository
public class TeamDaoImpl implements TeamDao { //id ="teamDAOImpl"
	// Service -> Dao -> Spring JDBC(DB)
	List<TeamVO> list = null; //전체 레코드 반환
	String sql = null; //쿼리문 저장
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//java 코드 : rs 저장 -> while(rs.next()){dto-> list}
	@Override
	public List<TeamVO> getTeamList() { //1. 전체 레코드 검색 - query()
		sql ="select * from team";
		
		//query() -> mapRow() : 
		//2) list
		list = this.jdbcTemplate.query(sql, new RowMapper<TeamVO>(){ //클래스 시작

			@Override
			public TeamVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// rs : 전체레코드 저장, rowNum : 행번호
				TeamVO vo = new TeamVO();
				vo.setTeam_id(rs.getInt("team_id"));
				vo.setTeam_name(rs.getString("team_name"));
			
				return vo;  //1)dto
			}
			
		}); // 클래스 끝
		
		return list;
	}

	//java 코드 : rs저장 -> if(rs.next()){dto}
	//queryForObject(sql, rowMapper, ?)
	@Override
	public TeamVO getTeamSearch(int team_id) { //2. 조건 검색 - queryForObject()
		sql ="select * from team where team_id=?";
		
		
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<TeamVO>(){

			@Override
			public TeamVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				TeamVO vo = new TeamVO();
				vo.setTeam_id(rs.getInt("team_id"));
				vo.setTeam_name(rs.getString("team_name"));
				
				return vo;
			}
			
		},team_id);
		
	}
	
	//update(sql,?)
	@Override
	public int teamInsert(TeamVO vo) {  //3. 레코드 삽입 - update()
		sql = "insert into team values(?,?)";
		return this.jdbcTemplate.update(sql,
							vo.getTeam_id(),
							vo.getTeam_name());
		//return 0;
	}
	
	//update(sql,?) : team_id 조회 -> team_name 수정
	@Override
	public int teamUpdate(TeamVO vo) { //4. 레코드 수정 - update()
		sql ="update team set team_name=? where team_id=?";
		return this.jdbcTemplate.update(sql,
					vo.getTeam_name(),
					vo.getTeam_id());
	}

	//update(sql,?) : team_id 조회 -> 삭제
	@Override
	public int teamDelete(int team_id) { // 5. 레코드 삭제 - update()
		sql ="delete from team where team_id=?";
		return this.jdbcTemplate.update(sql,team_id);

	}

}
