package businessLogic.creditBL;

import java.util.List;

import businessLogicService.creditBLService.CreditBLService;
import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.MarketVO;

/**
 * 
 * @author 61990
 * @lastChangedBy charles
 * @updateTime 2016/12/5
 */
public final class CreditController implements CreditBLService {

	
	private Credit credit;
	
	private static CreditController creditController = new CreditController();;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 
	 * 构造函数，初始化成员变量
	 */
	private CreditController() {
		//new the mock object
		credit = new MockCredit();
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return creditController的实例，单例化
	 */
	public static CreditController getInstance() {
		return creditController;
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @param chargeNum
	 *            从登录界面层传下来信用值数额
	 * @return 客户是否成功信用充值成功
	 */
	public ResultMessage charge(final String guestID, final float chargeNum) {
		return credit.charge(guestID, chargeNum);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @return 客户的基本信息
	 */
	public BasicInfoVO getBasicInfo(final String guestID) {
		return credit.getBasicInfo(guestID);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @return 客户个人所有信用记录
	 */
	public List<CreditVO> getAllCreditDetail(final String guestID) {
		return credit.getAllCreditDetail(guestID);
	}
	
	/**
	 * 
	 * @author charles
	 * @lastChangedBy charles
	 * @updateTime 2016/12/5
	 * @param creditVO 此次信用记录的载体
	 * @return 添加此条信用记录的结果
	 */
	public ResultMessage addCreditRecord(CreditVO creditVO) {
		return credit.addCreditRecord(creditVO);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return 会员等级
	 */
	public List<MarketVO> getMemberFormulation() {
		return credit.getMemberFormulation();
	}

}
