package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.Iterator;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.MockHotel;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.promotionBL.DiscountInSpan;
import businessLogic.promotionBL.MockPromotion;
import businessLogicService.orderBLService.GuestOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.GuestEvaluationPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.PreOrder;
import utilities.ResultMessage;
import utilities.UserType;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy Harvey
 * updateTime 2016/12/7
 *
 */
public class GuestOrder implements GuestOrderBLService {

	private OrderDataService orderDataService;

	private CommonOrder commonOrder;
	
	//hotel
	private HotelInfoOperation hotelInterface;
	
	//promotion
	private DiscountInSpan discountCalculator;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public GuestOrder() {
//		orderDataService = ClientRemoteHelper.getInstance().getOrderDataService();
		
		try {
			orderDataService = new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		discountCalculator = new MockPromotion();
		hotelInterface = new Hotel();
	}
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 若客户创建此订单，需要付的款项
	 */
	public double getTempPrice(OrderVO orderVO) {
		Iterator<Double> discountsInSpan = discountCalculator.getDiscountInSpan(new PreOrder(orderVO));
		final double prePrice = orderVO.previousPrice;
		double result = 0;
		while(discountsInSpan.hasNext()) {
			result += prePrice * discountsInSpan.next();
		}
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 */
	public ResultMessage createOrder(final OrderVO orderVO) {
		ResultMessage resultMessage = ResultMessage.ORDER_CREATE_FAILURE;
		
		//TODO fjj这里逻辑是不是有错？为什么不为null的时候还返回失败
		if (orderVO.orderGeneralVO.orderID != null && orderVO.orderGeneralVO.price != -1
				&& orderVO.checkInTime != null && orderVO.checkOutTime != null 
				&& orderVO.roomNumber != null && orderVO.score != -1 && orderVO.comment != null) {
			return resultMessage;
		}else {
			try {
				orderVO.orderGeneralVO.price = getTempPrice(orderVO);
				resultMessage = orderDataService.createOrder(new OrderPO(orderVO));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return resultMessage;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 */
	public ResultMessage undoNormalOrder(final String orderID) {
		ResultMessage resultMessage = ResultMessage.NORMAL_ORDER_UNDO_FAILURE;
		
		OrderState thisOrderState = commonOrder.getOrderDetail(orderID).orderGeneralVO.state;
		//TODO fjj注意：逻辑问题，为什么未执行订单不能撤销？
		if (thisOrderState != OrderState.UNEXECUTED) {
			return resultMessage;
		}else {
			try {
				resultMessage = orderDataService.undoNormalOrder(orderID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return resultMessage;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 */
	public ResultMessage addEvaluation(GuestEvaluationVO evaluationVO) {
		ResultMessage msg1 = ResultMessage.UPDATE_EVALUATION_FAILURE;
		
		ResultMessage msg2 = ResultMessage.HOTEL_SCORE_UPDATE_FAILURE;
		try {
			msg1 = orderDataService.addEvaluation(new GuestEvaluationPO(evaluationVO));
			hotelInterface = new MockHotel();
			msg2 = hotelInterface.scoreUpdate(evaluationVO.score);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (msg1 == ResultMessage.UPDATE_EVALUATION_SUCCESS && msg2 == ResultMessage.HOTEL_SCORE_UPDATE_SUCCESS) {
			return ResultMessage.UPDATE_EVALUATION_SUCCESS;
		}else {
			return ResultMessage.UPDATE_EVALUATION_FAILURE;
		}
		
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
		final Iterator<OrderGeneralVO> orderGenerals = commonOrder.getAllOrderGenerals(guestID,UserType.GUEST);

		while(orderGenerals.hasNext()){
			if(!orderGenerals.next().hasCommented){
				orderGenerals.remove();
			}
		}
		return orderGenerals;
	}
}
