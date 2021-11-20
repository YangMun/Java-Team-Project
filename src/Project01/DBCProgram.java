package Project01;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DBCProgram extends JFrame{

	public DBCProgram() {
		setTitle("데이터베이스 커넥션");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("연결");
		c.add(btn);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchProgram();
			}
		});
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DBCProgram();
	}

}
