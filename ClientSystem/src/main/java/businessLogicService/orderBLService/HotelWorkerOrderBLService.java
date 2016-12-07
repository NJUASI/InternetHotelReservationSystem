package businessLogicService.orderBLService;

import java.util.List;

import utilities.OrderState;
import utilities.ResultMessage;
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
	 * @updateTime 2016/11/27
	 * @param hotelID 酒店工作人员要查看本酒店<所有>订单时，酒店的编号
	 * @return 此酒店<所有>订单
	 */
	List<OrderGeneralVO> getAllHotelOrderGeneral(String hotelID);
	
	/**
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/7
	 * @param hotelID 酒店工作人员要查看本酒店<所有某种特定类型>订单时，酒店的编号
	 * @return 此酒店<所有某种特定类型>的所有订单
	 * 
	 * <所有某种特定类型>包括：未执行、已执行、异常、已撤销
	 */
	List<OrderGeneralVO> getAllHotelSpecialOrderGeneral(String hotelID, OrderState expectOrderState);
	
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
