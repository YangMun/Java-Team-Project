package project02;

import com.ysu.dbconnection.DBConnection;
import java.awt.event.*;
import java.sql.*;
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
			String sql = "select * from studentinfo where jumin like ?"
					+ "and name like ? "
					+ "and address like ?"
					+ "and phoneno like ?;";
		
			// sql문에 %?% 형식으로 사용이 불가.
			// 예) name="%name%"과 같은 형식. name은 변수명 실제로는 value 값이 들어감.
			String jumin = "%"+text[0].getText()+"%";
			String name = "%"+text[1].getText()+"%";
			String address = "%"+text[2].getText()+"%";
			String phoneno = "%"+text[3].getText()+"%";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jumin);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phoneno);
			
			rs = pstmt.executeQuery();
			
			// sql문을 실행한 결과를 한 행씩 접근.
			while(rs.next()) {
				jumin = rs.getString("jumin");
				name = rs.getString("name");
				address = rs.getString("address");
				phoneno = rs.getString("phoneno");
				String arr[] = {jumin,name, address, phoneno};
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
