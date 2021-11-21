package project02;

import java.awt.event.*;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ysu.dbconnection.DBConnection;

public class updateActionListener implements ActionListener {
		private Connection conn=null;
		private PreparedStatement pstmt=null;
		private ResultSet rs = null;
	
		DBConnection con = new DBConnection();
		JTextField nameText, addressText, phonenoText;
		DefaultTableModel model;
	
		updateActionListener(DefaultTableModel model, JTextField nameText, JTextField addressText, JTextField phonenoText) {
			this.model = model;
			this.nameText = nameText;
			this.addressText = addressText;
			this.phonenoText = phonenoText;
		}
		
		public void actionPerformed(ActionEvent e) {
			
	        try {
	        	Connection conn = con.getDBConn();
	        	
	        	String sql= "UPDATE studentinfo SET name=?, address=?, phoneno=? WHERE name=?"; 
		       	pstmt=conn.prepareStatement(sql); 
		       	 
		       	pstmt.setString(1, nameText.getText());
		       	pstmt.setString(2, addressText.getText()); 
		        pstmt.setString(3, phonenoText.getText());
		        pstmt.setString(4, nameText.getText()); 
		        
		        pstmt.executeUpdate();
		        
		    	System.out.println("DB 변경 완료\n");
	        }
                
	        catch(SQLException se) {
	        	System.out.println(se.getMessage());
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
