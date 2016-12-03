package dataHelper;

import java.util.List;

import po.CreditPO;
import utilities.ResultMessage;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/29
 *
 */
public interface CreditDataHelper {

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @return List<CreditPO> 获取所有CreditInfo载体
	 */
	List<CreditPO> getAll(String guestID);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @return ResultMessage 是否成功添加CreditInfo到数据库中
	 */
	ResultMessage add(CreditPO creditPO);
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/29
	 * @param 
	 * @return 
	 */
	void close();
	
}
