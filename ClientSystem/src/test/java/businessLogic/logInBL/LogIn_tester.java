package businessLogic.logInBL;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import vo.GuestVO;

public class LogIn_tester {

	
	@Test
	public void test5() {
		//test cooperation with class User
		//test interface guestSignUp(GuestVO guestVO)
		LogInController controller = LogInController.getInstance();
		
		GuestVO guestVO = new GuestVO("1234567890", LocalDate.of(1995, 4, 1), "school", "zhangsan", 
				"xiaosan", "000000", "13523456789", 100);
		GuestVO result = controller.guestSignUp(guestVO);
		assertEquals("1234567890", result.userID);
		assertEquals(100,result.credit,0);
	}

}
