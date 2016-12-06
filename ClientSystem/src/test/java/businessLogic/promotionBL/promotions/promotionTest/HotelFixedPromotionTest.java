package businessLogic.promotionBL.promotions.promotionTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import businessLogic.promotionBL.promotions.HotelFixedPromotion;
import utilities.PreOrder;

public class HotelFixedPromotionTest {

	HotelFixedPromotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new HotelFixedPromotion();
	}

	@Test
	public void testGetDiscountOneday() {
		LocalDate start = LocalDate.of(2016, 2, 2);
		PreOrder preOrder = new PreOrder("1234567890","12345678",start,4,2);
		LocalDate today = LocalDate.of(2016, 2, 2);
		double discount = promotion.getDiscountOneday(preOrder, today);
		assertEquals(0.9*0.8*0.7,discount,0.1);
	}

}
