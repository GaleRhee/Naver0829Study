package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("내이름은 "+args[0]+"입니다");
		System.out.println("우리집은 "+args[1]+"입니다");
		System.out.println("내혈액형은 "+args[2]+"형입니다");
		System.out.println();
		System.out.println("실수형 데이터 타입");
		
		float f1=1234.567891234f;
		//4byte float으로 값을 지정하려면 f 추가
		double f2=1234.567891234;
		System.out.println(f1);//.빼고 앞에서부터 8자리까지만 정확하게 출력
		System.out.println(f2);//15자리까지만 정확하게 출력
		
		//char 타입은 2 바이트라 한글 한 글자도 저장 가능하다
		char ch1='A';
		char ch2='가';
		System.out.println(ch1);
		System.out.println(ch2);

	}

}
