package businessLogic.promotionBL;

import java.util.Iterator;

import utilities.PreOrder;

public interface DiscountInSpan {
	/**
	 * @Description 计算出在入住时间内，每天打的折扣
	 * @param preOrder
	 * @return
	 * Iterator<Double>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 上午2:01:44
	 */
	public Iterator<Double> getDiscountInSpan(PreOrder preOrder);
}
