package spring.mvc.ch02;

// 파라미터 바인딩 시키는 클래스
public class CommandVO {
		private int bno;
		private String title;
		private String content;
		public int getBno() {
			return bno;
		}
		public void setBno(int bno) {
			this.bno = ++bno; //0->1
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
}
