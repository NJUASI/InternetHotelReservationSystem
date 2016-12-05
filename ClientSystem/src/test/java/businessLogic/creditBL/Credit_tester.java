package businessLogic.creditBL;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.junit.Test;

import vo.CreditVO;

public class Credit_tester {

	@Test
	public void test3() {
		//test cooperation with class User
		//test interface getAllCreditDetail(String guestID)
		CreditController controller = CreditController.getInstance();
		Iterator<CreditVO> list = controller.getAllCreditDetail("1234567890");
		CreditVO creditVO1 = list.next();
		CreditVO creditVO2 = list.next();
		CreditVO creditVO3 = list.next();
	
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
	
}
