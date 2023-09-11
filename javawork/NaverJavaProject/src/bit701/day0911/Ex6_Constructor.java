package bit701.day0911;

class Student
{
	private String name;
	private int birthYear;
	private int score;
	
	Student()
	{
		name="이효리";
		birthYear=2000;
		score=50;
	}
	
	Student(String name)
	{
		this.name=name;
		birthYear=2000;
		score=50;
	}
	
	Student(String name, int birthYear, int score)
	{
		this.name=name;
		this.birthYear=birthYear;
		this.score=score;
	}
}

public class Ex6_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
