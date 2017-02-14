package spring.jdbc.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.jdbc.dao.TeamDao;
import spring.jdbc.vo.TeamVO;

@Service
public class TeamService {	//KOB 구단을 보여주는 클래스
	// View -> Service -> Dao
	
	private int id=0; 
	private String name=null; 
	private int re=0; 
	private boolean check=false; 
	private TeamVO team=null; 
	
	@Autowired
	private TeamDao teamDao; // teamDAO 주입
	private BufferedReader input; 
	
	public TeamService(){ // 생성자:키보드 입력 객체 생성 
		input = new BufferedReader(
				new InputStreamReader(System.in));
	}
	/* id 유무 체크 검사(별도 메서드 작성) */
	public boolean idCheck(){
		List<TeamVO> list = this.teamDao.getTeamList();		
		TeamVO team = new TeamVO();		
		for(int i=0; i<list.size(); i++){			
			team = list.get(i);
			if(team.getTeam_id()==id)
				check=true;		   	
		}
		return check;
	}
	/* 1. 구단 보기 */
	public void teamList(){  
		/* 전체 레코드 목록 보기*/
		List<TeamVO> list = this.teamDao.getTeamList();		
		System.out.println("************");
		System.out.println("ID    구단명");		
		for(TeamVO team : list){
			// 팀 id와 name 출력
			System.out.printf("%d    %s\n",team.getTeam_id(),
					        team.getTeam_name());
		}
		System.out.println("************");
	}
	/* 2. 구단 추가 */
	public void teamInsert(){ 		
		try {
			System.out.print("추가할 팀 id 입력 : ");
			id=Integer.parseInt(input.readLine());
			System.out.print("추가할 팀 name 입력 : ");
			name=input.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		/* id 또는 name 중복 체크 */
		List<TeamVO> list = this.teamDao.getTeamList();
		team = new TeamVO();		
		for(int i=0; i<list.size(); i++){			
			team = list.get(i);
			if(team.getTeam_id()==id || team.getTeam_name().equals(name))
				check=true;		   	
		}
		if(check==true){
			System.out.println("Team의 id 또는 name이 중복됩니다.");
			return;		
		}
		/* 레코드 저장*/
		team.setTeam_id(id); team.setTeam_name(name);		
		try {
			re = this.teamDao.teamInsert(team);
			if(re==1){
				teamList();	// 팀 목록보기 메서드 호출
			}else{
				System.out.println("레코드 추가에 실패하였습니다.");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	/* 3. 구단 검색 */
	public void teamSearch(){ 				
		try {
			System.out.print("검색할 팀 id 입력 : ");
			id=Integer.parseInt(input.readLine());			
		} catch (NumberFormatException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		/* 레코드 검색*/
		try {
			team = this.teamDao.getTeamSearch(id); 
			System.out.println("************");
			System.out.println("ID    구단명");		
			System.out.printf("%d    %s\n",team.getTeam_id(),
						        team.getTeam_name());
			System.out.println("************");
		} catch (Exception e) {
			System.out.println("***********************");
			System.out.println("해당 ID가 존재하지 않습니다.");
			System.out.println("***********************");
		}
		
	}
	/* 4. 구단 수정 */
	public void teamUpdate(){ 
		try {
			System.out.print("수정할 팀 id 입력 : ");
			id=Integer.parseInt(input.readLine());
			System.out.print("수정할 팀 name 입력 : ");
			name=input.readLine();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* id 유무 체크 검사*/
		List<TeamVO> list = this.teamDao.getTeamList();		
		TeamVO team = new TeamVO();		
		for(int i=0; i<list.size(); i++){			
			team = list.get(i);
			if(team.getTeam_id()==id)
				check=true;		   	
		}
		if(check==false){
			System.out.println("해당하는 Team의 id가 없습니다.");
			return;			
		}
		/* 레코드 수정*/
		team.setTeam_id(id); team.setTeam_name(name);		
		try {
			re = this.teamDao.teamUpdate(team);
			if(re==1){
				teamList();	
			}else{
				System.out.println("레코드 수정에 실패하였습니다.");
			}	
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
	}
	/* 5. 구단 삭제 */
	public void teamDelete(){
		try {
			System.out.print("삭제할 팀 id 입력 : ");
			id=Integer.parseInt(input.readLine());
		} catch (NumberFormatException e) {	
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		/* id 유무 체크 검사 메서드 호출*/
		check=idCheck();
		
		if(check==false){
			System.out.println("해당하는 Team의 id가 없습니다.");
			return;			
		}
		
		/* 레코드 삭제*/
		try {
			re = this.teamDao.teamDelete(id);
			if(re==1){
				teamList();	
			}else{
				System.out.println("레코드 삭제에 실패하였습니다.");
			}	
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		
	}
	
}