package spring.anno.example1;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
private String filePath;
	
	//설정 메서드 DI
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public void output(String msg) throws IOException{ // 출력 메시지
		FileWriter out = new FileWriter(filePath);
		out.write(msg); // 파일 저장
		out.close(); //닫기
	}
}
