package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogicService.orderBLService.CommonOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.HotelEvaluationPO;
import po.OrderGeneralPO;
import utilities.OrderState;
import utilities.UserType;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy Harvey
 * updateTime 2016/12/8
 *
 */
public class CommonOrder implements CommonOrderBLService {

	private OrderDataService orderDataService;

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

	/**
	 * @Description:酒店工作人员/客户查看各自订单,全部订单及处于不同订单状态的订单
	 * @param userID
	 * @param userType
	 * @param orderState
	 * void
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 上午2:26:44
	 */
	public Iterator<OrderGeneralVO> getOrderGenerals(String userID, UserType userType, OrderState orderState) {
		List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		List<OrderGeneralPO> orderGeneralPOs = null;

		try {
			if(userType == UserType.GUEST){
				orderGeneralPOs = orderDataService.getAllGuestOrderGeneral(userID);
			}
			else{
				orderGeneralPOs = orderDataService.getAllHotelOrderGeneral(userID);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		//当订单状态不为空时，返回对应状态的订单
		if(orderState == null){
			for(OrderGeneralPO po: orderGeneralPOs){
				result.add(new OrderGeneralVO(po));
			}
		}
		else{
			for(OrderGeneralPO po: orderGeneralPOs){
				if(po.getState() == orderState){
					result.add(new OrderGeneralVO(po));
				}
			}
		}

		return result.iterator();
	}

	/**
	 * @author charles
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<已执行／未执行>订单时，客户的编号
	 * @return 客户个人<已执行／未执行>订订单
	 * 
	 * <<已执行／未执行>只包含一种
	 */
	public Iterator<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean hasCommented) {
		final Iterator<OrderGeneralVO> orderGenerals = getOrderGenerals(guestID,UserType.GUEST,null);

		while(orderGenerals.hasNext()){
			if(!orderGenerals.next().hasCommented){
				orderGenerals.remove();
			}
		}
		return orderGenerals;
	}

}
