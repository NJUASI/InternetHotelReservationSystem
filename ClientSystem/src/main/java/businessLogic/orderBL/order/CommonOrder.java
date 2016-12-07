package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.promotionBL.DiscountInSpan;
import businessLogic.promotionBL.MockPromotion;
import businessLogicService.orderBLService.CommonOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.HotelEvaluationPO;
import vo.HotelEvaluationVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public class CommonOrder implements CommonOrderBLService {

	private OrderDataService orderDataService;

	private HotelInfoOperation hotelInterface;
	private DiscountInSpan discountCalculator;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public CommonOrder() {
//		orderDataService = ClientRemoteHelper.getInstance().getOrderDataService();
		
		try {
			orderDataService = new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		discountCalculator = new MockPromotion();
		//hotel的协作类需要hotelID，故在此不能初始化
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 用户当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 */
	public OrderVO getOrderDetail(final String orderID) {
		OrderVO thisOrderVO = null;
		
		try {
			thisOrderVO = new OrderVO(orderDataService.getOrderDetail(orderID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return thisOrderVO;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店工作人员／客户查看酒店的评论
	 * @return 此酒店的所有评价
	 */
	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
		final List<HotelEvaluationVO> result = new ArrayList<HotelEvaluationVO>();
		
		List<HotelEvaluationPO> hotelEvaluationPOs = null;
		try {
			hotelEvaluationPOs = orderDataService.getEvaluations(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (hotelEvaluationPOs != null) {
			for (int i = 0; i < hotelEvaluationPOs.size(); i++) {
				result.add(new HotelEvaluationVO(hotelEvaluationPOs.get(i)));
			}
		}
		
		return result.iterator();
	}
}
