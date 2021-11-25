package project02;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.ysu.dbconnection.DBConnection;

import CheckValue.ValueCheck;

public class UpdateAction implements ActionListener {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	DBConnection con = new DBConnection();
	JTextField jumin, name, address, phoneno;
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
        	
        	jumin = text[0];
        	name = text[1];
        	address = text[2];
        	phoneno = text[3];
        	
        	String sql= "UPDATE studentinfo SET name=?, address=?, phoneno=? WHERE jumin=?"; 
	       	pstmt=conn.prepareStatement(sql); 
	       	for(int i = 1 ; i<text.length ;i++)
	       		pstmt.setString(i, text[i].getText()); //text[1] = name, text[2] = address, text[3] = phoneno
	        pstmt.setString(4, jumin.getText());
	        
	        int jCheck = vc.juminCheck(jumin); // 주민번호 정규식 체크를 위한 확인
	        int nCheck = vc.nameCheck(name); // 이름 정규식 체크를 위한 확인
	        int pCheck = vc.phoneCheck(phoneno); //휴대전화 정규식 체크를 위한 확인
	        if(jCheck == 1)
	        {
	        	if(nCheck == 1)
	        	{
	        		if(pCheck == 1)
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
	        	else
	        	{
	        		System.out.println("이름이 조건에 맞지 않습니다.");
	        	}
	        }
	        else
	        {
	        	System.out.println("주민번호가 조건에 맞지 않습니다.");
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
