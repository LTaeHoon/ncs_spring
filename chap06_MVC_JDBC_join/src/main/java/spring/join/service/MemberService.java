package spring.join.service;

import java.util.List;

import spring.join.vo.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList(); //회원 전체 리스트
	MemberVO getMember_id(String id); //특정 회원
	void regMember(MemberVO vo); //회원 등록
	void modifyMember(MemberVO vo); //회원 수정
	void delMember(String id);//회원 삭제
	
}
