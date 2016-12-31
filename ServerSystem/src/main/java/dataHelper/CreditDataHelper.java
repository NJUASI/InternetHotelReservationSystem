package dataHelper;

import java.util.List;

import po.CreditPO;
import utilities.enums.ResultMessage;

/**
 * 
 * @author 董金玉
 * lastChangedBy charles
 * updateTime 2017/1/1
 *
 */
public interface CreditDataHelper {

	public List<CreditPO> getAllCreditDetail(String guestID);

	public ResultMessage addCredit(CreditPO creditPO);

//	public List<CreditPO> getCreditOfOneOrder(String guestID);
	
	void close();
	
}
