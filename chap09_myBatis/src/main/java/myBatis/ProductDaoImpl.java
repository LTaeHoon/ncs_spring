package myBatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Product;

public class ProductDaoImpl{
	static SqlSession session = null;
	Scanner sc=null;
	Product product=null;
	
	public static void main(String[] args) throws IOException {
		// myBatis 설정 파일 지정
		String resource = "dbInfo/SqlMapConfig.xml";
		// 1. myBatis 설정 파일 읽기
		Reader reader = Resources.getResourceAsReader(resource);
		// 2. SqlSessionFactory 객체 생성
		SqlSessionFactory factory = new
			 SqlSessionFactoryBuilder().build(reader);
		// 3. Session 객체 열기
		session = factory.openSession();
		
		// start() 메서드 호출
		ProductDaoImpl pro = new ProductDaoImpl();
		pro.start();
	}		
	public void start(){
		sc = new Scanner(System.in);
		boolean flag = true;
		while(flag){
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.println("1. 전체 상품");
			System.out.println("2. 상품 검색");
			System.out.println("3. 상품 추가");
			System.out.println("4. 상품 삭제");
			System.out.println("5. 상품 변경");
			System.out.println("6. 종료");
			System.out.println("-=-=-=-=-=-=-=-=-=");
			System.out.print("숫자 입력후 Enter.. : ");
			int nu = Integer.parseInt(sc.nextLine());;
			switch(nu){
			case 1 :
				// 1) selectList() 메소드 - 2개 이상의 레코드 검색 -> List				
				List<Product> list;
				// queryForList() -> selectList()
				try{
				  list=session.selectList("selectAllPro");
					for(Product pr : list){
						System.out.printf("num : %d, name : %s, price : %d, reg_date: %s\n",
						pr.getNum(), pr.getName(), pr.getPrice(),pr.getReg_date());}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2 :
				// 2) selectOne() 메서드 : 검색결과가 1개인 경우
				// queryForObject 대신 사용되는 메서드
				System.out.print("검색할 제품번호를 입력하세요 : ");
				sc = new Scanner(System.in);
				int num = Integer.parseInt(sc.nextLine());
				try{
				  product = 
				    (Product)session.selectOne("selectPro",num);
				  if(product != null){
				     System.out.printf
					  ("검색 결과 : id : %d, name : %4s, price : %d reg_date: %s\n",
							  product.getNum(), product.getName(), product.getPrice(),product.getReg_date());
				  }else{
					System.out.println("해당하는 제품이 없음");
				  }				
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 3 :
				System.out.println("신규 제품 추가");
				product = new Product();
				System.out.print("제품명 입력 : ");
				product.setName(sc.nextLine());
				System.out.print("가격 입력 : ");
				product.setPrice(Integer.parseInt(sc.nextLine()));
				
				try{
					session.insert("insertPro",product);
					session.commit();  // db 테이블 갱신
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 4 :
				System.out.print("삭제할 제품의 번호를 입력하시오 : ");
				num = Integer.parseInt(sc.nextLine());
				try{
					// 사용자가 입력한 id 조회
					product = 
							(Product)session.selectOne("selectPro",num);
					if(product != null){
						session.delete("deletePro",num);
						session.commit();  // db 테이블 갱신
					}else{
						System.out.println("해당하는 제품이 없음");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 5 :
				System.out.print("변경할 제품의 번호를 입력하시오 : ");
				num = Integer.parseInt(sc.nextLine());				
				try{
					// 사용자가 입력한 id 조회
					product = 
					  (Product)session.selectOne("selectPro",num);
					if(product != null){
						System.out.print("제품명 입력 : ");
						product.setName(sc.nextLine());
						System.out.print("가격 입력 : ");
						product.setPrice(Integer.parseInt(sc.nextLine()));
						session.update("updatePro",product);
						session.commit(); // db 테이블 갱신
					}else{
						System.out.println("해당하는 제품이 없음");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 6 :
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);				
				break;
			default:
				System.out.println("1-6사이의 숫자를 입력해 주세요.");
			}
		}
	}
}
