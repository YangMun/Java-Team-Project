package project02;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TextSetActionListener extends MouseAdapter{
	JTable table;
	JTextField text[];
	
	TextSetActionListener(JTable table, JTextField text[]) {
		this.table=table;
		this.text=text;
	}
	
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		TableModel data = table.getModel();
		if (row!=-1){
			// 테이블에서 선택한 jumin, name, address, phoneno 값 가져옴. text로 묶어서 전달.
			String juminSetText = (String)data.getValueAt(row, 0);
			String nameSetText = (String)data.getValueAt(row, 1);
			String addressSetText = (String)data.getValueAt(row, 2);
			String phonenoSetText = (String)data.getValueAt(row, 3);
			String textSet[] = {juminSetText, nameSetText, 
					addressSetText, phonenoSetText};
			
			for(int i=0; i<text.length; i++) {
				text[i].setText(textSet[i]);;
			}
		}
	}
}
