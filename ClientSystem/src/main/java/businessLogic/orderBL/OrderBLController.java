package businessLogic.orderBL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.orderBL.order.CommonOrder;
import businessLogic.orderBL.order.GuestOrder;
import businessLogic.orderBL.order.HotelWorkerOrder;
import businessLogic.orderBL.order.OrderForHotelModule;
import businessLogic.orderBL.order.WebMarketerOrder;
import businessLogicService.orderBLService.CommonOrderBLService;
import businessLogicService.orderBLService.GuestOrderBLService;
import businessLogicService.orderBLService.HotelWorkerOrderBLService;
import businessLogicService.orderBLService.OrderForHotelModuleBLService;
import businessLogicService.orderBLService.WebMarketerOrderBLService;
import utilities.OrderState;
import utilities.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.GuestEvaluationVO;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 * 
 * 对Order模块重构
 */
public final class OrderBLController implements CommonOrderBLService, GuestOrderBLService, HotelWorkerOrderBLService, WebMarketerOrderBLService, OrderForHotelModuleBLService {

	private CommonOrder commonOrder;
	private GuestOrder guestOrder;
	private HotelWorkerOrder hotelWorkerOrder;
	private WebMarketerOrder webMarketerOrder;
	private OrderForHotelModule orderForHotelModule;
	
	private static OrderBLController orderController = new OrderBLController();
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * 构造函数，初始化成员变量
	 */
	private OrderBLController() {
		// init the orders
		commonOrder = new CommonOrder();
		guestOrder = new GuestOrder();
		hotelWorkerOrder = new HotelWorkerOrder();
		webMarketerOrder = new WebMarketerOrder();
		orderForHotelModule = new OrderForHotelModule();
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @return order controller的实例，单例化
	 */
	public static OrderBLController getInstance() {
		return orderController;
	}
	

	/*
	 * commonOrder的接口
	 */
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 用户当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 */
	@Override
	public OrderVO getOrderDetail(final String orderID) {
		return commonOrder.getOrderDetail(orderID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * @param hotelID 酒店工作人员／客户查看酒店的评论
	 * @return 此酒店的所有评价
	 */
	@Override
	public Iterator<HotelEvaluationVO> getEvaluations(String hotelID) {
		return commonOrder.getEvaluations(hotelID);
	}
	
	
	/*
	 * guestOrder的接口
	 */
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 若客户创建此订单，需要付的款项
	 */
	@Override
	public double getTempPrice(OrderVO orderVO) {
		return guestOrder.getTempPrice(orderVO);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 */
	@Override
	public ResultMessage createOrder(final OrderVO orderVO) {
		return guestOrder.createOrder(orderVO);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 */
	@Override
	public ResultMessage undoNormalOrder(final String orderID) {
		return guestOrder.undoNormalOrder(orderID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人<所有>订单时，客户的编号
	 * @return 客户个人<所有>订单
	 */
	public List<OrderGeneralVO> getAllGuestOrderGeneral(final String guestID) {
		return guestOrder.getAllGuestOrderGeneral(guestID);
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
		return guestOrder.getAllGuestSpecialOrderGeneral(guestID, expectOrderState);
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
		return guestOrder.getAllGuestCommentOrderGeneral(guestID, hasCommented);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 */
	@Override
	public ResultMessage addEvaluation(GuestEvaluationVO evaluationVO) {
		return guestOrder.addEvaluation(evaluationVO);
	}
	
	
	
	
	
	
	/*
	 * hotelWorkerOrder的接口
	 */
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	@Override
	public ResultMessage executeOrder(final String orderID) {
		return hotelWorkerOrder.executeOrder(orderID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店要查看本酒店<所有>订单时，酒店的编号
	 * @return 此酒店<所有>订单
	 */
	@Override
	public List<OrderGeneralVO> getAllHotelOrderGeneral(final String hotelID) {
		return hotelWorkerOrder.getAllHotelOrderGeneral(hotelID);
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
	public List<OrderGeneralVO> getAllHotelSpecialOrderGeneral(String hotelID, OrderState expectOrderState) {
		return hotelWorkerOrder.getAllHotelSpecialOrderGeneral(hotelID, expectOrderState);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckIn (CheckInVO checkInVO) {
		return hotelWorkerOrder.updateCheckIn(checkInVO);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckOut (CheckOutVO checkOutVO) {
		return hotelWorkerOrder.updateCheckOut(checkOutVO);
	}
	
	
	
	
	
	
	/*
	 * webMarketerOrder的接口
	 */
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 */
	@Override
	public ResultMessage undoAbnormalOrder(final String orderID) {
		return webMarketerOrder.undoAbnormalOrder(orderID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param date 网站营销人员撤销异常订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的异常订单
	 */
	@Override
	public List<OrderGeneralVO> getAllAbnormalOrderGeneral(final LocalDate date) {
		return webMarketerOrder.getAllAbnormalOrderGeneral(date);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * @param date 网站营销人员查看未执行订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的未执行订单
	 */
	@Override
	public List<OrderGeneralVO> getAllUnexecutedOrderGeneral(final LocalDate date) {
		return webMarketerOrder.getAllUnexecutedOrderGeneral(date);
	}
	
	
	
	
	
	
	/*
	 * 为酒店模块单独的接口
	 * 也可单独提出来
	 */
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户需要查看个人定过的酒店时依照的客户个人编号
	 * @return 客户定过的酒店列表
	 */
	public List<String> getBookedHotels(final String guestID) {
		return orderForHotelModule.getBookedHotels(guestID);
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
		return orderForHotelModule.getOrderState(guestID, hotelID);
	}

}
