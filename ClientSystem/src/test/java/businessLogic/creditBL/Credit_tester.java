package businessLogic.creditBL;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import exception.operationFailedException.UpdateFaiedException;
import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;
import vo.CreditVO;

public class Credit_tester {

//	@Test
//	public void test1() {
//		//test cooperation with class User & Market
//		//test interface getBasicInfo(String guestID)
//		CreditController controller = CreditController.getInstance();
//		
//		BasicInfoVO userBasicInfoVO = controller.getBasicInfo("1234567890");
//		GuestVO guestVO = userBasicInfoVO.guestVO;
//		
//		assertEquals("1234567890", guestVO.userID);
//		assertEquals("000000", guestVO.password);
//		assertEquals(LocalDate.of(1996, 4, 1), guestVO.birthday);
//		assertEquals("school", guestVO.enterprise);
//		assertEquals("zhangsan", guestVO.name);
//		assertEquals("xiaosan", guestVO.nickName);
//		assertEquals(100, guestVO.credit, 0);
//		assertEquals("13523456789", guestVO.phone);
//		
//	    assertEquals(userBasicInfoVO.memberDegree, "Lv1");
//	}
//	
	@Test
	public void test2() {
		//test cooperation with class User
		//test interface charge(String guestID, int chargeNum)
		CreditController controller = CreditController.getInstance();
	    
	    try {
			assertEquals(ResultMessage.SUCCESS, controller.charge("1234567890", 100));
		} catch (UserInexistException e) {
			e.printStackTrace();
		} catch (UpdateFaiedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		//test cooperation with class User
		//test interface getAllCreditDetail(String guestID)
		CreditController controller = CreditController.getInstance();
		CreditVO creditVO1 =controller.getAllCreditDetail("1234567890").next();
		CreditVO creditVO2 = controller.getAllCreditDetail("1234567890").next();
		CreditVO creditVO3 = controller.getAllCreditDetail("1234567890").next();
	
	    assertEquals("1234567890", creditVO1.guestID);
	    assertEquals(LocalDateTime.of(2016, 10, 2, 18, 12), creditVO1.time);
	    assertEquals("123420161002", creditVO1.orderID);
	    assertEquals(100, creditVO1.previousCredit, 0);
	    assertEquals(100, creditVO1.afterCredit, 0);
	    assertEquals("undo", creditVO1.reason);
	    
	    assertEquals("1234567890", creditVO1.guestID);
	    assertEquals(LocalDateTime.of(2016, 10, 3, 13, 14), creditVO2.time);
	    assertEquals("124520161003", creditVO2.orderID);
	    assertEquals(100, creditVO2.previousCredit, 0);
	    assertEquals(100, creditVO2.afterCredit, 0);
	    assertEquals("create", creditVO2.reason);
	    
	    assertEquals("1234567890", creditVO1.guestID);
	    assertEquals(LocalDateTime.of(2016, 10, 4, 15, 22), creditVO3.time);
	    assertEquals("244520161004", creditVO3.orderID);
	    assertEquals(100, creditVO3.previousCredit, 0);
	    assertEquals(300, creditVO3.afterCredit, 0);
	    assertEquals("executed", creditVO3.reason);
	    
	}
	
//	@Test
//	public void test4() {
//		//test cooperation with class Market
//		//test interface getMemberFormulation()
//		CreditController controller = CreditController.getInstance();
//	    
//	    List<MarketVO> memberFormulationList = controller.getMemberFormulation();
//	    MarketVO marketVO = memberFormulationList.get(0);
//	    
//	    assertEquals("Lv1", marketVO.marketName);
//	    assertEquals(50, marketVO.marketCredit, 0);
//	    assertEquals(0.9, marketVO.marketBenefit, 0);    
//	}
}
