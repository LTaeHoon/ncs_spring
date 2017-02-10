package spring.di.ch07;

import java.util.Map;

public class MapCollection {
	private Map<String, Object> map;
	
	public void setMap(Map<String, Object> map){
		this.map = map;
	}
	public void display(){
		System.out.println("*** map 원소 ***");
		System.out.println(this.map);
	}
}
