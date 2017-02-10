package spring.di.ch05;

import spring.di.ch05.SmsSender;

//구현클래스 : 시스템 모니터링
public class SystemMoniter {
	private int time; // 모니터링 시간
	private SmsSender smsSender; //sms 메시지 전송
	
	//2개 파라미터 생성자 DI
	public SystemMoniter(int time,SmsSender smsSender){
		this.time = time;
		this.smsSender = smsSender;
	}
	
	
	public void display(){
		System.out.println("SystemMoniter 클래스 수행");
		System.out.println("모니터링 시간 : "+ this.time);
		System.out.println("sender 메시지 : "+ this.smsSender);
	}
}
