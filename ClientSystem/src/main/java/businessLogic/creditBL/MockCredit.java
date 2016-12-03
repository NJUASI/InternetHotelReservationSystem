package businessLogic.creditBL;

import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.marketBL.MockMarket;
import businessLogic.userBL.MockUser;
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
public class MockCredit extends Credit {
	
	private User user;
	
	private Market market;
	

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public MockCredit() {
		user = new MockUser();
		market = new MockMarket();
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
	@Override
	public ResultMessage charge(final String guestID, final float chargeNum) {
		return user.modifyCredit("1234567890", 100);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @return 客户的基本信息
	 */
	@Override
	public BasicInfoVO getBasicInfo(final String guestID) {
		final GuestVO guestVO = (GuestVO) user.getSingle("1234567890", UserType.GUEST);
		final List<MarketVO> memberFormulationList = market.getMemberFormulation();
		final MarketVO marketVO = memberFormulationList.get(0);
		
		String memberDegree = "Lv0";
		if (guestVO.credit > marketVO.marketCredit) {
			memberDegree = "Lv1";
		}
		return new BasicInfoVO(guestVO, memberDegree);
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @return 客户个人所有信用记录
	 */
	@Override
	public List<CreditVO> getAllCreditDetail(final String guestID) {
		return user.getAllCreditDetail(guestID);
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return 会员等级
	 */
	@Override
	public List<MarketVO> getMemberFormulation() {
		return market.getMemberFormulation();
	}

}
