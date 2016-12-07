package businessLogicService.orderBLService;

import java.util.Iterator;

import vo.HotelEvaluationVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public interface CommonOrderBLService {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户／酒店工作人员／网站营销人员当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 */
	OrderVO getOrderDetail(String orderID);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * @param hotelID 客户／酒店工作人员查看酒店的评论
	 * @return 此酒店的所有评价
	 */
	Iterator<HotelEvaluationVO> getEvaluations(String hotelID);
}
