package bit701.day0911;

class MethodEx2
{
	int var;
	
	public void setInt(int var)
	{
		this.var=var;
	}
	
	public int getInt()
	{
		return var;
	}
}

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodEx2 me2=new MethodEx2();
		me2.setInt(1000);
		System.out.println("var : "+me2.getInt());
		
	}

}
