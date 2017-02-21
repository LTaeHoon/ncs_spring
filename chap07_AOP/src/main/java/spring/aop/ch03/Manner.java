package spring.aop.ch03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통모듈 클래스
@Aspect
@Component
public class Manner { //id="manner"
	
	@Pointcut("execution(public * Human.sayName(..))")
	public void sayName(){ } //형식상 정의
	
	@Before("sayName()")
	public void hi(){
		System.out.println("@before : 인사하기 전 호출");
	}
	@After("sayName()")
	public void after(){
		System.out.println("@After : 인사한 후 호출");
	}
	@AfterReturning("sayName()")
	public void afterReturn(){
		System.out.println("@AfterReturning : 포인트 컷 수행 성공 후 호출");
	}
	@AfterThrowing("sayName()")
	public void afterErr(){
		System.out.println("@AfterThrowing : 포인트 컷 수행 중 예외 발생");
	}
	
	
}
