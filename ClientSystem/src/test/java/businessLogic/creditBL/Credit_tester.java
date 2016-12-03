package businessLogic.creditBL;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.GuestVO;
import vo.MarketVO;

public class Credit_tester {

	@Test
	public void test1() {
		//test cooperation with class User & Market
		//test interface getBasicInfo(String guestID)
		CreditController controller = CreditController.getInstance();
		
		BasicInfoVO userBasicInfoVO = controller.getBasicInfo("1234567890");
		GuestVO guestVO = userBasicInfoVO.guestVO;
		
		assertEquals("1234567890", guestVO.userID);
		assertEquals("000000", guestVO.password);
		assertEquals(LocalDate.of(1996, 4, 1), guestVO.birthday);
		assertEquals("school", guestVO.enterprise);
		assertEquals("zhangsan", guestVO.name);
		assertEquals("xiaosan", guestVO.nickName);
		assertEquals(100, guestVO.credit, 0);
		assertEquals("13523456789", guestVO.phone);
		
	    assertEquals(userBasicInfoVO.memberDegree, "Lv1");
	}
	
	@Test
	public void test2() {
		//test cooperation with class User
		//test interface charge(String guestID, int chargeNum)
		CreditController controller = CreditController.getInstance();
	    
	    assertEquals(ResultMessage.SUCCESS, controller.charge("1234567890", 100));
	}
	
	@Test
	public void test3() {
		//test cooperation with class User
		//test interface getAllCreditDetail(String guestID)
		CreditController controller = CreditController.getInstance();
		List<CreditVO> list = controller.getAllCreditDetail("1234567890");
		CreditVO creditVO1 = list.get(0);
		CreditVO creditVO2 = list.get(1);
		CreditVO creditVO3 = list.get(2);
	
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
	
	@Test
	public void test4() {
		//test cooperation with class Market
		//test interface getMemberFormulation()
		CreditController controller = CreditController.getInstance();
	    
	    List<MarketVO> memberFormulationList = controller.getMemberFormulation();
	    MarketVO marketVO = memberFormulationList.get(0);
	    
	    assertEquals("Lv1", marketVO.marketName);
	    assertEquals(50, marketVO.marketCredit, 0);
	    assertEquals(0.9, marketVO.marketBenefit, 0);    
	}
	
//	
//	@Test
//	public void test1() {
//		//test method charge(int chargeNum)
//		CreditController controller = CreditController.getInstance();
//			
//	    assertEquals(controller.charge(200), ResultMessage.SUCCESS);
//	}
//	
//	@Test
//	public void test2() {
//		//test method getBasicInfo(String ID)
//		CreditController controller = CreditController.getInstance();
//		CreditVO creditVO = controller.getBasicInfo("1234567890");
//			
//	    assertEquals(creditVO.guestID, "1234567890");
//	    assertEquals(creditVO.time, "2016/1/1");
//	    assertEquals(creditVO.orderID, "123456789012");
//	    assertEquals(creditVO.credit, 100);
//	    assertEquals(creditVO.preCredit, 100);
//	    assertEquals(creditVO.reason, "undo");
//	    
//	}

}
