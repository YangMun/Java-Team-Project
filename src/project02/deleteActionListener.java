package project02;

import com.ysu.dbconnection.DBConnection;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;


public class deleteActionListener implements ActionListener {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs = null;

	DBConnection con = new DBConnection();
	JTextField jumin; 
	JTextField text[];
	DefaultTableModel model; 

	deleteActionListener(DefaultTableModel model, JTextField text[]) {
		this.model = model;
		this.text = text;
		}
		public void actionPerformed(ActionEvent e) {
	        try {
	        	int choice = JOptionPane.showConfirmDialog(
	        			null, "정말 삭제하시겠습니까?", "삭제", 
	        			JOptionPane.YES_NO_OPTION,
	        			JOptionPane.WARNING_MESSAGE);
	        	
	        	Connection conn = con.getDBConn();
	        	
	        	if (choice==0) {
	        		jumin = text[0];

		        	String sql= "DELETE FROM studentinfo WHERE jumin=?"; 
			       	pstmt=conn.prepareStatement(sql); 
	     	
			       	pstmt.setString(1, jumin.getText());

			        pstmt.executeUpdate();
			        new ModelPrint(model);
			        
			        text[0].setEditable(true); // 삭제 후 jumin을 다시 편집 가능하도록 만들어줌
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
