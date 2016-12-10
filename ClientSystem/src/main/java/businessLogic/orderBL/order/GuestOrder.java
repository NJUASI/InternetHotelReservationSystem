package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.MockHotel;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.promotionBL.DiscountInSpan;
import businessLogic.promotionBL.MockPromotion;
import businessLogicService.orderBLService.GuestOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import exception.verificationException.UserInexistException;
import po.GuestEvaluationPO;
import po.OrderPO;
import utilities.PreOrder;
import utilities.enums.OrderState;
import utilities.enums.ResultMessage;
import utilities.enums.UserType;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/10
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
		
		commonOrder = new CommonOrder();
		
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
		Iterator<Double> discountsInSpan = null;
		try {
			discountsInSpan = discountCalculator.getDiscountInSpan(new PreOrder(orderVO));
		} catch (UserInexistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * @updateTime 2016/12/8
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 */
	public ResultMessage createOrder(final OrderVO orderVO) {
		ResultMessage resultMessage = ResultMessage.FAIL;
		
		if (orderVO.orderGeneralVO.orderID == "" && orderVO.orderGeneralVO.price == -1
				&& orderVO.checkInTime == null && orderVO.checkOutTime == null 
				&& orderVO.roomNumber == "" && orderVO.score == -1 && orderVO.comment == "") {
			try {
				orderVO.orderGeneralVO.price = getTempPrice(orderVO);
				resultMessage = orderDataService.createOrder(new OrderPO(orderVO));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return resultMessage;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 */
	public ResultMessage undoNormalOrder(final String orderID) {
		ResultMessage msg1 = ResultMessage.FAIL;
		ResultMessage msg2 = ResultMessage.FAIL;
		
		OrderVO thisOrder = commonOrder.getOrderDetail(orderID);
		//撤销未执行订单，改变此订单状态
		final OrderState thisOrderState = thisOrder.orderGeneralVO.state;
		if (thisOrderState == OrderState.UNEXECUTED) {
			try {
				msg1 = orderDataService.undoNormalOrder(orderID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		//更新此订单撤销后的酒店剩余房间数
		/*
		 * new the mock one to test
		 */
		hotelInterface = new MockHotel();
		msg2 = hotelInterface.updateRemainRoomNumForUndoOrder(thisOrder.orderGeneralVO.hotelID, thisOrder.roomType, thisOrder.roomNumCount);
		if (msg1 == ResultMessage.SUCCESS && msg2 == ResultMessage.SUCCESS) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAIL;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 */
	public ResultMessage addEvaluation(GuestEvaluationVO evaluationVO) {
		ResultMessage msg1 = ResultMessage.FAIL;
		ResultMessage msg2 = ResultMessage.FAIL;
		
		try {
			msg1 = orderDataService.addEvaluation(new GuestEvaluationPO(evaluationVO));
			
			/*
			 * new the mock one to test
			 */
			hotelInterface = new MockHotel();
			msg2 = hotelInterface.scoreUpdate(evaluationVO.score);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (msg1 == ResultMessage.SUCCESS && msg2 == ResultMessage.SUCCESS) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.FAIL;
		}
		
	}

	/**
	 * @author charles
	 * @lastChangedBy Harvey
	 * @updateTime 2016/12/8
	 * @param guestID 客户要查看个人<已执行／未执行>订单时，客户的编号
	 * @return 客户个人<已执行／未执行>订订单
	 * 
	 * <<已执行／未执行>只包含一种
	 */
	public Iterator<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean hasCommented) {
		List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>(); 
		System.out.println("guestID: " + guestID);
		
		final Iterator<OrderGeneralVO> orderGenerals = commonOrder.getAllOrderGenerals(guestID, UserType.GUEST);

		while(orderGenerals.hasNext()){
			OrderGeneralVO thisOrderGeneral = orderGenerals.next();
			if(thisOrderGeneral.state == OrderState.EXECUTED && thisOrderGeneral.hasCommented == hasCommented){
				result.add(thisOrderGeneral);
			}
		}
		return result.iterator();
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/10
	 * @param guestID 客户编号
	 * @param hotelID 目标酒店编号
	 * @return 客户在目标酒店的所有订单记录
	 */
	public Iterator<OrderGeneralVO> getMyOrdersOfThisHotel(String guestID, String hotelID) {
		List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		final Iterator<OrderGeneralVO> orderGenerals = commonOrder.getAllOrderGenerals(guestID, UserType.GUEST);

		while(orderGenerals.hasNext()){
			OrderGeneralVO thisOrderGeneral = orderGenerals.next();
			if(thisOrderGeneral.hotelID.equals(hotelID)){
				result.add(thisOrderGeneral);
			}
		}
		return result.iterator();
	}
}
