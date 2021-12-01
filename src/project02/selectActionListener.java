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
	String arr [] = {"jumin", "name", "address", "phoneno"};
	
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
