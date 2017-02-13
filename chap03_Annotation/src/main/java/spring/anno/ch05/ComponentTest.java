package spring.anno.ch05;

import org.springframework.stereotype.Component;

@Component
public class ComponentTest {//<bean id ="componentTest" class="ComponentTest"/>

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ComponentTest 클래스 수행";
	}
	
}
