package project02;

import com.ysu.dbconnection.DBConnection;

import checkValue.ValueCheck;

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
		       	
		       	for(int i = 0; i<text.length;i++)
		       		pstmt.setString(i+1, text[i].getText()); //text[0]=jumin,[1]=name,[2]=address,[3]=phoneno
		       	

		        boolean jCheck = vc.juminCheck(jumin); // 주민번호 정규식 체크를 위한 확인
		        boolean nCheck = vc.nameCheck(name); // 이름 정규식 체크를 위한 확인
		        boolean pCheck = vc.phoneCheck(phoneno); //휴대전화 정규식 체크를 위한 확인
		        if(jCheck == true){
		        	if(nCheck == true){
		        		if(pCheck == true){
				        	pstmt.executeUpdate();
				        	for(int i=0; i<text.length;i++)
				        		text[i].setText("");
					        new ModelPrint(model);
					    	System.out.println("DB 변경 완료\n");
				        }else System.out.println("전화번호가 조건에 맞지 않습니다.");
		        	}else System.out.println("이름이 조건에 맞지 않습니다.");
		        }else System.out.println("주민번호가 조건에 맞지 않습니다.");
	        }  
	        catch(SQLException se) {
	        	System.out.println(se.getMessage());
	        }finally{
		       	 if(rs != null) 
		       	    try{rs.close();}catch(SQLException sqle){}
		       	 if(pstmt != null) 
		       		try{pstmt.close();}catch(SQLException sqle){}
		       	 if(conn != null) 
		       		try{conn.close();}catch(SQLException sqle){}
		         }
	    }    
}
