package project01;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchProgram extends JFrame{
	private String colNames[] = {"주민번호","이름", "주소", "전화번호"};
	private JTextField juminText = new JTextField(5);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5);
	
	// table의 각 데이터들 수정 불가 설정. 
	private DefaultTableModel model = new DefaultTableModel(colNames, 0) {
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};
		
	JTextField text[] = {juminText, nameText, addressText, phonenoText};
	
	public SearchProgram() {
		setTitle("연락처 검색 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(750,200));
		setLocation(500, 400);
		Container c = getContentPane();
		
		JTable table = new JTable(model);
		c.add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JButton findButton = new JButton("검색");
		
		for(int i = 0; i<colNames.length; i++)
		{
			panel.add(new JLabel(colNames[i]));
			panel.add(text[i]);
		}
		
		panel.add(findButton);
		c.add(panel, BorderLayout.NORTH);
		
		findButton.addActionListener(new SearchBtnAction(model, text));
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SearchProgram();
	}

}
