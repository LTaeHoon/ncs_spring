package spring.aop.ch02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//공통모듈
@Service
public class AspectImpl {
	//스톱워치 객체 생성
	static StopWatch sw = new StopWatch();
	
	static void before(){ //메서드 호출 전 공통모듈
		sw.start(); //초 시작
		System.out.println("[Log] : 포인트 컷 메서드 호출 시작");
	}
	
	static void after(){//수업후 공통모듈(aspect)
		sw.stop(); //초 종료
		System.out.println("[Log] : 포인트 컷 메서드 호출 종료");
		System.out.printf("[Log] : 포인트 컷 메서드 소요 시간 : %d 초 \n",sw.getTotalTimeMillis()/1000);	
	}
	
	//포인트컷 메서드를 호출하는 메서드
	public Object weaving(ProceedingJoinPoint pjp) throws Throwable{
		//포인트컷 메서드 호출 전 공통모듈 호출
		AspectImpl.before();
		
		//포인트 컷 메서드 호출
		Object re = pjp.proceed(); //study() 호출
		
		//포인트컷 메서드 호출 후 공통모듈 호출
		AspectImpl.after();
		
		return re;
	}
}
