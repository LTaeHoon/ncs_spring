package spring.anno.example1;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class Piano implements Instrument {
	private String sound;
	
	@Autowired
	private FileOutput fileOutput;
	
	public void setSound(String sound){
		this.sound=sound;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("피아노를 연주합니다.");
		System.out.println("피아노 소리 :" + this.sound);
		String msg ="피아노를 연주합니다.\n" + "피아노 소리: "+this.sound; 
		//파일 출력
		try {
			this.fileOutput.output(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
