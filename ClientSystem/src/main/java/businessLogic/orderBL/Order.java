package businessLogic.orderBL;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogic.promotionBL.DiscountCalculator;
import businessLogic.promotionBL.DiscountInSpan;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import po.GuestEvaluationPO;
import po.HotelEvaluationPO;
import po.OrderGeneralPO;
import po.OrderPO;
import rmi.ClientRemoteHelper;
import utilities.OrderState;
import utilities.PreOrder;
import utilities.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.GuestEvaluationVO;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/4
 *
 */
public class Order {
	
	private OrderDataService orderDataService;
	
	private HotelInfoOperation hotelInterface;
	private DiscountInSpan discountCalculator;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public Order() {
//		orderDataService = ClientRemoteHelper.getInstance().getOrderDataService();
		try {
			orderDataService = new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		discountCalculator = new DiscountCalculator();
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
		return orderVO.previousPrice * discountsInSpan.next();
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
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	public ResultMessage executeOrder(final String orderID) {
		ResultMessage resultMessage = ResultMessage.ORDER_EXECUTE_FAILURE;
		
		OrderState thisOrderState = getOrderDetail(orderID).orderGeneralVO.state;
		if (thisOrderState != OrderState.UNEXECUTED && thisOrderState != OrderState.ABNORMAL) {
			return resultMessage;
		}else {
			try {
				resultMessage = orderDataService.executeOrder(orderID);
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
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 */
	public ResultMessage undoAbnormalOrder(final String orderID) {
		ResultMessage resultMessage = ResultMessage.ABNORMAL_ORDER_UNDO_FAILURE;
		
		OrderState thisOrderState = getOrderDetail(orderID).orderGeneralVO.state;
		if (thisOrderState != OrderState.ABNORMAL) {
			return resultMessage;
		}else {
			try {
				resultMessage = orderDataService.undoAbnormalOrder(orderID);
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
		
		OrderState thisOrderState = getOrderDetail(orderID).orderGeneralVO.state;
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
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店要查看本酒店所有订单时，酒店的编号
	 * @return 此酒店所有的所有订单
	 */
	public List<OrderGeneralVO> getAllHotelOrderGeneral(final String hotelID) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllHotelOrderGeneral(hotelID);
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
	 * @updateTime 2016/11/27
	 * @param date 网站营销人员撤销异常订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的异常订单
	 */
	public List<OrderGeneralVO> getAllAbnormalOrderGeneral(final LocalDate date) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllAbnormalOrderGeneral(date);
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
	 * @updateTime 2016/11/29
	 * @return 网站营销人员需要查看的所有的异常订单，按倒序排列
	 */
	public List<OrderGeneralVO> getAllAbnormalOrderGeneral() {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllAbnormalOrderGeneral();
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
	 * @updateTime 2016/11/29
	 * @param date 网站营销人员查看未执行订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的未执行订单
	 */
	public List<OrderGeneralVO> getAllUnexecutedOrderGeneral(final LocalDate date) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllUnexecutedOrderGeneral(date);
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
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckIn (CheckInVO checkInVO) {
		ResultMessage resultMessage = ResultMessage.CHECK_IN_FAILURE;
		
		try {
			resultMessage = orderDataService.updateCheckIn(new CheckInPO(checkInVO));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckOut (CheckOutVO checkOutVO) {
		ResultMessage resultMessage = ResultMessage.CHECK_OUT_FAILURE;
		
		try {
			resultMessage = orderDataService.updateCheckOut((new CheckOutPO(checkOutVO)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
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
			
			hotelInterface = new Hotel(orderDataService.getOrderDetail(evaluationVO.orderID).getHotelID());
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
	 * @updateTime 2016/12/2
	 * @param hotelID 酒店工作人员／客户查看酒店的评论
	 * @return 此酒店的所有评价
	 */
	public List<HotelEvaluationVO> getEvaluations(String hotelID) {
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
		
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户需要查看个人定过的酒店时依照的客户个人编号
	 * @return 客户定过的酒店列表
	 */
	public List<String> getBookedHotels(final String guestID) {
		List<String> result = null;
		
		try {
			result = orderDataService.getBookedHotels(guestID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param guestID 此客户的客户编号
	 * @param hotelID 此客户相对的酒店编号
	 * @return 此客户在此相应酒店预定过的订单状态
	 */
	public OrderState getOrderState(String guestID, String hotelID) {
		List<OrderGeneralPO> guestOrders = null;
		
		try {
			guestOrders = orderDataService.getAllGuestOrderGeneral(guestID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		List<OrderState> states = new ArrayList<OrderState>();
		if (guestOrders != null) {
			for (int i = 0; i < guestOrders.size(); i++) {
				OrderGeneralPO thisOrderGeneral = guestOrders.get(i);
				if (thisOrderGeneral.getHotelID().equals(hotelID)) {
					states.add(thisOrderGeneral.getState());
				}
			}
		}
		
		return getMaxOrderState(states);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param states 此客户在此相应酒店预定过的所有订单状态
	 * @return 优先级最高的订单状态（已评论 > 已执行 > 未执行 > 异常 > 已取消）
	 */
	private OrderState getMaxOrderState(List<OrderState> states) {
		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 0; i < states.size(); i++) {
			integers.add(states.get(i).ordinal());
		}
		
		int indexOfMax = 0;
		for (int i = 0; i < integers.size(); i++) {
			if (integers.get(i) > integers.get(indexOfMax)) {
				indexOfMax = i;
			}
		}
		return OrderState.values()[indexOfMax];
	}
	
}
