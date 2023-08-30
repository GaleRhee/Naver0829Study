package bit701.day0830;

public class DataEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//10진수로 표현할때 1~9는 숫자 10부터는 알파벳
		int a1=0xa3;//16진수 a3는 10진수로 얼마일까요? 10*16+3=163
		System.out.println(a1);
		int a2=0xf4;//15*16+4=244
		System.out.println(a2);
		int a3=0xa56;//10*16^2+5*16+6=2646
		System.out.println(a3);
		//0x는 아스키 코드로 16진수임을 나타내는 기호로 해석을 하고
		//그 뒤에 각 자리의 값들을 맨 뒤에서부터 16^0=1, 16^1=16, 16^2=256, ...을 곱하고 
		//각 자리의 결과값들을 더한다
		
		
		
		//8진수
		int a4=045;//4*8+5, 앞에 0을 붙이면 8진수로 인식한다
		System.out.println(a4);//37
		

	}

}
