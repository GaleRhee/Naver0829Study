package bit701.day0906;

public class Ex1_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//교재 p.165
		//배열: 연속된 형태로 데이터가 저장되는 형태
		//		배열에는 같은타입의 데이터만 저장이 가능하다
		//		일괄적으로 처리하기 위해 배열을 사용
		//		자바에서 하나의 (기본형인데도) 배열은 하나의 객체로 인식된다
		
		//배열 선언 방법 1
		int []arr1=new int[5];//5개의 정수 타입을 저장할 공간이 확보 
		//0으로 자동 초기화(참조형은 null로 초기화)
		//무조건 생성이 되면 공간이 확보되고 차지한다
		//어느 정도 데이터 개수가 정해져 있을 때 사용
		//나중에는 collection type이 나오는데 그건 데이터를 입력하는대로 추가됨
		System.out.println("arr1의 할당 갯수: "+arr1.length);//5
		
		//배열의 특정 번지에 값을 넣는 방법
		arr1[1]=10;
		arr1[4]=50;
		
		//출력 1 (i 값이 필요할 때 사용하는 공식) 
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
		
		System.out.println();
		
		//출력 2
		for(int n:arr1)//arr1의 갯수만큼 자동으로 반복되면서 하나하나의 값을 n으로 보냄
		{
			System.out.println(n);
		}
		
		
		
		
//		String[] season={"Spring", "Summer", "Fall", "Winter"};
//		
//		System.out.println("season[0] : "+ season[0]);
//		System.out.println("season[1] : "+ season[1]);
//		System.out.println("season[2] : "+ season[2]);
//		System.out.println("season[3] : "+ season[3]);
//
//		season[1]= "여름";
//		System.out.println("season[1] : "+ season[1]);
//		System.out.println();
//
//		//배열 변수 선언과 생성
//		int[]scores={83, 90, 87};
//		//크기와 상관없이 입력된순서에 따라 인덱스 값이 부여된다
//
//		//총합과 평균 구하기
//		int sum=0;
//		for(int i=0;i<3;i++){
//			sum+=scores[i];
//		}
//		System.out.println("총합 : "+ sum);
//		double avg=(double)sum/3;
//		System.out.println("평균 : "+ avg);

		}
	
	}


