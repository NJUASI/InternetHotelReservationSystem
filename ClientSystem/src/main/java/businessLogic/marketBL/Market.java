package businessLogic.marketBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.marketDataService.MarketDataService;
import dataService.marketDataService.MarketDataService_Stub;
import po.MarketPO;
import utilities.ResultMessage;
import vo.MarketVO;

/**
 * 
 * @author 61990
 *
 */
public class Market {
	private MarketDataService marketDataService;

	/**
	 * @author 61990
	 * @lastChangedBy 61990
	 * @updateTime 2016/11/27 
	 * @构造函数，初始化成员变量
	 */
	public Market() {
		marketDataService = new MarketDataService_Stub();
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
	 * @param marketVOList
	 *            从会员等级界面层传下来的list
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
}
