package presentation.webMarketerUI.driver;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import businessLogic.creditBL.stub.CreditBLService_Stub;
import utilities.ResultMessage;
import vo.GuestVO;

public class CreditBLService_DriverTest {

	@Test
	public void test1() {
		//test interface charge
		CreditBLService_Stub stub = new CreditBLService_Stub();
		CreditBLService_Driver driver = new CreditBLService_Driver(stub);
		assertEquals(ResultMessage.SUCCESS, driver.creditBLService.charge("1234567890", 100));
	
	}
	
	@Test
	public void test2() {
		//test interface getBasicInfo
		CreditBLService_Stub stub = new CreditBLService_Stub();
		CreditBLService_Driver driver = new CreditBLService_Driver(stub);
		
		GuestVO guestVO = driver.creditBLService.getBasicInfo("1234567890").guestVO;
		String MemberDegree = driver.creditBLService.getBasicInfo("1234567890").memberDegree;
		
		assertEquals(LocalDate.of(1995, 4, 1), guestVO.birthday);
		assertEquals("Samsung", guestVO.enterprise);
		assertEquals("Carol", guestVO.name);
		assertEquals("cal", guestVO.nickName);
		assertEquals("123456", guestVO.password);
		assertEquals("13555550000", guestVO.phone);
		assertEquals(400, guestVO.credit, 0);

		assertEquals("L1", MemberDegree);
	
	}

}
