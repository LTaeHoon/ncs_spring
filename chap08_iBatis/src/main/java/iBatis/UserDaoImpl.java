package iBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import vo.User;

public class UserDaoImpl{
	
	//SqlMapClient 클래스는 Mapper를 생성하는 클래스이다.
	//static 멤버로 선언 - (메모리 로딩시 메모리 할당)
	private static SqlMapClient sqlMapper;	
	private User user=null;
	private String id=null;
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
		UserDaoImpl m = new UserDaoImpl();
		m.start();
	}		
	public void start(){
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.println("1. 모든 유저 출력");
			System.out.println("2. 하나의 유저 출력");
			System.out.println("3. 유저 추가");
			System.out.println("4. 유저정보 삭제");
			System.out.println("5. 유저정보 변경");
			System.out.println("6. 종료");
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.print("숫자 입력후 Enter.. : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num){
			case 1 :
				try{
					List<User> list;
					list = sqlMapper.queryForList("selectAll");
					for(User user : list){
						System.out.println(" 사용자 ID : "
					     +user.getUser_id()+ "  "
					     + "사용자 비번 : " + "  "
					     + user.getUser_pwd() + "  " 
					     + "사용자 이름 : " 
					     + user.getUser_name());
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2 :
				System.out.print("검색할 아이디를 입력하시오 : ");
				id = sc.nextLine(); // 키보드로 아이디 입력
				try{
					user = (User)sqlMapper.queryForObject("selectUser",id);
					if(user==null){
						System.out.println("검색된 레코드가 없습니다.");
					}else{
						System.out.println("사용자 id : " + user.getUser_id());
						System.out.println("사용자 비번 : " + user.getUser_pwd());
						System.out.println("사용자 이름 : " + user.getUser_name());
					}
				}catch(Exception e){
					e.printStackTrace();
				}				
				break;
			case 3 :
				System.out.println("신규 유저 추가");
				try{
					user = new User();
					System.out.print("아이디 입력 : ");
					user.setUser_id(sc.nextLine());
					System.out.print("비밀번호 입력 : ");
					user.setUser_pwd(sc.nextLine());
					System.out.print("이름 입력 : ");
					user.setUser_name(sc.nextLine());
					sqlMapper.insert("insertUser", user);
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 4 :
				System.out.print("삭제할 유저 아이디를 입력하시오 : ");
				id = sc.nextLine(); // 키보드로 id 입력받음
				try{
					// 사용자가 입력한 id 조회
					user = 
					(User)sqlMapper.queryForObject("selectUser", id);
					if(user != null){
						// 해당하는 id가 있는 경우 레코드 삭제
						sqlMapper.delete("deleteUser",id);//레코드 삭제						
					}else{
						System.out.println("해당하는 id가 없습니다.");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 5 :
				System.out.print("변경할 유저 아이디를 입력하시오 : ");
				id = sc.nextLine(); // id 입력받음
				try{
					// 사용자가 입력한 id 조회
					user = 
					(User)sqlMapper.queryForObject("selectUser", id);
					if(user != null){
						System.out.print("이름 입력 : ");
						user.setUser_name(sc.nextLine()); //이름입력
						System.out.print("비번 입력 : ");
						user.setUser_pwd(sc.nextLine()); // 비번입력						
						// 해당하는 id가 있는 경우 레코드 수정
						sqlMapper.update("updateUser",user);
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
	
} // class end