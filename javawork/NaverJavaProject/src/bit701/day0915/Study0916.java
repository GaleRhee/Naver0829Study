package bit701.day0915;

import java.util.Scanner;

public class Study0916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String my_string=sc.nextLine();
		String overwrite_string=sc.nextLine();
		int s=Integer.parseInt(sc.nextLine());
		
		
        String a=my_string;
        String b=overwrite_string;
        
        
        for(int i=0;i<a.length();i++)
        {
            if(i<s)
                System.out.print(a.charAt(i));
             else if(i==s)
                System.out.print(b);
             else if(i>=s+b.length())
                System.out.print(a.charAt(i));    
            
        }
		
	}

}


