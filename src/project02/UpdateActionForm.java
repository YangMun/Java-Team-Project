package project02;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
//새로운 창을 띄워주는 클래스
public class UpdateActionForm extends JFrame{
	String text[];
	DefaultTableModel model;
	JButton update = new JButton("변경");
	JPanel panel = new JPanel();
	
	private JTextField juminText = new JTextField(5);
	private JTextField nameText = new JTextField(5);
	private JTextField addressText = new JTextField(8);
	private JTextField phonenoText = new JTextField(5);
	
	public UpdateActionForm(DefaultTableModel model, String text[]) {
		this.model = model;
		this.text = text;
		
		setTitle("정보 변경");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 4, -50, 5));
		
		//받아온 text의 값은 현재 String으로 해당 클래스에서 생성한 JTextField에 값을 넣어줌.
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
		
		add(new JLabel());
		add(panel);
		panel.add(update);
		
		//현재 값을 변경한 JTextField 타입의 textGet배열을 넘겨줌.
		JTextField textGet[] = {juminText, nameText, addressText, phonenoText};
		update.addActionListener(new UpdateAction(model, textGet));
		
		setSize(200,220);
		setVisible(true);
		
	}
}
