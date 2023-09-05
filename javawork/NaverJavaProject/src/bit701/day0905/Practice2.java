package bit701.day0905;

public class Practice2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//교재 p.135 (Break 문)
		Outter: for(char upper='A';upper<='Z';upper++) {
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper+"-"+lower);
				if(lower=='g') {
					break Outter;
				}
			}
		}
		System.out.println("프로그램 실행 종료");
		
	}

}
