package checkValue;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ValueCheck {
	private String regJumin ="^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\"
			+ "-[1-4][0-9]{6}$"; // 주민번호에 대한 정규식
	private String regPhone = "^0[123456][016789]?-\\d{4}-\\d{4}$"; // 휴대전화에 대한 정규식
	private String regName = "^[가-힣]+|[a-zA-Z]+$"; // 이름에 대한 정규식
	boolean check = false;
	
private static ValueCheck instance = new ValueCheck();
    public static ValueCheck getInstance() {
        return instance;
    }
    
    public boolean check(JTextField phoneno, JTextField jumin, JTextField name) {
    	if(Pattern.matches(regJumin, (CharSequence) jumin.getText()) == true) { // 전화번호 정규식 적용
    		if(Pattern.matches(regName, (CharSequence) name.getText()) == true){ // 전화번호 정규식 적용
    			 if(Pattern.matches(regPhone, (CharSequence) phoneno.getText()) == true) { // 전화번호 정규식 적용
    				JOptionPane.showMessageDialog(null, "DB 변경 완료.");
    				check = true;
		        }else JOptionPane.showMessageDialog(null, "전화번호가 조건에 맞지 않습니다.");
        	}else JOptionPane.showMessageDialog(null,"이름이 조건에 맞지 않습니다.");
        }else JOptionPane.showMessageDialog(null,"주민번호가 조건에 맞지 않습니다.");
    	return check;
    }
}
