package spring.anno.ch06;

import org.springframework.stereotype.Component;

@Component
public class MemberVo { //Value Object = DTO (id="memberVo")
	private String id="hong";
	private String pwd="1234";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
