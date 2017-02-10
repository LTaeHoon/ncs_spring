package spring.di.exam;

import java.io.IOException;

public class MessageImpl implements Message {
	private String name;
	private String greeting;
	private FileOutput fieOutput; //외부 클래스 멤버
	
	// 생성자 DI
	public MessageImpl(String name){
		this.name = name;
	}
	// 설정메서드 DI
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}
	//
	public void setFileOutput(FileOutput fieOutput){
		this.fieOutput = fieOutput;
	}
	
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(this.greeting+this.name+"님");
		String msg = this.greeting +"," + this.name;
		//파일 출력
		try {
			this.fieOutput.output(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
