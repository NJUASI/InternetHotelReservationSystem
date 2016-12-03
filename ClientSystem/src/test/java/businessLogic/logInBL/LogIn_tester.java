package businessLogic.logInBL;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import utilities.ResultMessage;
import vo.GuestVO;

public class LogIn_tester {

	@Test
	public void test1() {
		//test cooperation with class User
		//test interface guestLogIn(String guest, String password)
		LogInController controller = LogInController.getInstance();
			
		assertEquals(ResultMessage.SUCCESS, controller.guestLogIn("1234567890", "123456"));
		assertEquals(ResultMessage.FAIL, controller.guestLogIn("1234567890", "000000"));
	}
	
	@Test
	public void test2() {
		//test cooperation with class User
		//test interface hotelWorkerLogIn(String hotelWorker, String password)
		LogInController controller = LogInController.getInstance();
			
		assertEquals(ResultMessage.SUCCESS, controller.hotelWorkerLogIn("12345678", "123456"));
		assertEquals(ResultMessage.FAIL, controller.hotelWorkerLogIn("12345678", "000000"));
	}
	
	@Test
	public void test3() {
		//test cooperation with class User
		//test interface webMarketerLogIn(String webMarketer, String password)
		LogInController controller = LogInController.getInstance();
			
		assertEquals(ResultMessage.SUCCESS, controller.webMarketerLogIn("123456", "123456"));
		assertEquals(ResultMessage.FAIL, controller.webMarketerLogIn("123456", "000000"));
	}
	
	@Test
	public void test4() {
		//test cooperation with class User
		//test interface webManagerLogIn(String webManager, String password)
		LogInController controller = LogInController.getInstance();
			
		assertEquals(ResultMessage.SUCCESS, controller.webManagerLogIn("1234", "123456"));
		assertEquals(ResultMessage.FAIL, controller.webManagerLogIn("1234", "000000"));
	}
	
	@Test
	public void test5() {
		//test cooperation with class User
		//test interface guestSignUp(GuestVO guestVO)
		LogInController controller = LogInController.getInstance();
		
		GuestVO guestVO = new GuestVO("1234567890", LocalDate.of(1995, 4, 1), "school", "zhangsan", 
				"xiaosan", "000000", "13523456789", 100);
			
		assertEquals(ResultMessage.SUCCESS, controller.guestSignUp(guestVO));
	}

}
