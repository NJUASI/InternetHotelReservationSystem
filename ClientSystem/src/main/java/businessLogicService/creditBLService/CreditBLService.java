package businessLogicService.creditBLService;

import java.util.Iterator;

import utilities.enums.ResultMessage;
import vo.CreditVO;

/**
 * 
 * @author 61990
 * @lastChangedBy charles
 * @updateTime 2016/12/9
 */
public interface CreditBLService {

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID 从登录界面层传下来的ID
	 * @return 客户个人所有信用记录
	 */
	public Iterator<CreditVO> getAllCreditDetail(String guestID);

	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/9
	 * @param orderID 从登录界面层传下来的订单编号
	 * @return 客户个人此订单的信用记录
	 */
	public Iterator<CreditVO> getCreditOfOneOrder(String orderID);
	
	/**
	 * @author 61990
	 * @lastChangedBy charles
	 * @updateTime 2016/12/9
	 * @param creditVO 一条信用记录
	 * @return 是否成功添加此信用记录并修改客户信用值
	 */
	public ResultMessage addCreditRecord(CreditVO creditVO);
	
}
