package businessLogicService.orderBLService;

import java.util.Iterator;

import utilities.enums.ResultMessage;
import vo.CheckInVO;
import vo.CheckOutVO;
import vo.OrderGeneralVO;

/**
 * 
 * @author cuihua
 * lastChangedBy charles
 * updateTime 2016/12/7
 *
 */
public interface HotelWorkerOrderBLService {

//	/**
//	 * @author charles
//	 * @lastChangedBy charles
//	 * @updateTime 2016/11/27
//	 * @param orderID 酒店工作人员当前需要执行订单的订单号
//	 * @return 酒店工作人员是否成功执行此订单
//	 */
//	ResultMessage executeOrder(String orderID);
	
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
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/15
	 * @param hotelID 酒店编号
	 * @param hasCheckOut 状态：已退房／未退房
	 * @return 客户<已退房／未退房>订单
	 */
	Iterator<OrderGeneralVO> getAllHotelCheckOutOrderGeneral(String hotelID, boolean hasCheckOut);
}
