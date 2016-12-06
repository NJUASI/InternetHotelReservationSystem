package businessLogic.promotionBL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.promotionBL.discountCalculation.DiscountCalculator;
import utilities.PreOrder;

public class MockPromotion extends DiscountCalculator {

	
	@Override
	public Iterator<Double> getDiscountInSpan(PreOrder preOrder) {

		List<Double> discounts = new ArrayList<Double>();
		discounts.add(0.8);
		discounts.add(0.9);
		return discounts.iterator();
	}
}
