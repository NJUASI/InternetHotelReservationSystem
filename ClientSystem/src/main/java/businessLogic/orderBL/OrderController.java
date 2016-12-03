package businessLogic.orderBL;

import java.time.LocalDate;
import java.util.List;

import businessLogicService.orderBLService.OrderBLService;
import utilities.ResultMessage;
import vo.GuestEvaluationVO;
import vo.HotelEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/11/29
 */
public final class OrderController implements OrderBLService {

	
	private Order order;
	
	private static OrderController orderController;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * 构造函数，初始化成员变量
	 */
	private OrderController() {
		//new the mock object
		order = new MockOrder();
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @return order controller的实例，单例化
	 */
	public static OrderController getInstance() {
		if (orderController == null) {
			orderController = new OrderController();
		}
		return orderController;
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
	 * @param guestID 客户要查看个人所有订单时，客户的编号
	 * @return 客户个人所有订单
	 */
	@Override
	public List<OrderGeneralVO> getAllGuestOrderGeneral(final String guestID) {
		return order.getAllGuestOrderGeneral(guestID);
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店要查看本酒店所有订单时，酒店的编号
	 * @return 此酒店所有的所有订单
	 */
	@Override
	public List<OrderGeneralVO> getAllHotelOrderGeneral(final String hotelID) {
		return order.getAllHotelOrderGeneral(hotelID);
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
	public List<HotelEvaluationVO> getEvaluations(String hotelID) {
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

}
