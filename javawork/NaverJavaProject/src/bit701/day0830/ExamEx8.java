package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//money 변수에 args[0]값을 대입후 (급여:백만단위:5674321)
		/*
		 * 출력
		 * money : 5674321원
		 * 만원짜리 567 장
		 * 천원짜리 4 장
		 * 백원짜리 3개
		 * 십원짜리 2개
		 * 일원짜리 1개
		 * 
		 * :산술연산자를 사용해서 출력해보세요
		 * 
		 */
		
		
		String money=args[0];
		int su1=Integer.parseInt(money);
		int a=su1/10000;
		int b=(su1%10000)/1000;
		int c=(su1%1000)/100;
		int d=(su1%100)/10;
		int e=su1%10;
		
		System.out.println("money : " +args[0]+"원");
		System.out.printf("만원짜리 %d장\n천원짜리 %d장\n백원짜리 %d개\n십원짜리 %d개\n일원짜리 %d개\n",a,b,c,d,e);
		
	}

}
