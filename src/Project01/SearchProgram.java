package Project01;

// 추가 해보기
// 추가 실험

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchProgram extends JFrame{
	private String colNames[] = {"이름", "주소", "전화번호"};
	
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5);
	
	public SearchProgram() {
		setTitle("연락처 검색 프로그램");
		setPreferredSize(new Dimension(450,200));
		setLocation(500, 400);
		Container c = getContentPane();
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton findButton = new JButton("검색");
		
		panel.add(new JLabel("이름"));
		panel.add(nameText);
		
		panel.add(new JLabel("주소"));
		panel.add(addressText);
		
		panel.add(new JLabel("전화번호"));
		panel.add(phonenoText);
		
		panel.add(findButton);

		c.add(panel, BorderLayout.NORTH);
		
	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SearchProgram();
	}

}
