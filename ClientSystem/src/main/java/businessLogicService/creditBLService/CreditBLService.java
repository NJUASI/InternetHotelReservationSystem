package businessLogicService.creditBLService;

import java.util.Iterator;
import java.util.List;

import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.MarketVO;

public interface CreditBLService {

	public BasicInfoVO getBasicInfo (String guestID);
	
	public Iterator<CreditVO> getAllCreditDetail(String guestID);

	public Iterator<CreditVO> getCreditOfOneOrder(String orderID);
	
	public ResultMessage addCredit(CreditVO creditVO);
	
	public List<MarketVO> getMemberFormulation();
	
}
