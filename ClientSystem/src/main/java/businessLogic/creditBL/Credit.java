package businessLogic.creditBL;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.userBL.User;
import utilities.ResultMessage;
import utilities.UserType;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.GuestVO;
import vo.MarketVO;

/**
 * 
 * @author 61990
 *
 */
public class Credit {

	private User user;
	
	private Market market;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	public Credit() {
		user = new User();
		market = new Market();
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
		return user.modifyCredit(guestID, chargeNum);
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
	
		final GuestVO guestVO = (GuestVO) user.getSingle(guestID, UserType.GUEST);

		final List<MarketVO> memberFormulationList = market.getMemberFormulation();
		for (int i = 0; i < memberFormulationList.size(); i++) {
			if (guestVO.credit < memberFormulationList.get(i).marketCredit) {
				return new BasicInfoVO(guestVO, memberFormulationList.get(i).marketName);
			}
		}
		return new BasicInfoVO(guestVO, memberFormulationList.get(memberFormulationList.size() - 1).marketName);

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
		return user.getAllCreditDetail(guestID);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return 会员等级
	 */
	public List<MarketVO> getMemberFormulation() {
		return market.getMemberFormulation();
	}
}
