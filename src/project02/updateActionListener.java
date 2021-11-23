package project02;

import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ysu.dbconnection.DBConnection;

public class updateActionListener implements ActionListener {
		private Connection conn=null;
		private PreparedStatement pstmt=null;
		private ResultSet rs = null;
		
		DBConnection con = new DBConnection();
		JTextField jumin, name, address, phoneno;
		JTextField text[];
		DefaultTableModel model;
		ValueCheck vc = ValueCheck.getInstance();
		
		updateActionListener(DefaultTableModel model, JTextField text[]) {
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
	        	
	        	String sql= "UPDATE studentinfo SET jumin =?, name=?, address=?, phoneno=? WHERE jumin=?"; 
		       	pstmt=conn.prepareStatement(sql); 
		       	
		       	pstmt.setString(1, jumin.getText());
		       	pstmt.setString(2, name.getText());
		       	pstmt.setString(3, address.getText()); 
		        pstmt.setString(4, phoneno.getText());
		        pstmt.setString(5, jumin.getText()); 
		        
		        int check = vc.phoneCheck(phoneno); //휴대전화 정규식 체크를 위한 확인
		        if(check == 1)
		        {
		        	pstmt.executeUpdate();
			        new ModelPrint(model);
			    	System.out.println("DB 변경 완료\n");
		        }
		        else
		        {
		        	System.out.println("전화번호가 조건에 맞지 않습니다.");
		        }
		    	
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
