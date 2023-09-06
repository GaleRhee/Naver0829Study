package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 총 4명의 이름과 점수를 입력하면 이름과 점수 등수를
		 * 출력하는 프로그램을 작성하시오
		 * 단, 점수가 0~100 을 버어날 경우 다시 입력하시오
		 * 
		 * 예:
		 * 	0번 이름: 송혜교
		 * 	0번 점수: 99
		 * 
		 * 	1번 이름: 강호동
		 * 	1번 점수:120
		 * 		다시 입력하세요
		 * 	1번 이름: 강호동
		 * 	1번 점수: 60
		 * 	...
		 * 
		 * 	번호	이름	점수	등수
		 * 	----------------------------
		 * 		1	강호동	  99    	1	
		 */
		Scanner sc=new Scanner(System.in);
		//선언
		String[] names=new String[4];
		int[] scores=new int[4];
		int[] ranks=new int[4];
		
		//입력
		for(int i=0;i<scores.length;i++)
		{
			System.out.print(i+"번 이름: ");
			names[i]=sc.nextLine();
			
			System.out.print(i+"번 점수: ");
			scores[i]=Integer.parseInt(sc.nextLine());
			
			if(scores[i]<1 || scores[i]>100)
			{
				System.out.println("다시 입력하세요");
				i--;
				continue;
			}
			System.out.println();
			
		}
		
		//계산 (등수 구하기)
		for(int i=0;i<scores.length;i++)
		{
			ranks[i]=1;
			for(int j=0;j<scores.length;j++)
			{
				if(scores[i]<scores[j])
					ranks[i]++;
			}
		}
		
		
		//출력
		System.out.println("\t번호\t이름\t점수\t등수");
		System.out.println("-".repeat(50));
		for(int i=0;i<scores.length;i++)
		{
			System.out.println(i+1+"\t"+names[i]+"\t"+scores[i]+"\t"+ranks[i]);
		}

	}

}
