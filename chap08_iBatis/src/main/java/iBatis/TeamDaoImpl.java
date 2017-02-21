package iBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.Team;

public class TeamDaoImpl {
	
	private static SqlMapClient sqlMapper;	
	private Team team=null;
	private int id;
	static{// static 초기화 블럭 - static 멤버변수를 초기화하는 역할		
		try {
			// 1. SqlMapConfig.xml 파일의 설정내용을 가져온다.
			Reader reader = Resources.getResourceAsReader("dbInfo/SqlMapConfig.xml");
			// 2. Mapper 객체 생성하기
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamDaoImpl m = new TeamDaoImpl();
		m.start();
	}		
	public void start(){
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("===============");			
			System.out.println("1. KBO 구단보기"); 
			System.out.println("2. KBO 구단추가"); 
			System.out.println("3. KBO 구단검색"); 
			System.out.println("4. KBO 구단수정"); 
			System.out.println("5. KBO 구단삭제"); 
			System.out.println("6. 프로그램 종료");
			System.out.println("===============");
			System.out.print("번호 입력 후 Enter : ");

			int num = Integer.parseInt(sc.nextLine());
			switch(num){
			case 1 :
				try{
					List<Team> list;
					list = sqlMapper.queryForList("selectTeamAll");
					for(Team team : list){
						System.out.println(" 팀 ID : "
					     + team.getTeam_id()+ "  "					     
					     + "팀 이름 : " 
					     + team.getTeam_name());
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
				
			case 2 :
				System.out.println("KBO 구단추가");
				try{
					team = new Team();
					System.out.print("팀 아이디 입력 : ");					
					team.setTeam_id(Integer.parseInt(sc.nextLine()));
					System.out.print("팀 이름 입력 : ");
					team.setTeam_name(sc.nextLine());
					sqlMapper.insert("insertTeam", team);
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
				
			case 3 :
				System.out.print("검색할 구단 아이디를 입력하시오 : ");
				id =Integer.parseInt(sc.nextLine()); // 키보드로 아이디 입력
				
				try{
					team = (Team)sqlMapper.queryForObject("selectTeam",id);
					if(team==null){
						System.out.println("검색된 레코드가 없습니다.");
					}else{
						System.out.println("팀 id : " + team.getTeam_id());
						System.out.println("팀 이름 : " + team.getTeam_name());
					}
				}catch(Exception e){
					e.printStackTrace();
				}				
				break;

			case 4 :
				System.out.print("변경할 구단 아이디를 입력하시오 : ");
				id = Integer.parseInt(sc.nextLine());
				try{
					// 사용자가 입력한 id 조회
					team = 
					(Team)sqlMapper.queryForObject("selectTeam", id);
					if(team != null){
						System.out.print("이름 입력 : ");
						team.setTeam_name(sc.nextLine()); //이름입력	
						team.setTeam_id(id);
						// 해당하는 id가 있는 경우 레코드 수정
						sqlMapper.update("updateTeam",team);
					}else{
						System.out.println("해당하는 id가 없습니다.");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
				
			case 5 :
				System.out.print("삭제할 구단 아이디를 입력하시오 : ");
				id = Integer.parseInt(sc.nextLine()); // 키보드로 id 입력받음
				try{
					// 사용자가 입력한 id 조회
					team = 
					(Team)sqlMapper.queryForObject("selectTeam", id);
					if(team != null){
						// 해당하는 id가 있는 경우 레코드 삭제
						sqlMapper.delete("deleteTeam",id);//레코드 삭제						
					}else{
						System.out.println("해당하는 id가 없습니다.");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;

			case 6 :
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);				
				break;
			default:
				System.out.println("1-6사이의 숫자를 입력해 주세요.");
			}
		}
	}	

}





