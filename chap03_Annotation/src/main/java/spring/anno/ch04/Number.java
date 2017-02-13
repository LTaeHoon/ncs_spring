package spring.anno.ch04;

public class Number {
	private int number;
	
	public void setNumber(int number){
		this.number = number;
	}
	
	//객체정보 문자열 반환
	public String toString(){
		return "number = "+this.number;
	}
}
