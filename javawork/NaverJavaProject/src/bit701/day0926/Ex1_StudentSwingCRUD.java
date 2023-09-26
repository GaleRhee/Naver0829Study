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
import oracle.jdbc.proxy.annotation.Pre;

public class Ex1_StudentSwingCRUD extends JFrame{
	JTextField tfName,tfPhone;
	JComboBox<String> cbBlood;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel,btnSearch,btnAll;

	DBConnect db=new DBConnect();

	public Ex1_StudentSwingCRUD() {
		// TODO Auto-generated constructor stub
		super("학생관리");
		this.setBounds(1000, 100, 500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}


	private void setDesign() {
		// TODO Auto-generated method stub

		//상단
		tfName=new JTextField(4);
		tfPhone=new JTextField(10);
		String[] cbTitle= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(cbTitle);

		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("전화"));
		pTop.add(tfPhone);
		pTop.add(new JLabel("혈액형"));
		pTop.add(cbBlood);

		this.add("North",pTop);


		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("검색");
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
				String phone=tfPhone.getText();
				String blood=(String)cbBlood.getSelectedItem();
				if(name.length()==0 || phone.length()==0)
					return;


				//db에 insert 하는 메서드 호출
				insertStudent(name, phone, blood);
				//db로부터 다시 데이터를 가져와서 출력
				studentSelectAll();
				//입력값 초기화
				tfName.setText("");
				tfPhone.setText("");
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
					JOptionPane.showMessageDialog(Ex1_StudentSwingCRUD.this, "삭제할 행을 선택해주세요");

				}else {
					//row 행의 0 번열이 num 값
					String num=table.getValueAt(row, 0).toString();
					deleteStudent(num);
					//삭제 후 데이터 다시 불러온다
					studentSelectAll();
				}
			}
		});

		//조회
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//검색할 이름 입력 받기 
				String searchName=JOptionPane.showInputDialog("검색할 이름을 입력 해주세요");
				System.out.println(searchName);
				if(searchName==null)
					return;//취소 누를 경우 이벤트 종료
				else
					searchStudent(searchName);//이름이 포함된 모든 데이터 테이블에 출력
			}
		});

		//전체조회
		btnAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				studentSelectAll();

			}
		});

		this.add("South", pBottom);

		//Center Table
		String[] title= {"번호","이름","혈액형","전화","작성일"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));


		//초기 db 데이터 가져오기
		studentSelectAll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_StudentSwingCRUD ex=new Ex1_StudentSwingCRUD();
	}

	//DB method
	//db에서 전체 데이터를 가져와서 테이블에 출력하는 메서드
	public void studentSelectAll() {
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select * 
				from student 
				order by num desc
				""";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) {
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");

				Timestamp ts=rs.getTimestamp("writeday");
				String writeday=sdf.format(ts);

				//Vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(writeday);

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
	public void insertStudent(String name,String phone,String blood)
	{
		System.out.println(name);
		System.out.println(phone);
		System.out.println(blood);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql="""
				insert 
				into student
				values
				(null,
				?,
				?,
				?,
				now()) 
				""";

		try {
			pstmt=conn.prepareStatement(sql);
			//? 3개 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, blood);
			pstmt.setString(3, phone); //테이블 컬럼 순서대로 입력해야 함

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
	public void deleteStudent(String num)
	{
		//System.out.println(num);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		String sql="""
				delete 
				from student
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

	public void searchStudent(String searchName) 
	{
		//기존 테이블의 데이터를 모두 지운다
		tableModel.setRowCount(0);

		Connection conn=db.getMysqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="""
				select * 
				from student 
				where name like ?
				""";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+searchName+"%");
			rs=pstmt.executeQuery();

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			while(rs.next()) 
			{
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String blood=rs.getString("blood");
				String phone=rs.getString("phone");

				Timestamp ts=rs.getTimestamp("writeday");
				String writeday=sdf.format(ts);

				//Vector에 순서대로 추가한다
				data.add(num);
				data.add(name);
				data.add(blood);
				data.add(phone);
				data.add(writeday);

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















