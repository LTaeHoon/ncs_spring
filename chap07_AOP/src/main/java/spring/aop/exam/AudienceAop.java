package spring.aop.exam;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AudienceAop {
	@Pointcut("execution(public * Performance.perform(..))")
	public void perform(){ } //형식상 정의
	
	@Before("perform()")
	public void trunOffPhone(){
		System.out.println("휴대전화 끄기");
	}

	@Before("perform()")
	public void takeSeat(){
		System.out.println("자리에 앉기~");
	}
	
	@AfterReturning("perform()")
	public void applaud(){
		System.out.println("와우!! 감동적이네요~~ 앵콜~");
	}
	@AfterThrowing("perform()")
	public void demandRefund(){
		System.out.println("우우! 돈 돌려줘~");
	}
	
}
