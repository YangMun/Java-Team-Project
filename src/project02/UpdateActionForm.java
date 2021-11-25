package project02;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

//새로운 창을 띄워주는 클래스
public class UpdateActionForm extends JFrame{
	String text[];
	DefaultTableModel model;
	JFrame frame = new JFrame();
	JButton update = new JButton("변경");
	JPanel panel = new JPanel();
	
	private JTextField juminText = new JTextField(5);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5);
	
	String label[] = {"주민번호", "이름", "주소", "전화번호"}; // 라벨 명
	String arr [] = {"jumin", "name", "address", "phoneno"}; // 배열로 적어 아래에서 또 적기 위함을 방지
	JTextField tf[] = {juminText, nameText, addressText, phonenoText}; // JTextField 배열에 넣기
	
	public UpdateActionForm(DefaultTableModel model, String text[]) {
		this.model = model;
		this.text = text;
		
		frame.setTitle("정보 변경");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		frame.setLayout(new GridLayout(5, 4, -50, 5));
		
		//받아온 text의 값은 현재 String으로 해당 클래스에서 생성한 JTextField에 값을 넣어줌.
		for(int i = 0; i<label.length; i++) //arr 과 label 사이즈가 같기에 아무거나 사용해도 무관
		{
			arr[i] = text[i];
			frame.add(new JLabel(label[i]));
			frame.add(tf[i]);
			tf[i].setText(arr[i]);
			
		}
		juminText.setEditable(false);
		/*
		String jumin = text[0];
		String name = text[1];
		String address = text[2];
		String phoneno = text[3];
		
		add(new JLabel("주민번호"));
		add(juminText);
		juminText.setText(jumin);
		juminText.setEditable(false);;
		
		add(new JLabel("이름"));
		add(nameText);
		nameText.setText(name);
		
		add(new JLabel("주소"));
		add(addressText);
		addressText.setText(address);
		
		add(new JLabel("전화번호"));
		add(phonenoText);
		phonenoText.setText(phoneno);
		*/
		
		// 그리드 위치조정으로 인해 빈 라벨하나를 추가함.
		frame.add(new JLabel());
		frame.add(panel);
		panel.add(update); //변경 버튼
		
		//현재 값을 변경한 JTextField 타입의 jf배열을 넘겨줌.
		update.addActionListener(new UpdateAction(model, tf, frame));
		frame.setSize(200,220);
		frame.setVisible(true);
	}
}
