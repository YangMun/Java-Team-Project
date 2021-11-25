package checkValue;
// 정규식 체크 부분
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class ValueCheck {
	private String regJumin ="^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$"; // 주민번호에 대한 정규식
	private String regPhone = "^0[123456][016789]?-\\d{4}-\\d{4}$"; // 휴대전화에 대한 정규식
	private String regName = "^[가-힣]+|[a-zA-Z]+$"; // 이름에 대한 정규식
	boolean check;
private static ValueCheck instance = new ValueCheck();
    
    public static ValueCheck getInstance() {
        return instance;
    }
    
    private ValueCheck() { }
    
    public boolean phoneCheck(JTextField phoneno) {
    	 if(Pattern.matches(regPhone, (CharSequence) phoneno.getText()) == true) // 전화번호 정규식 적용
	        {
    		 check = true;
	        }else{
	        	check = false;
	        }
		return check;
    	
    }
    
    public boolean juminCheck(JTextField jumin) {
   	 if(Pattern.matches(regJumin, (CharSequence) jumin.getText()) == true) // 전화번호 정규식 적용
   	 	{
		 check = true;
        }else{
        	check = false;
        }
	return check;
    	
    }
    
    public boolean nameCheck(JTextField name) {
   	 if(Pattern.matches(regName, (CharSequence) name.getText()) == true) // 전화번호 정규식 적용
   	 	{
		 check = true;
        }else{
        	check = false;
        }
	return check;
    	
    }
}
