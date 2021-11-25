package checkValue;
// 정규식 체크 부분
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class ValueCheck {
	private String regJumin ="^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$"; // 주민번호에 대한 정규식
	private String regPhone = "^0[123456][016789]?-\\d{4}-\\d{4}$"; // 휴대전화에 대한 정규식
	private String regName = "^[가-힣]+|[a-zA-Z]+$"; // 이름에 대한 정규식
private static ValueCheck instance = new ValueCheck();
    
    public static ValueCheck getInstance() {
        return instance;
    }
    
    private ValueCheck() { }
    
    public int phoneCheck(JTextField phoneno) {
    	int x = 0;
    	 if(Pattern.matches(regPhone, (CharSequence) phoneno.getText()) == true) // 전화번호 정규식 적용
	        {
    		 x = 1;
	        }
	        else
	        {
	        	x = 0;
	        }
    	
		return x;
    	
    }
    
    public int juminCheck(JTextField jumin) {
    	int x = 0;
   	 if(Pattern.matches(regJumin, (CharSequence) jumin.getText()) == true) // 전화번호 정규식 적용
	        {
   		 x = 1;
	        }
	        else
	        {
	        	x = 0;
	        }
   	
		return x;
    	
    }
    
    public int nameCheck(JTextField name) {
    	int x = 0;
   	 if(Pattern.matches(regName, (CharSequence) name.getText()) == true) // 전화번호 정규식 적용
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