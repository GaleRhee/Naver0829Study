package bit701day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 구구단을 출력할 시작단 입력
		 * 4
		 * 구구단을 출력할 끝단 입력
		 * 6
		 * 
		 * 	4단		5단		6단
		 * 4x1=4	5x1=5	6x1=6		-다중 for문
		 * 4x2=8	5x2=10	6x2=12
		 * (i x j라고 할 경우에 뒤에 j 가 일관되기에 가장 바깥의 for문으로 사용한다
		 */
		
		Scanner sc=new Scanner(System.in);
	
		
		System.out.println("구구단을 출력할 시작단은?");
		int start=sc.nextInt();
		System.out.println("구구단을 출력할 끝단은?");
		int end=sc.nextInt();
		
		//start가 end보다 클 경우 두 변수의 값을 바꿔보자
		if(start>end) {
			int temp=start;
			start=end;
			end=temp;
		}
		
		
		//제목 출력
		for(int dan=start;dan<=end;dan++)
		{
			System.out.printf("%7d단",dan);
		}
		System.out.println("\n");
		
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=start;dan<=end;dan++)
			{
				System.out.printf("%5dX%d=%2d",dan,i,dan*i);
			}
			System.out.println();
		}
		
		
	}

}
