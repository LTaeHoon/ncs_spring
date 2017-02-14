package jdbc.exam.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbc.exam.dao.GoodsDAO;
import jdbc.exam.vo.GoodsVO;
import spring.jdbc.vo.TeamVO;

@Service
public class GoodsService {
	
	private String code=null; 
	private String name=null;
	private int price=0;
	private String maker=null;
	private int re=0; 
	private boolean check=false; 
	private GoodsVO goods=null; 
	
	@Autowired
	private GoodsDAO goodsDAO;
	private BufferedReader input; 
	
	public GoodsService(){ // 생성자:키보드 입력 객체 생성 
		input = new BufferedReader(
				new InputStreamReader(System.in));
	}
	/* id 유무 체크 검사(별도 메서드 작성) */
	public boolean idCheck(){
		List<GoodsVO> list = this.goodsDAO.getGoodsList();		
		GoodsVO goods = new GoodsVO();		
		for(int i=0; i<list.size(); i++){			
			goods = list.get(i);
			if(goods.getCode().equals(code))
				check=true;		   	
		}
		return check;
	}
	/* 1. 상품 보기 */
	public void goodsList(){  
		/* 전체 레코드 목록 보기*/
		List<GoodsVO> list = this.goodsDAO.getGoodsList();		
		System.out.println("************");
		System.out.println("코드		상품명 	가격 		제조사");		
		for(GoodsVO good : list){
			// 팀 id와 name 출력
			System.out.printf("%s    %s		%d		%s\n",good.getCode(),
					        good.getName(),good.getPrice(),good.getMaker());
		}
		System.out.println("************");
	}
	/* 2. 상품 추가 */
	public void goodsInsert(){ 		
		try {
			System.out.print("추가할 상품 코드 입력 : ");
			code=input.readLine();
			System.out.print("추가할 상품명 입력 : ");
			name=input.readLine();
			System.out.print("추가할 상품가격 입력 : ");
			price=Integer.parseInt(input.readLine());
			System.out.print("추가할 제조사 입력 : ");
			maker=input.readLine();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		/* id 또는 name 중복 체크 */
		List<GoodsVO> list = this.goodsDAO.getGoodsList();
		goods = new GoodsVO();		
		for(int i=0; i<list.size(); i++){			
			goods = list.get(i);
			if(goods.getCode()==code || goods.getName().equals(name))
				check=true;		   	
		}
		if(check==true){
			System.out.println("상품의 코드 또는 상품명이 중복됩니다.");
			return;		
		}
		/* 레코드 저장*/
		goods.setCode(code); goods.setName(name); goods.setPrice(price);
		goods.setMaker(maker);
		try {
			re = this.goodsDAO.goodsInsert(goods);
			if(re==1){
				goodsList();	// 팀 목록보기 메서드 호출
			}else{
				System.out.println("레코드 추가에 실패하였습니다.");
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	/* 3. 상품 검색 */
	public void goodsSearch(){ 				
		try {
			System.out.print("검색할 상품 코드 입력 : ");
			code=input.readLine();			
		} catch (NumberFormatException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		/* 레코드 검색*/
		try {
			goods = this.goodsDAO.getGoodsSearch(code); 
			System.out.println("************");
			System.out.println("상품 코드         상품명              상품가격               제조사");		
			System.out.printf("%s     %s	%d      %s	\n",goods.getCode(),
						        goods.getName(),goods.getPrice(),goods.getMaker());
			System.out.println("************");
		} catch (Exception e) {
			System.out.println("***********************");
			System.out.println("해당 ID가 존재하지 않습니다.");
			System.out.println("***********************");
		}
		
	}
	/* 4. 상품 수정 */
	public void goodsUpdate(){ 
		try {
			System.out.print("수정할 상품 코드 입력 : ");
			code=input.readLine();
			System.out.print("수정할 상품명 입력 : ");
			name=input.readLine();
			System.out.print("수정할 상품가격 입력 : ");
			price=Integer.parseInt(input.readLine());
			System.out.print("수정할 제조사 입력 : ");
			maker=input.readLine();
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* id 유무 체크 검사*/
		List<GoodsVO> list = this.goodsDAO.getGoodsList();		
		GoodsVO goods= new GoodsVO();		
		for(int i=0; i<list.size(); i++){			
			goods = list.get(i);
			System.out.printf("%s\n",goods.getCode());
			System.out.println(goods.getCode().equals(code));
			if(goods.getCode().equals(code))
				check=true;		   	
		}
		if(check==false){
			System.out.println("해당하는 상품이 없습니다.");
			return;			
		}
		/* 레코드 수정*/
		goods.setCode(code); goods.setName(name); goods.setPrice(price);
		goods.setMaker(maker);		
		try {
			re = this.goodsDAO.goodsUpdate(goods);
			if(re==1){
				goodsList();	
			}else{
				System.out.println("레코드 수정에 실패하였습니다.");
			}	
		} catch (Exception e) {			
			e.printStackTrace();
		}
			
	}
	/* 5. 구단 삭제 */
	public void goodsDelete(){
		try {
			System.out.print("삭제할 상품 코드 입력 : ");
			code=input.readLine();
		} catch (NumberFormatException e) {	
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		/* id 유무 체크 검사 메서드 호출*/
		check=idCheck();
		
		if(check==false){
			System.out.println("해당하는 상품의 code가 없습니다.");
			return;			
		}
		
		/* 레코드 삭제*/
		try {
			re = this.goodsDAO.goodsDelete(code);
			if(re==1){
				goodsList();	
			}else{
				System.out.println("레코드 삭제에 실패하였습니다.");
			}	
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		
	}
	
}
