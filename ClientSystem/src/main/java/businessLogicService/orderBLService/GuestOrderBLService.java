package businessLogicService.orderBLService;

import java.util.List;

import utilities.OrderState;
import utilities.ResultMessage;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public interface GuestOrderBLService {

	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 若客户创建此订单，需要付的款项
	 */
	double getTempPrice(OrderVO orderVO);
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderVO 从客户界面层传下来的Order载体
	 * @return 客户是否成功创建此订单
	 */
	ResultMessage createOrder(OrderVO orderVO);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 客户当前需要撤销的正常订单的订单号
	 * @return 客户是否成功撤销此正常订单
	 */
	ResultMessage undoNormalOrder(String orderID);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param guestID 客户要查看个人<所有>订单时，客户的编号
	 * @return 客户个人<所有>订单
	 */
	List<OrderGeneralVO> getAllGuestOrderGeneral(String guestID);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<所有某种特定类型>订单时，客户的编号
	 * @return 客户个人<所有某种特定类型>订单
	 * 
	 * <所有某种特定类型>包括：未执行、已执行、异常、已撤销
	 */
	List<OrderGeneralVO> getAllGuestSpecialOrderGeneral(String guestID, OrderState expectOrderState);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param guestID 客户要查看个人<已执行／未执行>订单时，客户的编号
	 * @return 客户个人<已执行／未执行>订订单
	 * 
	 * <<已执行／未执行>只包含一种
	 */
	List<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean hasCommented);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/2
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 */
	ResultMessage addEvaluation(GuestEvaluationVO evaluationVO);
}
