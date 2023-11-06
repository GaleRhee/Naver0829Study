package personal.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class ReviewsDao {
	DbConnect db= new DbConnect();
	
	public void insertReview(ReviewsDto dto) 
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="""
				insert into reviews
				values (null,?,?,?,now())
				""";
		
		try {

			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getProduct());
			pstmt.setString(3, dto.getContent());
			//실행
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	
	public void deleteReview(String idx)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="""
				delete from reviews
				where idx=?
				""";
		
		try {

			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, idx);
			//실행
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	
	public List<ReviewsDto> getReviews(String num)
	{
		List<ReviewsDto> list=new Vector<ReviewsDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select *
				from reviews
				where num=?
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ReviewsDto dto=new ReviewsDto();
				//dto.setIdx(rs.getString("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setProduct(rs.getString("product"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가
				list.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		
		return list;
	}
}



















