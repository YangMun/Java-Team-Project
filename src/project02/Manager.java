package project02;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Manager extends JFrame{
	// static Manager은 DBCProgram에서 사용하기 위한 객체입니다.
	// static Manager manager = new Manager();
	private String colNames[] = {"주민번호","이름", "주소", "전화번호"};
	private JTextField juminText = new JTextField(5);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5); // 원래 phonenoTextText
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);

	JTextField text[] = {juminText, nameText, addressText, phonenoText};
	
	public Manager() {
		setTitle("학생정보관리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700,200));
		setLocation(500, 200);
		Container c = getContentPane();
		
		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton select = new JButton("검색"); // select 버튼
		JButton insert = new JButton("추가"); // insert 버튼
		JButton update = new JButton("변경"); // update 버튼
		JButton delete = new JButton("삭제"); // delete 버튼
		
		panel.add(new JLabel("주민번호"));
		panel.add(juminText);
		
		panel.add(new JLabel("이름"));
		panel.add(nameText);
		
		panel.add(new JLabel("주소"));
		panel.add(addressText);
		
		panel.add(new JLabel("전화번호"));
		panel.add(phonenoText);
		
		panel.add(select);
		panel.add(insert);
		panel.add(update);
		panel.add(delete);
		
		//테이블 클릭시 이벤트 발생.
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//해당 row를 클릭시 데이터 값은 JTextField jumin, name, address, phoneno로 들어감.
	        	int row = table.getSelectedRow();
	    		TableModel data = table.getModel();
	    		if (row!=-1){
	    			String juminSetText = (String)data.getValueAt(row, 0);
	    			String nameSetText = (String)data.getValueAt(row, 1);
	    			String addressSetText = (String)data.getValueAt(row, 2);
	    			String phonenoSetText = (String)data.getValueAt(row, 3);
	    			
	    			juminText.setText(juminSetText);
	    			nameText.setText(nameSetText);
	    			addressText.setText(addressSetText);
	    			phonenoText.setText(phonenoSetText);
	    		}
			}
		});
		
		select.addActionListener(new selectActionListener(model, text));
		insert.addActionListener(new InsertActionListener(model, text));
		update.addActionListener(new updateActionListener(model, text));
		delete.addActionListener(new deleteActionListener(model, text));
		c.add(panel, BorderLayout.NORTH);
		pack();
		// setVisible(false); DBCProgram으로 연결해보고 싶으면 아래와 주석 바꾸기!
		// 메인도 아예 다 지우셔야 합니다. 또 위의 static 쪽 주석처리 해제하시면 동작합니다.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Manager();
	}
}