package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnect;

public class Ex4_MysqlSawonDelete {
	DBConnect db=new DBConnect();
	
	public void sawonDelete()
	{
		Scanner sc=new Scanner(System.in);
		
		//사원명 입력 후 해당 사원 삭제
		System.out.println("삭제할 사원 이름:");
		String sawon=sc.nextLine();
		
		String sql="delete from sawon where name='"+sawon+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMysqlConnection();
		
		//결과값이 0 이면 xxx 사원은 없습니다
		//		   n 이면 총 n 명의 xxx 사원 정보를 삭제했습니다
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			
			if(n==0)
				System.out.println(sawon+" 사원은 없습니다");
			else
				System.out.println("총 "+n+"명의"+sawon+" 사원 정보를 삭제했습니다 ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex=new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}

}
