package bit701.day0905;

import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String juminNo;

		while(true)
		{
			System.out.println("주민등록 번호 입력");
			juminNo=sc.nextLine();
			//q or Q 입력시 종료
			if(juminNo.equalsIgnoreCase("q")) {
				System.out.println("Program End!!!!");
				break;
			}
			String yearStr=juminNo.substring(0,2);
			String monthStr=juminNo.substring(2,4);
			String dayStr=juminNo.substring(4,6);
			char gender=juminNo.charAt(7);
			System.out.println(yearStr+"년"+monthStr+ "월"+dayStr+ "일");

			if(gender=='1' ||gender=='2' ||gender=='3' ||gender=='4') {
				System.out.println("내국인");
			}else if(gender=='5' ||gender=='6') {
				System.out.println("외국인");
			}else{
				System.out.println("8번째 값을 잘못 입력했어요");
			}

			switch(gender) {
			case '1': case '3': case '5':
				System.out.println("남자!");
				break;
			case '2': case '4': case '6':
				System.out.println("여자!");
				break;
			default:
				System.out.println("성별 알 수 없음!!");
			}
		}

		//		String ssn="";
		//		int i=(int)(ssn.charAt(0));
		//		
		//		
		//		Exit:
		//		System.out.println("주민번호를 입력해주세요");
		//		ssn=sc.nextLine();
		//
		//			if(ssn.length()!=14 && ssn.charAt(6)!='-') {
		//				if(i<1 || i>6) {
		//					break;
		//				}
		//			
		//			}else {
		//			
		//				while(true) {
		//			
		//					switch(i){
		//						case 1:
		//						case 2:
		//						case 3:
		//						case 4:
		//							System.out.print("내국인 ");
		//							if(i==1 || i==3) {
		//								System.out.println("남성입니다");
		//							}else {
		//								System.out.println("여성입니다");
		//							}
		//						case 5:
		//						case 6:
		//							System.out.print("외국인 ");
		//							if(i==5)
		//								System.out.println("남성입니다");
		//							else {
		//								System.out.println("여성입니다");
		//							
		//							}
		//						default:
		//							break Exit;
		//			
		//					}
		//				}
		//			
		//			}
		//			System.out.println("다시 입력해주세요");

	}

}
