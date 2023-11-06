package personal.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import myshop.data.MyShopDto;
import mysql.db.DbConnect;
import simpleboard.data.SimpleBoardDto;

public class PersonalDao {
DbConnect db=new DbConnect();
	
	//검색 결과 출력
	public List<PersonalDto> getSearchProduct(String search)
	{
		
		List<PersonalDto> list=new Vector<PersonalDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from coffee 
				where name like ? 
				order by num
				""";			
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+search.trim()+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonalDto dto=new PersonalDto();//반드시 while 문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSize(rs.getString("Size"));
				dto.setAddday(rs.getTimestamp("addday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
			
			
		return list;
		
	}
	
	
	//Show All
	public List<PersonalDto> getShowAll()
	{
		
		List<PersonalDto> list=new Vector<PersonalDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from coffee 
				order by num
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonalDto dto=new PersonalDto();//반드시 while 문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSize(rs.getString("Size"));
				dto.setAddday(rs.getTimestamp("addday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		
		
		return list;
		
	}
	
	//By name
	public List<PersonalDto> getByName()
	{
		
		List<PersonalDto> list=new Vector<PersonalDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from coffee 
				order by name asc
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonalDto dto=new PersonalDto();//반드시 while 문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSize(rs.getString("Size"));
				dto.setAddday(rs.getTimestamp("addday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		
		
		return list;
		
	}
	
	//By Price
	public List<PersonalDto> getByPrice()
	{
		
		List<PersonalDto> list=new Vector<PersonalDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from coffee 
				order by price asc
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonalDto dto=new PersonalDto();//반드시 while 문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSize(rs.getString("Size"));
				dto.setAddday(rs.getTimestamp("addday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		
		
		return list;
		
	}
	
	//By size
	public List<PersonalDto> getBySize()
	{
		
		List<PersonalDto> list=new Vector<PersonalDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from coffee 
				order by size
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				PersonalDto dto=new PersonalDto();//반드시 while 문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setSize(rs.getString("Size"));
				dto.setAddday(rs.getTimestamp("addday"));
				//list 에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		
		
		return list;
		
	}
	
	//내용 보기
	public PersonalDto getData(String num)
	{
			PersonalDto dto=new PersonalDto();
			String sql="""
					select *
					from coffee
					where num=?
					""";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, num);
				//실행
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNum(rs.getInt("num"));
					dto.setName(rs.getString("name"));
					dto.setPhoto(rs.getString("photo"));
					dto.setPrice(rs.getInt("price"));
					dto.setContent(rs.getString("content"));
					dto.setSize(rs.getString("Size"));
					dto.setAddday(rs.getTimestamp("addday"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
				
			}
			
			return dto;
	}
		
	
}
