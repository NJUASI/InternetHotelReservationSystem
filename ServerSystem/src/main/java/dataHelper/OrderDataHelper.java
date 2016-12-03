package dataHelper;

import java.util.List;

import po.OrderPO;
import utilities.OrderState;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/29
 *
 */
public interface OrderDataHelper {

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param orderPO  order的信息载体
	 * @return ResultMessage 是否成功添加orderInfo到数据库中
	 */
	ResultMessage add(OrderPO orderPO);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param orderID  
	 * @param state  需要修改的状态
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	ResultMessage setState(String orderID, OrderState state);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param orderID  
	 * @param comment  需要修改的评论
	 * @return ResultMessage 是否成功修改orderInfo
	 */
	ResultMessage setComment(String orderID, String comment);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param orderID  
	 * @return OrderPO orderInfo载体
	 */
	OrderPO getSingleOrder(String orderID);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param guestID  
	 * @return List<OrderPO> 据guestID获得的所有orderInfo载体
	 */
	List<OrderPO> getAllOrderOfGuest(String guestID);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param hotelID  
	 * @return List<OrderPO> 据hotelID获得的所有orderInfo载体
	 */
	List<OrderPO> getAllOrderOfHotel(String hotelID);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @return List<OrderPO> 据date获得的所有异常orderInfo载体
	 */
	List<OrderPO> getAbnormal();
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param date  需要查询的日期  
	 * @return List<OrderPO> 据date获得的所有未执行orderInfo载体
	 */
	List<OrderPO> getUnexecuted();
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param 
	 * @return 
	 */
	void close();
	
}
