package businessLogicService.marketBLService;

import java.util.List;

import utilities.ResultMessage;
import vo.MarketVO;

public interface MarketBLService {

	public List<MarketVO> getMemberFormulation ();
	
	public ResultMessage setMemberFormulation (List<MarketVO> marketVOList);
	
}
