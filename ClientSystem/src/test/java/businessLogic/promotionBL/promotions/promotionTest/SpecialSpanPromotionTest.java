package businessLogic.promotionBL.promotions.promotionTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.promotions.SpecialSpanPromotion;

public class SpecialSpanPromotionTest {

	SpecialSpanPromotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new SpecialSpanPromotion();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDiscountOneday() {
		LocalDate today = LocalDate.of(2016, 11, 11);
		double discount =  promotion.getDiscountOneday("12345678",today);
		assertEquals(0.9*0.9,discount,0.01);
	}

}
