package project02;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.Pattern;
// 부득이하게 예선님이 작성한 내용은 UpdateAction으로 옮겼습니다.
// 클래스명을 맞추기위해 옮겼으며, 바뀐 내용은 없습니다.
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
    		TableModel data = table.getModel();
    		if (row!=-1){
    			// 테이블에서 선택한 jumin, name, address, phoneno 값 가져옴. text로 묶어서 전달.
    			String juminSetText = (String)data.getValueAt(row, 0);
    			String nameSetText = (String)data.getValueAt(row, 1);
    			String addressSetText = (String)data.getValueAt(row, 2);
    			String phonenoSetText = (String)data.getValueAt(row, 3);
    			String text[] = {juminSetText, nameSetText, 
    					addressSetText, phonenoSetText};
    			new UpdateActionForm(model, text);
    		}
    		
		}
	}
}

