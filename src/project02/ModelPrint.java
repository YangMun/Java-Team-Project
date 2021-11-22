package project02;

import com.ysu.dbconnection.DBConnection;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ModelPrint extends JFrame{
	DefaultTableModel model;
	DBConnection con = new DBConnection();
	
	public ModelPrint(DefaultTableModel model) throws SQLException {
		this.model = model;
		model.setRowCount(0);
		
		Connection conn = con.getDBConn();
		String sql = "select * from studentinfo;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			String phoneno = rs.getString("phoneno");
			String jumin = rs.getString("jumin");
			String arr[] = {jumin, name, address, phoneno};
			model.addRow(arr);
		}
		
		
	}
	
}
