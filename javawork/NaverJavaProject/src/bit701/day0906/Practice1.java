package bit701.day0906;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[3];
		
		for(int i=0;i<arr1.length;i++)
		{
			System.out.print("arr1["+i+"]:"+arr1[i]+",");
		}
		System.out.println();
		
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		for(int i=0;i<arr1.length;i++)
		{
			System.out.print("arr1["+i+"]:"+arr1[i]+",");
		}
		System.out.println("\n");
		
		
		
		double[] arr2=new double[3];
		for(int i=0;i<arr2.length;i++)
		{
			System.out.print("arr2["+i+"]:"+arr2[i]+",");
		}
		System.out.println();
		
		arr2[0]=0.1;
		arr2[1]=0.2;
		arr2[2]=0.3;
		for(int i=0;i<arr2.length;i++)
		{
			System.out.print("arr2["+i+"]:"+arr2[i]+",");
		}
		System.out.println("\n");
		
		String[] arr3=new String[3];
		for(int i=0;i<arr3.length;i++)
		{
			System.out.print("arr3["+i+"]:"+arr3[i]+",");
		}
		System.out.println();
		
		arr3[0]="1월";
		arr3[1]="2월";
		arr3[2]="3월";
		for(int i=0;i<arr3.length;i++)
		{
			System.out.print("arr3["+i+"]:"+arr3[i]+",");
		}
		System.out.println("\n");
		
		
		
		//다차원 배열
		
		int[][] scores= {
				{80,90,96},
				{76,88}
		};
		
//		int score1=scores[0][1];//90
//		int score2=scores[1][1];//88
		
//		scores.length;//2
//		scores[0].length;//3
//		scores[1].length;//2
		
		System.out.println("1차원 배열의 길이 (반의 수): "+scores.length);
		System.out.println("2차원 배열의 길이 (첫번째 반 학생 수): "+scores[0].length);
		System.out.println("2차원 배열의 길이 (두번째 반 학생 수): "+scores[1].length);
		
		System.out.println("scores[0][2]: "+scores[0][2]);//첫번째 반 세번째 학생 점수 읽기
		System.out.println("scores[1][1]: "+scores[1][1]);//두번째 반 두번째 학생 점수 읽기
		
		//첫번째 반 평균 구하기
		int sum1=0;
		
		for(int i=0;i<scores[0].length;i++)
		{
			sum1+=scores[0][i];
		}
		double avg1=(double)sum1/scores[0].length;
		System.out.println("첫번째 반의 평균: "+avg1);
		
		//두번째 반 평균 구하기
		int sum2=0;
		
		for(int i=0;i<scores[1].length;i++)
		{
			sum2+=scores[1][i];
		}
		double avg2=(double)sum2/scores[1].length;
		System.out.println("두번째 반의 평균: "+avg2);
		
		//모든 반의 평균 점수 구하기
		int totalsum=0;
		int totalnum=0;
		
		for(int i=0;i<scores.length;i++)
		{
			totalnum+=scores[i].length;
			for(int j=0;j<scores[i].length;j++)
			{
				totalsum+=scores[i][j];
			}
		}
		double totalavg=(double)totalsum/totalnum;
		System.out.println("전체 학생 평균: "+totalavg);
	}

}
