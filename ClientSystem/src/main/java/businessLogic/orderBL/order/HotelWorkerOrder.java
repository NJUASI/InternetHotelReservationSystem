package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.orderBLService.HotelWorkerOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import po.OrderGeneralPO;
import utilities.OrderState;
import utilities.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.OrderGeneralVO;

/**
 * 
 * @author charles
 * lastChangedBy Harvey
 * updateTime 2016/12/7
 *
 */
public class HotelWorkerOrder implements HotelWorkerOrderBLService {

	private OrderDataService orderDataService;

	private CommonOrder commonOrder;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public HotelWorkerOrder() {
//		orderDataService = ClientRemoteHelper.getInstance().getOrderDataService();
		
		try {
			orderDataService = new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		commonOrder = new CommonOrder();
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	public ResultMessage executeOrder(final String orderID) {
		ResultMessage resultMessage = ResultMessage.ORDER_EXECUTE_FAILURE;
		
		OrderState thisOrderState = commonOrder.getOrderDetail(orderID).orderGeneralVO.state;
		if (thisOrderState != OrderState.UNEXECUTED && thisOrderState != OrderState.ABNORMAL) {
			return resultMessage;
		}else {
			try {
				resultMessage = orderDataService.executeOrder(orderID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return resultMessage;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckIn (CheckInVO checkInVO) {
		ResultMessage resultMessage = ResultMessage.CHECK_IN_FAILURE;
		
		try {
			resultMessage = orderDataService.updateCheckIn(new CheckInPO(checkInVO));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckOut (CheckOutVO checkOutVO) {
		ResultMessage resultMessage = ResultMessage.CHECK_OUT_FAILURE;
		
		try {
			resultMessage = orderDataService.updateCheckOut((new CheckOutPO(checkOutVO)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return resultMessage;
	}
}
