package spring.join.dao;

import java.util.List;

import spring.join.vo.MemberVO;

public interface MemberDao {
	List<MemberVO> findAllMember(); //회원 전체 리스트
	MemberVO findMember_id(String id); //특정 회원
	int insertMember(MemberVO vo); //회원 등록
	int updateMember(MemberVO vo); //회원 수정
	int deleteMember(String id);//회원 삭제
}
