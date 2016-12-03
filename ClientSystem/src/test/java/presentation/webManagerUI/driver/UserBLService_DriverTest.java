package presentation.webManagerUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.userBL.stub.UserBLService_Stub;
import utilities.ResultMessage;
import vo.GuestVO;
import vo.UserVO;

public class UserBLService_DriverTest {

	@Test
	public void test1() {
		//test interface getSingle
		UserBLService_Stub stub = new UserBLService_Stub();
		UserBLService_Driver driver = new UserBLService_Driver(stub);
		UserVO guestVO = new GuestVO("1234567890", LocalDate.of(1996, 4, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789", 100);
		assertEquals(ResultMessage.SUCCESS, driver.userBLService.add(guestVO));
	}

	@Test
	public void test2() {
		//test interface modify
		UserBLService_Stub stub = new UserBLService_Stub();
		UserBLService_Driver driver = new UserBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.userBLService.modify(new UserVO("1234567890", "000000")));
	}

}
