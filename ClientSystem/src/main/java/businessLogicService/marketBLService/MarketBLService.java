package businessLogicService.marketBLService;

import java.util.List;

import exception.verificationException.MemberInexistException;
import exception.verificationException.UserInexistException;
import utilities.enums.ResultMessage;
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

	/**
	 * @Description:获取等级制度
	 * @return
	 * List<MarketVO>
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:47:39
	 */
	public List<MarketVO> getMemberFormulation();
	
	/**
	 * @Description:设置等级制度
	 * @param marketVOList 等级制度集合
	 * @return
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:01
	 */
	public ResultMessage setMemberFormulation(List<MarketVO> marketVOList);
	
	/**
	 * @Description:获取等级
	 * @param guestID 用户id
	 * @return
	 * @throws UserInexistException
	 * @throws MemberInexistException
	 * int
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:03
	 */
	public int getLevel(String guestID) throws UserInexistException, MemberInexistException;
	
	/**
	 * @Description:获取等级名字
	 * @param userID 用户
	 * @return
	 * @throws UserInexistException
	 * @throws MemberInexistException
	 * String
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:06
	 */
	public String getLevelName(String userID) throws UserInexistException, MemberInexistException;
	
	/**
	 * @Description:获取会员折扣
	 * @param 用户id
	 * @return
	 * @throws UserInexistException
	 * @throws MemberInexistException
	 * double
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:08
	 */
	public double getMemberDiscout(String userID) throws UserInexistException, MemberInexistException;
}
