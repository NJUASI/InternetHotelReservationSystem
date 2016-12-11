package businessLogicService.orderBLService;

import utilities.enums.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public interface HotelWorkerOrderBLService {

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/11/27
	 * @param orderID 酒店工作人员当前需要执行订单的订单号
	 * @return 酒店工作人员是否成功执行此订单
	 */
	ResultMessage executeOrder(String orderID);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkInVO 酒店工作人员更新订单入住信息
	 * @return 是否成功更新
	 */
	ResultMessage updateCheckIn(CheckInVO checkInVO);

	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/4
	 * @param checkOutVO 酒店工作人员更新订单退房信息
	 * @return 是否成功更新
	 */
	ResultMessage updateCheckOut(CheckOutVO checkOutVO);
}
