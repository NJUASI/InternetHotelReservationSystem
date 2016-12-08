package businessLogic.orderBL.order;

import java.rmi.RemoteException;

import businessLogic.hotelBL.HotelInfoOperation;
import businessLogic.hotelBL.MockHotel;
import businessLogic.hotelBL.hotel.Hotel;
import businessLogicService.orderBLService.HotelWorkerOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.CheckInPO;
import po.CheckOutPO;
import utilities.OrderState;
import utilities.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.OrderVO;

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
	
	//hotel
	private HotelInfoOperation hotelInterface;
	
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
	 * @updateTime 2016/12/8
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	public ResultMessage executeOrder(final String orderID) {
		ResultMessage resultMessage = ResultMessage.ORDER_EXECUTE_FAILURE;
		
		OrderState thisOrderState = commonOrder.getOrderDetail(orderID).orderGeneralVO.state;
		if (thisOrderState == OrderState.UNEXECUTED || thisOrderState == OrderState.ABNORMAL) {
			try {
				resultMessage = orderDataService.executeOrder(orderID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return resultMessage;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckIn (CheckInVO checkInVO) {
		ResultMessage msg1 = ResultMessage.CHECK_IN_FAILURE;
		ResultMessage msg2 = ResultMessage.CHECK_IN_FAILURE;
		
		try {
			msg1 = orderDataService.updateCheckIn(new CheckInPO(checkInVO));
			
			/*
			 * new the mock one to test
			 */
			hotelInterface = new MockHotel();
			OrderVO thisOrder = commonOrder.getOrderDetail(checkInVO.orderID);
			
			/*
			 * TODO gcm hotel checkIn 接口参数待确定
			 */
			msg2 = hotelInterface.checkIn(thisOrder.orderGeneralVO.orderID, thisOrder.roomType.toString(), thisOrder.roomNumCount); 
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (msg1 == ResultMessage.CHECK_IN_SUCCESS && msg2 == ResultMessage.CHECK_IN_SUCCESS) {
			return ResultMessage.CHECK_IN_SUCCESS;
		}else {
			return ResultMessage.CHECK_IN_FAILURE;
		}
	}

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/8
	 * @param checkInVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	public ResultMessage updateCheckOut (CheckOutVO checkOutVO) {
		ResultMessage msg1 = ResultMessage.CHECK_OUT_FAILURE;
		ResultMessage msg2 = ResultMessage.CHECK_OUT_FAILURE;
		
		try {
			msg1 = orderDataService.updateCheckOut((new CheckOutPO(checkOutVO)));
			
			/*
			 * new the mock one to test
			 */
			hotelInterface = new MockHotel();
			OrderVO thisOrder = commonOrder.getOrderDetail(checkOutVO.orderID);
			
			/*
			 * TODO gcm hotel checkOut 接口参数待确定
			 */
			msg2 = hotelInterface.checkOut(thisOrder.orderGeneralVO.orderID, thisOrder.roomType.toString(), thisOrder.roomNumCount); 
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (msg1 == ResultMessage.CHECK_OUT_SUCCESS && msg2 == ResultMessage.CHECK_OUT_SUCCESS) {
			return ResultMessage.CHECK_OUT_SUCCESS;
		}else {
			return ResultMessage.CHECK_OUT_FAILURE;
		}
	}
}
