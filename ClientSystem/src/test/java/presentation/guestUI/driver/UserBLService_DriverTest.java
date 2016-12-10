package presentation.guestUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.userBL.stub.UserBLService_Stub;
import presentation.webManagerUI.driver.UserBLService_Driver;
import utilities.enums.UserType;
import vo.GuestVO;
import vo.UserVO;

public class UserBLService_DriverTest {

	@Test
	public void test1() {
		// test interface getSingle
		UserBLService_Stub stub = new UserBLService_Stub();
		UserBLService_Driver driver = new UserBLService_Driver(stub);
		UserVO guestVO = new GuestVO("1234567890", LocalDate.of(1996, 4, 1), "school", "zhangsan", "xiaosan",
				"000000", "13523456789", 100); 
		guestVO = driver.userBLService.add(guestVO , UserType.GUEST);
		assertEquals(guestVO.userID, "1234567890");
	}
}
