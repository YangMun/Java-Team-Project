package project02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class InsertActionListener implements ActionListener {
		JTextField name, address, phoneno;
		JTextField text[]; //JTextField 생성
		DefaultTableModel model;
		
		InsertActionListener(DefaultTableModel model, JTextField text[]) {
			this.text = text;
			this.model = model;
		}
		public void actionPerformed(ActionEvent e) {
			Connection conn = null;
			PreparedStatement ps = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "ysu","1234"); 
	        	String sql= "INSERT INTO studentinfo VALUES(?, ?, ?)"; 
		       	ps=conn.prepareStatement(sql); 
		       	
		       	name = text[0];
	        	address = text[1];
	        	phoneno = text[2];
		       	 
		       	ps.setString(1, name.getText()); //name으로 들어감
		       	ps.setString(2, address.getText()); //address로 들어감
		        ps.setString(3, phoneno.getText()); //phoneno로 들어감
		       	 
		       	ps.executeUpdate();
		       	
		    	System.out.println("DB 추가 완료\n");
		    	new ModelPrint(model);
	        }
                
	            
	        catch (ClassNotFoundException cnfe) {
	        	System.out.println("해당 클래스를 찾을 수 없습니다." +	cnfe.getMessage());
	        }
	        catch(SQLException se) {
	        	System.out.println(se.getMessage());
	        }
	        finally {
	        	try {
	        		ps.close();
	        	}
	        	catch (Exception ignored) {
	        	}
	        	try {
	        		conn.close();
	        	}
	        	catch (Exception ignored) {
	        	}
	        }
	    }    
}
