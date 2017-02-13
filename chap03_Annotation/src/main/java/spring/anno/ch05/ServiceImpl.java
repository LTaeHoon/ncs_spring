package spring.anno.ch05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {//<bean id="serviceImpl" class=""/>
	//Controller -> Service -> Dao
	
	@Autowired
	private DaoImpl daoImpl;
	
	public void display(){
		System.out.println("ServiceImpl 클래스 수행");
		System.out.println(this.daoImpl); // 객체정보가 문자열 출력
	}
	
}
