package project02;

import com.ysu.dbconnection.DBConnection;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DBCProgramAction implements ActionListener{
	DBConnection con = new DBConnection();
	Manager mainframe = new Manager();
	JButton btn;
	
	public DBCProgramAction(JButton btn) {
		this.btn = btn;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(btn.getText().equals("연결")) {
			if(con.getDBConn()!=null) {
				mainframe.setVisible(true);
				btn.setText("해제");
			}else {
				System.out.println("DB 연결에 실패했습니다.");
			}
		}else {
			mainframe.setVisible(false);
			btn.setText("연결");
		}
		
	}
	
}
