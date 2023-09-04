package bit701.day0904;

public class Ex1_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 반복문에는 for, while, do~while 3가지가 있다
		 * for문은 주로 반복 횟수가 정해져 있는 경우에 많이 사용한다
		 * while이나 do~while은 반복 횟수가 정해져 있지 않은 경우에 많이 사용
		 * while과 do~while 차이점은 조건을 먼저 주느냐, 나중에 주느냐 (선조건, 후조건) 차이
		 */
		
		int a=65;//대소문자 A의 아스키코드값
		while(a<=90)//조건이 참인 동안 실행: 91이 되면 빠져나간다
		{
//			System.out.print((char)a);
//			a++;
			
			//위의 코드를 한줄로 줄여보세요
			System.out.print((char)a++);//출력 후에 증가라서 프린트 안에 써도 된다
			//출력 전 증가 원하면 ++a
		}
		System.out.println();
		System.out.println("빠져나온 후에 a값"+a);
		
		a=65;
		while(true) {
			System.out.print((char)a++);
			if(a>90) {
				break;
			}
		}
		System.out.println();
		
		a=65;
		do {
			System.out.print((char)a++);
		}while(a<=90);//조건 뒤에 반드시 ; 추가
		
		int n=10;
//		while(n<10)//조건이 거짓이면 한번도 반복 안함
//		{
//			System.out.println(n--);
//		}
		
		//do~while은 무조건 일단 한번은 실행,
		//조건이 안맞아도 한번은 출력하고 싶을 때 사용
		do {
			System.out.println(n--);
			if(n==0)
				break;
		}while(n<10);//무한 loop 돈다 
		
	}

}
