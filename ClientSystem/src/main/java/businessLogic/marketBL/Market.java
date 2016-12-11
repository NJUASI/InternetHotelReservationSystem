package businessLogic.marketBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogic.userBL.UserController;
import businessLogicService.marketBLService.MarketBLService;
import businessLogicService.userBLService.UserBLService;
import dataService.marketDataService.MarketDataService;
import dataService.marketDataService.MarketDataService_Stub;
import exception.verificationException.UserInexistException;
import po.MarketPO;
import rmi.ClientRemoteHelper;
import utilities.enums.ResultMessage;
import vo.GuestVO;
import vo.MarketVO;

/**
 * 
 * @author 61990
 *
 */
public class Market implements MarketBLService{
	
	private MarketDataService marketDataService;
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 
	 * @构造函数，初始化成员变量
	 */
	public Market() {
		marketDataService = ClientRemoteHelper.getInstance().getMarketDataService();
//		try {
//			marketDataService = new MarketDataService_Stub();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @return 得到会员等级信息列表
	 */
	public List<MarketVO> getMemberFormulation() {
		final List<MarketVO> marketVOList = new ArrayList<MarketVO>();
		try {

			final List<MarketPO> marketPOList = marketDataService.getMemberFormulation();
			for (int i = 0; i < marketPOList.size(); i++) {
				marketVOList.add(new MarketVO(marketPOList.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return marketVOList;
	}
	
	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27
	 * @param marketVOList 从会员等级界面层传下来的list
	 * @return 是否保存等级制度成功
	 */
	public ResultMessage setMemberFormulation(final List<MarketVO> marketVOList) {

		try {
			final List<MarketPO> marketPOList = new ArrayList<MarketPO>();
			for (int i = 0; i < marketVOList.size(); i++) {
				marketPOList.add(new MarketPO(marketVOList.get(i)));
			}
			return marketDataService.setMemberFormulation(marketPOList);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Byron Dong
	 * @lastChangedBy Byron Dong
	 * @updateTime 2016/12/8
	 * @param guestID 需要获取等级客户ID
	 * @return int 获取客户当前会员等级（需要处理未达最低信用值的情况，此时返回值为0）
	 * @throws UserInexistException 
	 */
	public int getLevel(String guestID) throws UserInexistException{
		UserBLService user = UserController.getInstance();
		double credit = ((GuestVO)user.getSingle(guestID)).credit;
		List<MarketVO> list = this.getMemberFormulation();
		
		int level = 0;
		for(int i=0;i<list.size();i++){
			if(credit>=list.get(i).marketCredit){
				level++;
			}
			else{
				break;
			}
		}
		
		return level;
	}
}
