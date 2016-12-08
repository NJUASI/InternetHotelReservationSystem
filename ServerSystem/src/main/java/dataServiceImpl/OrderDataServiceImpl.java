package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataHelper.OrderDataHelper;
import dataHelperImpl.stub.OrderDataHelperImpl_Stub;
import dataService.orderDataService.OrderDataService;
import po.CheckInPO;
import po.CheckOutPO;
import po.GuestEvaluationPO;
import po.HotelEvaluationPO;
import po.OrderGeneralPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {

	private  OrderDataHelper orderDataHelper;
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
//		orderDataHelper = new OrderDataServiceImpl();
		orderDataHelper = new OrderDataHelperImpl_Stub();
	}
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param order 从逻辑层层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage createOrder(final OrderPO order) throws RemoteException {
		String random = formateRandomNumber((int)(Math.random()*10000));
		String date = formateDate(order.getCreateTime().toLocalDate());
		
		order.setOrderID(random + date);
		ResultMessage message = orderDataHelper.add(order);
		if (message == ResultMessage.SUCCESS) {
			return ResultMessage.ORDER_CREATE_SUCCESS;
		}else {
			return ResultMessage.ORDER_CREATE_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage executeOrder(final String orderID) throws RemoteException {
		ResultMessage message = orderDataHelper.setState(orderID, OrderState.EXECUTED);
		if (message == ResultMessage.SUCCESS) {
			return ResultMessage.ORDER_EXECUTE_SUCCESS;
		}else {
			return ResultMessage.ORDER_EXECUTE_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage undoAbnormalOrder(final String orderID, final double percent) throws RemoteException {
		OrderPO thisOrder = orderDataHelper.getSingleOrder(orderID);
		//TODO 冯俊杰：调用User模块modifyCredit 减少信用值
		
		ResultMessage message = orderDataHelper.setState(orderID, OrderState.CANCELLED);
		if (message == ResultMessage.SUCCESS) {
			return ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS;
		}else {
			return ResultMessage.ABNORMAL_ORDER_UNDO_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage undoNormalOrder(final String orderID) throws RemoteException {
		ResultMessage message = orderDataHelper.setState(orderID, OrderState.CANCELLED);
		if (message == ResultMessage.SUCCESS) {
			return ResultMessage.NORMAL_ORDER_UNDO_SUCCESS;
		}else {
			return ResultMessage.NORMAL_ORDER_UNDO_FAILURE;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 用户当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 * @throws RemoteException RMI
	 */
	@Override
	public OrderPO getOrderDetail(final String orderID) throws RemoteException {
		return orderDataHelper.getSingleOrder(orderID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人所有订单时，客户的编号
	 * @return 客户个人所有订单
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllGuestOrderGeneral(final String guestID) throws RemoteException {
		List<OrderPO> guestOrders = orderDataHelper.getAllOrderOfGuest(guestID);
		List<OrderGeneralPO> result = new ArrayList<OrderGeneralPO>();
		
		for (OrderPO guestOrder : guestOrders) {
			result.add(new OrderGeneralPO(guestOrder));
		}
		
		return result;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店要查看本酒店所有订单时，酒店的编号
	 * @return 此酒店所有的所有订单
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllHotelOrderGeneral(final String hotelID) throws RemoteException {
		List<OrderPO> hotelOrders = orderDataHelper.getAllOrderOfHotel(hotelID);
		List<OrderGeneralPO> result = new ArrayList<OrderGeneralPO>();
		
		for (OrderPO hotelOrder : hotelOrders) {
			result.add(new OrderGeneralPO(hotelOrder));
		}
		
		return result;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param date 网站营销人员撤销异常订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的异常订单
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllAbnormalOrderGeneral(final LocalDate date) throws RemoteException {
		List<OrderPO> abnormalOrders = orderDataHelper.getAbnormal();
		List<OrderGeneralPO> result = new ArrayList<OrderGeneralPO>();
		
		for (OrderPO abnormalOrder : abnormalOrders) {
			LocalDate temp = abnormalOrder.getExpectExecuteTime().toLocalDate();
			if (temp.getYear() == date.getYear() && temp.getMonth() == date.getMonth() && temp.getDayOfMonth() == date.getDayOfMonth()) {
				result.add(new OrderGeneralPO(abnormalOrder));
			}
		}
		
		return result;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @return 网站营销人员需要查看的所有的异常订单，按倒序排列
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllAbnormalOrderGeneral() throws RemoteException {
		List<OrderPO> abnormalOrders = orderDataHelper.getAbnormal();
		List<OrderGeneralPO> result = new ArrayList<OrderGeneralPO>();
		
		for (OrderPO abnormalOrder : abnormalOrders) {
			result.add(new OrderGeneralPO(abnormalOrder));
		}
		
		return result;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * @param date 网站营销人员查看未执行订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的未执行订单
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllUnexecutedOrderGeneral(final LocalDate date) throws RemoteException {
		List<OrderPO> unexecutedOrders = orderDataHelper.getUnexecuted();
		List<OrderGeneralPO> result = new ArrayList<OrderGeneralPO>();
		
		for (OrderPO unexecutedOrder : unexecutedOrders) {
			LocalDate temp = unexecutedOrder.getExpectExecuteTime().toLocalDate();
			if (temp.getYear() == date.getYear() && temp.getMonth() == date.getMonth() && temp.getDayOfMonth() == date.getDayOfMonth()) {
				result.add(new OrderGeneralPO(unexecutedOrder));
			}
		}
		
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param checkInPO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	@Override
	public ResultMessage updateCheckIn (CheckInPO checkInPO) throws RemoteException {
		ResultMessage msg1 = orderDataHelper.setCheckIn(checkInPO.getOrderID(), checkInPO.getRoomNumber(), checkInPO.getCheckInTime(), checkInPO.getExpectLeaveTime());
		ResultMessage msg2 = orderDataHelper.setState(checkInPO.getOrderID(), OrderState.EXECUTED);
		
		if (msg1 == ResultMessage.SUCCESS && msg2 == ResultMessage.SUCCESS) {
			return ResultMessage.CHECK_IN_SUCCESS;
		}else {
			return ResultMessage.CHECK_IN_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param checkOutPO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	@Override
	public ResultMessage updateCheckOut (CheckOutPO checkOutPO) throws RemoteException {
		ResultMessage msg1 = orderDataHelper.setCheckOut(checkOutPO.getOrderID(), checkOutPO.getCheckOutTime());
		if (msg1 == ResultMessage.SUCCESS) {
			return ResultMessage.CHECK_OUT_SUCCESS;
		}else {
			return ResultMessage.CHECK_OUT_FAILURE;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestEvaluationPO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage addEvaluation(GuestEvaluationPO guestEvaluationPO) throws RemoteException {
		ResultMessage msg1 = orderDataHelper.setEvaluation(guestEvaluationPO.getOrderID(), guestEvaluationPO.getScore(), guestEvaluationPO.getComment());
		ResultMessage msg2 = orderDataHelper.setHasCommentBool(guestEvaluationPO.getOrderID());
		
		if (msg1 == ResultMessage.SUCCESS && msg2 == ResultMessage.SUCCESS) {
			return ResultMessage.UPDATE_EVALUATION_SUCCESS;
		}else {
			return ResultMessage.UPDATE_EVALUATION_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param hotelID 酒店工作人员／客户查看酒店的评论
	 * @return 此酒店的所有评价
	 * @throws RemoteException RMI
	 */
	@Override
	public List<HotelEvaluationPO> getEvaluations(String hotelID) throws RemoteException {
		List<OrderPO> hotelPOs = orderDataHelper.getAllOrderOfHotel(hotelID);
		List<HotelEvaluationPO> result = new ArrayList<HotelEvaluationPO>();
		
		for (int i = 0; i < hotelPOs.size(); i++) {
			OrderPO thisOrder = hotelPOs.get(i);
			result.add(new HotelEvaluationPO(thisOrder.getGuestID(), thisOrder.getCheckInTime().toLocalDate(), 
					thisOrder.getScore(), thisOrder.getComment()));
		}
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户需要查看个人定过的酒店时依照的客户个人编号
	 * @return 客户定过的酒店列表
	 * @throws RemoteException RMI
	 */
	@Override
	public List<String> getBookedHotels(final String guestID) throws RemoteException {
		List<OrderPO> guestOrders = orderDataHelper.getAllOrderOfGuest(guestID);
		List<String> result = new ArrayList<String>();
		
		for (OrderPO guestOrder : guestOrders) {
			if (guestOrder.getGuestID().equals(guestID)) {
				String thisHotelID = guestOrder.getHotelID();
				//遍历result中是否已加入此酒店
				boolean alreadyHasThisHotel = false;
				for (String string : result) {
					if (string.equals(thisHotelID)) {
						alreadyHasThisHotel = true;
						break;
					}
				}
				
				if (alreadyHasThisHotel == false) {
					result.add(thisHotelID);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param randomNumber 随机生成的4位数，便于验证
	 * @return 标准格式化此4位数之后的String
	 */
	private String formateRandomNumber(int randomNumber) {
		if (randomNumber >= 1000 && randomNumber <= 9999) {
			return String.valueOf(randomNumber);
		}else if (randomNumber > 100 && randomNumber <= 999) {
			return "0" + String.valueOf(randomNumber);
		}else if (randomNumber > 10 && randomNumber <= 99) {
			return "00" + String.valueOf(randomNumber);
		}else {
			return "000" + String.valueOf(randomNumber);
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param localDate 订单的createDate
	 * @return 标准格式化此时间之后的String
	 */
	private String formateDate(LocalDate localDate) {
		String temp = localDate.toString();
		return temp.substring(0, 4) + temp.substring(5, 7) + temp.substring(8);
	}
}
