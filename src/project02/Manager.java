package project02;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class Manager extends JFrame{
	private String colNames[] = {"주민번호","이름", "주소", "전화번호"};
	private JTextField juminText = new JTextField(10);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(15);
	private JTextField phonenoText = new JTextField(8); // 원래 phonenoTextText
	// table의 각 데이터들 수정 불가 설정. 
	private DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
	
	String label[] = {"주민번호", "이름", "주소", "전화번호"}; // 라벨 명
	JTextField text[] = {juminText, nameText, addressText, phonenoText};
	
	public Manager() {
		setTitle("학생정보관리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(890,200));
		setLocation(500, 200);
		Container c = getContentPane();

		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton select = new JButton("검색"); // select 버튼
		JButton insert = new JButton("추가"); // insert 버튼
		JButton delete = new JButton("삭제"); // delete 버튼
		JButton reset = new JButton("리셋");
		
		for(int i = 0; i<label.length; i++)
		{
			panel.add(new JLabel(label[i]));
			panel.add(text[i]);
		}
		// 버튼이 3개이므로 for문에 적을 수 없습니다.
		panel.add(select);
		panel.add(insert);
		panel.add(delete);
		panel.add(reset);
		/*
		panel.add(new JLabel("주민번호"));
		panel.add(juminText);
		
		panel.add(new JLabel("이름"));
		panel.add(nameText);
		
		panel.add(new JLabel("주소"));
		panel.add(addressText);
		
		panel.add(new JLabel("전화번호"));
		panel.add(phonenoText);
		*/
		
		table.addMouseListener(new TextSetActionListener(table, text));
		reset.addActionListener(new TextReset(text));
		//select, insert, update, delete
		select.addActionListener(new selectActionListener(model, text));
		insert.addActionListener(new InsertActionListener(model, text));
		table.addMouseListener(new UpdateActionListener(model, table));
		delete.addActionListener(new deleteActionListener(model, text));
		c.add(panel, BorderLayout.NORTH);
		pack();
		setVisible(false);
	}
}