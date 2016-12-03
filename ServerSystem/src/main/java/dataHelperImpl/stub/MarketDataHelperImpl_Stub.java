package dataHelperImpl.stub;

import java.util.ArrayList;
import java.util.List;

import dataHelper.MarketDataHelper;
import po.MarketPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉 lastChangedBy 董金玉 updateTime 2016/12/1
 *
 */
public class MarketDataHelperImpl_Stub implements MarketDataHelper {

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @return List<MarketPO> 所有marketInfo载体
	 */
	public List<MarketPO> getAll() {
		List<MarketPO> a= new ArrayList<MarketPO>();
		MarketPO b= new MarketPO("aa",0,0.9);
		a.add(b);
		return a;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param list 所有需要修改的marketInfo载体
	 * @return ResultMessage 是否成功修改所有marketInfo
	 */
	public ResultMessage modifyAll(final List<MarketPO> list) {
		
		return ResultMessage.SUCCESS;
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/12/1
	 * @param
	 * @return
	 */
	public void close() {
	}
}
