package spring.anno.ch06;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	//Service(vo) -> Dao(vo) -> 로그인 인증(DB)
	
	public void login(MemberVo vo){
		System.out.println("MemberDao 클래스 수행");
		if(vo.getId().equals("hong")&vo.getPwd().equals("1234")){
			System.out.println("로그인 성공");
		}else{
			System.out.println("로그인 실패");
		}
	}
}
