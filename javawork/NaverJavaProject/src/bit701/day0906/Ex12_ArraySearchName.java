package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[] names={"강호동","유재석","한채영","이효리","이승기",
				"강남길","이민정","이서진","손미나","유미리"};
		/*
		 * 검색할 성은? 이
		 * 			4:이효리
		 * 			5:이승기
		 * 			7:이민정
		 * 			8:이서진
		 * 			총 4명
		 * 
		 * 검색할 성은? 박
		 * 	'박'씨성을 가진 멤버는 없습니다
		 * 
		 * 검색할 성은? 끝
		 * 		종료합니다
		 * 
		 * 	  변수: String searchSung
		 * 			int count;
		 * 			boolean bFind;
		 * 
		 * 	startsWith 이용해서 프로그램 작성해보세요
		 * 
		 */
		
		//선언
		String searchSung="";
		int count;
		boolean bFind;
		
		//입력
		while(true)
		{
			count=0;
			bFind=false;
			//안에서 선언해야지 다시 시작했을 때 이 값들로 초기화됨
			
			System.out.print("검색할 성은?");
			searchSung=sc.nextLine();
			
			if(searchSung.equals("끝"))
			{
				System.out.println("** 종료합니다 **");
				break;
			}
			
			for(int i=0;i<names.length;i++)
			{
				if(names[i].startsWith(searchSung))
				{
					bFind=true;
					count++;
					System.out.println(i+1+":"+names[i]);
				}
			}
			if(bFind)
				System.out.println("** 총 "+count+"명 **");
			else
				System.out.printf("\"%s\"씨 성을 가진 멤버는 없습니다\n",searchSung);
			System.out.println();
			
		}
		
	}

}
