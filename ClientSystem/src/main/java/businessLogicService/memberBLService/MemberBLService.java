package businessLogicService.memberBLService;

import exception.verificationException.UserInexistException;
import utilities.enums.MemberType;
import utilities.enums.ResultMessage;
import vo.MemberVO;

public interface MemberBLService {

	/**
	 * @Description:添加会员
	 * @param 会员信息载体
	 * @return
	 * @throws UserInexistException
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:12
	 */
	public ResultMessage add(MemberVO memberVO) throws UserInexistException;
	
	/**
	 * @Description:修改会员信息
	 * @param memberVO 会员信息载体
	 * @return
	 * @throws UserInexistException
	 * ResultMessage
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:14
	 */
	public ResultMessage modify(MemberVO memberVO) throws UserInexistException;
	
	/**
	 * @Description:获取会员信息
	 * @param userID 用户id
	 * @return
	 * @throws UserInexistException
	 * MemberVO
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:16
	 */
	public MemberVO getMemberInfo(String userID) throws UserInexistException;
	
	/**
	 * @Description:判断是否是会员
	 * @param userID 用户id
	 * @param memberType 会员类型
	 * @return
	 * @throws UserInexistException
	 * boolean
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:18
	 */
	public boolean isMember(String userID, MemberType memberType) throws UserInexistException;
	
	/**
	 * @Description:获取会员类型
	 * @param userID 用户id
	 * @return
	 * @throws UserInexistException
	 * MemberType
	 * @author: Harvey Gong
	 * @lastChangedBy: Harvey Gong
	 * @time:2017年1月2日 上午11:48:21
	 */
	public MemberType getMemberType(String userID) throws UserInexistException;

}
