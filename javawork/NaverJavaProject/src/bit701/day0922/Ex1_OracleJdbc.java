package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_OracleJdbc {
	static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	public Ex1_OracleJdbc() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			//System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이브 오류:"+e.getMessage());
		}
	}
	
	public void shopAllData()
	{
		Connection conn=null;
		
		Statement stmt=null;
		ResultSet rs=null;//select일 경우에만 필요
		String sql="select * from shop order by sang_no";
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			//System.out.println("오라클 연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//select 일 경우에는 무조건 executeQuery (반환 타입이 ResultSet)
			
			//rs.next(); : 다음 데이터로 이동을 하고 true 반환, 이동할 데이터가 없을 경우 false 반환
			System.out.println("상품번호\t상품명\t가격\t색상");
			System.out.println("=".repeat(40));
			int total=0;
			while(rs.next())
			{
				//데이터를 가져올 때 인덱스로 가져오거나 컬럼명으로 가져온다
				//일단 인덱스로 가져와 보자
//				String no=rs.getString(1);
//				String name=rs.getString(2);
//				int price=rs.getInt(3);
//				String color=rs.getString(4);
				
				//이번에는 컬럼명으로 가져와 보자
				String no=rs.getString("sang_no");
				String name=rs.getString("sang_name");
				int price=rs.getInt("sang_price");
				String color=rs.getString("sang_color");
				
				total+=price;
				
				System.out.println(no+"\t"+name+"\t"+price+"\t"+color);
			}
			System.out.println("\n총금액: "+total);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 연결 실패"+e.getMessage());
		}finally {
			//if문으로 예외 처리 상황을 명시하거나 NullPointerException 처리 해야 오류 방지 할 수 있다
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracleJdbc ex=new Ex1_OracleJdbc();
		ex.shopAllData();
	}

}
