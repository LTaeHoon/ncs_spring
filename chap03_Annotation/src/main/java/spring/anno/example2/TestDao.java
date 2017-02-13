package spring.anno.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	@Autowired
	private TestDto testDto;
		
	public void display(){
		System.out.println("TestDao 클래스 호출");
		this.testDto.display();
	}
}
