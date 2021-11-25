package project02;

import javax.swing.*;
import java.awt.event.*;

public class TextReset implements ActionListener{
	JTextField text[];
	
	TextReset(JTextField text[]) {
		this.text=text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<text.length;i++) {
			text[i].setText("");
		}
	}
}
