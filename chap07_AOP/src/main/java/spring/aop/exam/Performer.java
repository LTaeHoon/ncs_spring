package spring.aop.exam;

import org.springframework.stereotype.Service;

@Service
public class Performer implements Performance {
	
	@Override
	public void perform() {
		int sum = 10/0;
		System.out.println("연극을 시작합니다.");
	}

}
