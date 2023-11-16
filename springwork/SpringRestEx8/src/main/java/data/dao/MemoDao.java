package data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.dto.MemoDto;

@Repository
public class MemoDao {
	@Autowired
	private SqlSession session;
	
	private String namespace="data.dao.MemoDao.";
	
	public void insertMemo(MemoDto dto)
	{
		session.insert(namespace+"insertMemo", dto);
	}
	
	public List<MemoDto> getAllMemos()
	{
		return session.selectList(namespace+"selectAllMemos");
	}
}
