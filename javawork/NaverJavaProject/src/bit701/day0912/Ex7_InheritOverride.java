package bit701.day0912;

class SuperB
{
	public void processA()
	{
		System.out.println("부모가 가진 메서드 A");
	}
}

class SubB extends SuperB
{
	@Override //어노테이션
	public void processA() {
		// TODO Auto-generated method stub
		super.processA();//부모가 먼저 작업을 하고
		System.out.println("자식이 가진 오버라이드 메서드 A");//나머지는 자식 클래스에서 작업을 완성을 한다
	}
	
	public void processB()
	{
		System.out.println("자식만이 갖고 있는 메서드 B");
	}
}

////////////////////////////////////
public class Ex7_InheritOverride {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubB sub1=new SubB();
		sub1.processA();
		
		//다형성의 기본 원리
		//선언은 부모 클래스로, 생성은 자식 클래스로
		SuperB sub2=new SubB();
		sub2.processA();//오버라이드된 자식이 가진 메서드가 호출
	}

}