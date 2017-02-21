package spring.aop.ch01;

import org.aspectj.lang.ProceedingJoinPoint;

//공통모듈
public class AspectImpl {
	
	static void before(){ //수업전 공통모듈(aspect)
		System.out.println("휴대폰 off");
		System.out.println("조명 off");
	}
	
	static void after(){//수업후 공통모듈(aspect)
		System.out.println("휴대폰 on");
		System.out.println("조명 on");
	}
	
	//포인트컷 메서드를 호출하는 메서드
	public Object weaving(ProceedingJoinPoint pjp) throws Throwable{
		//수업전 공통모듈 호출
		AspectImpl.before();
		
		//포인트 컷 메서드 호출
		Object re = pjp.proceed(); //study() 호출
		
		//수업후 공통모듈 호출
		AspectImpl.after();
		
		return re;
	}
}
