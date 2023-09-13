package bit701.day0913;

abstract class Tire
{
	abstract public void roll();
}


class HankookTire extends Tire
{

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다");
	}
	
}

class KeumhoTire extends Tire
{

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다");
	}
	
}

//////////////////////////////////////////////////////////////
class Car
{
	public Tire tire;
	
	public void run()
	{
		tire.roll();//tire 에 new 로 생성을 안 한 상태에서 호출 시 NullPointException 발생
		//tire이 null이라는 의미
	}
}

public class Book314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		car.tire=new HankookTire();
		car.run();
		
		car.tire=new KeumhoTire();
		car.run();
	}

}
