package dataService.orderDataService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import po.CheckInPO;
import po.CheckOutPO;
import po.GuestEvaluationPO;
import po.HotelEvaluationPO;
import po.OrderGeneralPO;
import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;
import utilities.RoomType;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/5
 *
 */
public class OrderDataService_Stub extends UnicastRemoteObject implements OrderDataService {

	
	public OrderDataService_Stub() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}


	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param orderPO 从客户界面层传下来的Order载体
	 * @return 若客户创建此订单，需要付的款项
	 * @throws RemoteException RMI
	 */
	public double getTempPrice(OrderPO orderPO) throws RemoteException {
		return 200;
	}
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param order 从逻辑层层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 * @throws RemoteException RMI
	 */
	public ResultMessage createOrder(final OrderPO order) throws RemoteException {
		return ResultMessage.SUCCESS;
	}


	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 * @throws RemoteException RMI
	 */
	public ResultMessage executeOrder(final String orderID) throws RemoteException {
		return ResultMessage.SUCCESS;
	}


	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 * @throws RemoteException RMI
	 */
	public ResultMessage undoAbnormalOrder(final String orderID) throws RemoteException {
		return ResultMessage.SUCCESS;
	}

	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 * @throws RemoteException RMI
	 */
	public ResultMessage undoNormalOrder(final String orderID) throws RemoteException {
		return ResultMessage.SUCCESS;
	}
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 用户当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 * @throws RemoteException RMI
	 */
	public OrderPO getOrderDetail(final String orderID) throws RemoteException {
		final LocalDateTime createTime = LocalDateTime.of(2016, 2, 2, 18, 20);
		final LocalDateTime checkInTime = LocalDateTime.of(2016, 2, 3, 11, 23);
		final LocalDateTime checkOutTime = LocalDateTime.of(2016, 2, 4, 10, 58);
		final LocalDateTime expectExecuteTime = LocalDateTime.of(2016, 2, 3, 14, 00);
		final LocalDateTime expectLeaveTime = LocalDateTime.of(2016, 2, 4, 12, 00);

		final OrderState orderState = OrderState.EXECUTED;
		final RoomType roomType = RoomType.AMBASSADOR;
		
		
		return new OrderPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 200, 200,
				createTime, checkInTime, checkOutTime, expectExecuteTime, expectLeaveTime, orderState, false, 
				roomType, 2, "301  302", 2, "zhangsan","13554321234", "no", 4.3, "good");
	}

	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人所有订单时，客户的编号
	 * @return 客户个人所有订单
	 * @throws RemoteException RMI
	 */
	public List<OrderGeneralPO> getAllGuestOrderGeneral(final String guestID) throws RemoteException {
		final List<OrderGeneralPO> orderGenerals = new ArrayList<OrderGeneralPO>();
		orderGenerals.add(new OrderGeneralPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 
				200, LocalDateTime.of(2016, 2, 3, 14, 0), LocalDateTime.of(2016, 2, 4, 12, 0), 
				OrderState.EXECUTED, false, "zhangsan","13554321234"));
		return orderGenerals;
	}

	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店要查看本酒店所有订单时，酒店的编号
	 * @return 此酒店所有的所有订单
	 * @throws RemoteException RMI
	 */
	public List<OrderGeneralPO> getAllHotelOrderGeneral(final String hotelID) throws RemoteException {
		final List<OrderGeneralPO> orderGenerals = new ArrayList<OrderGeneralPO>();
		orderGenerals.add(new OrderGeneralPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 
				200, LocalDateTime.of(2016, 2, 3, 14, 0), LocalDateTime.of(2016, 2, 4, 12, 0), 
				OrderState.EXECUTED, false, "zhangsan","13554321234"));
		return orderGenerals;
	}

	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param date 网站营销人员撤销异常订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的异常订单
	 * @throws RemoteException RMI
	 */
	public List<OrderGeneralPO> getAllAbnormalOrderGeneral(final LocalDate date) throws RemoteException {
		final List<OrderGeneralPO> orderGenerals = new ArrayList<OrderGeneralPO>();
		orderGenerals.add(new OrderGeneralPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 
				200, LocalDateTime.of(2016, 2, 3, 14, 0), LocalDateTime.of(2016, 2, 4, 12, 0), 
				OrderState.ABNORMAL, false, "zhangsan","13554321234"));
		return orderGenerals;
	}


	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @return 网站营销人员需要查看的所有的异常订单，按倒序排列
	 * @throws RemoteException RMI
	 */
	public List<OrderGeneralPO> getAllAbnormalOrderGeneral() throws RemoteException {
		final List<OrderGeneralPO> orderGenerals = new ArrayList<OrderGeneralPO>();
		orderGenerals.add(new OrderGeneralPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 
				200, LocalDateTime.of(2016, 2, 3, 14, 0), LocalDateTime.of(2016, 2, 4, 12, 0), 
				OrderState.ABNORMAL, false, "zhangsan","13554321234"));
		return orderGenerals;
	}


	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * @param date 网站营销人员查看未执行订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的未执行订单
	 * @throws RemoteException RMI
	 */
	@Override
	public List<OrderGeneralPO> getAllUnexecutedOrderGeneral(final LocalDate date) throws RemoteException {
		final List<OrderGeneralPO> orderGenerals = new ArrayList<OrderGeneralPO>();
		orderGenerals.add(new OrderGeneralPO("123456789012", "1234567890", "12345678", "thisHotel", "address", 
				200, LocalDateTime.of(2016, 2, 3, 14, 0), LocalDateTime.of(2016, 2, 4, 12, 0), 
				OrderState.UNEXECUTED, false, "zhangsan","13554321234"));
		return orderGenerals;
	}
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInPO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 * @throws RemoteException RMI
	 */
	public ResultMessage updateCheckIn(CheckInPO checkInPO) throws RemoteException {
		return ResultMessage.CHECK_IN_SUCCESS;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInPO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 * @throws RemoteException RMI
	 */
	public ResultMessage updateCheckOut (CheckOutPO checkOutPO) throws RemoteException {
		return ResultMessage.CHECK_OUT_SUCCESS;
	}
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param evaluationPO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 * @throws RemoteException RMI
	 */
	public ResultMessage addEvaluation(GuestEvaluationPO guestEvaluationPO) throws RemoteException {
		return ResultMessage.UPDATE_EVALUATION_SUCCESS;
	}
	
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param hotelID 酒店工作人员／客户查看酒店的评论
	 * @return 此酒店的所有评价
	 * @throws RemoteException RMI
	 */
	public List<HotelEvaluationPO> getEvaluations(String hotelID) throws RemoteException {
		List<HotelEvaluationPO> result = new ArrayList<HotelEvaluationPO>();
		result.add(new HotelEvaluationPO("1234567890", LocalDate.of(2016, 11, 21), 4.5, "very good"));
		result.add(new HotelEvaluationPO("1234567891", LocalDate.of(2016, 11, 21), 4.5, "good"));
		result.add(new HotelEvaluationPO("1234567891", LocalDate.of(2016, 11, 23), 4.3, "ok"));
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
		final List<String> bookedHotels = new ArrayList<String>();
		bookedHotels.add("12345678");
		bookedHotels.add("12345679");
		return bookedHotels;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * @param guestID 此客户的客户编号
	 * @param hotelID 此客户相对的酒店编号
	 * @return 此客户在此相应酒店预定过的订单状态
	 * @throws RemoteException RMI
	 */
	public OrderState getOrderState(String guestID, String hotelID) throws RemoteException {
		return OrderState.COMMENTED;
	}
}
