package businessLogicService.marketBLService;

import java.util.List;

<<<<<<< HEAD
import utilities.enums.ResultMessage;
=======
import exception.verificationException.UserInexistException;
import utilities.ResultMessage;
>>>>>>> master
import vo.MarketVO;

/**
 * 
 * @author charles
 * @lastChangedBy Byron Dong
 * @updateTime 2016/12/8
 * 
 * @description 营销模块逻辑：制定会员等级制度、获取会员等级制度
 */
public interface MarketBLService {

	public List<MarketVO> getMemberFormulation();
	
	public ResultMessage setMemberFormulation(List<MarketVO> marketVOList);
	
	public int getLevel(String guestID) throws UserInexistException;
	
}
