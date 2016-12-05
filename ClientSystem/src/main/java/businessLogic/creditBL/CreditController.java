package businessLogic.creditBL;

import java.util.Iterator;
import java.util.List;

import businessLogicService.creditBLService.CreditBLService;
import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.MarketVO;

/**
 * 
 * @author 61990
 * @lastChangedBy Harvey Gong
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
	public Iterator<CreditVO> getAllCreditDetail(final String guestID) {
		return credit.getAllCreditDetail(guestID);
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

	@Override
	public Iterator<CreditVO> getCreditOfOneOrder(String orderID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addCredit(CreditVO creditVO) {
		// TODO 自动生成的方法存根
		return null;
	}

}
