package project02;
// 정규식 체크 부분
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class ValueCheck {
	private String regex = "^0[123456][016789]?-\\d{4}-\\d{4}"; // \가 특수기호이므로 두번 해줘야 정상 작동

private static ValueCheck instance = new ValueCheck();
    
    public static ValueCheck getInstance() {
        return instance;
    }
    
    private ValueCheck() { }
    
    public int phoneCheck(JTextField phoneno) {
    	int x = 0;
    	 if(Pattern.matches(regex, (CharSequence) phoneno.getText()) == true) // 전화번호 정규식 적용
	        {
    		 x = 1;
	        }
	        else
	        {
	        	x = 0;
	        }
    	
		return x;
    	
    }
}
