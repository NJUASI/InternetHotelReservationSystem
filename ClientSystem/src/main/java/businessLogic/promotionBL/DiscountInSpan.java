package businessLogic.promotionBL;

import java.util.Iterator;

import utilities.PreOrder;

public interface DiscountInSpan {
	public Iterator<Double> getDiscountInSpan(PreOrder preOrder);
}
