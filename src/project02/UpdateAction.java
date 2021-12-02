package project02;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.ysu.dbconnection.DBConnection;

import checkValue.ValueCheck;

public class UpdateAction implements ActionListener {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	DBConnection con = new DBConnection();
	JFrame frame;
	JTextField jumin, name, address, phoneno;
	JTextField text[];
	DefaultTableModel model;
	ValueCheck vc = ValueCheck.getInstance();

	
	UpdateAction(DefaultTableModel model, JTextField text[], JFrame frame) {
		this.model = model;
		this.text = text;
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			Connection conn = con.getDBConn();
        	jumin = text[0];name = text[1];
        	address = text[2];phoneno = text[3];
        	
        	String sql= "UPDATE studentinfo SET name=?, address=?, phoneno=? WHERE jumin=?"; 
	       	pstmt=conn.prepareStatement(sql); 
	       	for(int i = 1 ; i<text.length ;i++)
	       		pstmt.setString(i, text[i].getText()); //text[1] = name, text[2] = address, text[3] = phoneno
	        pstmt.setString(4, jumin.getText());
	        
	        boolean check = vc.check(phoneno, jumin, name);
	        if (check==true) {
	        	pstmt.executeUpdate();
		        new ModelPrint(model);
		        frame.dispose();
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
