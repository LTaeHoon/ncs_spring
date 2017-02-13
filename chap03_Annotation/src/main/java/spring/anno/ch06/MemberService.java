package spring.anno.ch06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	//Controller(vo) -> Service(vo) -> Dao
	
	@Autowired
	private MemberDao memberDao;
	
	public void login(MemberVo vo){
		System.out.println("MemberService 클래스 수행");
		this.memberDao.login(vo);
	}
}
