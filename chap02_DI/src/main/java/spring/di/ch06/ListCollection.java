package spring.di.ch06;

import java.util.List;

public class ListCollection {
	private List<String> userName;
	
	public void setUserName(List<String> userName){
		this.userName = userName;
	}
	
	//List 원소 출력
	public void display(){
		System.out.println("*** list 원소 ***");
		for(String name : userName){
			System.out.println("list 원소 : "+ name);
		}
	}
}
