package project02;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class UpdateActionListener extends MouseAdapter {
	JTable table;
	DefaultTableModel model;
	UpdateActionListener(DefaultTableModel model, JTable table) {
		this.table = table;
		this.model = model;
	}
	public void mouseClicked(MouseEvent e) {
		//해당 row를 더블 클릭시 아래의 if문 참.
		if(e.getClickCount()>1) {
			// row는 테이블의 선택한 열을 가져옴. data는 테이블의 모델을 가져옴.
			int row = table.getSelectedRow();
    		if (row!=-1){
    			// 테이블에서 선택한 jumin, name, address, phoneno 값 가져옴. text로 묶어서 전달.
    			String juminSetText = (String)table.getValueAt(row, 0);
    			String nameSetText = (String)table.getValueAt(row, 1);
    			String addressSetText = (String)table.getValueAt(row, 2);
    			String phonenoSetText = (String)table.getValueAt(row, 3);
    			String text[] = {juminSetText, nameSetText, 
    					addressSetText, phonenoSetText};
    			new UpdateActionForm(model, text);
    		}
    		
		}
	}
}

