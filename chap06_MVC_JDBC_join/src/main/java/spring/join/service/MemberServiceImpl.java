package spring.join.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import spring.join.dao.MemberDao;
import spring.join.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	//service -> dao
	private MemberVO member=null;
	private boolean check = false;
	private int re=0;
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return this.memberDao.findAllMember();			
	}

	@Override
	public MemberVO getMember_id(String id) {
		// TODO Auto-generated method stub
		return this.memberDao.findMember_id(id);
		
	}

	@Override
	public void regMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
		/* id 또는 name 중복 체크 */
		List<MemberVO> list = this.memberDao.findAllMember();
		member = new MemberVO();		
		for(int i=0; i<list.size(); i++){			
			member = list.get(i);
			if(member.getId().equals(vo.getId())&&member.getPasswd().equals(vo.getPasswd()))
				check=true;		   	
		}
		if(check==true){
			System.out.println("member의 id 또는passwd가 중복됩니다.");
			return;		
		}
		/* 레코드 저장*/
				
		try {
			re =this.memberDao.insertMember(vo);
			if(re==1){
				System.out.println("레코드 입력 성공");	// 팀 목록보기 메서드 호출
			}else{
				System.out.println("레코드 추가에 실패하였습니다.");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

	@Override
	public void modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		re=this.memberDao.updateMember(vo);
		if(re==1){
			System.out.println("레코드 수정 성공");	// 팀 목록보기 메서드 호출
		}else{
			System.out.println("레코드 수정 실패하였습니다.");
		}	
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		re=this.memberDao.deleteMember(id);
		if(re==1){
			System.out.println("레코드 삭제 성공");	// 팀 목록보기 메서드 호출
		}else{
			System.out.println("레코드 삭제 실패하였습니다.");
		}	
	}

}
