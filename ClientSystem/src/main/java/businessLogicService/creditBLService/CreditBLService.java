package businessLogicService.creditBLService;

import java.util.List;

import utilities.ResultMessage;
import vo.BasicInfoVO;
import vo.CreditVO;
import vo.MarketVO;

public interface CreditBLService {

	public ResultMessage charge(String guestID, float chargeNum);
	
	public BasicInfoVO getBasicInfo (String guestID);
	
	public List<CreditVO> getAllCreditDetail(String guestID);
	
	public List<MarketVO> getMemberFormulation();
	
}
