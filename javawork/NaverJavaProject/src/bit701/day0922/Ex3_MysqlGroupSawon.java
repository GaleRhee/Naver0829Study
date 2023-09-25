package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3_MysqlGroupSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	public Ex3_MysqlGroupSawon() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 드라이버 실패:"+e.getMessage());
		}
	}
	
	public void sawonBunseok()
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="select buseo,count(*) count,max(score),min(score),avg(score) avgscore\r\n"
				+ "from sawon group by buseo;";
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("부서\t인원수\t최고점수 최저점수 평균");
			System.out.println("=".repeat(40));
			
			while(rs.next())
			{
				String buseo=rs.getString("buseo");
				int count=rs.getInt("count");
				int max=rs.getInt("max(score)");
				int min=rs.getInt("min(score)");
				Double avg=rs.getDouble("avgscore");
				
				System.out.println(buseo+"\t"+count+"\t"+max+"\t"+min+"\t"+avg);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 연결 실패:"+e.getMessage());
		}finally {
			//if문으로 예외 처리 상황을 명시하거나 NullPointerException 처리 해야 오류 방지 할 수 있다
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_MysqlGroupSawon ex=new Ex3_MysqlGroupSawon();
		ex.sawonBunseok();
	}

}
