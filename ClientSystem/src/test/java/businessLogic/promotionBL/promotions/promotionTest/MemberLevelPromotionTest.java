package businessLogic.promotionBL.promotions.promotionTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.promotions.MemberLevelPromotion;
import exception.verificationException.UserInexistException;

public class MemberLevelPromotionTest {

	MemberLevelPromotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new MemberLevelPromotion();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDiscount() {
		try {
			assertEquals(0, promotion.getDiscount("1234567890"),0.1);
		} catch (UserInexistException e) {
			e.printStackTrace();
		}
	}

}
