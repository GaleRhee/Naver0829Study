package bit701.day0926;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DBConnect;

public class Ex2_SawonSwingCRUD extends JFrame{
	JTextField tfName,tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel,btnSearch,btnAll;
	
	DBConnect db=new DBConnect();
	
	public Ex2_SawonSwingCRUD() {
		// TODO Auto-generated constructor stub
		super("사원관리");
		this.setBounds(1000, 100, 450, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	

	private void setDesign() {
		// TODO Auto-generated method stub
		
		//상단
		tfName=new JTextField(4);
		tfScore=new JTextField(10);
		String[] cbTitle= {"여자","남자"};
		cbGender=new JComboBox<String>(cbTitle);
		String[] cbTitle1= {"홍보부","인사부","사업부","교육부","상담"};
		cbBuseo=new JComboBox<String>(cbTitle1);
		
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("name"));
		pTop.add(tfName);
		pTop.add(new JLabel("score"));
		pTop.add(tfScore);
		pTop.add(new JLabel("gender"));
		pTop.add(cbGender);
		pTop.add(new JLabel("buseo"));
		pTop.add(cbBuseo);
		
		this.add("North",pTop);
		
		
		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("조회");
		btnAll=new JButton("전체조회");
		
		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		
		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=tfName.getText();
				//이름이나 점수 입력 안 했을 경우
				if(name.length()==0)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "이름을 입력해 주세요");
					return;
				}
				
				int score=0;
				try {
					score=Integer.parseInt(tfScore.getText());
				} catch (Exception e2) {
					score=0;// 점수에 문자를 넣으면 그냥 0점으로
				}
					
				String gender=(String)cbGender.getSelectedItem();
				String buseo=(String)cbBuseo.getSelectedItem();
				
				if(score<0 ||score>100)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "점수는 0~100 사이 입력해주세요");
				}
				
				
				//db에 insert 하는 메서드 호출
				insertSawon(name, score, gender, buseo);
				//db로부터 다시 데이터를 가져와서 출력
				sawonSelectAll();
				//입력값 초기화
				tfName.setText("");
				tfScore.setText("");
			}
		});

		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 행 번호를 얻는다
				int row=table.getSelectedRow();
				System.out.println(row);//선택 안 했을 경우-1
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD.this, "삭제할 행을 선택해주세요");
					
				}else {
					//row 행의 0 번열이 num 값
					String num=table.getValueAt(row, 0).toString();
					deleteSawon(num);
					//삭제 후 데이터 다시 불러온다
					sawonSelectAll();
				}
			}
		});

		//조회
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//검색할 이름 입력 받기 
				String searchBuseo=JOptionPane.showInputDialog("검색할 부서를 입력 해주세요");
				System.out.println(searchBuseo);
				if(searchBuseo==null)
					return;//취소 누를 경우 이벤트 종료
				else
					searchSawon(searchBuseo);//이름이 포함된 모든 데이터 테이블에 출력
			}
		});
		
		//전체조회
		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sawonSelectAll();

			}
		});
		
		this.add("South", pBottom);
		
		//Center Table
		String[] title= {"num","name","score","gender","buseo"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		
		//초기 db 데이터 가져오기
		sawonSelectAll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_SawonSwingCRUD ex=new Ex2_SawonSwingCRUD();
	}
	
	//DB method
	//db에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void sawonSelectAll() {
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select * 
				from sawon 
				order by num desc
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
			
				
				//Vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				//테이블에 추가
				tableModel.addRow(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}

	}
	
	//db에 추가
	public void insertSawon(String name,int score,String gender, String buseo)
	{
		System.out.println(name);
		System.out.println(score);
		System.out.println(gender);
		System.out.println(buseo);
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql="""
				insert 
				into sawon
				values
				(null,
				?,
				?,
				?,
				?) 
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//? 3개 바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);//테이블 컬럼 순서대로 입력해야 함
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	
	
	//db 삭제하는 메서드
	public void deleteSawon(String num)
	{
		//System.out.println(num);
		
		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql="""
				delete 
				from sawon
				where
				num=?
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//1 개 바인딩
			pstmt.setString(1, num);
			
			//실행
			pstmt.execute();
			
//			int n=pstmt.executeUpdate();
//			if(n==0)
//				System.out.println("행이 없습니다");
//			else
//				System.out.println("삭제 되었습니다");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	
	public void searchSawon(String searchBuseo) 
	{
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select * 
				from sawon 
				where buseo like ?
				""";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+searchBuseo+"%");
			rs=pstmt.executeQuery();

			while(rs.next()) 
			{
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");

				//Vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);

				//테이블에 추가
				tableModel.addRow(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);

		}
		
	}

}















