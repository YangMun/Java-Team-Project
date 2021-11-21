package project02;

import com.ysu.dbconnection.DBConnection;
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ModelPrint extends JFrame{
	DefaultTableModel model;
	DBConnection con = new DBConnection();
	
	public ModelPrint(DefaultTableModel model) throws SQLException {
		this.model = model;
		
		Connection conn = con.getDBConn();
		String sql = "select * from studentinfo;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			String phoneno = rs.getString("phoneno");
			String arr[] = {name, address, phoneno};
			model.addRow(arr);
		}
		
		
	}
	
}
