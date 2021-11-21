package project02;

import com.ysu.dbconnection.DBConnection;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;


public class InsertActionListener implements ActionListener {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;
	
	DBConnection con = new DBConnection();
	JTextField nameText, addressText, phonenoText; //JTextField 생성
	DefaultTableModel model; //model 가져와 하나로 공유하기 위함

	InsertActionListener(DefaultTableModel model, JTextField nameText, JTextField addressText, JTextField phonenoText) {
		this.model = model;
		this.nameText = nameText;
		this.addressText = addressText;
		this.phonenoText = phonenoText;
		}
		public void actionPerformed(ActionEvent e) {
	        try {
	        	Connection conn = con.getDBConn();
	        	
	        	String sql= "INSERT INTO studentinfo VALUES(?, ?, ?)"; 
		       	pstmt=conn.prepareStatement(sql); 
     	
		       	pstmt.setString(1, nameText.getText()); //name으로 들어감
		        pstmt.setString(2, addressText.getText()); //address로 들어감
		        pstmt.setString(3, phonenoText.getText()); //phoneno로 들어감
		       	 
		        pstmt.executeUpdate();
		    	
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
