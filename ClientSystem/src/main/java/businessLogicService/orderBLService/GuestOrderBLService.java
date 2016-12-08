package businessLogicService.orderBLService;

import java.util.Iterator;

import utilities.ResultMessage;
import vo.GuestEvaluationVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/8
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
	 * @updateTime 2016/12/2
	 * @param evaluationVO 客户评价单个订单时产生的订单
	 * @return 客户是否成功评价该订单
	 */
	ResultMessage addEvaluation(GuestEvaluationVO evaluationVO);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @param guestID 客户编号
	 * @param hasCommented 状态：已评价／未评价
	 * @return 客户<已评价／未评价>订单
	 */
	Iterator<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean hasCommented);

}
