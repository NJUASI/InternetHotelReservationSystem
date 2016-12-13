package businessLogic.promotionBL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import vo.PreOrderVO;

public class MockPromotion extends DiscountCalculator {

	
	@Override
	public Iterator<Double> getDiscountInSpan(PreOrderVO preOrder) {

		List<Double> discounts = new ArrayList<Double>();
		discounts.add(0.8);
		discounts.add(0.9);
		return discounts.iterator();
	}
}
