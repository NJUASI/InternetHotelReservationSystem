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

	public List<CreditPO> getAllCreditDetail(String guestID);

	public ResultMessage addCredit(CreditPO creditPO);

	public List<CreditPO> getCreditOfOneOrder(String guestID);
	
	void close();
	
}
