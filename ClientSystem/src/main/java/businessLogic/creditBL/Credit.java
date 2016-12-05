package businessLogic.creditBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import businessLogic.marketBL.Market;
import businessLogic.userBL.User;
import businessLogic.userBL.userService.Guest;
import businessLogic.userBL.userService.service.CreditService;
import businessLogicService.creditBLService.CreditBLService;
import businessLogicService.creditBLService.CreditDataService_Stub;
import dataService.creditDataService.CreditDataService;
import po.CreditPO;
import utilities.ResultMessage;
import utilities.UserType;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.GuestVO;
import vo.MarketVO;

/**
 * 
 * @author 61990
 * lastChangedBy charles
 * updateTime 2016/12/5
 *
 */
public class Credit implements CreditBLService{

	private CreditService guest;
	private User user;
	
	private Market market;
	
	private CreditDataService creditDataService;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 构造函数，初始化成员变量
	 */
	public Credit() {
		user = new User();
		guest = new Guest();
		market = new Market();
		creditDataService = new CreditDataService_Stub();
	}

	/**
	 * @author 61990
	 * @lastChangedBy Harvey Gong
	 * @updateTime 2016/12/5
	 * @param guestID
	 *            从登录界面层传下来的ID
	 * @return 客户个人所有信用记录
	 */
	public Iterator<CreditVO> getAllCreditDetail(final String guestID) {
		try {
			return convertPOListToItr(creditDataService.getAllCreditDetail(guestID));
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * @Description:查看关于某一订单的所有
	 * @param guestID
	 * @param orderID
	 * @return
	 * Iterator<CreditVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月5日 下午1:37:49
	 */
	public Iterator<CreditVO> getCreditOfOneOrder(String orderID){
		try {
			return convertPOListToItr(creditDataService.getCreditOfOneOrder(orderID));
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * @Description:添加一条信用数据
	 * @param creditVO
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2016年12月5日 下午1:09:56
	 */
	public ResultMessage addCredit(CreditVO creditVO){
		try {
			guest.modifyCredit(creditVO.guestID, creditVO.afterCredit);
			return creditDataService.addCredit(new CreditPO(creditVO));
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
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
	 * @return 会员等级
	 */
	public List<MarketVO> getMemberFormulation() {
		return market.getMemberFormulation();
	}
	
	private Iterator<CreditVO> convertPOListToItr(List<CreditPO> list){
		List<CreditVO> VOList = new ArrayList<CreditVO>();
		for(CreditPO creditPO : list){
			CreditVO creditVO = new CreditVO(creditPO);
			VOList.add(creditVO);
		}
		return VOList.iterator();
	}
}
