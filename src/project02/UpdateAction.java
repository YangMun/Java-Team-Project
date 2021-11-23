package project02;

import java.awt.event.*;
import java.sql.*;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ysu.dbconnection.DBConnection;

public class UpdateAction implements ActionListener {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	DBConnection con = new DBConnection();
	String jumin, name, address, phoneno;
	JTextField text[];
	DefaultTableModel model;
	ValueCheck vc = ValueCheck.getInstance();
	
	UpdateAction(DefaultTableModel model, JTextField text[]) {
		this.model = model;
		this.text = text;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			Connection conn = con.getDBConn();
        	
        	jumin = text[0].getText();
        	name = text[1].getText();
        	address = text[2].getText();
        	phoneno = text[3].getText();
        	
        	String sql= "UPDATE studentinfo SET name=?, address=?, phoneno=? WHERE jumin=?"; 
	       	pstmt=conn.prepareStatement(sql); 
	       	
	       	pstmt.setString(1, name);
	       	pstmt.setString(2, address); 
	        pstmt.setString(3, phoneno);
	        pstmt.setString(4, jumin);     
	        
	        //값을 text[3]은 JTextField phonenoText를 가지고 있음.
	        int check = vc.phoneCheck(text[3]); //휴대전화 정규식 체크를 위한 확인
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
	    	
        }catch(SQLException se) {
        	System.out.println(se.getMessage());
        }finally {
	       	 if(pstmt != null) 
	       		try{pstmt.close();}catch(SQLException sqle){}
	       	 if(conn != null) 
	       		try{conn.close();}catch(SQLException sqle){}
	         }
	    }   
}
