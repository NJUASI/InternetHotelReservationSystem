package dataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataHelper.OrderDataHelper;
import dataHelperImpl.DataFactoryImpl;
import dataService.orderDataService.OrderDataService;
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
 * updateTime 2016/11/29
 *
 */
public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {

	private static final long serialVersionUID = 3434060152387200042L;
	
	private static OrderDataHelper orderDataHelper;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * @throws RemoteException RMI
	 */
	public OrderDataServiceImpl() throws RemoteException {
		if (orderDataHelper == null) {
			init();
		}
	}

	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 
	 * 单例初始化 orderDataHelper
	 */
	private void init() {
		DataFactoryImpl dataFactory = DataFactoryImpl.getInstance();
		orderDataHelper = dataFactory.getOrderDataHelper();
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
	@Override
	public ResultMessage createOrder(final OrderPO order) throws RemoteException {
		return orderDataHelper.add(order);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage executeOrder(final String orderID) throws RemoteException {
		return orderDataHelper.setState(orderID, OrderState.EXECUTED);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage undoAbnormalOrder(final String orderID) throws RemoteException {
		return orderDataHelper.setState(orderID, OrderState.CANCELLED);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage undoNormalOrder(final String orderID) throws RemoteException {
		return orderDataHelper.setState(orderID, OrderState.CANCELLED);
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
	 * @updateTime 2016/12/4
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 * @throws RemoteException RMI
	 */
	@Override
	public ResultMessage addEvaluation(GuestEvaluationPO guestEvaluationPO) throws RemoteException {
		//！！！有问题
		return orderDataHelper.setComment(guestEvaluationPO.getOrderID(), guestEvaluationPO.getComment());
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

}
