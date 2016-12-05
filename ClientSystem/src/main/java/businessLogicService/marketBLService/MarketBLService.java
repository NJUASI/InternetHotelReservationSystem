package businessLogicService.marketBLService;

import java.util.List;

import utilities.ResultMessage;
import vo.MarketVO;

/**
 * 
 * @author charles
 * @lastChangedBy charles
 * @updateTime 2016/11/27
 * 
 * @description 营销模块逻辑：制定会员等级制度、获取会员等级制度
 */
public interface MarketBLService {

	public List<MarketVO> getMemberFormulation();
	
	public ResultMessage setMemberFormulation(List<MarketVO> marketVOList);
	
}
