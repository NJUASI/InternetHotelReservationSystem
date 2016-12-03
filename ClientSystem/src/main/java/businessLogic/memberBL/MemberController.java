package businessLogic.memberBL;

import businessLogicService.memberBLService.MemberBLService;
import utilities.MemberType;
import utilities.ResultMessage;
import vo.MemberVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/27
 *
 */
public class MemberController implements MemberBLService {

	
	private Member member;
	private static MemberController memberController;
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	private MemberController() {
		//new the mock object
		member = new MockMember();
	}
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param 
	 * @return 唯一memberController对象
	 */
	public static MemberController getInstance(){ //采用单粒模式
		if(memberController == null) memberController = new MemberController();
		return memberController;
	}
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param memberVO 从客户界面层传下来的memberInfo载体
	 * @return 用户是否成功添加会员信息
	 */
	public ResultMessage add(MemberVO memberVO) {
		return member.add(memberVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param memberVO 从客户界面层传下来的memberInfo载体
	 * @return 用户是否成功修改会员信息
	 */
	public ResultMessage modify(MemberVO memberVO) {
		return member.modify(memberVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID，memberType 从客户界面层传下来的用户ID和需要获取指定会员类型信息
	 * @return memberVO MemberInfo载体
	 */
	public MemberVO getMemberInfo(String userID, MemberType memberType) {
		return member.getMemberInfo(userID, memberType);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID，memberType 从客户界面层传下来的用户ID和需要获取指定会员类型信息
	 * @return boolean 该用户是否为指定会员类型
	 */
	public boolean isMember(String userID, MemberType memberType) {
		return member.isMember(userID, memberType);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID 从客户界面层传下来的用户ID
	 * @return MemberType 指定用户的会员类型
	 */
	public MemberType getMemberType(String userID) {
		return member.getMemberType(userID);
	}
	
}
