package myBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Account;

public class AccountDaoImpl{
	static SqlSession session = null;
	Scanner sc=null;
	Account account=null;
	
	public static void main(String[] args) throws IOException {
		// myBatis 설정 파일 지정
		String resource = "dbInfo/SqlMapConfig.xml";
		// 1. myBatis 설정 파일 읽기
		Reader reader = Resources.getResourceAsReader(resource);
		// 2. SqlSessionFactory 객체 생성
		SqlSessionFactory factory = new
			 SqlSessionFactoryBuilder().build(reader);
		// 3. Session 객체 열기
		session = factory.openSession();
		
		// start() 메서드 호출
		AccountDaoImpl acc = new AccountDaoImpl();
		acc.start();
	}		
	public void start(){
		sc = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.println("1. 전체 계정");
			System.out.println("2. 계정 검색");
			System.out.println("3. 계정 추가");
			System.out.println("4. 계정 삭제");
			System.out.println("5. 계정 변경");
			System.out.println("6. 종료");
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.print("숫자 입력후 Enter.. : ");
			int num = Integer.parseInt(sc.nextLine());;
			switch(num){
			case 1 :
				// 1) selectList() 메소드 - 2개 이상의 레코드 검색 -> List				
				List<Account> list;
				// queryForList() -> selectList()
				try{
				  list=session.selectList("selectAllAcc");
					for(Account ac : list)
						System.out.printf("id : %6s, pwd : %4s, name : %s\n",
						ac.getId(), ac.getPwd(), ac.getName());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2 :
				// 2) selectOne() 메서드 : 검색결과가 1개인 경우
				// queryForObject 대신 사용되는 메서드
				System.out.print("검색할 id를 입력하세요 : ");
				sc = new Scanner(System.in);
				String id = sc.nextLine();
				try{
				  account = 
				    (Account)session.selectOne("selectAcc",id);
				  if(account != null){
				     System.out.printf
					  ("검색 결과 : 비번 : %s, 이름 : %s\n",
						account.getPwd(),account.getName());
				  }else{
					System.out.println("해당하는 id가 없음");
				  }				
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 3 :
				System.out.println("신규 개정 추가");
				account = new Account();
				System.out.print("ID 입력 : ");
				account.setId(sc.nextLine());
				System.out.print("비번 입력 : ");
				account.setPwd(sc.nextLine());
				System.out.print("이름 입력 : ");
				account.setName(sc.nextLine());
				try{
					session.insert("insertAcc",account);
					session.commit();  // db 테이블 갱신
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 4 :
				System.out.print("삭제할 계정의 아이디를 입력하시오 : ");
				id = sc.nextLine();
				try{
					// 사용자가 입력한 id 조회
					account = 
							(Account)session.selectOne("selectAcc",id);
					if(account != null){
						session.delete("deleteAcc",id);
						session.commit();  // db 테이블 갱신
					}else{
						System.out.println("해당하는 id가 없음");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 5 :
				System.out.print("변경할 계정의 아이디를 입력하시오 : ");
				id = sc.nextLine();				
				try{
					// 사용자가 입력한 id 조회
					account = 
					  (Account)session.selectOne("selectAcc",id);
					if(account != null){
						System.out.print("비번 입력 : ");
						account.setPwd(sc.nextLine());
						System.out.print("이름 입력 : ");
						account.setName(sc.nextLine());
						session.update("updateAcc",account);
						session.commit(); // db 테이블 갱신
					}else{
						System.out.println("해당하는 id가 없음");
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
