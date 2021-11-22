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
	JTextField jumin, name, address, phoneno; //JTextField 생성
	JTextField text[];
	DefaultTableModel model; //model 가져와 하나로 공유하기 위함

	InsertActionListener(DefaultTableModel model, JTextField text[]) {
		this.model = model;
		this.text = text;
		}
		public void actionPerformed(ActionEvent e) {
	        try {
	        	Connection conn = con.getDBConn();
	        	
	        	jumin = text[0];
	        	name = text[1];
	        	address = text[2];
	        	phoneno = text[3];

	        	String sql= "INSERT INTO studentinfo VALUES(?, ?, ?, ?)"; 
		       	pstmt=conn.prepareStatement(sql); 
		       	
		       	pstmt.setString(1, jumin.getText()); //jumin으로 들어감
		       	pstmt.setString(2, name.getText()); //name으로 들어감
		        pstmt.setString(3, address.getText()); //address로 들어감
		        pstmt.setString(4, phoneno.getText()); //phoneno로 들어감

		        pstmt.executeUpdate();
		        new ModelPrint(model);

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
