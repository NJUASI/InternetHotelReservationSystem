package businessLogic.promotionBL.promotions.promotionTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.promotions.SpecialCirclePromotion;

public class SpecialCirclePromotionTest {

	SpecialCirclePromotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new SpecialCirclePromotion();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDiscount() {
		assertEquals(0.9,promotion.getDiscount("123456780", "12345678"),0.1);
	}

}
