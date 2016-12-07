package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.MockHotel;
import businessLogic.promotionBL.DiscountInSpan;
import businessLogic.promotionBL.MockPromotion;
import businessLogicService.orderBLService.GuestOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.GuestEvaluationPO;
import po.OrderGeneralPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.PreOrder;
import utilities.ResultMessage;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public class GuestOrder implements GuestOrderBLService {

	private OrderDataService orderDataService;

	private CommonOrder commonOrder;
	
	private HotelInfoOperation hotelInterface;
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
		//hotel的协作类需要hotelID，故在此不能初始化
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
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人所有订单时，客户的编号
	 * @return 客户个人所有订单
	 */
	public List<OrderGeneralVO> getAllGuestOrderGeneral(final String guestID) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllGuestOrderGeneral(guestID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (orderGeneralPOs != null) {
			for (int i = 0; i < orderGeneralPOs.size(); i++) {
				result.add(new OrderGeneralVO(orderGeneralPOs.get(i)));
			}
		}
		
		return result;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店工作人员要查看本酒店<所有某种特定类型>订单时，酒店的编号
	 * @return 此酒店<所有某种特定类型>的所有订单
	 * 
	 * <所有某种特定类型>包括：未执行、已执行、异常、已撤销
	 */
	public List<OrderGeneralVO> getAllGuestSpecialOrderGeneral(String guestID, OrderState expectOrderState) {
		final List<OrderGeneralVO> orderGeneralVOs = getAllGuestOrderGeneral(guestID);
		return orderStateFilter(orderGeneralVOs, expectOrderState);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<已执行／未执行>订单时，客户的编号
	 * @return 客户个人<已执行／未执行>订订单
	 * 
	 * <<已执行／未执行>只包含一种
	 */
	public List<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean hasCommented) {
		final List<OrderGeneralVO> orderGeneralVOs = getAllGuestOrderGeneral(guestID);
		
		List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		for (int i = 0; i < orderGeneralVOs.size(); i++) {
			OrderGeneralVO thisOrderGeneral = orderGeneralVOs.get(i);
			if (thisOrderGeneral.state == OrderState.EXECUTED && thisOrderGeneral.hasCommented == hasCommented) {
				result.add(thisOrderGeneral);
			}
		}
		return result;
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
			/*
			 * ！！！！！！！！！！！！MockHotel初始化！！！！！！！！！！！！！
			 */
			hotelInterface = new MockHotel(orderDataService.getOrderDetail(evaluationVO.orderID).getHotelID());
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
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderGenerals 需要被筛选的订单详情列表
	 * @param expectOrderState 期待被筛选出的订单状态
	 * @return 符合此状态的所有订单
	 */
	private List<OrderGeneralVO> orderStateFilter(List<OrderGeneralVO> orderGenerals, OrderState expectOrderState) {
		System.out.println("filter to " + expectOrderState);
		
		List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		for (int i = 0; i < orderGenerals.size(); i++) {
			OrderGeneralVO thisOrderGeneral = orderGenerals.get(i);
			if (thisOrderGeneral.state.equals(expectOrderState)) {
				result.add(thisOrderGeneral);
			}
		}
		return result;
	}
	
}
