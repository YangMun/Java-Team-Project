package project02;

import com.ysu.dbconnection.DBConnection;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class selectActionListener implements ActionListener {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	DBConnection con = new DBConnection();
	DefaultTableModel model;
	
	JTextField text[];
	
	selectActionListener(DefaultTableModel model, JTextField text[]) {
        this.model = model;
        this.text = text;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		model.setRowCount(0);
		try {
			Connection conn = con.getDBConn();
			String sql = "select * from studentinfo where name like ? "
					+ "and address like ?"
					+ "and phoneno like ?;";
		
			// sql문에 %?% 형식으로 사용이 불가.
			// 예) name="%name%"과 같은 형식. name은 변수명 실제로는 value 값이 들어감.
			String name = "%"+text[0].getText()+"%";
			String address = "%"+text[1].getText()+"%";
			String phoneno = "%"+text[2].getText()+"%";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, phoneno);
			
			rs = pstmt.executeQuery();
			
			// sql문을 실행한 결과를 한 행씩 접근.
			while(rs.next()) { 
				name = rs.getString("name");
				address = rs.getString("address");
				phoneno = rs.getString("phoneno");
				String arr[] = {name, address, phoneno};
				model.addRow(arr);
			}	
		}catch (SQLException e1) {
			System.out.println("DB연결 실패\n");
			System.out.print("사유 : " + e1.getMessage() + "\n");
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
