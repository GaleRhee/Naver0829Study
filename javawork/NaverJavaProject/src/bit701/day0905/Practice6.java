package bit701.day0905;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//교재 p.158 주민번호 (문자 추출) + 응용 문제
		String ssn="950421123456";
		char sex=ssn.charAt(6);
		
		switch(sex) {
			case '1':
			case '3':
				System.out.println("남자입니다");
				break;
			case '2':
			case '4':
				System.out.println("여자입니다");
				break;
		}
		
	}
}