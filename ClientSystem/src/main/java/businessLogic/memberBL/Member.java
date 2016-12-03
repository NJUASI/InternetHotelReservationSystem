package businessLogic.memberBL;

import java.rmi.RemoteException;

import dataService.guestDataService.GuestDataService;
import dataService.guestDataService.GuestDataService_Stub;
import po.MemberPO;
import utilities.MemberType;
import utilities.ResultMessage;
import vo.GuestVO;
import vo.MemberVO;

/**
 * 
 * @author 董金玉
 * lastChangedBy 董金玉
 * updateTime 2016/11/27
 *
 */
public class Member {

	
	private GuestDataService guestDataService;

	private MemberInfo member;

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * 构造函数，初始化成员变量
	 */
	public Member() {
		guestDataService = new GuestDataService_Stub();
		member = new MemberInfo();
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param memberVO 从客户界面层传下来的MemberInfo载体
	 * @return 客户是否成功添加会员信息
	 */
	public ResultMessage add(MemberVO memberVO) {
		return this.addMemberInfo(memberVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param memberVO 从客户界面层传下来的MemberInfo载体
	 * @return 客户是否成功修改会员信息
	 */
	public ResultMessage modify(MemberVO memberVO) {
		return this.addMemberInfo(memberVO);
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID，memberType 从客户界面层传下来的用户ID和需要获取指定会员类型信息
	 * @return memberVO MemberInfo载体
	 */
	public MemberVO getMemberInfo(String userID, MemberType memberType) {
		try {
			GuestVO guestVO = new GuestVO(guestDataService.getSingleGuest(userID));
			return new MemberVO(guestVO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID，memberType 从客户界面层传下来的用户ID和需要获取指定会员类型信息
	 * @return boolean 该用户是否为指定会员类型
	 */
	public boolean isMember(String userID, MemberType memberType) {
		try {
			GuestVO guestVO = new GuestVO(guestDataService.getSingleGuest(userID));
			MemberVO memberVO = new MemberVO(guestVO);
			if (member.isCommonMember(memberVO, memberType)) { // 是普通会员，返回true
				return true;
			}
			if (member.isEnterpriseMember(memberVO, memberType)) { // 是企业会员，返回true
				return true;
			}

			if (member.isBothMember(memberVO, memberType)) { // 判断是两种类型会员，返回true
				return true;
			}

			return false; // 不满足上述三种情况，返回false
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("error"); // 异常返回错误
			return false;
		}
	}

	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param userID 从客户界面层传下来的用户ID
	 * @return MemberType 指定用户的会员类型
	 */
	public MemberType getMemberType(String userID) {
		try {
			GuestVO guestVO = new GuestVO(guestDataService.getSingleGuest(userID));
			MemberVO memberVO = new MemberVO(guestVO);

			return member.getMemberType(memberVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @author 董金玉
	 * @lastChangedBy 董金玉
	 * @updateTime 2016/11/27
	 * @param memberVO 来自本类的member信息载体 
	 * @return ResultMessage 添加会员信息是否成功
	 */
	private ResultMessage addMemberInfo(MemberVO memberVO) {
		try {
			MemberPO memberPO = new MemberPO(memberVO);
			return guestDataService.modifyMember(memberPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
}
