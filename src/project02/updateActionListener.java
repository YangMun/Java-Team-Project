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
		private String regex = "^0[123456][016789]?-\\d{4}-\\d{4}"; // \가 특수기호이므로 두번 해줘야 정상 작동
		
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
		        
		        if(Pattern.matches(regex, (CharSequence) phoneno.getText()) == true)
		        {
		        	pstmt.executeUpdate();
			        new ModelPrint(model);
			        
			    	System.out.println("DB 변경 완료\n");
		        }
		        else
		        {
		        	System.out.println("전화번호가 조건에 맞지 않습니다.");
		        	phoneno.selectAll();
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
