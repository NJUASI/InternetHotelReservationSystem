package businessLogicService.creditBLService;

import java.util.List;

import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.MarketVO;

/**
 * 
 * @author charles
 * @lastChangedBy charles
 * @updateTime 2016/12/5
 * 
 * @description 信用模块逻辑：充值、获取客户所有信息、获取客户信用记录、
 */
public interface CreditBLService {

	/**
	 * 
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID 客户编号
	 * @param chargeNum 此客户需要的充值额度
	 * @return 网站营销人员是否成功充值
	 */
	ResultMessage charge(String guestID, float chargeNum);
	
	/**
	 * 
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID 客户编号
	 * @return 获取用户的基本信息
	 */
	BasicInfoVO getBasicInfo (String guestID);
	
	/**
	 * 
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID 客户编号
	 * @return 获取用户的所有信用记录（包括时间、订单号、动作、信用度变化、信用度结果）
	 */
	List<CreditVO> getAllCreditDetail(String guestID);
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * @param creditVO 此次信用记录的载体
	 * @return 添加此条信用记录的结果
	 */
	ResultMessage addCreditRecord(CreditVO creditVO);
	
	/**
	 * 
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return 获取系统的会员登记制度
	 */
	List<MarketVO> getMemberFormulation();
	
}
