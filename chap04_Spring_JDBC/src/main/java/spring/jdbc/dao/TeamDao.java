package spring.jdbc.dao;

import java.util.List;

import spring.jdbc.vo.TeamVO;


public interface TeamDao {
	//추상메서드 : public
	
	// 1. 전체 레코드 검색 : list<DTO>
	List<TeamVO> getTeamList();
	
	// 2. 레코드 조건 검색 : 1개 레코드 반환
	TeamVO getTeamSearch(int team_id); //id 기준
	
	// 3. 레코드 추가
	int teamInsert(TeamVO vo); // vo(team_id, team_name) 
	
	// 4. 레코드 수정
	int teamUpdate(TeamVO vo);
	
	// 5. 레코드 삭제
	int teamDelete(int team_id); //id 기준

}
