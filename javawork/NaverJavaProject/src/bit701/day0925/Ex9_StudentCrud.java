package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import db.DBConnect;

public class Ex9_StudentCrud {
	
	DBConnect db=new DBConnect();
	Scanner sc=new Scanner(System.in);
	
	public int getMenu()
	{
		System.out.println("1.추가 2.삭제 3.수정 4.전체출력 5.검색 6.종료");
		int menu=Integer.parseInt(sc.nextLine());
		return menu;
		
	}
	
	
	//insert
	public void insertStudent() 
	{
		System.out.println("이름:");
		String name=sc.nextLine();
		System.out.println("혈액형:");
		String blood=sc.nextLine();
		System.out.println("전화번호:");
		String phone=sc.nextLine();
		
		String sql="""
				insert into student
				values
				(null,
				?,
				?,
				?,
				now()
				)
				
				""";
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());//대문자로 변환해서 넣기
			pstmt.setString(3, phone);

			//실행
			pstmt.execute();
			System.out.println("추가되었습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}	
	}
	
	//delete
	public void deleteStudent()
	{
		System.out.println("삭제할 학생 이름은?");
		String name=sc.nextLine();
		
		String sql="""
				delete 
				from student
				where name=?
				""";
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println("해당 이름을 찾을 수 없습니다");
			else
				System.out.println("삭제 되었습니다");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	
	//update
	public void updateStudent()
	{
		System.out.println("num :");
		int num=Integer.parseInt(sc.nextLine());
		System.out.println("이름:");
		String name=sc.nextLine();
		System.out.println("혈액형:");
		String blood=sc.nextLine();
		System.out.println("전화번호:");
		String phone=sc.nextLine();
		
		String sql="""
				update student
				set
				name=?,
				blood=?,
				phone=? 
				where num=?
				""";
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood.toUpperCase());//대문자로 변환해서 넣기
			pstmt.setString(3, phone);
			pstmt.setInt(4, num);

			//실행
			int n=pstmt.executeUpdate();
			if(n==0)
				System.out.println("해당 학생 번호가 없습니다");
			else
				System.out.println("수정되었습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}	
	}
		
	
	
	
	//전체 출력
	public void selectAllStudent()
	{
		String sql="""
				select *
				from student
				order by num
				""";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println(" 번호\t이름\t혈액형\t전화번호\t작성일");
			System.out.println("-".repeat(50));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				//String writeday=rs.getString("writeday");//날짜 타입도 String 타입으로 가져와도 된다
				Timestamp ts=rs.getTimestamp("writeday");
				
				//System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+ts.toLocaleString());
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+sdf.format(ts));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}
	
	//검색 - 번호 끝 4 자리로 검색
	public void searchPhone()
	{
		System.out.println("전화번호 끝 4 자리 입력하세요");
		String searchPhone=sc.nextLine();
		
		String sql="""
				select *
				from student
				where phone like?
				""";
		
//		String sql="""
//				select *
//				from student
//				where right(phone,4) like?
//				order by num
//				"""; //이것도 뒤에 4자리 추출
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getMysqlConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchPhone);
			rs=pstmt.executeQuery();
			
			System.out.println("전화번호 "+searchPhone+" 검색 결과");
			System.out.println(" 번호\t이름\t혈액형\t전화번호\t작성일");
			System.out.println("-".repeat(50));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");
				//String writeday=rs.getString("writeday");//날짜 타입도 String 타입으로 가져와도 된다
				Timestamp ts=rs.getTimestamp("writeday");
				
				//System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+ts.toLocaleString());
				System.out.println(num+"\t"+name+"\t"+blood+"\t"+phone+"\t"+sdf.format(ts));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex9_StudentCrud ex=new Ex9_StudentCrud();
		
		while(true)
		{
			System.out.println("-".repeat(40));
			int menu=ex.getMenu();
			System.out.println("-".repeat(40));
			switch(menu)
			{
			case 1:
				ex.insertStudent();
				break;
			case 2:
				ex.deleteStudent();
				break;
			case 3:
				ex.updateStudent();
				break;
			case 4: 
				ex.selectAllStudent();
				break;
			case 5:
				ex.searchPhone();
				break;
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}
	}

}
