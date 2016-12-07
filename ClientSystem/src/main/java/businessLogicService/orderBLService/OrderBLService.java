package businessLogicService.orderBLService;

import java.util.Iterator;

import utilities.OrderState;
import utilities.UserType;
import vo.OrderGeneralVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 * 新增查看订单详情时各个种类的接口
 */
public interface OrderBLService extends CommonOrderBLService,GuestOrderBLService,HotelWorkerOrderBLService,OrderForHotelModuleBLService,WebMarketerOrderBLService{
	
	/**
	 * @Description:根据userID，userType和orderState获得对应的order
	 * 酒店工作人员/客户均通过此方法调用各自的订单
	 * @param userID
	 * @param userType
	 * @param orderState
	 * @return
	 * Iterator<OrderGeneralVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月8日 上午2:24:16
	 */
	public Iterator<OrderGeneralVO> getOrderGenerals(String userID,UserType userType,OrderState orderState);

	public Iterator<OrderGeneralVO> getAllGuestCommentOrderGeneral(String guestID, boolean b);
	
}
