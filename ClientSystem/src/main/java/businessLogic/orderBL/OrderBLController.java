package businessLogic.orderBL;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import businessLogicService.orderBLService.OrderBLService;
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
 * 新增查看订单详情时各个种类的接口
 */
public final class OrderBLController implements OrderBLService {

	
	private Order order;
	
	private static OrderBLController orderController = new OrderBLController();
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * 构造函数，初始化成员变量
	 */
	private OrderBLController() {
		//new the mock object
		order = new Order();
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
		return order.getTempPrice(orderVO);
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
		return order.createOrder(orderVO);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	@Override
	public ResultMessage executeOrder(final String orderID) {
		return order.executeOrder(orderID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @return 网站营销人员是否成功撤销此异常订单
	 */
	@Override
	public ResultMessage undoAbnormalOrder(final String orderID) {
		return order.undoAbnormalOrder(orderID);
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
		return order.undoNormalOrder(orderID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 用户当前需要查看的订单的订单号
	 * @return 此被需要订单的详情载体
	 */
	@Override
	public OrderVO getOrderDetail(final String orderID) {
		return order.getOrderDetail(orderID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人<所有>订单时，客户的编号
	 * @return 客户个人<所有>订单
	 */
	public List<OrderGeneralVO> getAllGuestOrderGeneral(final String guestID) {
		return order.getAllGuestOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有未执行>订单时，客户的编号
	 * @return 客户个人<所有未执行>订单
	 */
	public List<OrderGeneralVO> getAllGuestUnexecutedOrderGeneral(final String guestID) {
		return order.getAllGuestUnexecutedOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有已执行>订单时，客户的编号
	 * @return 客户个人<所有已执行>订单
	 */
	public List<OrderGeneralVO> getAllGuestExecutedOrderGeneral(final String guestID) {
		return order.getAllGuestExecutedOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有异常>订单时，客户的编号
	 * @return 客户个人<所有异常>订单
	 */
	public List<OrderGeneralVO> getAllGuestAbnormalOrderGeneral(final String guestID) {
		return order.getAllGuestAbnormalOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有已撤销>订单时，客户的编号
	 * @return 客户个人<所有已撤销>订单
	 */
	public List<OrderGeneralVO> getAllGuestCancelledOrderGeneral(final String guestID) {
		return order.getAllGuestCancelledOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有已评价>订单时，客户的编号
	 * @return 客户个人<所有已评价>订单
	 */
	public List<OrderGeneralVO> getAllGuestCommentedOrderGeneral(final String guestID) {
		return order.getAllGuestCommentedOrderGeneral(guestID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有未评价>订单时，客户的编号
	 * @return 客户个人<所有未评价>订单
	 */
	public List<OrderGeneralVO> getAllGuestUncommentedOrderGeneral(final String guestID) {
		return order.getAllGuestUncommentedOrderGeneral(guestID);
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
		return order.getAllHotelOrderGeneral(hotelID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店要查看本酒店<所有未执行>订单时，酒店的编号
	 * @return 此酒店<所有未执行>的所有订单
	 */
	public List<OrderGeneralVO> getAllHotelUnexecutedOrderGeneral(final String hotelID) {
		return order.getAllHotelUnexecutedOrderGeneral(hotelID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店要查看本酒店<所有已执行>订单时，酒店的编号
	 * @return 此酒店<所有已执行>订单
	 */
	public List<OrderGeneralVO> getAllHotelExecutedOrderGeneral(final String hotelID) {
		return order.getAllHotelExecutedOrderGeneral(hotelID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店要查看本酒店<所有异常>订单时，酒店的编号
	 * @return 此酒店所有异常>订单
	 */
	public List<OrderGeneralVO> getAllHotelAbnormalOrderGeneral(final String hotelID) {
		return order.getAllHotelAbnormalOrderGeneral(hotelID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店要查看本酒店<所有已撤销>订单时，酒店的编号
	 * @return 此酒店<所有已撤销>订单
	 */
	public List<OrderGeneralVO> getAllHotelCancelledOrderGeneral(final String hotelID) {
		return order.getAllHotelCancelledOrderGeneral(hotelID);
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
		return order.getAllAbnormalOrderGeneral(date);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * @return 网站营销人员需要查看的所有的异常订单，按倒序排列
	 */
	@Override
	public List<OrderGeneralVO> getAllAbnormalOrderGeneral() {
		return order.getAllAbnormalOrderGeneral();
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
		return order.getAllUnexecutedOrderGeneral(date);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckIn (CheckInVO checkInVO) {
		return order.updateCheckIn(checkInVO);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckOut (CheckOutVO checkOutVO) {
		return order.updateCheckOut(checkOutVO);
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
		return order.addEvaluation(evaluationVO);
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
		return order.getEvaluations(hotelID);
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户需要查看个人定过的酒店时依照的客户个人编号
	 * @return 客户定过的酒店列表
	 */
	@Override
	public List<String> getBookedHotels(final String guestID) {
		return order.getBookedHotels(guestID);
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
		return order.getOrderState(guestID, hotelID);
	}

}
