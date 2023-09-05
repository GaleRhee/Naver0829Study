package bit701.day0905;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//교재 p.137 뒷장 문재 6번과 응용 문제(for 문)
		
//		for(int i=1;i<=5;i++){
//			for(int j=1;j<=i;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
//		for(int i=1;i<=5;i++){
//			for(int j=i;j<=5;j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		for(int i=1;i<=5;i++){
			for(int j=1;j<=5;j++){
				if(i==j)
					System.out.print(j);
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		

		
	}

}
