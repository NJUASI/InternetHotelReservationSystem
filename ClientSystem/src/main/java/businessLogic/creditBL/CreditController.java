package businessLogic.creditBL;

import java.util.Iterator;

import businessLogicService.creditBLService.CreditBLService;
import utilities.ResultMessage;
import vo.CreditVO;

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
		credit = new Credit();
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
	 * @return 客户个人所有信用记录
	 */
	public Iterator<CreditVO> getAllCreditDetail(final String guestID) {
		return credit.getAllCreditDetail(guestID);
	}
	
	@Override
	public Iterator<CreditVO> getCreditOfOneOrder(String orderID) {
		return null;
	}

	@Override
	public ResultMessage addCredit(CreditVO creditVO) {
		return null;
	}

}
