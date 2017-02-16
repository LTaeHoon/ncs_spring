package spring.mvc.ch06;

public class SearchType {
	private int gno; //게임번호
	private String gtype; //게임유형
	
	//생성자
	public SearchType(int gno, String gtype){
		this.gno = gno;
		this.gtype=gtype;
	}
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGtype() {
		return gtype;
	}
	public void setGtype(String gtype) {
		this.gtype = gtype;
	}
	
	
	
}	
