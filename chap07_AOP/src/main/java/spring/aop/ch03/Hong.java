package spring.aop.ch03;

import org.springframework.stereotype.Service;

// 핵심모듈 클래스
@Service
public class Hong implements Human {

	@Override
	public void sayName() { //포인트 컷 메서드
		// TODO Auto-generated method stub
		int sum = 10/0;
		System.out.println("안녕하세요 홍길동 입니다.");
		
	}

}
