package project02;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.ysu.dbconnection.DBConnection;

public class updateActionListener implements ActionListener {
		private Connection conn=null;
		private PreparedStatement pstmt=null;
		private ResultSet rs = null;
	
		DBConnection con = new DBConnection();
		JTextField name, address, phoneno;
		JTextField text[];
		DefaultTableModel model;
	
		updateActionListener(DefaultTableModel model, JTextField text[]) {
			this.model = model;
			this.text = text;
		}
		
		public void actionPerformed(ActionEvent e) {
			
	        try {
	        	Connection conn = con.getDBConn();
	        	
	        	name = text[0];
	        	address = text[1];
	        	phoneno = text[2];
	        	
	        	String sql= "UPDATE studentinfo SET name=?, address=?, phoneno=? WHERE name=?"; 
		       	pstmt=conn.prepareStatement(sql); 
		       	
		       	
		       	pstmt.setString(1, name.getText());
		       	pstmt.setString(2, address.getText()); 
		        pstmt.setString(3, phoneno.getText());
		        pstmt.setString(4, name.getText()); 
		        
		        pstmt.executeUpdate();
		        new ModelPrint(model);
		        
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
