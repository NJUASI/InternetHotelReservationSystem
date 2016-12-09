package businessLogic.orderBL.order;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.GuestCreditService;
import businessLogic.userBL.userService.service.UserService;
import businessLogicService.orderBLService.WebMarketerOrderBLService;
import dataService.orderDataService.OrderDataService;
import dataService.orderDataService.OrderDataService_Stub;
import po.OrderGeneralPO;
import utilities.OrderState;
import utilities.ResultMessage;
import vo.GuestVO;
import vo.OrderGeneralVO;
import vo.OrderVO;

/**
 * 
 * @author charles
 * lastChangedBy charles
 * updateTime 2016/12/9
 *
 */
public class WebMarketerOrder implements WebMarketerOrderBLService {

	private OrderDataService orderDataService;

	private CommonOrder commonOrder;
	
	//user
	private GuestCreditService guestCreditService;
	private UserService userService;
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public WebMarketerOrder() {
//		orderDataService = ClientRemoteHelper.getInstance().getOrderDataService();
		
		try {
			orderDataService = new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		commonOrder = new CommonOrder();
		
		guestCreditService = new Guest();
		userService = new Guest();
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/9
	 * @param orderID 网站营销人员当前需要撤销的异常订单的订单号
	 * @param percent 撤销后需要恢复的信用值比例
	 * @return 网站营销人员是否成功按比例撤销此异常订单
	 */
	public ResultMessage undoAbnormalOrder(final String orderID, final double percent) {
		OrderVO thisOrder = commonOrder.getOrderDetail(orderID);
		
		ResultMessage msg1 = ResultMessage.ABNORMAL_ORDER_UNDO_FAILURE;
		ResultMessage msg2 = ResultMessage.RECORE_CREDIT_FAILURE;
		
		OrderState thisOrderState = thisOrder.orderGeneralVO.state;
		if (thisOrderState == OrderState.ABNORMAL) {
			try {
				msg1 = orderDataService.undoAbnormalOrder(orderID, percent);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		GuestVO thisGuest = (GuestVO)userService.getSingle(thisOrder.orderGeneralVO.guestID);
		/*
		 * 因为数据的问题，getOrderDetail得到的是一个UNEXECUTED对象，所以执行会抛异常
		 * 但是若是数据正确的话，就没有问题
		 */
		final double expectCreditNum = thisGuest.credit - thisOrder.orderGeneralVO.price * percent;
		msg2 = guestCreditService.modifyCredit(thisOrder.orderGeneralVO.guestID, expectCreditNum);
		
		if (msg1 == ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS && msg2 == ResultMessage.RECORE_CREDIT_SUCCESS) {
			return ResultMessage.ABNORMAL_ORDER_UNDO_SUCCESS;
		}else {
			return ResultMessage.ABNORMAL_ORDER_UNDO_FAILURE;
		}
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param date 网站营销人员撤销异常订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的异常订单
	 */
	public List<OrderGeneralVO> getAllAbnormalOrderGeneral(final LocalDate date) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllAbnormalOrderGeneral(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (orderGeneralPOs != null) {
			for (int i = 0; i < orderGeneralPOs.size(); i++) {
				result.add(new OrderGeneralVO(orderGeneralPOs.get(i)));
			}
		}
		
		return result;
	}
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/29
	 * @param date 网站营销人员查看未执行订单时输入的指定日期
	 * @return 网站营销人员需要查看的当天所有的未执行订单
	 */
	public List<OrderGeneralVO> getAllUnexecutedOrderGeneral(final LocalDate date) {
		final List<OrderGeneralVO> result = new ArrayList<OrderGeneralVO>();
		
		List<OrderGeneralPO> orderGeneralPOs = null;
		try {
			orderGeneralPOs = orderDataService.getAllUnexecutedOrderGeneral(date);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if (orderGeneralPOs != null) {
			for (int i = 0; i < orderGeneralPOs.size(); i++) {
				result.add(new OrderGeneralVO(orderGeneralPOs.get(i)));
			}
		}
		
		return result;
	}
}
