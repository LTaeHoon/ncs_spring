package spring.di.ch04;

//구현클래스 : 시스템 모니터링
public class SystemMoniter {
	private int time; // 모니터링 시간
	private SmsSender smsSender; //sms 메시지 전송
	
	// 설정메서드 DI(변수 주입)
	public void setTime(int time){
		this.time = time;
	}
	//설정메서드 DI(객체 주입)
	public void setSmsSender(SmsSender smsSender){
		this.smsSender = smsSender;
	}
	
	public void display(){
		System.out.println("SystemMoniter 클래스 수행");
		System.out.println("모니터링 시간 : "+ this.time);
		System.out.println("sender 메시지 : "+ this.smsSender);
	}
}
