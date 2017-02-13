package spring.anno.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Autowired
	private TestDao testDao;
		
	public void display(){
		System.out.println("TestService 클래스 호출");
		this.testDao.display();
	}
}
