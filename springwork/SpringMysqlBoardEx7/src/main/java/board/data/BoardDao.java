package board.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //bean �� �ڵ� ������ִ� Annotation : dao�� ���δ�
public class BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private String nameSpace="board.data.BoardDao.";
	
	//��ü ���� ��ȯ�ϴ� �޼���
	public int getTotalCount()
	{
		return session.selectOne(nameSpace+"totalCountOfBoard");
	}
	
	public void insertBoard(BoardDto dto)
	{
		session.insert(nameSpace+"insertBoard", dto);
	}
	
	public List<BoardDto> getAllDatas()
	{
		return session.selectList(nameSpace+"selectAllBoard");
	}
	
	
}
