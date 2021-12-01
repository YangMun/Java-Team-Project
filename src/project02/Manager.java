package project02;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class Manager extends JFrame{
	private String colNames[] = {"주민번호","이름", "주소", "전화번호"};
	
	private JTextField juminText = new JTextField(10);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(15);
	private JTextField phonenoText = new JTextField(8);
	
	// table의 각 데이터들 수정 불가 설정. 
	private DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	JTextField text[] = {juminText, nameText, addressText, phonenoText};
	
	public Manager() {
		setTitle("학생정보관리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(890,300));
		setLocation(500, 200);
		Container c = getContentPane();

		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton select = new JButton("검색"); 
		JButton insert = new JButton("추가"); 
		JButton delete = new JButton("삭제"); 
		JButton reset = new JButton("리셋");
		
		for(int i = 0; i<colNames.length; i++)
		{
			panel.add(new JLabel(colNames[i]));
			panel.add(text[i]);
		}
		panel.add(select);
		panel.add(insert);
		panel.add(delete);
		panel.add(reset);
		c.add(panel, BorderLayout.NORTH);
		
		
		table.addMouseListener(new TextSetActionListener(table, text)); // Row 클릭시 값을 전달하기 위한 이벤트
		reset.addActionListener(new TextReset(text)); // JTextField 초기화
		
		//select, insert, update, delete
		select.addActionListener(new selectActionListener(model, text));
		insert.addActionListener(new InsertActionListener(model, text));
		table.addMouseListener(new UpdateActionListener(model, table));
		delete.addActionListener(new deleteActionListener(model, text));
		pack();
		setVisible(false);
	}
}