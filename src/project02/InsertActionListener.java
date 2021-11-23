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
	ValueCheck vc = ValueCheck.getInstance();
	
	
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
					    	System.out.println("DB 추가 완료\n");
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
