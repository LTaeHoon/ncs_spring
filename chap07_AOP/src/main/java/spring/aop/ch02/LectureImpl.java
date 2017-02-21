package spring.aop.ch02;

import org.springframework.stereotype.Component;

@Component //id="lectureImpl"
public class LectureImpl implements Lecture {

	@Override
	public void study() {
		try {
			Thread.sleep(3000); //3초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//포인트 컷 메서드
		System.out.println("**********************");
		System.out.println("1교시 수업중 입니다.");
		System.out.println("**********************");
		
	}

}
