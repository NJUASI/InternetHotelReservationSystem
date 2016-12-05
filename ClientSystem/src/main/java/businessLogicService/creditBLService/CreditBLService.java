package businessLogicService.creditBLService;

import java.util.Iterator;

import utilities.ResultMessage;
import vo.CreditVO;

public interface CreditBLService {

	public Iterator<CreditVO> getAllCreditDetail(String guestID);

	public Iterator<CreditVO> getCreditOfOneOrder(String orderID);
	
	public ResultMessage addCredit(CreditVO creditVO);
	
}
