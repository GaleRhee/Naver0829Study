package bit701.day0905;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//교재 p.137 뒷장 문제 7번 (While문 switch-case)
		
		Scanner sc=new Scanner(System.in);
		boolean run=true;
		int money=0, total=0, num;
		
		Exit:
		while(run) {
			System.out.println("-".repeat(40));
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-".repeat(40));
			System.out.print("선택> ");
			num=sc.nextInt();
						
			switch(num){
				case 1:
					System.out.print("예금액: ");
					money=sc.nextInt();
					total+=money;
					break;
				case 2:
					System.out.print("출금액: ");
					money=sc.nextInt();
					total-=money;
					break;
				case 3:
					System.out.println("조회: "+total);
					break;
				case 4:
					//System.out.print("**프로그램 종료**");
					break Exit;
				default:
					System.out.println("다시 입력해주세요!");
					
					//else{  //(num<1 || num>4)의 경우
					//	System.out.println("다시 입력해주세요");
					//	continue;}
			}
			
			
		}
		System.out.print("**프로그램 종료**");
		
		
	}

}
