package bit701.day0831;

import java.text.NumberFormat;
//import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총 금액을 출력하시오
		 * 그리고 수량이 5개 이상일 경우 10프로 할인된 최종 금액도 출력해주세요
		 * 
		 * (예)
		 * 상품명: 딸기
		 * 수량: 6
		 * 단가: 1000
		 * 
		 * 총 금액: 6000 원
		 * 5개 이상 10프로 할인된 금액 :5400원
		 */
//		Scanner sc=new Scanner(System.in);
//		
//		System.out.println("상품명을 입력해 주세요");
//		String name=sc.nextLine();
//		System.out.println("수량을 입력해 주세요");
//		int number=sc.nextInt();
//		System.out.println("단가를 입력해 주세요");
//		int price=sc.nextInt();
//		//NumberFormat numberFormat1=NumberFormat.getInstance();
//		
//		int totalPrice=(number*price);
//		
//		
//		System.out.printf("상품명: %s\n수량: %d\n단가: %d\n\n",name,number,price);
//		
//		int salePrice=(totalPrice-(totalPrice/10));
//		if(number>=5)
//			System.out.printf("총금액: %d원\n5개 이상 10프로 할인된 금액 : %d원",totalPrice,salePrice);
//		else
//			System.out.printf("총금액: %d원 (할인 없음)",totalPrice);
//		
//		sc.close();
		
		
		//선언
		
		Scanner sc=new Scanner(System.in);
		NumberFormat numFormat=NumberFormat.getInstance();
		String name="";
		int number=0, price=0, total=0;
		 
		
		//입력
		
		System.out.println("상품명: ");
		name=sc.nextLine();
		System.out.println("수량: ");
		number=sc.nextInt();
		System.out.println("단가: ");
		price=sc.nextInt();
		 
		 
		
		//계산
		
		//총금액
		total=number*price;
		
		//출력
		System.out.println("총금액="+numFormat.format(total)+"원");
		
		//5개 이상 할인 받는 조건 추가
		
		if(number>=5)
		{
			total=(int)(total*0.9);
			System.out.printf("5개 이상 10프로 할인된 금액: %d 원\n",total);
	 		System.out.printf("5개 이상 10%% 할인된 금액: %s 원\n",numFormat.format(total));
		}
		 
		
		
	}

}
