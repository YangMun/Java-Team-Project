package Project01;

import com.ysu.dbconnection.DBConnection;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchBtnAction implements ActionListener{
	DBConnection con = new DBConnection();
	DefaultTableModel model;
	JTextField text[];
	
	// 해당 클래스를 호출하는 클래스에서 model 과 text를 받아옴.
	public SearchBtnAction(DefaultTableModel model, JTextField text[]) {
		this.model=model;
		this.text=text;
	}

	public void actionPerformed(ActionEvent e) {
		//model 객체를 불러올 때 무조건 열의 수를 0으로 초기화..
		model.setRowCount(0);
		try {
			Connection conn = con.getDBConn();
			// sql문 작성
			String sql = "select * from studentinfo where name like ? "
					+ "and address like ?"
					+ "and phoneno like ?;";
		
			// sql문에 %?% 형식으로 사용이 불가.
			// 예) name="%name%"과 같은 형식. name은 변수명 실제로는 value 값이 들어감.
			String name = "%"+text[0].getText()+"%";
			String address = "%"+text[1].getText()+"%";
			String phoneno = "%"+text[2].getText()+"%";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setString(3, phoneno);
			
			ResultSet rs = pstmt.executeQuery();
			
			// sql문을 실행한 결과를 한 행씩 접근.
			while(rs.next()) { 
				name = rs.getString("name");
				address = rs.getString("address");
				phoneno = rs.getString("phoneno");
				String arr[] = {name, address, phoneno};
				model.addRow(arr);
			}
			
		} catch (SQLException e1) {
			System.out.println("DB연결 실패");
		}
		
	}
}
