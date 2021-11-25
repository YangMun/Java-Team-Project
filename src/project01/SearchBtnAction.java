package project01;

import com.ysu.dbconnection.DBConnection;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchBtnAction implements ActionListener{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	DBConnection con = new DBConnection();
	DefaultTableModel model;
	JTextField text[];
	
	String arr [] = {"jumin", "name", "address", "phoneno"}; // 배열로 적어 아래에서 또 적기 위함을 방지
	// 해당 클래스를 호출하는 클래스에서 model 과 text를 받아옴.
	public SearchBtnAction(DefaultTableModel model, JTextField text[]) {
		this.model=model;
		this.text=text;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Connection conn = con.getDBConn();
			// sql문 작성
			String sql = "select * from studentinfo where jumin like ?"
					+ "and name like ? "
					+ "and address like ?"
					+ "and phoneno like ?;";
		
			// sql문에 %?% 형식으로 사용이 불가.
			// 예) name="%name%"과 같은 형식. name은 변수명 실제로는 value 값이 들어감.
			
			pstmt = conn.prepareStatement(sql);
			for(int i =0; i<arr.length; i++)
			{
				arr[i] = "%"+text[i].getText()+"%";
				pstmt.setString(i+1, arr[i]);
			}
			rs = pstmt.executeQuery();
			
			// sql문을 실행한 결과를 한 행씩 접근.
			while(rs.next()) {
				for(int i =0; i<arr.length; i++)
				{
					arr[i] = rs.getString(i + 1);
				}
				model.addRow(arr); //model.addRow(arr);
			}
		}catch (SQLException e1) {
			System.out.println("DB연결 실패");
		}
		finally{
	       	 if(rs != null) 
	       	    try{rs.close();}catch(SQLException sqle){}
	       	 if(pstmt != null) 
	       		try{pstmt.close();}catch(SQLException sqle){}
	       	 if(conn != null) 
	       		try{conn.close();}catch(SQLException sqle){}
	         }
	}
}
