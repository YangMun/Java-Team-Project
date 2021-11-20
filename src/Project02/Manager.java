package Project02;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Manager extends JFrame{
	private String colNames[] = {"이름", "주소", "전화번호"};
	
	private JTextField nameText = new JTextField( 5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5);

	JTextField text[] = {nameText, addressText, phonenoText};
	
	public Manager() {
		setTitle("학생정보관리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(700,200));
		setLocation(500, 200);
		Container c = getContentPane();
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton select = new JButton("검색"); // select 버튼
		JButton insert = new JButton("추가"); // insert 버튼
		JButton update = new JButton("변경"); // select 버튼
		JButton delete = new JButton("삭제"); // delete 버튼
		
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
		
		select.addActionListener(new selectActionListener(model, text));
		c.add(panel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Manager();
	}

}
